package com.epam.training.onlineTraining.service;

import com.epam.training.onlineTraining.dao.DaoHelper;
import com.epam.training.onlineTraining.dao.DaoHelperFactory;
import com.epam.training.onlineTraining.dao.TaskDao;
import com.epam.training.onlineTraining.entity.Task;
import com.epam.training.onlineTraining.exception.DaoException;
import com.epam.training.onlineTraining.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements TaskService{

    private final DaoHelperFactory daoHelperFactory;

    public TaskServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public List<Task> getAllTasks() throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            TaskDao dao = helper.createTaskDao();
            List<Task> taskList = dao.getAllTasks();
            helper.endTransaction();
            return taskList;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Task getTaskById(Long id) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            TaskDao dao = helper.createTaskDao();
            Optional<Task> task = dao.getById(id);
            if (!task.isPresent()) {
                throw new ServiceException("This task doesn't exist");
            }
            helper.endTransaction();
            return task.get();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void saveTask(Long courseId, String taskContent, boolean isDeleted) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            TaskDao dao = helper.createTaskDao();
            Task task = new Task(null, courseId, taskContent, isDeleted);
            dao.save(task);
            helper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void editTask(Long id, Long courseId, String taskContent, boolean isDeleted) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            TaskDao dao = helper.createTaskDao();
            Task task = new Task(id, courseId, taskContent, isDeleted);
            dao.save(task);
            helper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteTaskById(Long taskId) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create() ){
            helper.startTransaction();
            TaskDao dao = helper.createTaskDao();
            dao.removeById(taskId);
            helper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
