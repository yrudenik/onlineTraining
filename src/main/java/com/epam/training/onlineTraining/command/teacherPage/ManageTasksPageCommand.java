package com.epam.training.onlineTraining.command.teacherPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.entity.Course;
import com.epam.training.onlineTraining.entity.Task;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.TaskService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ManageTasksPageCommand implements Command {

    private final TaskService taskService;

    public ManageTasksPageCommand(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        List<Task> taskList = taskService.getAllTasks();
        req.setAttribute("taskList", taskList);
        return "WEB-INF/view/manageTasks.jsp";
    }
}
