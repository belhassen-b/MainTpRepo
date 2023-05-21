package org.example.dao.impl;

import org.example.dao.AgencyDAO;
import org.example.model.Agency;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class AgencyDAOImpl implements AgencyDAO {

    private final EntityManagerFactory entityManagerFactory;

    public AgencyDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    @Override
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

    @Override
    public List<Agency> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Agency> agencies = entityManager.createQuery("SELECT a FROM Agency a", Agency.class).getResultList();
        entityManager.close();
        return agencies;
    }

    @Override
    public Agency getById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

       try {
           return entityManager.find(Agency.class, id);
       }
       catch (Exception e) {
           e.printStackTrace();
           return null;
       }
       finally {
           entityManager.close();
       }
}
}



