package controller;

import controller.action.*;
import controller.action.get.*;
import controller.action.post.*;
import model.exception.ActionException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MotorDepotServlet extends HttpServlet {

    private Map<String, Action> getActions;
    private Map<String, Action> postActions;

    public MotorDepotServlet() {
        super();
        getActions = new HashMap<>();
        postActions = new HashMap<>();
    }

    @Override
    public void init() throws ServletException {
        Action[] getActions = {
                new SetCarStatusGetAction(),
                new SetDriverGetAction(),
                new TripsByIdGetAction(),
                new AutosAction(),
                new HomeAction(),
                new InfoPageAction(),
                new LoginGetAction(),
                new LogoutAction(),
                new RegistrationGetAction(),
                new TripsAction(),
                new ChatGetAction()
        };
        Action[] postActions = {
                new SetCarStatusPostAction(),
                new SetDriverPostAction(),
                new TripsByIdPostAction(),
                new LoginPostAction(),
                new RegistrationPostAction(),
                new SetCarStatusPostAction(),
                new SetDriverPostAction(),
                new TripsByIdPostAction()
        };
        for (Action action : getActions)
            this.getActions.put(action.getPattern(), action);
        for(Action action : postActions)
            this.postActions.put(action.getPattern(), action);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            getActions.get(action).execute(request, response, this.getServletContext());
        } catch (ActionException e) {
            request.setAttribute("errorMessage", e.getMessage());
            response.sendError(500);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            postActions.get(action).execute(request, response, this.getServletContext());
        } catch (ActionException e) {
            request.setAttribute("errorMessage", e.getMessage());
            response.sendError(500);
        }
    }
}
