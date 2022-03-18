package com.epam.training.onlineTraining.command;

import com.epam.training.onlineTraining.entity.User;
import com.epam.training.onlineTraining.exception.ServiceException;
import com.epam.training.onlineTraining.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LoginCommand implements com.epam.training.onlineTraining.command.Command {

    private final UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServiceException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Optional<User> user = userService.login(login, password);
        if (user.isPresent()) {
            req.getSession().setAttribute("user", user.get());
            return "/WEB-INF/view/main.jsp";
        } else {
            req.setAttribute("errorMessage", "Invalid login/password. Try again");
            return "/index.jsp";
        }
    }
}
