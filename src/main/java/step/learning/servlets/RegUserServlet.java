package step.learning.servlets;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import step.learning.dao.UserDAO;
import step.learning.entities.User;
import step.learning.services.MimeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.rmi.server.ExportException;
import java.util.Arrays;
import java.util.UUID;

@Singleton
@WebServlet("/register/")
@MultipartConfig
public class RegUserServlet extends HttpServlet {


    @Inject private UserDAO userDAO ;
    @Inject private MimeService mimeService;

//    @Inject
//    public RegUserServlet( UserDAO userDAO ) {
//        this.userDAO = userDAO ;
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Проверяем, есть ли сохраненные в сессии данные от предыдущей обработки
        HttpSession session = req.getSession() ;
        String regError = (String) session.getAttribute( "regError" ) ;
        String regOk = (String) session.getAttribute( "regOk" ) ;

        if( regError != null ) {  // Есть сообщение об ошибке
            req.setAttribute( "regError", regError ) ;
            session.removeAttribute( "regError" ) ;  // удаляем сообщение из сессии
        }
        if( regOk != null ) {  // Есть сообщение об успешной регистрации
            req.setAttribute( "regOk", regOk ) ;
            session.removeAttribute( "regOk" ) ;  // удаляем сообщение из сессии
        }


        req.setAttribute( "pageBody", "reg_user.jsp" ) ;
        req.getRequestDispatcher( "/WEB-INF/_layout.jsp" )
                .forward( req, resp ) ;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession() ;

        // Прием данных от формы регистрации
        String userLogin = req.getParameter( "userLogin" ) ;
        String userPassword = req.getParameter( "userPassword" ) ;
        String confirmPassword = req.getParameter( "confirmPassword" ) ;
        String userName = req.getParameter( "userName" ) ;

        // Валидация данных
        String errorMessage = null ;
        try {
            if( userLogin == null || userLogin.isEmpty() ) {
                throw new Exception( "Login could not be empty" ) ;
            }
            if( ! userLogin.equals( userLogin.trim() ) ) {
                throw new Exception( "Login could not contain trailing spaces" ) ;
            }
            if( userDAO.isLoginUsed( userLogin ) ) {
                throw new Exception( "Login is already in use" ) ;
            }
            if( userPassword == null || userPassword.isEmpty() ) {
                throw new Exception( "Password could not be empty" ) ;
            }
            if( ! userPassword.equals( confirmPassword ) ) {
                throw new Exception( "Passwords mismatch" ) ;
            }
            if( userName == null || userName.isEmpty() ) {
                throw new Exception( "Name could not be empty" ) ;
            }
            if( ! userName.equals( userName.trim() ) ) {
                throw new Exception( "Name could not contain trailing spaces" ) ;
            }

            String savedName = "";

            // region check file
            Part userAvatar = req.getPart("userAvatar");
            if (userAvatar == null) {
                throw new ExportException("Form integrity violation");
            }
            long size = userAvatar.getSize();
            if (size > 0) {
                String userFilename = userAvatar.getSubmittedFileName();
                int dotPosition = userFilename.lastIndexOf(".");
                if(dotPosition == -1) {
                    throw new Exception("File extension required");
                }

                String extension = userFilename.substring(dotPosition);
                if(!mimeService.isImage(extension)) {
                    throw new Exception("File type unsupported");
                }

                savedName = UUID.randomUUID() + extension;

                String path = req.getServletContext().getRealPath("/");

                File file = new File(path + "../upload/" + savedName);

                Files.copy(userAvatar.getInputStream(), file.toPath());
            }
            // endregion

            User user = new User() ;
            user.setName( userName ) ;
            user.setLogin( userLogin ) ;
            user.setPass( userPassword ) ;
            user.setAvatar( savedName );
            if( userDAO.add( user ) == null ) {
                throw new Exception( "Server error, try later" ) ;
            }
        }
        catch( Exception ex ) {
            errorMessage = ex.getMessage() ;
        }
        // Проверяем успешность валидации
        if( errorMessage != null ) {  // Есть ошибки
            session.setAttribute( "regError", errorMessage ) ;
            session.setAttribute("lastUserLogin", userLogin);
            session.setAttribute("lastUserName", userName);
        }
        else {  // Успешно - нет ошибок
            session.setAttribute( "regOk", "Registration successful" ) ;
        }
        resp.sendRedirect( req.getRequestURI() ) ;
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User toChange = new User();
        toChange.setId((String) req.getSession().getAttribute("AuthUserId"));
        toChange.setName((String) req.getParameter("name"));

        System.out.println("Id: " + toChange.getId());
        System.out.println("Name: " + toChange.getName());

        boolean res = userDAO.updateUser(toChange);
        if(!res) System.out.println("Something went wrong");

        resp.getWriter().print( "PUT works " + req.getParameter( "name" ) ) ;
    }
}