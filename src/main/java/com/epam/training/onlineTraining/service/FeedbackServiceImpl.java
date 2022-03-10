package com.epam.training.onlineTraining.service;

import com.epam.training.onlineTraining.dao.DaoHelper;
import com.epam.training.onlineTraining.dao.DaoHelperFactory;
import com.epam.training.onlineTraining.dao.FeedbackDao;
import com.epam.training.onlineTraining.entity.Feedback;
import com.epam.training.onlineTraining.exception.DaoException;
import com.epam.training.onlineTraining.exception.ServiceException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class FeedbackServiceImpl implements FeedbackService{

    private final DaoHelperFactory daoHelperFactory;

    public FeedbackServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public List<Feedback> getAllFeedbacks() throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            FeedbackDao dao = helper.createFeedbackDao();
            List<Feedback> feedbackList = dao.getAllFeedbacks();
            helper.endTransaction();
            return feedbackList;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Feedback getFeedbackById(Long id) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            FeedbackDao dao = helper.createFeedbackDao();
            Optional<Feedback> feedback = dao.getById(id);
            if (!feedback.isPresent()) {
                throw new ServiceException("This feedback doesn't exist");
            }
            helper.endTransaction();
            return feedback.get();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void saveTaskCompletion(Long id, Long taskId, Long studentId, String taskCompletion) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            FeedbackDao dao = helper.createFeedbackDao();
            Feedback studentTaskCompletion = new Feedback(id, taskId, studentId, taskCompletion, null, null, false);
            dao.save(studentTaskCompletion);
            helper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void saveFeedbackById(Long taskFeedbackId, BigDecimal mark, String feedbackContent, boolean isDeleted) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            FeedbackDao dao = helper.createFeedbackDao();
            Optional<Feedback> feedback = dao.getById(taskFeedbackId);
            feedback.ifPresent(value -> value.setMark(mark));
            feedback.ifPresent(value -> value.setFeedbackContent(feedbackContent));
            feedback.ifPresent(value -> value.setDeleted(isDeleted));
            if (feedback.isPresent()) {
                dao.save(feedback.get());
            }
            helper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

/*    @Override
    public void saveFeedback(Long id, Long taskId, Long studentId, String taskCompletion, BigDecimal mark, String feedbackContent, boolean isDeleted) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            FeedbackDao dao = helper.createFeedbackDao();
            Feedback feedback = new Feedback(id, taskId, studentId, taskCompletion, mark, feedbackContent, isDeleted);
            dao.save(feedback);
            helper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }*/

    @Override
    public void deleteFeedbackById(Long feedbackId) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create() ){
            helper.startTransaction();
            FeedbackDao dao = helper.createFeedbackDao();
            dao.removeById(feedbackId);
            helper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
