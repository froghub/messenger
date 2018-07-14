package com.web.messenger.model;



import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String email;
	private String login;
	private String password;
	@Transient
	transient private String passwordConfirm;
	@ManyToMany
	@JoinTable(name = "UserRole",joinColumns = @JoinColumn(name="UserID"),inverseJoinColumns = @JoinColumn(name = "RoleID"))
	private Set<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", email='" + email + '\'' +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", passwordConfirm='" + passwordConfirm + '\'' +
				", roles=" + roles +
				'}';
	}
}
