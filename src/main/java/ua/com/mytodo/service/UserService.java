package ua.com.mytodo.service;

import ua.com.mytodo.model.User;

public interface UserService {

    User findByEmail(String email);

    void save(User user);
}
