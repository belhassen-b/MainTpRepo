package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "team", value = "/team")
public class TeamServlet extends HttpServlet {

    private services.TeamService service;

    public void init() {
        service = new services.TeamService();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("action") != null && request.getParameter("action").equals("create") && !request.getParameter("name").equals("") && !request.getParameter("tournament").equals("")) {
         String name = request.getParameter("name");
         String  players = request.getParameter("players");
            String tournament = request.getParameter("tournament");
            if (service.create(name, players, tournament)) {
                response.sendRedirect("/index");
            }

        }
    }
    public void destroy() {
    }
}
