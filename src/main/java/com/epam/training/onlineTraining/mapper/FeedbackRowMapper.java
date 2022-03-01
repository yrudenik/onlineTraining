package com.epam.training.onlineTraining.mapper;

import com.epam.training.onlineTraining.entity.Feedback;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackRowMapper implements RowMapper<Feedback>{

    @Override
    public Feedback map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(Feedback.ID);
        Long task_id = resultSet.getLong(Feedback.TASK_ID);
        Long student_id = resultSet.getLong(Feedback.STUDENT_ID);
        BigDecimal mark = resultSet.getBigDecimal(Feedback.MARK);
        String feedbackContent = resultSet.getString(Feedback.FEEDBACK_CONTENT);
        return new Feedback(id, task_id, student_id, mark, feedbackContent);
    }
}
