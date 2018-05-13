package com.web.messenger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Index {

    @GetMapping("/")
    public ModelAndView index() {
        Map<String,String> model = new HashMap<>();
        model.put("title","Welcome");
        return new ModelAndView("index",model);
    }

}
