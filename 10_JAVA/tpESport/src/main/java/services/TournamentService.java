package services;

import entities.Game;
import entities.Tournament;
import interfaces.Repository;

import java.time.LocalDateTime;
import java.util.List;

public class TournamentService extends services.BaseService implements Repository<Tournament> {

    public TournamentService(){
        super();
    }


    @Override
    public boolean create(Tournament o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Tournament o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Tournament o) {
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
    public Tournament findById(int id) {
        Tournament tournament = null;
        session = sessionFactory.openSession();
        tournament = (Tournament) session.get(Tournament.class, id);
        session.close();
        return tournament;
    }

    @Override
    public List<Tournament> findAll() {
        List<Tournament> tournamentList = null;
        session = sessionFactory.openSession();
        org.hibernate.query.Query<Tournament> tournamentQuery = session.createQuery("from Tournament");
        tournamentList = tournamentQuery.getResultList();
        session.close();
        return tournamentList;
    }

    public void begin(){
        session = sessionFactory.openSession();
    }

    public void end(){

        //  session.close();
        sessionFactory.close();
    }

    public boolean create(String name, String game, String date, String teams) {
        Tournament tournament = new Tournament();
        tournament.setName(name);
        tournament.setGame(Game.valueOf(game));
        tournament.setDate(LocalDateTime.parse(date));
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(tournament);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
