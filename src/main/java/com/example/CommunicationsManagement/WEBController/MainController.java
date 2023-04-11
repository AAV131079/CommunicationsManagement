package com.example.CommunicationsManagement.WEBController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // Start page controller
    @GetMapping("/")
    public String startPage(Model model) {
        model.addAttribute("title", "Интеграционные API");
        return "StartPage";
    }

}
