package ua.com.mytodo.service.impl;

import com.j256.ormlite.dao.Dao;
import ua.com.mytodo.dao.TodoDao;
import ua.com.mytodo.dao.factory.DaoFactory;
import ua.com.mytodo.model.Todo;
import ua.com.mytodo.service.TodoService;

import java.sql.SQLException;
import java.util.List;

public class TodoServiceImpl implements TodoService {
       private TodoDao todoDao = DaoFactory.getTodoDao();

    @Override
    public void save(Todo todo) {
        try {
            todoDao.save(todo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Todo> findAll() {
        try {
            return todoDao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Todo findTheLastOne() throws SQLException {
        return todoDao.findTheLastOne();

        // TODO: 24.09.2018 call dao

    }

    @Override
    public void delete(int id) {

    }
}
