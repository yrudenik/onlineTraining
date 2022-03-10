package com.epam.training.onlineTraining.mapper;

import com.epam.training.onlineTraining.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends Identifable> {

    T map(ResultSet resultSet) throws SQLException;

    static RowMapper<? extends Identifable> create(String table){
        switch (table){
            case User.TABLE:
                return new UserRowMapper();
            case Course.TABLE:
                return new CourseRowMapper();
            case Task.TABLE:
                return new TaskRowMapper();
            case Feedback.TABLE:
                return new FeedbackRowMapper();
            default:
                throw new IllegalArgumentException("Unknown table = " + table);
        }
    }
}
