package com.example.tprevision13062023.repository;

import com.example.tprevision13062023.entity.Joueur;
import org.hibernate.Session;

import java.util.List;

public class JoueurRepository extends Repository<Joueur>{
    public JoueurRepository(Session session) {
        super(session);
    }

    @Override
    Joueur findById(int id) {
        return null;
    }

    @Override
    List<Joueur> findAll() {
        return null;
    }
}
