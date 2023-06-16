package com.belhassen.tp_revision.controller;

import com.belhassen.tp_revision.entity.JeuVideo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "addServlet", value = "/add")
public class AddServlet extends HttpServlet {

    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        // form to add a new game

        if (request.getParameter("nom") != null) {
            String nom = request.getParameter("nom");
            String genre = request.getParameter("genre");
            String plateforme = request.getParameter("plateforme");
            String description = request.getParameter("description");
            String image = request.getParameter("image");
            double prix = Double.parseDouble(request.getParameter("prix"));

            JeuVideo jeu = new JeuVideo( nom, genre, plateforme, description, image, prix);
            if (jeu.create(jeu)) {
                try {
                    response.sendRedirect("jeux");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
        }

    }


}
