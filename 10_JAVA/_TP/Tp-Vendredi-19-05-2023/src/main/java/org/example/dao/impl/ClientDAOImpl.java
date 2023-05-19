package org.example.dao.impl;

import org.example.model.Agency;
import org.example.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ClientDAOImpl {

    private EntityManagerFactory entityManagerFactory;

    public ClientDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public boolean create(Client client){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(client);
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

    public boolean update(Client client){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(client);
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

    public boolean delete(Long id){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Client client = entityManager.find(Client.class, id);
            entityManager.remove(client);
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

    public Client getById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Client client = entityManager.find(Client.class, id);
        entityManager.close();
        return client;
    }

    public List<Client> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Client> clients = entityManager.createQuery("SELECT c FROM Client c").getResultList();
        entityManager.close();
        return clients;
    }



}
