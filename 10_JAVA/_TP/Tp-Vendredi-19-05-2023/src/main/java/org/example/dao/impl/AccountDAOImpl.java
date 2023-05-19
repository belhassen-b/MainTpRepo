package org.example.dao.impl;

import org.example.model.Account;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class AccountDAOImpl {

    private EntityManagerFactory entityManagerFactory;

    public AccountDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public boolean create(Account account) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(account);
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

    public boolean delete(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Account account = entityManager.find(Account.class, id);
            entityManager.remove(account);
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

    public List<Account> getAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Account> accounts = entityManager.createQuery("SELECT a FROM Account a").getResultList();
        entityManager.close();
        return accounts;
    }


    public Account getById(Long accountId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Account account = entityManager.find(Account.class, accountId);
        entityManager.close();
        return account;
    }
}
