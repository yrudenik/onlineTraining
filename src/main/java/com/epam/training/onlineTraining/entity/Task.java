package com.epam.training.onlineTraining.entity;

public class Task implements Identifable {

    public static final String TABLE = "task";
    public static final String ID = "id";
    public static final String COURSE_ID = "course_id";
    public static final String TASK_CONTENT = "task_content";
    public static final String IS_DELETED = "is_deleted";

    private final Long id;
    private final Long courseId;
    private final String taskContent;
    private final boolean isDeleted;

    public Task(Long id, Long courseId, String taskContent, boolean isDeleted) {
        this.id = id;
        this.courseId = courseId;
        this.taskContent = taskContent;
        this.isDeleted = isDeleted;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getTaskContent() {
        return taskContent;
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

        Task task = (Task) o;

        if (id != null ? !id.equals(task.id) : task.id != null) {
            return false;
        }
        if (courseId != null ? !courseId.equals(task.courseId) : task.courseId != null) {
            return false;
        }
        return taskContent != null ? !taskContent.equals(task.taskContent) : task.taskContent != null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (taskContent != null ? taskContent.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", courseId='" + courseId + '\'' +
                ", taskContent=" + taskContent +
                ", isDeleted=" + isDeleted +
                '}';
    }
}

