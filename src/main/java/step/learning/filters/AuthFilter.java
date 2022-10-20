package step.learning.filters;

import step.learning.dao.UserDAO;
import step.learning.entities.User;
import step.learning.services.database.DataBaseProvider;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Singleton
public class AuthFilter implements Filter {

    private FilterConfig filterConfig;
    private final UserDAO dao;

    @Inject
    public AuthFilter(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        if (request.getParameter("logout") != null) {
            session.removeAttribute("AuthUserId");
            response.sendRedirect(request.getContextPath());
            return;
        }

        if (request.getMethod().equalsIgnoreCase("POST")) {
            String userLogin = request.getParameter("userLogin");
            String userPassword = request.getParameter("userPassword");

            if(userLogin != null && userPassword != null) {
                User user = dao.getUserByCredentials(userLogin, userPassword);

                if (user != null) {
                    session.setAttribute("AuthUserId", user.getId());
                    System.out.println(user.getLogin() + " " + user.getName() + " " + user.getPass());
                } else {
                    session.setAttribute("AuthError", "Credentials Incorrect");
                    System.out.println("Not found");
                }

                response.sendRedirect(request.getRequestURI());
                return;
            }
        }

        String authData = (String) session.getAttribute("AuthError");
        if (authData != null) {
            request.setAttribute("AuthError", authData);
            session.removeAttribute("AuthError");
        }

        authData = (String) session.getAttribute("AuthUserId");
        if (authData != null) {
            request.setAttribute("AuthUser", dao.getUserById(authData));
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
