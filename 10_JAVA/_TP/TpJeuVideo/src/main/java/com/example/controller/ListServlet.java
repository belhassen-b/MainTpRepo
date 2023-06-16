package com.example.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "jeux", value = "/ListeJeux")
public class ListServlet  extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("/WEB-INF/views/ListeJeux.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
