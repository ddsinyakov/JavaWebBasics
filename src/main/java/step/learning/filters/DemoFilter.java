package step.learning.filters;

import javax.inject.Singleton;
import javax.servlet.*;
import java.io.IOException;

//@WebFilter("/*")
@Singleton
public class DemoFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletRequest.setAttribute("DemoFilter", "FilterWorks!");
        servletRequest.setCharacterEncoding("UTF-8");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
