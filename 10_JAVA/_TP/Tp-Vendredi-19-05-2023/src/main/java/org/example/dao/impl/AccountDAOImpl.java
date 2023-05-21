package org.example.dao.impl;

import org.example.dao.AccountDAO;
import org.example.model.Account;
import org.example.model.Agency;
import org.example.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;


public class AccountDAOImpl implements AccountDAO {

    private final EntityManagerFactory entityManagerFactory;

    public AccountDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public boolean create(Account account, Long clientId, Long agencyId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Agency agency = entityManager.find(Agency.class, agencyId);
            Client client = entityManager.find(Client.class, clientId);
            account.setAgency(agency);
            client.getAccounts().add(account);
            entityManager.persist(account);
            entityManager.persist(account);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        return false;
    }

    @Override
    public List<Account> getAllByAgency(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
           List<Account> accounts = entityManager.createQuery("SELECT a FROM Account a WHERE a.agency.agencyId = :id", Account.class)
                    .setParameter("id", id)
                    .getResultList();
            entityManager.close();
            return accounts;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Account getById(Long accountId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(Account.class, accountId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean update(Account account) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(account);
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

}