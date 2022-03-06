package com.epam.training.onlineTraining.command;

import com.epam.training.onlineTraining.command.adminPage.*;
import com.epam.training.onlineTraining.command.studentPage.*;
import com.epam.training.onlineTraining.command.teacherPage.*;
import com.epam.training.onlineTraining.dao.DaoHelperFactory;
import com.epam.training.onlineTraining.service.UserServiceImpl;

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
                return new CourseSubmitCommand();
            case "taskCompletedCommand":
                return new TaskCompletedCommand();
            case "taskInformationCommand":
                return new TaskInformationCommand();
            case "addCourseCommand":
                return new AddCourseCommand();
            case "removeCourseCommand":
                return new RemoveCourseCommand();
            case "assignTeacherCommand":
                return new AssignTeacherCommand();
            case "courseJournalCommand":
                return new CourseJournalCommand();
            case "addTaskCommand":
                return new AddTaskCommand();
            case "removeTaskCommand":
                return new RemoveTaskCommand();
            case "taskFeedbackCommand":
                return new TaskFeedbackCommand();
            case "removeFeedbackCommand":
                return new RemoveFeedbackCommand();
            case "loginPage":
                return new LoginPageCommand();
            case "mainPageAdmin":
                return new MainPageAdminCommand();
            case "mainPageTeacher":
                return new MainPageTeacherCommand();
            case "mainPageStudent":
                return new MainPageStudentCommand();
            case "manageCoursesPage":
                return new ManageCoursesPageCommand();
            case "assignTeacherPage":
                return new AssignTeacherPageCommand();
            case "courseJournalAdminPage":
                return new CourseJournalAdminPageCommand();
            case "courseJournalTeacherPage":
                return new CourseJournalTeacherPageCommand();
            case "manageTasksPage":
                return new ManageTasksPageCommand();
            case "tasksCheckingPage":
                return new TasksCheckingPageCommand();
            case "chooseCoursePage":
                return new ChooseCoursePageCommand();
            case "taskInformationPage":
                return new TaskInformationPageCommand();
            default:
                throw new IllegalArgumentException("Unknown command = " + command);
        }
    }
}
