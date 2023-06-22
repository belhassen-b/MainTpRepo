package com.example.tp1spring.controller;


import com.example.tp1spring.entity.Todo;
import com.example.tp1spring.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private ITodoService todoService;


    @GetMapping("/show")
    public ModelAndView showAll() {
        ModelAndView mv = new ModelAndView();

        if (todoService.findAll().isEmpty()) {
            mv.setViewName("error");
        } else {
            mv.setViewName("show");
            mv.addObject("todos", todoService.findAll());
        }
        return mv;
    }


    @GetMapping("/add")
    public String addTodo(Model model) {
        model.addAttribute("todo", new Todo());
        model.addAttribute("category", todoService.findAllCategory());
        model.addAttribute("priority", todoService.findAllPriority());
        return "add";
    }
//    public ModelAndView addTodo() {
//        ModelAndView mv = new ModelAndView("add");
//        mv.addObject("todo", new Todo());
//        return mv;
//    }

    @PostMapping("/create")
    public String postTodo (@ModelAttribute Todo todo) {
        if(todo.getId() == null) {
            if(todoService.create(todo)) {
                return "redirect:/todo/show";
            }
            return "error";
        } else {
            Todo existTodo = todoService.findById(todo.getId());
            if(existTodo != null) {
                existTodo.setTitle(todo.getTitle());
                existTodo.setDescription(todo.getDescription());
                existTodo.setDone(todo.getDone());
                existTodo.setDate(todo.getDate());
                existTodo.setPriority(todo.getPriority());
                existTodo.setCategory(todo.getCategory());
                if(todoService.update(existTodo)) {
                    return "redirect:/todo/show";
                }
            }
            return "error";
        }
    }

}