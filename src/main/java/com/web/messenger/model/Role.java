package com.web.messenger.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	@ManyToMany
	private Set<User> users;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
