package ua.com.mytodo.dao.impl;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import ua.com.mytodo.dao.TodoDao;
import ua.com.mytodo.model.Todo;

import java.sql.SQLException;
import java.util.List;

public class TodoDaoImpl implements TodoDao {

    private static final String URL = "jdbc:sqlite:miracle.sqlite";
    private Dao<Todo, Integer> dao;

    {
        try {
            ConnectionSource source = new JdbcConnectionSource(URL);
            dao = DaoManager.createDao(source, Todo.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Todo todo) throws SQLException {
        dao.create(todo);
    }

    @Override
    public List<Todo> findAll() throws SQLException {
        return dao.queryForAll();
    }

    @Override
    public void delete(int id) {

    }
}
