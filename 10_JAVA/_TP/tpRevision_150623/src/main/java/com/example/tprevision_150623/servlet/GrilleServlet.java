package com.example.tprevision_150623.servlet;



import com.example.tprevision_150623.entities.Grille;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "grille", value = "/")
public class GrilleServlet extends HttpServlet {


    @Override
    public void init(ServletConfig config) throws ServletException {
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Grille grille = new Grille();
    req.getSession().setAttribute("grille", grille);
    req.getRequestDispatcher("WEB-INF/views/grille.jsp").forward(req, resp);
    }




}
