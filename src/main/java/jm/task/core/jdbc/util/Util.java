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
            connect.setAutoCommit(false);
            System.out.println("Connected to MySql server successfelly!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connect;
    }





}
