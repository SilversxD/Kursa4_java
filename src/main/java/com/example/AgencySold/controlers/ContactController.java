package com.example.AgencySold.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactController {
    @RequestMapping("/contact")
    @GetMapping("/contact")
    public String contact(Model model){
        model.addAttribute("contact", "Наши контакты");
        return "contact";
    }

}
