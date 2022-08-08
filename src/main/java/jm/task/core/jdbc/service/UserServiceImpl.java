package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    //JDBC
 //   UserDao userDao = new UserDaoJDBCImpl();

    //Hibernate

    UserDao userDaoHiber = new UserDaoHibernateImpl();


    public void createUsersTable() throws SQLException {
    userDaoHiber.createUsersTable();
    }

    public void dropUsersTable() throws SQLException {
    userDaoHiber.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
    userDaoHiber.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) throws SQLException {
    userDaoHiber.removeUserById(id);
    }

    public List<User> getAllUsers() throws SQLException {
        return userDaoHiber.getAllUsers();
    }

    public void cleanUsersTable() throws SQLException {
    userDaoHiber.cleanUsersTable();
    }
}
