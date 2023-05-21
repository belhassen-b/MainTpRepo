package org.example.dao.impl;

import org.example.dao.ClientDAO;
import org.example.model.Account;
import org.example.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {

    private final EntityManagerFactory entityManagerFactory;

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

    @Override
    public boolean getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
        List<Client> clients = entityManager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
        for (Client client : clients) {
            System.out.println("Id client: " + client.getId() + " Name client: " + client.getFullName());

            for (Account account : client.getAccounts()) {
                System.out.println("Id account: " + account.getAccountId() + " Balance account: " + account.getBalance());
            }
        }
        entityManager.close();
        return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Client getById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(Client.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }


}
