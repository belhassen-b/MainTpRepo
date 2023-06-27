package com.example.tp_spring_annonces.controller;


import com.example.tp_spring_annonces.entity.Ad;
import com.example.tp_spring_annonces.service.IAdService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ad")
public class AdController {

    @Autowired
    private IAdService adService;

    @Autowired
    private HttpSession _httpSession;

    @GetMapping("/adManagement")
    public String adManagement(Model model) {
        model.addAttribute("ads", adService.findAll());
        return "adManagement";
    }

    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView();
        if (_httpSession.getAttribute("user") != null) {
            modelAndView.setViewName("redirect:/ad/show");
            return modelAndView;
        } else if (adService.findAll().isEmpty()) {
            modelAndView.setViewName("redirect:/ad/show");
            modelAndView.addObject("message", "No ads to show");
        } else {
            modelAndView.setViewName("redirect:/ad/show");
            modelAndView.addObject("ads", adService.findAll());
        }
        return modelAndView;
    }

    @GetMapping("/add")
    public String add() {
        return "adForm";
    }

    @PostMapping("/create")
    public String create(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("price") double price) {
Ad ad = new Ad();
        ad.setTitle(ad.getTitle());
        ad.setContent(ad.getContent());
//        ad.setCategory(ad.getCategory());
        ad.setPrice(ad.getPrice());
//        ad.setPictures(ad.getPictures());
        adService.save(ad);
        return "redirect:/ad/show";
    }
}