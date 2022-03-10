package com.epam.training.onlineTraining.command;

import com.epam.training.onlineTraining.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException;//throws ServiceException
}
