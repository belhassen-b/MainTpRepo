package com.example.controller;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "home", value = "/")
public class HomeServlet extends HttpServlet {

    private String message;
    public void init() {
        message = "Gestion de jeux vidéos";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        out.println("<a href=\"ListeJeux\">Liste des jeux</a>");
        out.println("<br>");
        out.println("<a href=\"add\">Ajouter un jeu</a>");
        out.println("<br>");
        out.println("<a href=\"jeux/delete\">Supprimer un jeu</a>");
        out.println("<br>");
        out.println("<a href=\"jeux/update\">Modifier un jeu</a>");
        out.println("<br>");
        out.println("<a href=\"jeux/search\">Rechercher un jeu</a>");
        out.println("<br>");
        out.println("<a href=\"jeux/afficher\">Afficher un jeu</a>");
        out.println("<br>");
        out.println("</body></html>");
    }

}
