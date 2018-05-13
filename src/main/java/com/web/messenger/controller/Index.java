package com.web.messenger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class Index {

    @GetMapping("/")
    String index(Model model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "layouts/index";
    }

}
