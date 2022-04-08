package com.epam.training.onlineTraining.command.teacherPage;

import com.epam.training.onlineTraining.command.Command;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.TaskService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditTaskCommand implements Command {

    private final TaskService taskService;

    public EditTaskCommand(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {

        String taskIdNew = req.getParameter("id");
        Long id = taskIdNew == null ? null : Long.parseLong(taskIdNew);

        String courseIdNew = req.getParameter("course_id");
        Long courseId = Long.parseLong(courseIdNew);

        String taskContent = req.getParameter("task_content");

        boolean isDeleted = false;

/*        String isDeletedNew = req.getParameter("is_deleted");
        boolean isDeleted = Boolean.parseBoolean(isDeletedNew);*/

        taskService.editTask(id, courseId, taskContent, isDeleted);
        return "/WEB-INF/view/manageTasks.jsp";
    }
}
