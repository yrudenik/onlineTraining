package com.epam.training.onlineTraining.service;

import com.epam.training.onlineTraining.entity.User;
import com.epam.training.onlineTraining.exception.ServiceException;

import java.util.Optional;

public interface UserService {

    Optional<User> login(String login, String password) throws ServiceException;
}
