package com.epam.training.onlineTraining.mapper;

import com.epam.training.onlineTraining.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User map(ResultSet resultSet) throws SQLException {
        return new User();
    }
}
