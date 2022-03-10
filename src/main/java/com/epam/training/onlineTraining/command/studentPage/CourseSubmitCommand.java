package com.epam.training.onlineTraining.command.studentPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.CourseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CourseSubmitCommand implements Command {

    // TODO implement CourseSubmit


    private final CourseService courseService;

    public CourseSubmitCommand(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {

        return null;
    }
}
