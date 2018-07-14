package com.web.messenger.controller;

import com.web.messenger.dao.UserRepository;
import com.web.messenger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Login {

	public Login() {}
	public Login(UserRepository repository) {
		this.repository = repository;
	}

	@Autowired
	UserRepository repository;

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
	public User submit(@RequestBody User r){
		User u = repository.findByLoginAndPassword(r.getLogin(),r.getPassword()).get(0);
    	return u;
	}

}
