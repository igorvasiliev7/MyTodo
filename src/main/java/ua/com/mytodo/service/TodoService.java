package ua.com.mytodo.service;

import ua.com.mytodo.model.Todo;

import java.sql.SQLException;
import java.util.List;

public interface TodoService {

    void save(Todo todo);

    List<Todo> findAll();

    Todo findTheLastOne() throws SQLException;

    void delete(int id) throws SQLException;
}
