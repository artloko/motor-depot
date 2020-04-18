package controller.action.post;

import controller.NavigationConstants;
import controller.action.Action;
import model.dao.IUserDAO;
import model.entity.User;
import model.exception.ActionException;
import model.exception.DAOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class LoginPostAction implements Action {

    @Override
    public String getPattern() {
        return "login";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ActionException {
        User user = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (login != null && password != null) {
            if (login.isEmpty() && password.isEmpty()) {
                user = new User();
                user.setType("guest");
                user.setLogin("Гость");
            } else {
                IUserDAO userDAO = (IUserDAO) servletContext.getAttribute("userDAO");
                try {
                    user = userDAO.getUserInfo(login, password);
                } catch (DAOException e) {
                    throw new ActionException("Failed to check user", e);
                }
            }
        }

        String forwardPage;
        if (user != null) {
            startNewSessionAndSaveCookies(request, response, user);
            forwardPage = NavigationConstants.HOME;
        } else {
            forwardPage = NavigationConstants.LOGIN_PAGE;
        }
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(forwardPage);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new ActionException("Failed page forwarding", e);
        }
    }

    private void startNewSessionAndSaveCookies(HttpServletRequest request, HttpServletResponse response, User user) {
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        Cookie lastEnterTime = new Cookie("lastEnterTime", new Date().toString().replace(" ", "-"));
        lastEnterTime.setComment("LastEnterTime");
        Cookie usageCount = new Cookie("usageCount", "1");
        usageCount.setComment("VisitNumber");

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("usageCount")) {
                    int lastUsageCount = Integer.parseInt(cookie.getValue());
                    lastUsageCount += 1;
                    usageCount.setValue(Integer.toString(lastUsageCount));
                }
            }
        }
        response.addCookie(lastEnterTime);
        response.addCookie(usageCount);
    }
}
