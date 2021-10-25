package ru.rsreu.pastehex.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPanelController {

    @GetMapping("/admin")
    public String getAdminPanelPage() {
        return "admin";
    }
}
