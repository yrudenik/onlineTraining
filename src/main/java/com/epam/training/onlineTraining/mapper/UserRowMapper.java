package com.epam.training.onlineTraining.mapper;

import com.epam.training.onlineTraining.entity.User;
import com.epam.training.onlineTraining.entity.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(User.ID);
        String login = resultSet.getString(User.LOGIN);
        String name = resultSet.getString(User.NAME);
        String surname = resultSet.getString(User.SURNAME);
        UserRole role = UserRole.valueOf(resultSet.getString(User.ROLE).toUpperCase());
        return new User(id, login, name, surname, role);
    }
}
