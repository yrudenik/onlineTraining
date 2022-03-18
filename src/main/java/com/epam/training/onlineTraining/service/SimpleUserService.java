package com.epam.training.onlineTraining.service;

import com.epam.training.onlineTraining.dao.UserDao;
import com.epam.training.onlineTraining.entity.User;
import com.epam.training.onlineTraining.entity.UserRole;
import com.epam.training.onlineTraining.exception.DaoException;
import com.epam.training.onlineTraining.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public class SimpleUserService implements UserService {

    private final UserDao dao;

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

    @Override
    public List<User> getAllUsers() throws ServiceException {
        return null;
    }

    @Override
    public User getUserById(Long id) throws ServiceException {
        return null;
    }

    @Override
    public void saveUser(Long id, String name, String surname, String login, UserRole role) throws ServiceException {

    }
}
