package controller.filter;

import controller.NavigationConstants;
import model.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "RegistrationFormFilter", urlPatterns = {"/main"})
public class RegistrationFormFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String action = servletRequest.getParameter("action");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        if (action == null || !action.equals("registration") || !httpServletRequest.getMethod().equalsIgnoreCase("POST")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        String password = servletRequest.getParameter("password");
        String repeatPassword = servletRequest.getParameter("repeat-password");
        if (!password.equals(repeatPassword)) {
            servletRequest.setAttribute("errorMessage", "Passwords not equal");
            ((HttpServletResponse) servletResponse).sendError(500);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
