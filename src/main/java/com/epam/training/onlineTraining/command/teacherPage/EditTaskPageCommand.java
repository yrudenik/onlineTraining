package com.epam.training.onlineTraining.command.teacherPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.entity.Task;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.TaskService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditTaskPageCommand implements Command {

    private final TaskService taskService;

    public EditTaskPageCommand(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null) {
            String taskIdLine = req.getParameter("id");
            Long taskId = Long.valueOf(taskIdLine);
            Task task = taskService.getTaskById(taskId);
            req.setAttribute("task", task);
            return "/WEB-INF/view/editTask.jsp";
        } else {
            return "/WEB-INF/view/index.jsp";
        }
    }

    /*    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null) {
            return "/WEB-INF/view/editTask.jsp";
        } else {
            return "/WEB-INF/view/index.jsp";
        }
    }*/

}
