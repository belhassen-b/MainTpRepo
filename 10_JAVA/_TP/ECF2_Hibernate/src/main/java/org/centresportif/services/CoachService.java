package org.centresportif.services;

import org.centresportif.entities.Coach;
import org.centresportif.interfaces.Repository;

import java.util.List;

public class CoachService extends BaseService implements Repository<Coach> {

    public CoachService() {
        super();
    }

    @Override
    public boolean create(Coach o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Coach o) {

        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Coach o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public boolean deleteById(int id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        Coach coach = (Coach) session.get(Coach.class, id);
        session.delete(coach);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Coach findById(int id) {
        Coach coach = null;
        session = sessionFactory.openSession();
        coach = (Coach) session.get(Coach.class, id);
        session.close();
        return coach;
    }

    @Override
    public List<Coach> findAll() {
        List<Coach> coachList = null;
        session = sessionFactory.openSession();
        coachList = session.createQuery("from Coach").list();
        session.close();
        return coachList;
    }

    public void begin() {
        session = sessionFactory.openSession();
    }

    public void end() {
    }
}