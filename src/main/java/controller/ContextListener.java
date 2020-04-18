package controller;

import model.dao.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    private ITripDAO iTripDAO;

    private IAutoDAO iAutoDAO;

    private IUserDAO iUserDAO;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        iTripDAO = new TripDAO();
        iAutoDAO = new AutoDAO();
        iUserDAO = new UserDAO();

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("tripDAO", iTripDAO);
        servletContext.setAttribute("autoDAO", iAutoDAO);
        servletContext.setAttribute("userDAO", iUserDAO);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
