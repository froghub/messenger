package com.web.messenger.service;

import com.web.messenger.config.UserPrincipial;
import com.web.messenger.dao.UserRepository;
import com.web.messenger.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {


	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = repository.findUserByLogin(login);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		if(user==null) {
			throw new UsernameNotFoundException(login);
		}else {
			return new UserPrincipial(user);
		}
	}
}
