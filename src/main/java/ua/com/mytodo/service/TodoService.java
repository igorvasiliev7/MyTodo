package ua.com.mytodo.service;

import ua.com.mytodo.model.Todo;

import java.util.List;

public interface TodoService {

    void save(Todo todo);

    List<Todo> findAll();

    void delete(int id);
}