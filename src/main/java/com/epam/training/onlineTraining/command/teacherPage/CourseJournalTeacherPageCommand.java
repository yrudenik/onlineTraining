package com.epam.training.onlineTraining.command.teacherPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.entity.Course;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.CourseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CourseJournalTeacherPageCommand implements Command {

    private final CourseService courseService;

    public CourseJournalTeacherPageCommand(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        List<Course> courseList = courseService.getAllCourses();
        req.setAttribute("courseList", courseList);
        return "WEB-INF/view/courseJournalTeacher.jsp";
    }
}
