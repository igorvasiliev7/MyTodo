package ua.com.mytodo.dao;

import ua.com.mytodo.model.Todo;

import java.sql.SQLException;
import java.util.List;

public interface TodoDao {

    void save(Todo todo) throws SQLException;

    List<Todo> findAll() throws SQLException;

    void delete(int id);

    Todo findTheLastOne() throws SQLException;
}
