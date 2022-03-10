package com.epam.training.onlineTraining.command.teacherPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.entity.Task;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.TaskService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.sql.Date;

public class AddTaskCommand implements Command {

    private final TaskService taskService;

    public AddTaskCommand(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {

        String taskIdNew = req.getParameter("id");
        Long taskId = taskIdNew == null ? null : Long.parseLong(taskIdNew);

        String courseIdNew = req.getParameter("course_id");
        Long courseId = Long.parseLong(courseIdNew);

        String taskContent = req.getParameter("task_content");

        String isDeletedNew = req.getParameter("is_deleted");
        boolean isDeleted = Boolean.parseBoolean(isDeletedNew);

        taskService.saveTask(taskId, courseId, taskContent, isDeleted);
        return "WEB-INF/view/manageCourses.jsp";
    }
}

