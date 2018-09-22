package ua.com.mytodo.service.factory;

import ua.com.mytodo.service.TodoService;
import ua.com.mytodo.service.UserService;
import ua.com.mytodo.service.impl.TodoServiceImpl;
import ua.com.mytodo.service.impl.UserServiceImpl;

public class ServiceFactory {

    public static UserService getUserService() {
        return new UserServiceImpl();
    }

    public static TodoService getTodoService() {
        return new TodoServiceImpl();
    }
}
