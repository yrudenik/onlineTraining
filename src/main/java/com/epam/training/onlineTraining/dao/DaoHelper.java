package com.epam.training.onlineTraining.dao;

import com.epam.training.onlineTraining.connection.ConnectionPool;
import com.epam.training.onlineTraining.connection.ProxyConnection;
import com.epam.training.onlineTraining.exception.DaoException;

import java.sql.SQLException;

public class DaoHelper implements AutoCloseable {

    private final ProxyConnection connection;

    public DaoHelper(ConnectionPool pool) {
        this.connection = pool.getConnection();
    }

    public UserDao createUserDao() {
        return new UserDaoImpl(connection);
    }

    public CourseDao createCourseDao() {
        return new CourseDaoImpl(connection);
    }

    public TaskDao createTaskDao() {
        return new TaskDaoImpl(connection);
    }

    public FeedbackDao createFeedbackDao() {
        return new FeedbackDaoImpl(connection);
    }

    @Override
    public void close() throws DaoException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    public void startTransaction() throws DaoException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void endTransaction() throws DaoException {
        try {
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
