package com.example.esport.controller;


import com.example.esport.services.TeamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "team", value = "/team")
public class teamServlet extends HttpServlet {

private TeamService service;


public void init() {
    service = new TeamService();
}

@Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    if (request.getParameter("action") != null && request.getParameter("action").equals("create") && !request.getParameter("name").equals("") && !request.getParameter("game").equals("")) {
      String name = request.getParameter("name");
        String players = request.getParameter("players");
        if (service.create(name, players)) {
            response.sendRedirect("/index");
        }

    }
}



@Override
    public void destroy() {
    }
}


