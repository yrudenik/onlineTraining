package com.epam.training.onlineTraining.command.adminPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.CourseService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Date;


public class AddCourseCommand implements Command {

    private final CourseService courseService;

    public AddCourseCommand(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {

/*        String courseIdNew = req.getParameter("id");
        Long id = courseIdNew == null ? null : Long.valueOf(courseIdNew);*/

        String teacherIdNew = req.getParameter("user_id");
        Long teacherId = Long.parseLong(teacherIdNew);

        String courseTitle = req.getParameter("course_title");

        String startDateNew = req.getParameter("start_date");
        Date startDate = Date.valueOf(startDateNew);

        String endDateNew = req.getParameter("end_date");
        Date endDate = Date.valueOf(endDateNew);

        String priceNew = req.getParameter("price");
        BigDecimal price = new BigDecimal(priceNew);

        boolean isDeleted = false;

/*        String isDeletedNew = req.getParameter("is_deleted");
        boolean isDeleted = Boolean.parseBoolean(isDeletedNew);*/

        courseService.saveCourse(teacherId, courseTitle, startDate, endDate, price, isDeleted);
        return "/WEB-INF/view/manageCourses.jsp";
    }
}
