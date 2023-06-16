package com.belhassen.tp_revision.services;

import com.belhassen.tp_revision.entity.JeuVideo;
import com.belhassen.tp_revision.interfaces.Repository;

import java.util.List;

public class JeuVideoService extends services.BaseService implements Repository<JeuVideo> {

    public JeuVideoService() {
        super();
    }


    @Override
    public boolean create(JeuVideo o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(JeuVideo o) {
        return false;
    }

    @Override
    public boolean delete(JeuVideo o) {
        return false;
    }

    @Override
    public JeuVideo findById(int id) {
        return null;
    }

    @Override
    public List<JeuVideo> findAll() {
        return null;
    }
}
