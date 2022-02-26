package com.epam.training.onlineTraining.service;

import com.epam.training.onlineTraining.dao.UserDao;
import com.epam.training.onlineTraining.entity.User;
import com.epam.training.onlineTraining.exception.DaoException;
import com.epam.training.onlineTraining.exception.ServiceException;

import java.util.Optional;

public class SimpleUserService implements UserService {

    private UserDao dao;

    public SimpleUserService(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public Optional<User> login(String login, String password) throws ServiceException {
        try {
            Optional<User> user = dao.findUserByLoginAndPassword(login, password);
            return user;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
