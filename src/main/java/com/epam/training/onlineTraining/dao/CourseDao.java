package com.epam.training.onlineTraining.dao;

import com.epam.training.onlineTraining.entity.Course;
import com.epam.training.onlineTraining.exception.DaoException;

import java.util.List;

public interface CourseDao {

    List<Course> getAllCourses() throws DaoException;
}
