//package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

//public class UserDaoHibernateImpl implements UserDao {
//
//    SessionFactory sessionFactory = Util.getSessionFactory();
//    public UserDaoHibernateImpl() {
//
//    }
//
//
//    @Override
//    public void createUsersTable() {
//        Transaction transaction = null;
//        try(Session session = sessionFactory.openSession()){
//            transaction = session.beginTransaction();
//            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users " +
//                    "(id SERIAL PRIMARY KEY ," +
//                    "name VARCHAR(50)," +
//                    "lastName VARCHAR(50)," +
//                    "age INTEGER)").executeUpdate();
//            transaction.commit();
//
//            System.out.println("Created successfully!!");
//        }catch (HibernateException h){
//            h.printStackTrace();
//            if (transaction!=null){
//            transaction.rollback();
//            }
//        }
//    }
//
//    @Override
//    public void dropUsersTable() {
//        Transaction transaction = null;
//    try(Session session = sessionFactory.openSession()){
//        transaction=session.beginTransaction();
//        session.createSQLQuery("drop table users").executeUpdate();
//        transaction.commit();
//
//        System.out.println("Table users dropped");
//    }catch (Exception h){
//        h.printStackTrace();
//        if (transaction!=null){
//            transaction.rollback();
//        }
//    }
//    }
//
//    @Override
//    public void saveUser(String name, String lastName, byte age) {
//        Transaction transaction = null;
//    try(Session session = sessionFactory.openSession()){
//        transaction=session.beginTransaction();
//        session.persist(new User(name,lastName,age));
//        transaction.commit();
//
//        System.out.println("User with name " + name + " inserted to database");
//    }catch (Exception h){
//        h.printStackTrace();
//        if (transaction!=null){
//            transaction.rollback();
//        }
//    }
//    }
//
//    @Override
//    public void removeUserById(long id) {
//        Transaction transaction = null;
//        try (Session session = sessionFactory.openSession()){
//            transaction=session.beginTransaction();
//            User user = session.get(User.class,id);
//            if (user!=null){
//            session.delete(user);
//                System.out.println("User with id: " + id + " deleted ");
//            }else {
//                System.out.println("There is no user with id " + id);
//            }
//            transaction.commit();
//
//            System.out.println("User with " + id + "id is deleted from database");
//        }catch (Exception h){
//            h.printStackTrace();
//            if (transaction!=null){
//                transaction.rollback();
//            }
//        }
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        Transaction transaction = null;
//    List<User> users = new ArrayList<>();
//    try (Session session = sessionFactory.openSession()){
//        transaction=session.beginTransaction();
//        users = session.createQuery("select a from User a",User.class).getResultList();
//
//        transaction.commit();
//
//        System.out.println("Found " + users.size() + " users");
//    }catch (Exception h){
//        h.printStackTrace();
//        transaction.rollback();
//    }
//        return users;
//    }
//
//    @Override
//    public void cleanUsersTable() {
//        Transaction transaction = null;
//    try (Session session = sessionFactory.openSession()){
//        transaction=session.beginTransaction();
//        session.createSQLQuery("delete from users").executeUpdate();
//        transaction.commit();
//
//        System.out.println("Successfully deleted all data in users");
//    }catch (Exception h){
//        h.printStackTrace();
//        if (transaction != null) {
//            transaction.rollback();
//        }
//    }
//    }
//}
