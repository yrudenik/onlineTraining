package com.epam.training.onlineTraining.dao;

import com.epam.training.onlineTraining.entity.Course;
import com.epam.training.onlineTraining.exception.DaoException;
import com.epam.training.onlineTraining.mapper.CourseRowMapper;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseDaoImpl extends AbstractDao<Course> implements CourseDao{

    private static final String GET_ALL_COURSES_QUERY = "SELECT * FROM ? WHERE is_deleted=false";

    public CourseDaoImpl(Connection connection) {
        super(connection, new CourseRowMapper(), Course.TABLE);
    }

    @Override
    protected String getTableName() {
        return Course.TABLE;
    }

    @Override
    protected Map<String, Object> getColumnValues(Course entity) {
        Map<String, Object> values = new HashMap<>();
        values.put(Course.ID, entity.getId());
        values.put(Course.COURSE_TITLE, entity.getCourseTitle());
        values.put(Course.START_DATE, entity.getStartDate());
        values.put(Course.END_DATE, entity.getEndDate());
        values.put(Course.PRICE, entity.getPrice());
        values.put(Course.IS_DELETED, entity.isDeleted());
        return values;
    }

    @Override
    public List<Course> getAllCourses() throws DaoException {
        return executeQuery(GET_ALL_COURSES_QUERY, new CourseRowMapper(), Course.TABLE );
    }

    @Override
    public void removeById(long Id) {
    }
}
