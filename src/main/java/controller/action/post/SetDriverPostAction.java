package controller.action.post;

import controller.NavigationConstants;
import controller.action.Action;
import model.dao.ITripDAO;
import model.exception.DAOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetDriverPostAction implements Action {

    @Override
    public String getPattern() {
        return "setDriver";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws IOException, ServletException {
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(NavigationConstants.SET_DRIVER);

        String driverId = request.getParameter("driverId");
        String tripId = request.getParameter("tripId");

        if (driverId != null && tripId != null) {
            ITripDAO tripDAO = (ITripDAO)servletContext.getAttribute("tripDAO");
            try {
                tripDAO.setDriverForTrip(Integer.valueOf(driverId), Integer.valueOf(tripId));
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }
        dispatcher.forward(request, response);
    }
}
