package com.coderscampus.com.Unit5;

public class UserPOJO {

	private String username;
	private String password;
	private String name;

	String getUsername() {
		return username;
	}

	private void setUsername(String username) {
		this.username = username;
	}

	String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	UserPOJO(String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
	}

}
