package com.example.model;

import java.lang.reflect.Field;

public class RegisterRequest {
	
	String firstName; 
	String lastName; 
	String email;
	String password; 
	
	public RegisterRequest() {	}

	public RegisterRequest(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public User toUser()
	{
		return new User(firstName, lastName, email, password);
	}
	
	public boolean isNull() throws IllegalAccessException {
		   for (Field f : getClass().getDeclaredFields())
		       if (f.get(this) == null)
		           return true;
		   return false;
		}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegisterRequest [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + "]";
	}
	
	
	
}
