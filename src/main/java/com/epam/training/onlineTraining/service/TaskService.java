package com.epam.training.onlineTraining.service;

import com.epam.training.onlineTraining.entity.Task;
import com.epam.training.onlineTraining.exception.ServiceException;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks() throws ServiceException;

    Task getTaskById(Long id) throws ServiceException;

    void saveTask(Long id, Long courseId, String taskContent, boolean isDeleted) throws ServiceException;

    void deleteTaskById(Long taskId) throws ServiceException;

}
