package com.example.AgencySold.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller404 {
    @RequestMapping("/404")
    @GetMapping("/404")
    public String page404(Model model){
        model.addAttribute("404", "404");
        return "404";
    }
}
