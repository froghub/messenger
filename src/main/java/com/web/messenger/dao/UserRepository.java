package com.web.messenger.dao;

import com.web.messenger.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	List<User> findByEmail(String mail);
	List<User> findByLoginAndPassword(String login,String password);
	User findUserByLogin(String login);
}
