package ua.com.mytodo.dao;

import ua.com.mytodo.model.Todo;
import ua.com.mytodo.model.User;

import java.sql.SQLException;

public interface UserDao {

    User findByEmail(String email) throws SQLException;

    void save(User user) throws SQLException;
}
