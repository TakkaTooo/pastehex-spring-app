package ru.rsreu.pastehex.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String getMainPage(Model model, Authentication authentication) {
        model.addAttribute("authenticated", authentication != null);
        if (authentication != null) {
            model.addAttribute("name", authentication.getName());
        }
        return "main";
    }
}
