package com.epam.training.onlineTraining.dao;

import com.epam.training.onlineTraining.entity.User;
import com.epam.training.onlineTraining.exception.DaoException;
import com.epam.training.onlineTraining.mapper.UserRowMapper;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    private static final String FIND_BY_LOGIN_AND_PASSWORD = "select * from user where login = ? and password = ?";

    public UserDaoImpl(Connection connection) {
        super(connection, new UserRowMapper(), User.TABLE);
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        return executeForSingleResult(
                FIND_BY_LOGIN_AND_PASSWORD,
                new UserRowMapper(),
                login,
                password);
    }

    @Override
    protected String getTableName() {
        return User.TABLE;
    }

    @Override
    protected Map<String, Object> getColumnValues(User entity) {
        Map<String, Object> valuesMap = new HashMap<>();
        valuesMap.put(User.ID, entity.getId());
        valuesMap.put(User.NAME, entity.getName());
        valuesMap.put(User.SURNAME, entity.getSurname());
        valuesMap.put(User.ROLE, entity.getRole().toString().toLowerCase());
        return valuesMap;
    }

    @Override
    public void removeById(long Id) {
    }
}
