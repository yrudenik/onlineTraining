package com.epam.training.onlineTraining.command.teacherPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.entity.Course;
import com.epam.training.onlineTraining.entity.JournalLine;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.CourseService;
import com.epam.training.onlineTraining.service.JournalLineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CourseJournalTeacherPageCommand implements Command {

    private final JournalLineService journalLineService;

    public CourseJournalTeacherPageCommand(JournalLineService journalLineService) {
        this.journalLineService = journalLineService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        List<JournalLine> journalLineList = journalLineService.getJournal();
        req.setAttribute("journalLineList", journalLineList);
        return "/WEB-INF/view/courseJournalAdmin.jsp";
    }
}
