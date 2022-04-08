package com.epam.training.onlineTraining.entity;

import java.util.Objects;

public class JournalLine implements Identifable {

    public static final String TABLE = "courses_journal";
    public static final String ID = "id";
    public static final String COURSE_ID = "course_id";
    public static final String STUDENT_ID = "user_id";
    public static final String IS_DELETED = "is_deleted";

    private final Long id;
    private final Long courseId;
    private final Long studentId;
    private final boolean isDeleted;

    public JournalLine(Long id, Long courseId, Long studentId, boolean isDeleted) {
        this.id = id;
        this.courseId = courseId;
        this.studentId = studentId;
        this.isDeleted = isDeleted;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public Long getStudentId() {
        return studentId;
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

        JournalLine journalLine = (JournalLine) o;

        if (!Objects.equals(id, journalLine.id)) {
            return false;
        }
        if (!Objects.equals(courseId, journalLine.courseId)) {
            return false;
        }
        return !Objects.equals(studentId, journalLine.studentId);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", studentId=" + studentId +
                ", isDeleted=" + isDeleted +
                '}';
    }
}

