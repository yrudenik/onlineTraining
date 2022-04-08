package com.epam.training.onlineTraining.command.studentPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.CourseService;
import com.epam.training.onlineTraining.service.JournalLineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CourseSubmitCommand implements Command {

    private final JournalLineService journalLineService;

    public CourseSubmitCommand(JournalLineService journalLineService) {
        this.journalLineService=journalLineService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {

        String courseIdNew = req.getParameter("course_id");
        Long courseId = Long.parseLong(courseIdNew);

        String studentIdNew = req.getParameter("user_id");
        Long studentId = Long.parseLong(studentIdNew);

        boolean isDeleted = false;

        journalLineService.saveJournalLine(courseId, studentId, isDeleted);
        return "/WEB-INF/view/chooseCourse.jsp";
    }
}
