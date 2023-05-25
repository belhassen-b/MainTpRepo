package org.centresportif.services;

import org.centresportif.entities.Activity;
import org.centresportif.entities.Member;
import org.centresportif.interfaces.Repository;

import java.util.List;

public class ActivityService extends BaseService implements Repository<Activity> {

    public ActivityService() {
        super();
    }


    @Override
    public boolean create(Activity o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Activity o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Activity o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Activity findById(int id) {
        Activity activity;
        session = sessionFactory.openSession();
        activity = session.get(Activity.class, id);
        session.close();
        return activity;
    }

    @Override
    public List<Activity> findAll() {
        List<Activity> activityList;
        session = sessionFactory.openSession();
        activityList = session.createQuery("from Activity").list();
        session.close();
        return activityList;
    }

    public void begin() {
        session = sessionFactory.openSession();
    }

    public void end() {
        session.getTransaction().commit();
        session.close();
    }

    public boolean addMemberToActivity(int id, int idMember) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Activity activity = session.get(Activity.class, id);
        activity.getMembers().add(session.get(Member.class, idMember));
        session.update(activity);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}