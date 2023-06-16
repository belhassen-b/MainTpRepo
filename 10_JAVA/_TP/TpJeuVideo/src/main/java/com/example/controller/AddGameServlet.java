package com.example.controller;


import com.example.Plateform;
import com.example.entities.VideoGame;
import com.example.services.VideoGameService;
import com.example.util.Definition;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "add", value = "/add")
public class AddGameServlet extends HttpServlet {
    private VideoGameService service;


    @Override
    public void init() {
        service = new VideoGameService();
    }

    @Override

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (req.getParameter("nom") != null) {
            String name = req.getParameter("nom");
            String genre = req.getParameter("genre");
            Plateform plateforme = Plateform.valueOf(req.getParameter("plateforme"));
            String description = req.getParameter("description");
            Date addedDate = new Date();
            String image = req.getParameter("image");
            double prix = Double.parseDouble(req.getParameter("prix"));
            VideoGame videoGame = VideoGame.builder()
                    .name(name)
                    .genre(genre)
                    .plateform(plateforme)
                    .description(description)
                    .addedDate(addedDate)
                    .image(image)
                    .price(prix)
                    .build();
            if (service.create(videoGame)) {
                resp.sendRedirect("ListeJeux");
            }
        }
    }


@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if( request.getParameter("id") != null){
            int id = Integer.parseInt(request.getParameter("id"));
            VideoGame videoGame = service.findById(id);
            request.setAttribute("videoGame", videoGame);
            request.getRequestDispatcher(Definition.VIEW_PATH + "ListeJeux.jsp").forward(request, response);
        }else{
            request.setAttribute("videoGames", service.findAll());
            request.getRequestDispatcher(Definition.VIEW_PATH + "ListeJeux.jsp").forward(request, response);
        }
    }

    public void destroy() {
    }
}
