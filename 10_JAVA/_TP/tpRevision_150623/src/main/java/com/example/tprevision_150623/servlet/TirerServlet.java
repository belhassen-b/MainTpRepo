package com.example.tprevision_150623.servlet;



import com.example.tprevision_150623.entities.Grille;
import com.example.tprevision_150623.services.GrilleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/tirer")
public class TirerServlet extends HttpServlet {

    private GrilleService grilleService = new GrilleService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Grille grille = (Grille) req.getSession().getAttribute("grille");
        int x = Integer.parseInt(req.getParameter("x"));
        int y = Integer.parseInt(req.getParameter("y"));
            grilleService.tirer(grille, x, y);
            if(grilleService.resteBateau(grille)){
                req.getSession().setAttribute("gameOver", "true");
            }
        req.getSession().setAttribute("grille", grille);
        req.getRequestDispatcher("WEB-INF/views/grille.jsp").forward(req, resp);
    }
}
