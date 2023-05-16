package org.example.dao.impl;

import org.example.dao.TodoInfoDao;
import org.example.model.TodoInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TodoInfoDaoImpl implements TodoInfoDao {

    private EntityManagerFactory entityManagerFactory;

    public TodoInfoDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public boolean create(TodoInfo todoInfo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(todoInfo);
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
    public List<TodoInfo> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List todos = entityManager.createQuery("SELECT t FROM TodoInfo t", TodoInfo.class).getResultList();
        entityManager.close();
return todos;
    }

    @Override
    public boolean update(TodoInfo todoInfo) {
        return false;
    }

    @Override
    public boolean delete(TodoInfo todoInfo) {
        return false;
    }

    public TodoInfo getById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TodoInfo todoInfo = entityManager.find(TodoInfo.class, id);
        entityManager.close();
        return todoInfo;
    }
}
