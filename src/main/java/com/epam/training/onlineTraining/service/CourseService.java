package com.epam.training.onlineTraining.service;

import com.epam.training.onlineTraining.entity.Course;
import com.epam.training.onlineTraining.exception.ServiceException;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface CourseService {

    List<Course> getAllCourses() throws ServiceException;

    Course getCourseById(Long id) throws ServiceException;

    void saveCourse(Long id, Long teacherId, String courseTitle, Date startDate, Date endDate, BigDecimal price, boolean isDeleted) throws ServiceException;

    void deleteCourseById(Long courseId) throws ServiceException;

}
