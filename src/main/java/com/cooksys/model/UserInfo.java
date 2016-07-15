package com.cooksys.model;

public class UserInfo {
	private String username;

	public UserInfo(String username) {
		super();
		this.username = username;
	}

	public UserInfo() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
