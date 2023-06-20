package services;

import entities.Game;
import entities.Player;
import interfaces.Repository;

import org.hibernate.query.Query;
import java.util.List;

public class PlayerService extends services.BaseService implements Repository<Player> {

    public PlayerService(){
        super();
    }
    @Override
    public boolean create(Player o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Player o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Player o) {
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
    public Player findById(int id) {
        Player player = null;
        session = sessionFactory.openSession();
        player = (Player) session.get(Player.class, id);
        session.close();
        return player;
    }

    @Override
    public List<Player> findAll() {
        List<Player> playerList = null;
        session = sessionFactory.openSession();
        Query<Player> playerQuery = session.createQuery("from Player");
        playerList = playerQuery.getResultList();
        session.close();
        return playerList;
    }

    public void begin(){
        session = sessionFactory.openSession();
    }

    public void end(){

        //  session.close();
        sessionFactory.close();
    }

    public boolean create(String name, Game game) {
        Player player = new Player(name, game);
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(player);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
