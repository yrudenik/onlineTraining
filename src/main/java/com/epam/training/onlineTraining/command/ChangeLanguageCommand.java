package com.epam.training.onlineTraining.command;

import com.epam.training.onlineTraining.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ChangeLanguageCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String localeNew = req.getParameter("locale");
        HttpSession session = req.getSession();
        session.setAttribute("locale", localeNew);
        return "controller?command=mainPage";
    }
}
