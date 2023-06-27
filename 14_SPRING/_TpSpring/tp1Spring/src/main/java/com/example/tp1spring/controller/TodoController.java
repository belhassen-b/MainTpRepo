package com.example.tp1spring.controller;


import com.example.tp1spring.entity.Todo;
import com.example.tp1spring.service.ITodoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private ITodoService todoService;

    @Autowired
    private HttpSession _httpSession;



    // Affiche l'ensemble des todos
    @GetMapping("/show")
    public ModelAndView showAll() {
        ModelAndView mv = new ModelAndView();
        if(_httpSession.getAttribute("user") == null) {
            mv.setViewName("redirect:/user/login");
            return mv;
        }else if (todoService.findAll().isEmpty()) {
// return a message if the list is empty
            mv.setViewName("show");
            mv.addObject("message", "Aucun todo");

        } else {
            mv.setViewName("show");
            mv.addObject("todos", todoService.findAll());
        }
        return mv;
    }

    // recherche par id
    @GetMapping("/search")
    public String searchTodoById(@RequestParam("todoId") Integer todoId, Model model) {
        Todo todo = todoService.findById(todoId);
        model.addAttribute("todo", todo);
        return "todo-details";
    }

// permet l'ajout d'un todo si l'id est null en passant la methode create
    @GetMapping("/add")
    public String addTodo(Model model) {
        model.addAttribute("todo", new Todo());
        model.addAttribute("category", todoService.findAllCategory());
        model.addAttribute("priority", todoService.findAllPriority());
        return "add";
    }

    @PostMapping("/create")
    public String postTodo(@ModelAttribute Todo todo) {
        System.out.println("todo = " + todo);
        if (todo.getId() == null) {
            if (todoService.create(todo)) {
                return "redirect:/todo/show";
            }
        } else {
            Todo existTodo = todoService.findById(todo.getId());
            if (existTodo != null) {
                existTodo.setTitle(todo.getTitle());
                existTodo.setDescription(todo.getDescription());
                existTodo.setDone(todo.getDone());
                existTodo.setDate(todo.getDate());
                existTodo.setPriority(todo.getPriority());
                existTodo.setCategory(todo.getCategory());
                existTodo.setUrgent(todo.getUrgent());
                if (todoService.update(existTodo)) {
                    return "redirect:/todo/show";
                }
            }
        }
        return "error";
    }


    // Affoche la liste des todos réalisées
    @GetMapping("/done")
    public ModelAndView done() {
        ModelAndView mv = new ModelAndView();

        if (todoService.findAll().isEmpty()) {
            mv.setViewName("error");
        } else {
            mv.setViewName("done");
            mv.addObject("todos", todoService.findAll());
        }
        return mv;
    }

    // Affiche la liste des todos non réalisées
    @GetMapping("/notdone")
    public ModelAndView notdone() {
        ModelAndView mv = new ModelAndView();

        if (todoService.findAll().isEmpty()) {
            mv.setViewName("error");
        } else {
            mv.setViewName("notdone");
            mv.addObject("todos", todoService.findAll());
        }
        return mv;
    }

    //Methode pour mettre à jour
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        model.addAttribute("category", todoService.findAllCategory());
        model.addAttribute("priority", todoService.findAllPriority());
        return "add";
    }

    @PostMapping("/update/{id}")
    public Todo update(@PathVariable("id") Integer id, @RequestBody Todo todo) {
        Todo existTodo = todoService.findById(id);
        if (existTodo != null) {
            existTodo.setTitle(todo.getTitle());
            existTodo.setDescription(todo.getDescription());
            existTodo.setDone(todo.getDone());
            existTodo.setDate(todo.getDate());
            existTodo.setPriority(todo.getPriority());
            existTodo.setCategory(todo.getCategory());
            if (todoService.update(existTodo)) {
                return existTodo;
            }
        }
        return existTodo;
    }

    //Methode pour supprimer
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Todo todo = todoService.findById(id);
        if (todo != null) {
            todoService.delete(todo);
        }
        return "redirect:/todo/show";
    }

}