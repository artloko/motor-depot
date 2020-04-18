package controller.filter;

import controller.NavigationConstants;
import model.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(filterName = "UserSessionCheck", urlPatterns = {"/main"})
public class UserSessionCheckFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        String action = servletRequest.getParameter("action");
        if (user == null && !(action == null || action.equals("login") || action.equals("registration"))) {
            RequestDispatcher dispatcher = servletRequest.getRequestDispatcher(NavigationConstants.INFO_PAGE);
            dispatcher.forward(servletRequest, servletResponse);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
