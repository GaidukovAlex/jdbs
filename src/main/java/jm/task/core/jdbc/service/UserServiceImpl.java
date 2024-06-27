package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private  final UserDao userDaoJDBC = new UserDaoJDBCImpl();
    private final UserDao userDao = new UserDaoHibernateImpl();

    public UserServiceImpl(UserDao userDao) {
    }

    public UserServiceImpl() {
        UserDao userDaoJDBC = new UserDaoJDBCImpl();
        UserDao userDao = new UserDaoHibernateImpl();
    }

    public void createUsersTable() {
        userDaoJDBC.createUsersTable();
        userDao.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoJDBC.dropUsersTable();
        userDao.createUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoJDBC.saveUser(name,lastName,age);
        userDao.saveUser(name, lastName,age);
        System.out.println("User с именем " + name + " добавлен в базу данных");

    }

    public void removeUserById(long id) {
        userDaoJDBC.removeUserById(id);
        userDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDaoJDBC.getAllUsers();
        //return userDao.getAllUsers();
    }

     public void cleanUsersTable() {
             userDaoJDBC.cleanUsersTable();
             userDao.createUsersTable();
    }
}
