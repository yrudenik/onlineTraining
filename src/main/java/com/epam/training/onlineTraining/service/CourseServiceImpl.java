package com.epam.training.onlineTraining.service;

import com.epam.training.onlineTraining.dao.CourseDao;
import com.epam.training.onlineTraining.dao.DaoHelper;
import com.epam.training.onlineTraining.dao.DaoHelperFactory;
import com.epam.training.onlineTraining.entity.Course;
import com.epam.training.onlineTraining.exception.DaoException;
import com.epam.training.onlineTraining.exception.ServiceException;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CourseServiceImpl implements CourseService{

    private final DaoHelperFactory daoHelperFactory;

    public CourseServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public List<Course> getAllCourses() throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            CourseDao dao = helper.createCourseDao();
            List<Course> courseList = dao.getAllCourses();
            helper.endTransaction();
            return courseList;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Course getCourseById(Long id) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            CourseDao dao = helper.createCourseDao();
            Optional<Course> course = dao.getById(id);
            if (!course.isPresent()) {
                throw new ServiceException("This course doesn't exist");
            }
            helper.endTransaction();
            return course.get();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void saveCourse(Long id, Long teacherId, String courseTitle, Date startDate, Date endDate, BigDecimal price, boolean isDeleted) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            CourseDao dao = helper.createCourseDao();
            Course course = new Course(id, teacherId, courseTitle, startDate, endDate, price, isDeleted);
            dao.save(course);
            helper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteCourseById(Long courseId) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create() ){
            helper.startTransaction();
            CourseDao dao = helper.createCourseDao();
            dao.removeById(courseId);
            helper.endTransaction();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
