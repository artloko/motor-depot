package controller.action.get;

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
import java.util.List;

public class TripsAction implements Action {

    @Override
    public String getPattern() {
        return "trips";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws IOException, ServletException {
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(NavigationConstants.TRIPS);

        ITripDAO tripDAO = (ITripDAO) servletContext.getAttribute("tripDAO");
        List list = null;
        try {
            list = tripDAO.readAllTrips();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        request.setAttribute("tripsList", list);
        dispatcher.forward(request, response);
    }
}
