package com.epam.training.onlineTraining.dao;

import com.epam.training.onlineTraining.entity.Task;
import com.epam.training.onlineTraining.exception.DaoException;
import com.epam.training.onlineTraining.mapper.TaskRowMapper;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.List;

public class TaskDaoImpl extends AbstractDao<Task> implements TaskDao{

    private static final String GET_ALL_TASKS_QUERY = "SELECT * FROM %s WHERE is_deleted=false";
    private static final String REMOVE_TASK_QUERY = "update task set is_deleted = true WHERE id = ? ";

    public TaskDaoImpl(Connection connection) {
        super(connection, new TaskRowMapper(), Task.TABLE);
    }

    @Override
    public List<Task> getAllTasks() throws DaoException {
        String query = String.format(GET_ALL_TASKS_QUERY, Task.TABLE);
        return executeQuery(query);
    }

    @Override
    protected String getTableName() {
        return Task.TABLE;
    }

    @Override
    protected LinkedHashMap<String, Object> getColumnValues(Task entity) {
        LinkedHashMap<String, Object> values = new LinkedHashMap<>();
        values.put(Task.ID, entity.getId());
        values.put(Task.COURSE_ID, entity.getCourseId());
        values.put(Task.TASK_CONTENT, entity.getTaskContent());
        values.put(Task.IS_DELETED, entity.isDeleted());
        return values;
    }

    @Override
    public void removeById(long Id) throws DaoException {
        executeUpdate(REMOVE_TASK_QUERY, Id);
    }
}
