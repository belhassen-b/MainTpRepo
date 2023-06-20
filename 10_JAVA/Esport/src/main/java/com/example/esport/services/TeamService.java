package com.example.esport.services;

import com.example.esport.entities.Team;
import com.example.esport.interfaces.Repository;

import java.util.List;

public class TeamService extends BaseService implements Repository<Team> {

    public TeamService() {
        super();
    }


    @Override
    public boolean create(Team o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Team o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Team o) {
        return false;
    }

    @Override
    public Team findById(int id) {
        return null;
    }

    @Override
    public List<Team> findAll() {
        return null;
    }

    public boolean create(String name, String players) {
        Team team = new Team();
        team.setName(name);
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(team);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
