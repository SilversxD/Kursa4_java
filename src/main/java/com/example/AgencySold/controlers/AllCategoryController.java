package com.example.AgencySold.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AllCategoryController {
    @RequestMapping("/category_all")
    @GetMapping("/category_all")
    public String page404(Model model){
        model.addAttribute("category_all", "Все товары");
        return "category_all";
    }
}
