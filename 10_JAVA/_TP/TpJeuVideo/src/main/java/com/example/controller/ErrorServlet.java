package com.example.controller;


// Erreur : Une page d'erreur générique qui peut afficher un message d'erreur à l'utilisateur.
//Cette page pourrait être affichée si quelque chose se passe mal lors de l'exécution d'une action, comme l'ajout ou la modification d'un jeu.

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "errorServlet", value = "/error")

public class ErrorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().println("Error");
    }
}
