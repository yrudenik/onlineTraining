package com.epam.training.onlineTraining.command.studentPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.TaskService;
import com.epam.training.onlineTraining.service.TaskServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TaskInformationCommand implements Command {

    // this command possible is not needed

    public TaskInformationCommand(TaskService taskService) {
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        return null;
    }
}
