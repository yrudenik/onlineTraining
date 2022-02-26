package com.epam.training.onlineTraining.dao;

import com.epam.training.onlineTraining.entity.User;
import com.epam.training.onlineTraining.exception.DaoException;

import java.util.Optional;

public interface UserDao {

    Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException;

}
