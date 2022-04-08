package com.epam.training.onlineTraining.command;

import com.epam.training.onlineTraining.command.adminPage.*;
import com.epam.training.onlineTraining.command.studentPage.*;
import com.epam.training.onlineTraining.command.teacherPage.*;
import com.epam.training.onlineTraining.dao.DaoHelperFactory;
import com.epam.training.onlineTraining.service.*;

public class CommandFactory {

    public Command createCommand(String command) {
        switch (command) {
            case "loginCommand":
                return new LoginCommand(new UserServiceImpl(new DaoHelperFactory()));
            case "logOutCommand":
                return new LogOutCommand();
            case "changeLanguageCommand":
                return new ChangeLanguageCommand();
            case "courseSubmitCommand":
                return new CourseSubmitCommand(new JournalLineServiceImpl(new DaoHelperFactory()));
            case "taskCompletedCommand":
                return new TaskCompletedCommand(new FeedbackServiceImpl(new DaoHelperFactory()));
            case "taskInformationCommand":
                return new TaskInformationCommand(new TaskServiceImpl(new DaoHelperFactory()));
            case "addCourseCommand":
                return new AddCourseCommand(new CourseServiceImpl(new DaoHelperFactory()));
            case "editCourseCommand":
                return new EditCourseCommand(new CourseServiceImpl(new DaoHelperFactory()));
            case "editTaskCommand":
                return new EditTaskCommand(new TaskServiceImpl(new DaoHelperFactory()));
            case "removeCourseCommand":
                return new RemoveCourseCommand(new CourseServiceImpl(new DaoHelperFactory()));
            case "courseJournalCommand":
                return new CourseJournalCommand(new CourseServiceImpl(new DaoHelperFactory()));
            case "addTaskCommand":
                return new AddTaskCommand(new TaskServiceImpl(new DaoHelperFactory()));
            case "removeTaskCommand":
                return new RemoveTaskCommand(new TaskServiceImpl(new DaoHelperFactory()));
            case "taskFeedbackCommand":
                return new TaskFeedbackCommand(new FeedbackServiceImpl(new DaoHelperFactory()));
            case "removeFeedbackCommand":
                return new RemoveFeedbackCommand(new FeedbackServiceImpl(new DaoHelperFactory()));
            case "loginPage":
                return new LoginPageCommand();
            case "mainPage":
                return new MainPageCommand();
            case "mainPageTeacher":
                return new MainPageTeacherCommand();
            case "mainPageStudent":
                return new MainPageStudentCommand();
            case "manageCoursesPage":
                return new ManageCoursesPageCommand(new CourseServiceImpl(new DaoHelperFactory()));
            case "addCoursePage":
                return new AddCoursePageCommand();
            case "editCoursePage":
                return new EditCoursePageCommand(new CourseServiceImpl(new DaoHelperFactory()));
            case "courseJournalAdminPage":
                return new CourseJournalAdminPageCommand(new JournalLineServiceImpl(new DaoHelperFactory()));
            case "courseJournalTeacherPage":
                return new CourseJournalTeacherPageCommand(new JournalLineServiceImpl(new DaoHelperFactory()));
            case "manageTasksPage":
                return new ManageTasksPageCommand(new TaskServiceImpl(new DaoHelperFactory()));
            case "addTaskPage":
                return new AddTaskPageCommand();
            case "editTaskPage":
                return new EditTaskPageCommand(new TaskServiceImpl(new DaoHelperFactory()));
            case "tasksCheckingPage":
                return new TasksCheckingPageCommand(new FeedbackServiceImpl(new DaoHelperFactory()));
            case "chooseCoursePage":
                return new ChooseCoursePageCommand(new CourseServiceImpl(new DaoHelperFactory()));
            case "taskInformationPage":
                return new TaskInformationPageCommand(new TaskServiceImpl(new DaoHelperFactory()));
            default:
                throw new IllegalArgumentException("Unknown command = " + command);
        }
    }
}
