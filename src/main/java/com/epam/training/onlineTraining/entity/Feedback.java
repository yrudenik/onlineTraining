package com.epam.training.onlineTraining.entity;

import java.math.BigDecimal;

public class Feedback implements Identifable{

    public static final String TABLE = "feedback_journal";
    public static final String ID = "id";
    public static final String TASK_ID = "task_id";
    public static final String STUDENT_ID = "user_id";
    public static final String TASK_COMPLETION = "task_completion";
    public static final String MARK = "mark";
    public static final String FEEDBACK_CONTENT = "feedback";
    public static final String IS_DELETED = "is_deleted";

    private final Long id;
    private final Long taskId;
    private final Long studentId;
    private final String taskCompletion;
    private BigDecimal mark;
    private String feedbackContent;
    private boolean isDeleted;

    public Feedback(Long id, Long taskId, Long studentId, String taskCompletion, BigDecimal mark, String feedbackContent, boolean isDeleted) {
        this.id = id;
        this.taskId = taskId;
        this.studentId = studentId;
        this.taskCompletion = taskCompletion;
        this.mark = mark;
        this.feedbackContent = feedbackContent;
        this.isDeleted = isDeleted;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getTaskCompletion() {
        return taskCompletion;
    }

    public BigDecimal getMark() {
        return mark;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setMark(BigDecimal mark) {
        this.mark = mark;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Feedback feedback = (Feedback) o;

        if (id != null ? !id.equals(feedback.id) : feedback.id != null) {
            return false;
        }
        if (taskId != null ? !taskId.equals(feedback.taskId) : feedback.taskId != null) {
            return false;
        }
        if (studentId != null ? !studentId.equals(feedback.studentId) : feedback.studentId != null) {
            return false;
        }
        if (mark != null ? !mark.equals(feedback.mark) : feedback.mark != null) {
            return false;
        }
        if (taskCompletion != null ? !taskCompletion.equals(feedback.taskCompletion) : feedback.taskCompletion != null) {
            return false;
        }
        return feedbackContent != null ? !feedbackContent.equals(feedback.feedbackContent) : feedback.feedbackContent != null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (taskId != null ? taskId.hashCode() : 0);
        result = 31 * result + (studentId != null ? studentId.hashCode() : 0);
        result = 31 * result + (taskCompletion != null ? taskCompletion.hashCode() : 0);
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        result = 31 * result + (feedbackContent != null ? feedbackContent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", taskId='" + taskId + '\'' +
                ", studentId='" + studentId + '\'' +
                ", taskCompletion=" + taskCompletion +
                ", mark=" + mark +
                ", feedbackContent=" + feedbackContent +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
