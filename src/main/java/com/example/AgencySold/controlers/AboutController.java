package com.example.AgencySold.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {
    @RequestMapping("/about")
    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("about", "О нас");
        return "about";
    }

}
