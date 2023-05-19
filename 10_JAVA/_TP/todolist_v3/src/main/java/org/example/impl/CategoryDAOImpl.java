package org.example.impl;

import org.example.dao.CategoryDAO;
import org.example.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {

    private final EntityManagerFactory entityManagerFactory;

    public CategoryDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    public boolean addCategory(Category category) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(category);
        transaction.commit();
        entityManager.close();

        return false;
    }


    @Override
    public List<Category> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Category> categories = entityManager.createQuery("SELECT c FROM Category c", Category.class).getResultList();
        entityManager.close();
        return categories;
    }

    @Override
    public boolean update(Category category) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(category);
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
    public boolean delete(Long categoryId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Category category = entityManager.find(Category.class, categoryId);
            entityManager.remove(category);
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
    public Category getById(Long categoryId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Category category = entityManager.find(Category.class, categoryId);
            transaction.commit();
            return category;
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


}
