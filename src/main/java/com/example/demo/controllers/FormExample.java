package com.example.demo.controllers;

import com.example.demo.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
public class FormExample {
    // Showing how to create a form using thymeleaf
    ArrayList<String> indhold = new ArrayList<>();
    ArrayList<Post> posts = new ArrayList<>();


    @GetMapping(value= "/index")
    public String homePage(){
        return "index";
    }


    @GetMapping(value = "/submit")
    public String renderForm() {
        return "form";
    }



    @PostMapping(value= "/submit-post")
    public String redirectPage(@RequestParam(name = "title") String title,
                               @RequestParam(name = "content") String content,
                               @RequestParam(name = "date") String date,
                               @RequestParam(name = "color") String color,
                               @RequestParam(name = "radio") String publicOrNot, RedirectAttributes attributes){

        attributes.addAttribute("title", title);
        attributes.addAttribute("content", content);
        attributes.addAttribute("date", date);
        attributes.addAttribute("color", color);
        attributes.addAttribute("publicOrNot", publicOrNot);

        Post post = new Post(title, content, date, color, publicOrNot);
        posts.add(post);

        return "redirect:/succes";
    }



    @GetMapping(value= "/succes")
    public String renderList(@RequestParam String title, @RequestParam String content, @RequestParam
            String date, @RequestParam String color, @RequestParam String publicOrNot,
                             Model model) {
        model.addAttribute("title", title);
        model.addAttribute("content", content);
        model.addAttribute("date", date);
        model.addAttribute("color", color);
        model.addAttribute("publicOrNot", publicOrNot);

        return "succes";
    }

    @GetMapping(value= "/dashboard")
    public String dashboard(Model model){
        model.addAttribute("post", posts);

        return "dashboard";
    }

/*
    @GetMapping(value="/practice")
    public String practiceStuff(Model model){
        boolean isUserLoggedIn = false;
        model.addAttribute("isUserLoggedIn", isUserLoggedIn);

        String userType = "premium";
        model.addAttribute("userType",userType);

        return "practice";
    }
 */
}
