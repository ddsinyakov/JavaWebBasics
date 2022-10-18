package step.learning.filters;

import step.learning.services.database.DataBaseProvider;
import step.learning.services.database.MySQLProvider;

import javax.servlet.*;
import java.io.IOException;
import java.sql.Connection;

public class DBFilter implements Filter {

    FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        DataBaseProvider db = new MySQLProvider();

        if (db.getConnection() == null) {
            servletRequest.getRequestDispatcher("WEB-INF/static.jsp").forward(servletRequest, servletResponse);
        }
        else {
            servletRequest.setAttribute("DataService", db);
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}
