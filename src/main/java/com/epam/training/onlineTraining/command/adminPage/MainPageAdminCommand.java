package com.epam.training.onlineTraining.command.adminPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainPageAdminCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") !=null){
            return "WEB-INF/view/mainPageAdmin.jsp";
        } else {
            return "WEB-INF/view/index.jsp";
        }
    }
}
