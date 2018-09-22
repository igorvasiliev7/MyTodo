package ua.com.mytodo.service.impl;

import ua.com.mytodo.dao.factory.DaoFactory;
import ua.com.mytodo.model.User;
import ua.com.mytodo.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    @Override
    public User findByEmail(String email) {
        try {
            return DaoFactory.getUserDao().findByEmail(email);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
