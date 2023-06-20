package com.example.tprevision13062023.repository;

import com.example.tprevision13062023.entity.Equipe;
import org.hibernate.Session;

import java.util.List;


public class EquipeRepository extends Repository<Equipe> {

    public EquipeRepository(Session session) {
        super(session);
    }

    @Override
    Equipe findById(int id) {
        return null;
    }

    @Override
    List<Equipe> findAll() {
        return null;
    }


}
