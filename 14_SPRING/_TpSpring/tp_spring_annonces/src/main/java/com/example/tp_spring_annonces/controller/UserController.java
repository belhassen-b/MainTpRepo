package com.example.tp_spring_annonces.controller;


import com.example.tp_spring_annonces.entity.User;
import com.example.tp_spring_annonces.service.IUserService;
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

    // Login & logout
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/postUser")
    public String postUser(@RequestParam("email") String email, @RequestParam("password") String password) {
        User user = userService.findByEmailAndPassword(email, password);

        if(user != null) {
            _httpSession.setAttribute("user", user);
            if(user.isAdmin() == true)
                return "redirect:/user/management";
            else if(user.isAdmin() == false)
            return "redirect:/ad/show";
        }
        return "redirect:/user/login";
    }

    @RequestMapping("/logout")
    public String logout() {
        _httpSession.invalidate();
        return "redirect:/user/login";
    }


    // Create User
    @GetMapping("/register")
    public String register() {
        return "register";
    }


    @PostMapping("/create")
    public String postUser(@ModelAttribute User user, Model model) {
        if(user.isAdmin() == true){
            userService.save(user);
        return "redirect:/user/userManagement";
    }
        else if (user.getId() == null) {
            userService.save(user);
            model.addAttribute("user", user);

        }
        return "redirect:/ad/show";
    }

    // user admin
    @GetMapping("/management")
    public String management() {
        return "management";
    }

    @GetMapping("/userManagement")
    public String userManagement(Model model) {
        model.addAttribute("users", userService.findAll());
        return "userManagement";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/user/userManagement";
    }



    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
      User user = userService.findById(id);
        model.addAttribute("user", user);
        return  "editUser";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute User user) {
        User user1 = userService.findById(id);
        if( user1 != null) {
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());
            if (userService.update(user1)) {
                return "redirect:/user/userManagement";
            }
        }
        return "redirect:/user/userManagement";
    }


    @GetMapping("/profile/{id}")
    public String profile (@PathVariable("id") Long id) {
        User user = userService.findById(id);
    if(user.isAdmin() == true)
        user.setAdmin(false);
    else if(user.isAdmin() == false)
        user.setAdmin(true);
        userService.save(user);
        return "redirect:/user/userManagement";
    }


    @GetMapping("/ban/{id}")
    public String banUser(@PathVariable("id") Long id) {
        User user = userService.findById(id);
     if( user.isActive() == false)
        user.setActive(true);
     else
         user.setActive(false);
        userService.save(user);
        return "redirect:/user/userManagement";
    }
}
