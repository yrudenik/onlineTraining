package com.epam.training.onlineTraining.command.teacherPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.FeedbackService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveFeedbackCommand implements Command {

    private final FeedbackService feedbackService;

    public RemoveFeedbackCommand(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }


    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String feedbackIdNew = req.getParameter("id");
        Long id = feedbackIdNew == null ? null : Long.parseLong(feedbackIdNew);
        feedbackService.deleteFeedbackById(id);
        return "/WEB-INF/view/manageTasks.jsp";
    }
}
