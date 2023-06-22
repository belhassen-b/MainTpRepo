package com.example.tp5_cours.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/color")
public class ColorController {

    @GetMapping("formulaire")
    public String getPage (HttpServletResponse response) {
        Cookie cookie = new Cookie("data", "couleur");
        cookie.setMaxAge(36000);
        response.addCookie(cookie);
        return "<form action=\"/color/ajouter\" method=\"post\">\n" +
                "    <label for=\"couleur\">Choisissez une couleur de fond:</label>\n" +
                "    <select name=\"couleur\" id=\"couleur\">\n" +
                "      <option value=\"red\">Rouge</option>\n" +
                "      <option value=\"green\">Vert</option>\n" +
                "      <option value=\"blue\">Bleu</option>\n" +
                "    </select>\n" +
                "    <input type=\"submit\" value=\"Envoyer\">\n" +
                "</form>";
    }

@PostMapping("/ajouter")
public String ecrireCookie(HttpServletResponse response) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    Cookie cookie = new Cookie("data", "couleur");
    cookie.setMaxAge(36000);
    response.addCookie(cookie);
    return mapper.writeValueAsString(cookie);
}

@GetMapping("/lire")
public String lireCookie(HttpServletRequest request) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    Cookie[] cookies = request.getCookies();
    String couleur = "";
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("data")) {
            couleur = cookie.getValue();
        }
    }
    return mapper.writeValueAsString(couleur);

}

    }

