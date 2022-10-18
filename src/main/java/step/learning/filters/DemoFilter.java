package step.learning.filters;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter("/*")
public class DemoFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter starts");

        servletRequest.setAttribute("DemoFilter", "FilterWorks!");
        servletRequest.setCharacterEncoding("UTF-8");

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("Filter ends");
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
