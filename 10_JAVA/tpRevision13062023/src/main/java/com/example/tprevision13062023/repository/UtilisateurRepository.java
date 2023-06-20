package com.example.tprevision13062023.repository;

import com.example.tprevision13062023.entity.Utilisateur;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UtilisateurRepository extends Repository<Utilisateur> {
    public UtilisateurRepository(Session session) {
        super(session);
    }

    @Override
    Utilisateur findById(int id) {
        return null;
    }

    @Override
    List<Utilisateur> findAll() {
        return null;
    }

    public boolean login(String username, String password) {
        Query<Utilisateur> query = _session.createQuery("from Utilisateur where username = :username and password = :password", Utilisateur.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        Utilisateur utilisateur = query.uniqueResult();
        return utilisateur != null;
    }

    public boolean create(String username, String password) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUsername(username);
        utilisateur.setPassword(password);
        _session.save(utilisateur);
        return true;
    }
}
