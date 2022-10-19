package step.learning;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/index.jsp")
                .forward(req, resp);
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
