package org.example.dao.impl;

import org.example.dao.ActivityDAO;
import org.example.model.Activity;
import org.example.model.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ActivityDAOImpl implements ActivityDAO {

    private final EntityManagerFactory entityManagerFactory;
    public ActivityDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public boolean createActivityDAO(Activity activity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(activity);
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
        finally {
            entityManager.close();
        }

    }

    @Override
    public boolean updateActivityDAO(Activity activity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(activity);
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean deleteActivityDAO(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Activity activity = entityManager.find(Activity.class, id);
            entityManager.remove(activity);
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public Activity getActivityDAOById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            Activity activity = entityManager.find(Activity.class, id);
            entityManager.getTransaction().commit();
            return activity;
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Activity> getAllActivitiesDAO() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            List<Activity> activities = entityManager.createQuery("SELECT a FROM Activity a", Activity.class).getResultList();
            entityManager.getTransaction().commit();
            return activities;
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public void updateActivity(Activity activity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            entityManager.merge(activity);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public boolean addMemberToActivity(Long activityId, Long memberId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try{
            Activity activity = entityManager.find(Activity.class, activityId);
            activity.getMembers().add(entityManager.find(Member.class, memberId));
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return false;
    }
}
