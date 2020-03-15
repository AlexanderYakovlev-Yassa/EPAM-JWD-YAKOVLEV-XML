package by.epam.jwd.yakovlev.xmlparser.controller;

import by.epam.jwd.yakovlev.xmlparser.command.Pages;
import by.epam.jwd.yakovlev.xmlparser.command.RequestSolver;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Controller", value = "/start")
@MultipartConfig
public class Controller extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(Pages.INDEX.getStringLocation()).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestSolver requestSolver = new RequestSolver(request, response);

        Pages nextPage = null;
        nextPage = requestSolver.solveRequest();

        request.getRequestDispatcher(nextPage.getStringLocation()).forward(request, response);
    }
}
