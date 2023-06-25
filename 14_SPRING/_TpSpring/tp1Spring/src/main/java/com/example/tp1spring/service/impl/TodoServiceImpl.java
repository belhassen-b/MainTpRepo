package com.example.tp1spring.service.impl;

import com.example.tp1spring.entity.Todo;
import com.example.tp1spring.util.ServiceHibernate;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements com.example.tp1spring.service.ITodoService {

    @Autowired
    private ServiceHibernate serviceHibernate;
    private final Session session;

    public TodoServiceImpl(ServiceHibernate serviceHibernate) {
        this.serviceHibernate = serviceHibernate;
        session = this.serviceHibernate.getSession();
    }

    @Override
    public boolean create(Todo t) {
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
//        session.close();
        return true;
    }


    @Override
    public boolean update(Todo t) {
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(Todo t) {
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Todo findById(int id) {
        Todo todo = null;
        todo = (Todo) session.get(Todo.class, id);
        return todo;
    }

    @Override
    public List<Todo> findAll() {
        Query<Todo> todoQuery = session.createQuery("from Todo");
        return todoQuery.list();
    }

    @Override
    public Object findAllCategory() {
        List<String> categoryList;
        categoryList = session.createQuery("select distinct category from Todo").list();
        return categoryList;
    }

    @Override
    public Object findAllPriority() {
        List<String> priorityList;
        priorityList = session.createQuery("select distinct priority from Todo").list();
        return priorityList;
    }

}
