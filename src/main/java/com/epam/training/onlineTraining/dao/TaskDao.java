package com.epam.training.onlineTraining.dao;

import com.epam.training.onlineTraining.entity.Course;
import com.epam.training.onlineTraining.entity.Task;
import com.epam.training.onlineTraining.exception.DaoException;

import java.util.List;

public interface TaskDao extends Dao<Task> {

    List<Task> getAllTasks() throws DaoException;
}
