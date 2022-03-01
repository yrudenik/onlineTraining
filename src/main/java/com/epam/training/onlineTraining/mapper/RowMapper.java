package com.epam.training.onlineTraining.mapper;

import com.epam.training.onlineTraining.entity.Course;
import com.epam.training.onlineTraining.entity.Identifable;
import com.epam.training.onlineTraining.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T extends Identifable> {

    T map(ResultSet resultSet) throws SQLException;

    static RowMapper<? extends Identifable> create(String table){
        switch (table){
            case User.TABLE:
                return new UserRowMapper();
            case Course.TABLE:
                return new UserRowMapper();
            default:
                throw new IllegalArgumentException("Unknown table = " + table);
        }
    }
}
