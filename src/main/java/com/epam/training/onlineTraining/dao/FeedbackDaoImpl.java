package com.epam.training.onlineTraining.dao;

import com.epam.training.onlineTraining.entity.Feedback;
import com.epam.training.onlineTraining.exception.DaoException;
import com.epam.training.onlineTraining.mapper.FeedbackRowMapper;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FeedbackDaoImpl extends AbstractDao<Feedback> implements FeedbackDao{

    private static final String GET_ALL_FEEDBACKS_QUERY = "SELECT * FROM ?";

    public FeedbackDaoImpl(Connection connection) {
        super(connection, new FeedbackRowMapper(), Feedback.TABLE);
    }

    @Override
    protected String getTableName() {
        return Feedback.TABLE;
    }

    @Override
    protected Map<String, Object> getColumnValues(Feedback entity) {
        Map<String, Object> values = new HashMap<>();
        values.put(Feedback.ID, entity.getId());
        values.put(Feedback.TASK_ID, entity.getTaskId());
        values.put(Feedback.STUDENT_ID, entity.getStudentId());
        values.put(Feedback.TASK_COMPLETION, entity.getTaskCompletion());
        values.put(Feedback.MARK, entity.getMark());
        values.put(Feedback.FEEDBACK_CONTENT, entity.getFeedbackContent());
        return values;
    }

    @Override
    public void removeById(long Id) {
    }

    @Override
    public List<Feedback> getAllFeedbacks() throws DaoException {
        return executeQuery(GET_ALL_FEEDBACKS_QUERY, new FeedbackRowMapper(), Feedback.TABLE);
    }
}

