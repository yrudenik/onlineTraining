package com.epam.training.onlineTraining.dao;

import com.epam.training.onlineTraining.entity.User;
import com.epam.training.onlineTraining.exception.DaoException;
import com.epam.training.onlineTraining.mapper.UserRowMapper;

import java.sql.Connection;
import java.util.*;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    private static final String FIND_BY_LOGIN_AND_PASSWORD = "SELECT * FROM user WHERE login = ? AND password = ? ";
    //"SELECT * FROM %s WHERE %s = ? AND password = MD5(?)";

    public UserDaoImpl(Connection connection) {
        super(connection, new UserRowMapper(), User.TABLE);
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        //String query = String.format(FIND_BY_LOGIN_AND_PASSWORD, User.TABLE, User.LOGIN);
        return executeForSingleResult(
                FIND_BY_LOGIN_AND_PASSWORD,
                login,
                password);
    }

    @Override
    protected String getTableName() {
        return User.TABLE;
    }

    @Override
    protected LinkedHashMap<String, Object> getColumnValues(User entity) {
        LinkedHashMap<String, Object> valuesMap = new LinkedHashMap<>();
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
