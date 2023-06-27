package com.example.tp_spring_annonces.controller;


import com.example.tp_spring_annonces.entity.Category;
import com.example.tp_spring_annonces.entity.User;
import com.example.tp_spring_annonces.service.ICategoryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private User user;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private HttpSession _httpSession;


    @PostMapping("/create")
    public String postCategory(@ModelAttribute User user, @ModelAttribute Category category) {
        if (_httpSession != null) {
            user = (User) _httpSession.getAttribute("user");
            if (user == null) {
                return "redirect:/user/login";
            } else if (!user.isAdmin()) {
                return "redirect:/ad/show";
            } else if (user.isAdmin()) {
                categoryService.save(category);
                return "redirect:/category/categoryManagement";
            }

        }
        return "redirect:/user/login";
    }

    @GetMapping("/categoryManagement")
    public String categoryManagement(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "categoryManagement";
    }


    @GetMapping("/editCategory/{id}")
    public String editCategory(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "editCategory";
    }

    @PostMapping("/updateCategory/{id}")
    public String editCategory(@PathVariable("id") Long id, @ModelAttribute Category category
    ) {
        Category category1 = categoryService.findById(id);
        category1.setLabel(category.getLabel());
        categoryService.update(category1);
        return "redirect:/category/categoryManagement";
    }


    @GetMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        Category category = categoryService.findById(id);
        if(category != null) {
            categoryService.delete(category);
        }
        return "redirect:/category/categoryManagement";
    }
}
