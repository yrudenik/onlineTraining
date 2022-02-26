package com.epam.training.onlineTraining.dao;

import com.epam.training.onlineTraining.connection.ConnectionPool;
import com.epam.training.onlineTraining.exception.DaoException;

import java.io.IOException;
import java.sql.SQLException;

public class DaoHelperFactory {

    public DaoHelper create() throws DaoException {
        try {
            return new DaoHelper(ConnectionPool.getInstance());
        } catch (SQLException | IOException | ClassNotFoundException e) {
            throw new DaoException(e);
        }
    }
}
