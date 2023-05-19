package org.example.dao.impl;

import org.example.model.Account;
import org.example.model.Agency;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class AgencyDAOImpl {

    private EntityManagerFactory entityManagerFactory;

    public AgencyDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    public boolean create(Agency agency) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(agency);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            entityManager.close();
        }

    }

    public void read() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public boolean update(Agency agency) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(agency);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            entityManager.close();
        }
    }


    public boolean delete(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Agency agency = entityManager.find(Agency.class, id);
            entityManager.remove(agency);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            entityManager.close();
        }
    }


    public List<Agency> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Agency> agencies = entityManager.createQuery("SELECT a FROM Agency a").getResultList();
        entityManager.close();
        return agencies;
    }

    public Agency getById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Agency agency = entityManager.find(Agency.class, id);
        entityManager.close();
        return agency;
    }

}



