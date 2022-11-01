package step.learning.servlets;

import step.learning.services.email.EmailService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Singleton
@WebServlet("")
public class HomeServlet extends HttpServlet {

    @Inject
    private EmailService emailService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("pageBody", "index.jsp");
        req.getRequestDispatcher("/WEB-INF/_layout.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String repeatPassword = req.getParameter("repeatPassword");

        req.getSession().setAttribute("login", login);
        req.getSession().setAttribute("password", password);
        req.getSession().setAttribute("repeatPassword", repeatPassword);

        resp.sendRedirect(req.getRequestURI());
    }
}
