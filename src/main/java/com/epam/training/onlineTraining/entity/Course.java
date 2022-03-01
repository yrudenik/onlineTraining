package com.epam.training.onlineTraining.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Course implements Identifable {

    public static final String TABLE = "course";
    public static final String ID = "id";
    public static final String COURSE_TITLE = "course_title";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
    public static final String PRICE = "price";
    public static final String IS_DELETED = "is_deleted";

    private final Long id;
    private final String courseTitle;
    private final Date startDate;
    private final Date endDate;
    private final BigDecimal price;
    private final boolean isDeleted;

    public Course(Long id, String courseTitle, Date startDate, Date endDate, BigDecimal price, boolean isDeleted) {
        this.id = id;
        this.courseTitle = courseTitle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.isDeleted = isDeleted;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Course course = (Course) o;

        if (id != null ? !id.equals(course.id) : course.id != null) {
            return false;
        }
        if (courseTitle != null ? !courseTitle.equals(course.courseTitle) : course.courseTitle != null) {
            return false;
        }
        if (startDate != null ? !startDate.equals(course.startDate) : course.startDate != null) {
            return false;
        }
        if (endDate != null ? !endDate.equals(course.endDate) : course.endDate != null) {
            return false;
        }
        return price != null ? !price.equals(course.price) : course.price != null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (courseTitle != null ? courseTitle.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseTitle='" + courseTitle + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
