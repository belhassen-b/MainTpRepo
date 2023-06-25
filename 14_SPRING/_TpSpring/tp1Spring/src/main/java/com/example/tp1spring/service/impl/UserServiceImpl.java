package com.example.tp1spring.service.impl;


import com.example.tp1spring.entity.User;
import com.example.tp1spring.util.ServiceHibernate;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements com.example.tp1spring.service.IUserService{

    @Autowired
    private ServiceHibernate serviceHibernate;
    private final Session session;

    public UserServiceImpl(ServiceHibernate serviceHibernate) {
        this.serviceHibernate = serviceHibernate;
        session = this.serviceHibernate.getSession();
    }

    @Override
    public boolean create(User u) {
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(User u) {
        return false;
    }

    @Override
    public boolean delete(User u) {
        session.beginTransaction();
        session.delete(u);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public User findById(int id) {
        User user = null;
        user = session.get(User.class, id);
        return user;
    }

    @Override
    public List<User> findAll() {
        Query<User> userQuery = session.createQuery("from User");
        return userQuery.getResultList();
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        Query<User> userQuery = session.createQuery("from User where username = :username and password = :password");
        userQuery.setParameter("username", username);
        userQuery.setParameter("password", password);
        return userQuery.getSingleResult();
    }


}
