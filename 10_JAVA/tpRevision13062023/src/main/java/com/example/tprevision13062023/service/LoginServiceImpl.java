package com.example.tprevision13062023.service;

import jakarta.servlet.http.HttpSession;
import org.hibernate.SessionFactory;

public class LoginServiceImpl implements LoginService {
    private SessionFactory _sessionFactory;
    private UtilisateurService utilisateurService;
    public LoginServiceImpl( SessionFactory sessionFactory) {
        _sessionFactory = sessionFactory;
        utilisateurService = new UtilisateurService(_sessionFactory);
    }

    @Override
    public boolean isLogged() {
        return false;
    }

    @Override
    public boolean login(String username, String password) {
        //je peux utiliser un service Hibernate pour faire la vérification côté base de données.

        return utilisateurService.login(username, password);
    }
}
