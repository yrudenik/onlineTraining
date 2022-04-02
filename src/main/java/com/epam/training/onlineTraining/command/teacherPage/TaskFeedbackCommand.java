package com.epam.training.onlineTraining.command.teacherPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.entity.Feedback;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.FeedbackService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

public class TaskFeedbackCommand implements Command {

    private final FeedbackService feedbackService;

    public TaskFeedbackCommand(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {

        String feedbackIdNew = req.getParameter("id");
        Long id = feedbackIdNew == null ? null : Long.parseLong(feedbackIdNew);

        String markNew = req.getParameter("mark");
        BigDecimal mark = markNew == null ? null : new BigDecimal(markNew);

        String feedbackContent = req.getParameter("feedback_content");

        String isDeletedNew = req.getParameter("is_deleted");
        boolean isDeleted = Boolean.parseBoolean(isDeletedNew);

        feedbackService.saveFeedbackById(id, mark, feedbackContent, isDeleted);
        return "/WEB-INF/view/taskChecking.jsp";
    }
}
