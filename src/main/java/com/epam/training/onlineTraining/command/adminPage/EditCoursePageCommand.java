package com.epam.training.onlineTraining.command.adminPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.entity.Course;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.CourseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditCoursePageCommand implements Command {

    private final CourseService courseService;

    public EditCoursePageCommand(CourseService courseService) {
        this.courseService = courseService;
    }


    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null) {
        String courseIdLine = req.getParameter("id");
        Long courseId = Long.valueOf(courseIdLine);
        Course course = courseService.getCourseById(courseId);
        req.setAttribute("course", course);
        return "/WEB-INF/view/editCourse.jsp";
        } else {
            return "/WEB-INF/view/index.jsp";
        }
    }
}
