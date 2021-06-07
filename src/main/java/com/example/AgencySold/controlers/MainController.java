package com.example.AgencySold.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("index", "Главная страница");
        return "index";
    }
    @PreAuthorize("hasAuthority('developers:write')")
    @GetMapping("/indexu/add")
    public String menuAdd(Model model){
        model.addAttribute("title", "Добавление отзыва);
        model.addAttribute("hiddenEl", headerService.isUser());
        return "index-add";
    }

    @PreAuthorize("hasAuthority('developers:write')")
    @PostMapping("/index/add")
    public String menuPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
        Post post = new Post(title, anons, full_text);
        postRepository.save(post);
        return "redirect:/index";
    }

    @GetMapping("/index/{id}")
    public String menuDetails(Model model, @PathVariable(value = "id") long id){
        if(!postRepository.existsById(id)){
            return "redirect:/index";
        }
        model.addAttribute("title", "Описание");
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        model.addAttribute("hiddenEl", headerService.isUser());
        return "index-details";
    }

    @PreAuthorize("hasAuthority('developers:write')")
    @GetMapping("/index/{id}/edit")
    public String menuEdit(Model model, @PathVariable(value = "id") long id){
        if(!postRepository.existsById(id)){
            return "redirect:/index";
        }
        model.addAttribute("title", "Редактирование отзыва");
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        model.addAttribute("hiddenEl", headerService.isUser());
        return "index-edit";
    }

    @PreAuthorize("hasAuthority('developers:write')")
    @PostMapping("/index/{id}/edit")
    public String menuPostUpdate(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model, @PathVariable(value = "id") long id){
        Post post = postRepository.findById(id).orElseThrow(() -> {
            throw new AssertionError();
        });
        post.setTitle(title);
        post.setPrice(anons);
        post.setFull_text(full_text);
        postRepository.save(post);
        return "redirect:/index";
    }

    @PreAuthorize("hasAuthority('developers:write')")
    @PostMapping("/index/{id}/remove")
    public String menuPostDelete(Model model, @PathVariable(value = "id") long id){
        Post post = postRepository.findById(id).orElseThrow(() -> {
            throw new AssertionError();
        });
        postRepository.delete(post);
        return "redirect:/index";
    }
}