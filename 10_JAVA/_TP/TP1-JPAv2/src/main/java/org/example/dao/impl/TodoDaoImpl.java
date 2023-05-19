package org.example.dao.impl;

import org.example.dao.TodoDao;
import org.example.model.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TodoDaoImpl implements TodoDao {

    private EntityManagerFactory entityManagerFactory;

    public TodoDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    @Override
    public boolean create(Todo todo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(todo);
            transaction.commit();
            return true;
    }
        catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public List<Todo> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Todo> todos = entityManager.createQuery("SELECT t FROM Todo t", Todo.class).getResultList();
        entityManager.close();
        return todos;
    }

    @Override
    public boolean update(Todo todo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(todo);
            transaction.commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public boolean delete(Todo todo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(entityManager.contains(todo) ? todo : entityManager.merge(todo));
            transaction.commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public Todo getById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Todo todo = entityManager.find(Todo.class, id);
            transaction.commit();
            return todo;
        }
        catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return null;
        }
        finally {
            entityManager.close();
        }
    }
    @Override
    public boolean setAchieved(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Todo todo = entityManager.find(Todo.class, id);
            todo.setAchieved(true);
            entityManager.merge(todo);
            transaction.commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
        finally {
            entityManager.close();
        }
    }
}
