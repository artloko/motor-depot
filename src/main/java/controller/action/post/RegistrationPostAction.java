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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationPostAction implements Action {

    @Override
    public String getPattern() {
        return "registration";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ActionException {
        User user = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        RequestDispatcher dispatcher = null;
        if (login != null && password != null) {
            user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setType("client");

            IUserDAO userDAO = (IUserDAO) servletContext.getAttribute("userDAO");
            try {
                userDAO.registerUser(user);
            } catch (DAOException e) {
                throw new ActionException(String.format("Failed to register user with login - %s", login), e);
            }
            dispatcher = servletContext.getRequestDispatcher(NavigationConstants.LOGIN_PAGE);
        } else {
            dispatcher = servletContext.getRequestDispatcher(NavigationConstants.REGISTRATION_PAGE);
        }

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new ActionException("Failed page forwarding", e);
        }
    }
}
