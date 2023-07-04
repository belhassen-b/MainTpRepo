package com.example.tp_spring_annonces.controller;


import com.example.tp_spring_annonces.entity.Ad;
import com.example.tp_spring_annonces.entity.Category;
import com.example.tp_spring_annonces.service.IAdService;
import com.example.tp_spring_annonces.service.ICategoryService;
import com.example.tp_spring_annonces.service.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Controller
@RequestMapping("/ad")
public class AdController {

    @Autowired
    private IAdService adService;

    @Autowired
    private IUserService userService;

    @Autowired
    private HttpSession _httpSession;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/adManagement")
    public String adManagement(Model model) {
        model.addAttribute("ads", adService.findAll());
        model.addAttribute("categories", categoryService.findAll());
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


    @PostMapping("/create")
    public ModelAndView create(@RequestParam("title") String title,
                               @RequestParam("content") String content, @RequestParam("price") double price,
                               @RequestParam("category") List<Category> category,
                               @RequestParam("picture") List<MultipartFile> picture) {
        Ad ad = Ad.builder()
                .title()
                .content()
                .price()
                .build()
try{
    for (MultipartFile file : picture) {
        File path = new File("static/uploads" + file.getOriginalFilename());
        path.createNewFile();
        FileOutputStream outputStream= new FileOutputStream(path);
        outputStream.write(file.getBytes());
        outputStream.close();
    }
}catch(Exception e){

}

        return new ModelAndView ();
    }
}