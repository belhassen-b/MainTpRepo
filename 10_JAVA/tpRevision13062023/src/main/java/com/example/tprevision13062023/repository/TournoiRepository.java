package com.example.tprevision13062023.repository;

import com.example.tprevision13062023.entity.Tournoi;
import org.hibernate.Session;

import java.util.List;

public class TournoiRepository extends Repository<Tournoi>{

    public TournoiRepository(Session session) {
        super(session);
    }

    @Override
    Tournoi findById(int id) {
        return null;
    }

    @Override
    List<Tournoi> findAll() {
        return null;
    }
}
