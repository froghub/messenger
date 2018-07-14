package com.web.messenger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Layout {

    @GetMapping("/")
    String index(Model model) {
        //model.addAttribute("message", "attrval");
        return "layouts/index";
    }

    @GetMapping("/login")
    public String login() {
        return "layouts/login";
    }

	@GetMapping("/register")
	public String register() {
		return "layouts/register";
	}

    @GetMapping("/faq")
    public String faq() {
        return "layouts/faq";
    }

	@GetMapping("/api")
	public ModelAndView api(ModelAndView model) {
    	model.setViewName("layouts/api");
    	//model.addObject("number","#1");
		return model;
	}
}
