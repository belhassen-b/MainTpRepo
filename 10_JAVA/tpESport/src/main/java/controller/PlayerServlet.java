package controller;


import entities.Game;
import entities.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "player", value = "/player")
public class PlayerServlet extends HttpServlet {

    private services.PlayerService service;

    public void init() {
        service = new services.PlayerService();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("action") != null && request.getParameter("action").equals("create") && !request.getParameter("name").equals("") && !request.getParameter("game").equals("")) {
            if (service.create(request.getParameter("name"), Game.valueOf(request.getParameter(" game")))) {
                response.sendRedirect("/index");
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("action") != null && request.getParameter("action").equals("delete") && !request.getParameter("id").equals("")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Player player = service.findById(id);
            if (service.delete(request.getParameter("id"))) {
                response.sendRedirect("/index");
            }
        }
    }

    public void destroy() {
    }
}
