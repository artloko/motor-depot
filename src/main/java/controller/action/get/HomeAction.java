package controller.action.get;

import controller.NavigationConstants;
import controller.action.Action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeAction implements Action {

    @Override
    public String getPattern() {
        return "home";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws IOException, ServletException {
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(NavigationConstants.HOME);
        dispatcher.forward(request, response);
    }
}
