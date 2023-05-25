package org.example.dao.impl;

import org.example.dao.CoachDAO;
import org.example.model.Coach;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CoachDAOImpl implements CoachDAO {

    private final EntityManagerFactory entityManagerFactory;

    public CoachDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }


    @Override
    public boolean createCoachDAO(Coach coach) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(coach);
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
    public boolean updateCoachDAO(Coach coach) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(coach);
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
    public boolean deleteCoachDAO(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.createQuery("DELETE FROM Coach c WHERE c.id = :id")
                    .setParameter("id", 1L)
                    .executeUpdate();
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
        }    }


    @Override
    public Coach getCoachDAOById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Coach coach = entityManager.find(Coach.class, id);
            return coach;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public List<Coach> getAllCoachesDAO() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            List<Coach> coaches = entityManager.createQuery("SELECT c FROM Coach c", Coach.class).getResultList();
            for (Coach coach : coaches) {
                System.out.println("Id Coach : " + coach.getId() + " Name Coach : " + coach.getFullName());
            }
            entityManager.close();
            return coaches;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public boolean getCoachDAOByActivity() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            List<Coach> coaches = entityManager.createQuery("SELECT c FROM Coach c WHERE c.activity = :activity", Coach.class)
                    .setParameter("activity", "sport")
                    .getResultList();
            for (Coach coach : coaches) {
                System.out.println("Id Coach : " + coach.getId() + " Name Coach : " + coach.getFullName());
            }
            entityManager.close();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
