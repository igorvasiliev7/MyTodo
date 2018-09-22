package ua.com.mytodo.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import ua.com.mytodo.dao.UserDao;
import ua.com.mytodo.model.Todo;
import ua.com.mytodo.model.User;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private static final String URL = "jdbc:sqlite:miracle.sqlite";
    private Dao<User, Integer> dao;

    {
        try {
            ConnectionSource source = new JdbcConnectionSource(URL);
            dao = DaoManager.createDao(source, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User findByEmail(String email) throws SQLException {
        return dao.queryBuilder()
                .where()
                .eq("email", email)
                .queryForFirst();
    }

    @Override
    public void save(User user) throws SQLException {
        dao.create(user);
    }
}
