package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {

        try ( Connection connection = Util.connection();
              Statement statement = connection.createStatement()){
              statement.executeUpdate(" CREATE TABLE users (id serial primary key , " +
                      " name varchar(20) not null, " +
                      " lastName varchar(30) not null, " +
                      " age int)");
              connection.rollback();
            System.out.println("Table Users created!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Connection connection = Util.connection();
        Statement statement = connection.createStatement()) {
            statement.executeUpdate("drop table users");
            System.out.println("Table Users dropped!!");
            connection.rollback();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "insert into users (name,lastName,age) values (?,?,?)";
        try (Connection connection = Util.connection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
             preparedStatement.setString(1, name);
             preparedStatement.setString(2, lastName);
             preparedStatement.setByte(3, age);
             preparedStatement.executeUpdate();
             connection.rollback();
            System.out.println("User with name " + name + " inserted to database");

        }catch (SQLException e){
            e.printStackTrace();
        };

    }

    public void removeUserById(long id) {
    try (Connection connection = Util.connection();
    PreparedStatement preparedStatement = connection.prepareStatement("delete from users where id=?")){
    preparedStatement.setLong(1, id);
    preparedStatement.executeUpdate();
    connection.rollback();
        System.out.println("User with " + id + "id is deleted from database");

    }catch (SQLException e){
        e.printStackTrace();
    }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from users")) {
            while (resultSet.next()) {
                User user = new User(
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getByte("age"));
                users.add(user);
            }connection.rollback();
            System.out.println(users.size() + " users founded: " + users);
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
        return users;
    }

    public void cleanUsersTable() {
        try (Connection connection = Util.connection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("delete from users;");
            connection.rollback();
            System.out.println("DELETED ALL USERS");
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
        }
    }
}
