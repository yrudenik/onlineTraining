package com.epam.training.onlineTraining.mapper;

import com.epam.training.onlineTraining.entity.Task;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskRowMapper implements RowMapper<Task>{

    @Override
    public Task map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(Task.ID);
        Long course_id = resultSet.getLong(Task.COURSE_ID);
        String task_content = resultSet.getString(Task.TASK_CONTENT);
        boolean is_deleted = resultSet.getBoolean(Task.IS_DELETED);
        return new Task(id, course_id, task_content, is_deleted);
    }
}
