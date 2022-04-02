package com.epam.training.onlineTraining.command.adminPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.CourseService;
import com.epam.training.onlineTraining.service.CourseServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveCourseCommand implements Command {

    private final CourseService courseService;

    public RemoveCourseCommand(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String courseIdNew = req.getParameter("id");
        Long id = courseIdNew == null ? null : Long.parseLong(courseIdNew);
        courseService.deleteCourseById(id);
        return "/WEB-INF/view/manageCourses.jsp";
    }
}
