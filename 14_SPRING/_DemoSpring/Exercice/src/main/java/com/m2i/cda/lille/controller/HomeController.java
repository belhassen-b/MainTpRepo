package com.m2i.cda.lille.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody

public class HomeController {

    @RequestMapping("/")
    public String getHome() {
        return "Hello World!";
    }
    @RequestMapping("/toto")
    public String getToto() {
        return "Hello Toto!";
    }

    @RequestMapping(value = "test/demo", method = RequestMethod.GET)
    public String getTest() {
        return "Just a test";
    }

    @RequestMapping(value = "header/demo",headers = "Accept=application/json",method = RequestMethod.GET)
    public String getTest2() {
        return "Just a test 2";
    }

    @GetMapping("/home")
    public String getHome2() {
        return "get method";
    }

    @PostMapping("/post")
    public String pagePost() {
        return "post method";
    }

    @GetMapping("/home/{data}")
    public String getHome3(@PathVariable ("data") Integer id){
        return "get method with data : " + id;
    }

    @GetMapping("/get/{data}/test/{id}")
    public String getHome4(@PathVariable ("data") Integer id, @PathVariable Integer id2){
        return "get method with data : " + id + " and " + id2;
    }

    @GetMapping("/getParams")
    public String getHome5(@RequestParam ("id")Integer id){
        return "le param est : " + id;
    }
}
