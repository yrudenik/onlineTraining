package com.epam.training.onlineTraining.service;

import com.epam.training.onlineTraining.entity.User;
import com.epam.training.onlineTraining.entity.UserRole;
import com.epam.training.onlineTraining.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> login(String login, String password) throws ServiceException;

    List<User> getAllUsers() throws ServiceException;

    User getUserById(Long id) throws ServiceException;

    void saveUser(Long id, String name, String surname, String login, UserRole role) throws ServiceException;

}
