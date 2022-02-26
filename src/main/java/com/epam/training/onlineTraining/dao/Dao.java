package com.epam.training.onlineTraining.dao;

import com.epam.training.onlineTraining.entity.Identifable;
import com.epam.training.onlineTraining.exception.DaoException;

import java.util.List;
import java.util.Optional;

//CRUD
public interface Dao<T extends Identifable> {

    Optional<T> getById(Long Id) throws DaoException;

    List<T> getAll() throws DaoException;

    void save(T item) throws DaoException;

    void removeById(long Id);
}
