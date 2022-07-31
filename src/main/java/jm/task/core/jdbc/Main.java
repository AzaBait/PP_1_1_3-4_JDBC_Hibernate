package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Util.connection();
        //JDBC
        UserDao daoJdbc = new UserDaoJDBCImpl();

//              daoJdbc.createUsersTable();
        daoJdbc.saveUser("Azamat", "Baitashov", (byte) 35);
        daoJdbc.saveUser("Ruslan", "Maratov", (byte) 29);
        daoJdbc.saveUser("Anvar", "Mirzaev", (byte) 25);
        daoJdbc.saveUser("Nikolay", "Petrov", (byte) 38);
//        List<User> users= daoJdbc.getAllUsers();
//        System.out.println(users);
//              daoJdbc.cleanUsersTable();
//        daoJdbc.dropUsersTable();
    }
}
