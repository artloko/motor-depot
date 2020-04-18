package controller.action.post;

import controller.NavigationConstants;
import controller.action.Action;
import model.dao.IAutoDAO;
import model.entity.CarStatusEnum;
import model.exception.DAOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetCarStatusPostAction implements Action {

    @Override
    public String getPattern() {
        return "setCarStatus";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws IOException, ServletException {


        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(NavigationConstants.SET_CAR_STATUS);

        String carId = request.getParameter("carId");

        if (carId != null) {
            IAutoDAO autoDAO = (IAutoDAO)servletContext.getAttribute("autoDAO");
            try {
                autoDAO.setCarStatus(Integer.valueOf(carId), CarStatusEnum.N);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }
        dispatcher.forward(request, response);
    }
}
