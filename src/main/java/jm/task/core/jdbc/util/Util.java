package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    //JDBC
    private static final String url = "jdbc:mysql://localhost:3306/kata";
    private static final String login = "root";
    private static final String password = "ormonhan8687";

    public static Connection connection() {
        Connection connect = null;
        try {

            connect = DriverManager.getConnection(url, login, password);
            System.out.println("Connected to MySql server successfelly!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connect;
    }

    //HIBERNATE
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        try {
            if (sessionFactory == null) {
                sessionFactory = new Configuration()
                        .setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver")
                        .setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect")
                        .setProperty(Environment.URL, "jdbc:mysql://localhost:3306/kata")
                        .setProperty(Environment.USER, "root")
                        .setProperty(Environment.PASS, "ormonhan8687")
                        .setProperty(Environment.HBM2DDL_AUTO, "update")
                        .setProperty(Environment.SHOW_SQL, "true")
                        .addAnnotatedClass(User.class)
                        .buildSessionFactory();
            }
        }catch (Exception h){
            h.printStackTrace();
        }
        return sessionFactory;
    }


}
