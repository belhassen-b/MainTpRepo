package controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "tournament", value = "/tournament")
public class TournamentServlet extends HttpServlet {

    private services.TournamentService service;

    public void init() {
        service = new services.TournamentService();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
 if (request.getParameter("action") != null && request.getParameter("action").equals("create") && !request.getParameter("name").equals("") && !request.getParameter("date").equals("") && !request.getParameter("place").equals("")) {
            if (service.create(request.getParameter("name"), request.getParameter("game"), request.getParameter("date"), request.getParameter("teams"))) {
                response.sendRedirect("/index");
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("action") != null && request.getParameter("action").equals("delete") && !request.getParameter("id").equals("")) {
            if (service.delete(request.getParameter("id"))) {
                response.sendRedirect("/index");
            }
        }
    }

    public void destroy() {
    }

}
