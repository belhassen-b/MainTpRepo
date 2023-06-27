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

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "/addUser";
    }

    @PostMapping("/create")
    public String postUser(@ModelAttribute User user) {
        System.out.println("user = " + user);
        if (user.getId() == null) {
            userService.create(user);
        }
        return "redirect:/todo/show";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/postUser")
    public String postUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = userService.findByUsernameAndPassword(username, password);

        if(user != null) {
            _httpSession.setAttribute("user", user);
            return "redirect:/todo/show";
        }else {
            return "redirect:/user/login";
        }
    }
    @GetMapping("/logout")
    public String logout() {
        _httpSession.invalidate();
        return "redirect:/user/login";
      }
}