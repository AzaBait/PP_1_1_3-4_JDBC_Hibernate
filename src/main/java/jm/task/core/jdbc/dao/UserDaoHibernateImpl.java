package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try(Session session = Util.getSessionFactory().openSession()){
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users " +
                    "(id SERIAL PRIMARY KEY ," +
                    "name VARCHAR(50)," +
                    "lastName VARCHAR(50)," +
                    "age INTEGER)").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Created successfully!!");
        }catch (HibernateException h){
            h.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
    try(Session session = Util.getSessionFactory().openSession()){
        session.beginTransaction();
        session.createSQLQuery("drop table users").executeUpdate();
        session.getTransaction().commit();
        System.out.println("Table users dropped");
    }catch (Exception h){
        h.printStackTrace();
    }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
    try(Session session = Util.getSessionFactory().openSession()){
        session.beginTransaction();
        session.persist(new User(name,lastName,age));
        session.getTransaction().commit();
        System.out.println("User with name " + name + " inserted to database");
    }catch (Exception h){
        h.printStackTrace();
    }
    }

    @Override
    public void removeUserById(long id) {
        try (Session session = Util.getSessionFactory().openSession()){
            session.beginTransaction();
            User user = session.get(User.class,id);
            session.delete(user);
            session.getTransaction().commit();
            System.out.println("User with " + id + "id is deleted from database");
        }catch (Exception h){
            h.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
    List<User> users = new ArrayList<>();
    try (Session session = Util.getSessionFactory().openSession()){
        session.beginTransaction();
        users = session.createQuery("select a from User a",User.class).getResultList();
      //  users.add();
        session.getTransaction().commit();
        System.out.println("Found " + users.size() + " users");
    }catch (Exception h){
        h.printStackTrace();
    }
        return users;
    }

    @Override
    public void cleanUsersTable() {
    try (Session session = Util.getSessionFactory().openSession()){
        session.beginTransaction();
        session.createSQLQuery("delete from users").executeUpdate();
        session.getTransaction().commit();
        System.out.println("Successfully deleted all data in users");
    }catch (Exception h){
        h.printStackTrace();
    }
    }
}
