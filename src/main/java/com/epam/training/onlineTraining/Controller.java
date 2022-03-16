package com.epam.training.onlineTraining;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.command.CommandFactory;
import com.epam.training.onlineTraining.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandLine = req.getParameter("command");
        CommandFactory commandFactory = new CommandFactory();
        Command command = commandFactory.createCommand(commandLine);
        try {
            String page = command.execute(req, resp);
            processPage(page, req, resp);
        } catch (ServiceException e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            req.setAttribute("errorMessage", sw.toString());//from constants
            processPage("/WEB-INF/view/loginError.jsp", req, resp);
        }
    }

    private void processPage(String page, HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getRequestDispatcher(page);
            dispatcher.forward(req, resp);
    }

}
