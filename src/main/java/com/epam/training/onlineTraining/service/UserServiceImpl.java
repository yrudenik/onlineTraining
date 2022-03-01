package com.epam.training.onlineTraining.service;

import com.epam.training.onlineTraining.dao.DaoHelper;
import com.epam.training.onlineTraining.dao.DaoHelperFactory;
import com.epam.training.onlineTraining.dao.UserDao;
import com.epam.training.onlineTraining.entity.User;
import com.epam.training.onlineTraining.exception.DaoException;
import com.epam.training.onlineTraining.exception.ServiceException;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final DaoHelperFactory daoHelperFactory;

    public UserServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public Optional<User> login(String login, String password) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            helper.startTransaction();
            UserDao dao = helper.createUserDao();
            Optional<User> user = dao.findUserByLoginAndPassword(login, password);
            helper.endTransaction();
            return user;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
/*        try {
            String databaseDriverClass = "com.mysql.jdbc.Driver";
            String databaseConnectionUrl = "jdbc:mysql://localhost:3306/library";
            String databaseUsername = "root";
            String databasePassword = "";
            Class.forName(databaseDriverClass);
            try (Connection connection = DriverManager.getConnection(databaseConnectionUrl, databaseUsername, databasePassword)) {
                UserDao dao = new UserDaoImpl(connection);
                return dao.findUserByLoginAndPassword(login, password);
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServiceException(e);
        }*/
    }

}
