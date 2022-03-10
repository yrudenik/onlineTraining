package com.epam.training.onlineTraining.command.adminPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.CourseService;
import com.epam.training.onlineTraining.service.CourseServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CourseJournalCommand implements Command {

    // this command possible is not needed

    public CourseJournalCommand(CourseService courseService) {
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        return null;
    }
}
