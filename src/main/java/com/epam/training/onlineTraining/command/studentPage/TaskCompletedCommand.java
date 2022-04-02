package com.epam.training.onlineTraining.command.studentPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.FeedbackService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TaskCompletedCommand implements Command {

    private final FeedbackService feedbackService;

    public TaskCompletedCommand(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String feedbackIdNew = req.getParameter("id");
        Long id = feedbackIdNew == null ? null : Long.parseLong(feedbackIdNew);

        String taskIdNew = req.getParameter("task_id");
        Long taskId = taskIdNew == null ? null : Long.parseLong(taskIdNew);

        String studentIdNew = req.getParameter("user_id");
        Long studentId = studentIdNew == null ? null : Long.parseLong(studentIdNew);

        String taskCompletion = req.getParameter("task_completion");

        feedbackService.saveTaskCompletion(id, taskId, studentId, taskCompletion);
        return "/WEB-INF/view/manageCourses.jsp";
    }
}


