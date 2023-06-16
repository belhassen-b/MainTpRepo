package com.example.services;

import com.example.entities.VideoGame;
import com.example.interfaces.Repository;
import org.hibernate.Query;
import java.util.List;

public class VideoGameService extends BaseService implements Repository<VideoGame> {
    @Override
    public boolean create(VideoGame o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(VideoGame o) {
        session = sessionFactory .openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(VideoGame o) {
        session = sessionFactory .openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public VideoGame findById(int id) {
        VideoGame videoGame = null;
        session = sessionFactory.openSession();
        videoGame = (VideoGame) session.get(VideoGame.class, id);
        session.close();
        return videoGame;
    }

    @Override
    public List<VideoGame> findAll() {
        List<VideoGame> videoGameList = null;
        session = sessionFactory.openSession();
        Query<VideoGame> videoGameQuery = session.createQuery("from VideoGame");
        videoGameList = videoGameQuery.list();
        session.close();
        return videoGameList;
    }
}
