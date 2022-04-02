package com.epam.training.onlineTraining.command.teacherPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.TaskService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveTaskCommand implements Command {

    private final TaskService taskService;

    public RemoveTaskCommand(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String taskIdNew = req.getParameter("id");
        Long id = taskIdNew == null ? null : Long.parseLong(taskIdNew);
        taskService.deleteTaskById(id);
        return "/WEB-INF/view/manageTasks.jsp";
    }
}
