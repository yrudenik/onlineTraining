package com.epam.training.onlineTraining.dao;

import com.epam.training.onlineTraining.entity.Course;
import com.epam.training.onlineTraining.exception.DaoException;
import com.epam.training.onlineTraining.mapper.CourseRowMapper;

import java.sql.Connection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CourseDaoImpl extends AbstractDao<Course> implements CourseDao{

    private static final String GET_ALL_COURSES_QUERY = "select * from %s where is_deleted = false ";

            //"SELECT * FROM ? WHERE is_deleted=false";

    public CourseDaoImpl(Connection connection) {
        super(connection, new CourseRowMapper(), Course.TABLE);
    }

    @Override
    protected String getTableName() {
        return Course.TABLE;
    }

    @Override
    protected LinkedHashMap<String, Object> getColumnValues(Course entity) {
        LinkedHashMap<String, Object> values = new LinkedHashMap<>();
        values.put(Course.ID, entity.getId());
        values.put(Course.TEACHER_ID, entity.getTeacherId());
        values.put(Course.COURSE_TITLE, entity.getCourseTitle());
        values.put(Course.START_DATE, entity.getStartDate());
        values.put(Course.END_DATE, entity.getEndDate());
        values.put(Course.PRICE, entity.getPrice());
        values.put(Course.IS_DELETED, entity.isDeleted());
        return values;
    }

    @Override
    public List<Course> getAllCourses() throws DaoException {
        String query = String.format(GET_ALL_COURSES_QUERY, Course.TABLE);
        return executeQuery(query);
    }

    @Override
    public void removeById(long Id) {
    }
}
