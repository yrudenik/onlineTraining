package com.epam.training.onlineTraining.command.teacherPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.entity.Feedback;
import com.epam.training.onlineTraining.entity.Task;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.FeedbackService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class TasksCheckingPageCommand implements Command {

    private final FeedbackService feedbackService;

    public TasksCheckingPageCommand(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        List<Feedback> feedbackList = feedbackService.getAllFeedbacks();
        req.setAttribute("feedbackList", feedbackList);
        return "/WEB-INF/view/taskChecking.jsp";
    }
}
