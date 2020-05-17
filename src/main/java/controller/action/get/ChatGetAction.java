package controller.action.get;

import controller.NavigationConstants;
import controller.action.Action;
import model.entity.User;
import model.exception.ActionException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChatGetAction implements Action {

    @Override
    public String getPattern() {
        return "chat";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext)
            throws ActionException {
        User user = (User) request.getSession().getAttribute("user");

        request.setAttribute("senderId", user.getLogin());
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(NavigationConstants.CHAT_PAGE);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new ActionException("Failed page forwarding", e);
        }
    }

}
