package com.example.tprevision13062023.service;

import com.example.tprevision13062023.repository.UtilisateurRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UtilisateurService  {

    private SessionFactory _sessionFactory;

    private UtilisateurRepository utilisateurRepository;

    private Session session;


    public UtilisateurService(SessionFactory sessionFactory) {
        _sessionFactory = sessionFactory;
    }

    public boolean login(String username, String password) {
        session = _sessionFactory.openSession();
        utilisateurRepository = new UtilisateurRepository(session);
        boolean isLogged = utilisateurRepository.login(username, password);
        session.close();
        return isLogged;
    }


    public boolean create(String username, String password) {
        session = _sessionFactory.openSession();
        utilisateurRepository = new UtilisateurRepository(session);
        boolean isCreated = utilisateurRepository.create(username, password);
        session.close();
        return isCreated;
    }
}
