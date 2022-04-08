package com.epam.training.onlineTraining.mapper;

import com.epam.training.onlineTraining.entity.Course;
import com.epam.training.onlineTraining.entity.JournalLine;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JournalLineRowMapper implements RowMapper<JournalLine> {

    @Override
    public JournalLine map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(JournalLine.ID);
        Long courseId = resultSet.getLong(JournalLine.COURSE_ID);
        Long studentId = resultSet.getLong(JournalLine.STUDENT_ID);
        boolean is_deleted = resultSet.getBoolean(JournalLine.IS_DELETED);
        return new JournalLine(id, courseId, studentId, is_deleted);
    }
}
