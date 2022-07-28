package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //JDBC
 //       UserDao daoJdbc = new UserDaoJDBCImpl();
        //HIBERNATE
        UserDao daoHibernate = new UserDaoHibernateImpl();
//               daoHibernate.createUsersTable();
//        daoHibernate.saveUser("Azamat", "Baitashov", (byte) 35);
//        daoHibernate.saveUser("Ruslan", "Maratov", (byte) 29);
//        daoHibernate.saveUser("Anvar", "Mirzaev", (byte) 25);
//        daoHibernate.saveUser("Nikolay", "Petrov", (byte) 38);
//        List<User> users= daoHibernate.getAllUsers();
//        System.out.println(users);
//              daoHibernate.cleanUsersTable();
//        daoHibernate.dropUsersTable();
    }
}
