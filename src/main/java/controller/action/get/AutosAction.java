package controller.action.get;

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
import java.util.List;

public class AutosAction implements Action {

    @Override
    public String getPattern() {
        return "autos";
    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws IOException, ServletException {
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(NavigationConstants.AUTOS);

        IAutoDAO autoDAO = (IAutoDAO) servletContext.getAttribute("autoDAO");
        List list = null;
        try {
            list = autoDAO.getCarsByStatus(CarStatusEnum.N);
        } catch (DAOException e) {
            e.printStackTrace();
        }
        request.setAttribute("brokenCarsList", list);
        dispatcher.forward(request, response);
    }
}
