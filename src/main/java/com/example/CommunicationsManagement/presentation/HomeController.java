package com.example.CommunicationsManagement.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/"})
    public String getIndexPage(Model model, String error) {
        return "index";
    }
}
