package com.epam.training.onlineTraining.service;

import com.epam.training.onlineTraining.entity.Feedback;
import com.epam.training.onlineTraining.exception.ServiceException;

import java.math.BigDecimal;
import java.util.List;

public interface FeedbackService {


    List<Feedback> getAllFeedbacks() throws ServiceException;

    Feedback getFeedbackById(Long id) throws ServiceException;

    void saveTaskCompletion (Long id, Long taskId, Long studentId, String taskCompletion) throws ServiceException;

    void saveFeedbackById(Long taskFeedbackId, BigDecimal mark, String feedbackContent, boolean isDeleted) throws ServiceException;

    void deleteFeedbackById(Long feedbackId) throws ServiceException;

}
