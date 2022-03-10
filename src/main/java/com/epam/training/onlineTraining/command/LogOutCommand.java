package com.epam.training.onlineTraining.command;

import com.epam.training.onlineTraining.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutCommand implements Command {

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        HttpSession session = req.getSession();
        session.invalidate();
        return "controller?command=loginPage";
    }
}
