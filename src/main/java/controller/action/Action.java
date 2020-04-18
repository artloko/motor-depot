package controller.action;

import model.exception.ActionException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {

    String getPattern();

    void execute(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ActionException, ServletException, IOException;

}
