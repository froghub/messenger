package com.web.messenger.controller;

import com.web.messenger.dao.UserRepository;
import com.web.messenger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Register {

	@Autowired
	UserRepository repository;

	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String register(@RequestBody User r){

		System.out.println(r);
		return "redirect:layout/index";
	}

}
