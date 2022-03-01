package com.epam.training.onlineTraining.mapper;

import com.epam.training.onlineTraining.entity.Course;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CourseRowMapper implements RowMapper<Course>{

    @Override
    public Course map(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong(Course.ID);
        String course_title = resultSet.getString(Course.COURSE_TITLE);
        Date start_date = resultSet.getDate(Course.START_DATE);
        Date end_date = resultSet.getDate(Course.END_DATE);
        BigDecimal price = resultSet.getBigDecimal(Course.PRICE);
        boolean is_deleted = resultSet.getBoolean(Course.IS_DELETED);
        return new Course(id, course_title, start_date, end_date, price, is_deleted);

    }
}
