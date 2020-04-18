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
import java.util.List;

public class TripsByIdPostAction implements Action {

    @Override
    public String getPattern() {
        return "tripsById";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws IOException, ServletException {
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(NavigationConstants.TRIPS_BY_ID);

        System.out.println("execute in tripsbyid");

        String driverId = request.getParameter("driverId");
        if (driverId != null) {
            ITripDAO tripDAO = (ITripDAO) servletContext.getAttribute("tripDAO");
            List list = null;
            try {
                list = tripDAO.readTripsByDriverId(Integer.valueOf(driverId));
            } catch (DAOException e) {
                e.printStackTrace();
            }
            request.setAttribute("tripsByIdList", list);
        }
        dispatcher.forward(request, response);
    }
}
