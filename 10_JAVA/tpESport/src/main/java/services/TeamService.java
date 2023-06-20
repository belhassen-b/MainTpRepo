package services;

import entities.Team;
import interfaces.Repository;

import java.util.List;

public class TeamService extends services.BaseService implements Repository<Team>{

    public TeamService(){
        super();
    }


    @Override
    public boolean create(Team o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;    }

    @Override
    public boolean update(Team o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Team o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    public boolean delete(String o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Team findById(int id) {
        Team team = null;
        session = sessionFactory.openSession();
        team = (Team) session.get(Team.class, id);
        session.close();
        return team;
    }

    @Override
    public List<Team> findAll() {
        List<Team> teamList = null;
        session = sessionFactory.openSession();
        org.hibernate.query.Query<Team> teamQuery = session.createQuery("from Team");
        teamList = teamQuery.getResultList();
        session.close();
        return teamList;
    }

    public boolean create(String name, List players,  tournament) {
        Team team = new Team();
        team.setName(name);
        team.setPlayers(players);
        team.setTournament(tournament);
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(team);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
