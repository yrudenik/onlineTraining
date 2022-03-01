package com.epam.training.onlineTraining.dao;

import com.epam.training.onlineTraining.entity.Task;
import com.epam.training.onlineTraining.exception.DaoException;
import com.epam.training.onlineTraining.mapper.TaskRowMapper;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskDaoImpl extends AbstractDao<Task> implements TaskDao{

    private static final String GET_ALL_TASKS_QUERY = "SELECT * FROM ? WHERE is_deleted=false";

    public TaskDaoImpl(Connection connection) {
        super(connection, new TaskRowMapper(), Task.TABLE);
    }

    @Override
    public List<Task> getAllTasks() throws DaoException {
        return executeQuery(GET_ALL_TASKS_QUERY, new TaskRowMapper(), Task.TABLE);
    }

    @Override
    protected String getTableName() {
        return Task.TABLE;
    }

    @Override
    protected Map<String, Object> getColumnValues(Task entity) {
        Map<String, Object> values = new HashMap<>();
        values.put(Task.ID, entity.getId());
        values.put(Task.COURSE_ID, entity.getCourseId());
        values.put(Task.TASK_CONTENT, entity.getTaskContent());
        values.put(Task.IS_DELETED, entity.isDeleted());
        return values;
    }

    @Override
    public void removeById(long Id) {
    }
}
