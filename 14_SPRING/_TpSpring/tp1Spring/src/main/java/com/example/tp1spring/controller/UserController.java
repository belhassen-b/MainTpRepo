package com.example.tp1spring.controller;

import com.example.tp1spring.entity.User;
import com.example.tp1spring.service.IUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private HttpSession _httpSession;



    // ajout user
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";

    }


    @PostMapping("/createuser")
    public String postUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userService.findByUsernameAndPassword(username, password);

        if(user != null) {
            _httpSession.setAttribute("user", user);
            boolean isLogged = true;
            return "redirect:/todo/show";
        }
        return "login";

    }

    @GetMapping("/logout")
    public String logout() {
        _httpSession.invalidate();
        boolean isLogged = false;
        return "redirect:/user/login";
    }

    @GetMapping("/show")
    public String showAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "show";
    }

    @GetMapping("/search")
    public String searchUserById(@RequestParam("userId") Integer userId, Model model) {
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        return "user-details";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "add";
    }

    @PostMapping("/create")
    public String postUser(@ModelAttribute User user) {
        System.out.println("user = " + user);
        if (user.getId() == null) {
            userService.create(user);
        }
        return "redirect:/todo/show";
    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteUser(@PathVariable Integer id) {
//        userService.delete(id);
//        return "redirect:/user/show";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String editUser(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("user", userService.findById(id));
//        return "add";
//    }
}