package com.epam.training.onlineTraining.dao;

import com.epam.training.onlineTraining.entity.Feedback;
import com.epam.training.onlineTraining.exception.DaoException;

import java.util.List;

public interface FeedbackDao {

    List<Feedback> getAllFeedbacks() throws DaoException;

}

