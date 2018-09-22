package ua.com.mytodo.dao.factory;

import ua.com.mytodo.dao.TodoDao;
import ua.com.mytodo.dao.UserDao;
import ua.com.mytodo.dao.impl.TodoDaoImpl;
import ua.com.mytodo.dao.impl.UserDaoImpl;

public class DaoFactory {

    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }

    public static TodoDao getTodoDao() {
        return new TodoDaoImpl();
    }
}
