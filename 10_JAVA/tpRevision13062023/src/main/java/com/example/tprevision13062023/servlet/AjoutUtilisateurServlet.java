package com.example.tprevision13062023.servlet;

import com.example.tprevision13062023.service.LoginService;
import com.example.tprevision13062023.service.UtilisateurService;
import com.example.tprevision13062023.util.Definition;
import com.example.tprevision13062023.util.HibernateSession;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "utilisateur", value = "/utilisateur")
public class AjoutUtilisateurServlet extends HttpServlet {
    private LoginService loginService;

    private UtilisateurService utilisateurService;

    public void init() {
        utilisateurService = new UtilisateurService(HibernateSession.getSessionFactory());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if(request.getParameter("username") != null && !request.getParameter("username").equals("") && request.getParameter("password") != null && !request.getParameter("password").equals("")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if(utilisateurService.create(username, password)) {
                response.sendRedirect(Definition.BASE_URL+"/index");
            }
        }
    }


}
