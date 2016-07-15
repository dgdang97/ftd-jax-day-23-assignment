package com.cooksys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

	@Column(name="location")
	private String location;
	
	public User() {
		super();
	}

	public User(String username) {
		super();
		this.username = username;
	}
	
	public User(String username, String password, String location) {
		super();
		this.username = username;
		this.password = password;
		this.location = location;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocationId(String location) {
		this.location= location;
	}
}
