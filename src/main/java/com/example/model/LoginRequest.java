package com.example.model;

import java.lang.reflect.Field;

public class LoginRequest {

	String loginEmail;
	String loginPassword; 
	
	public LoginRequest()
	{
		
	}
	
	public boolean isNull() throws IllegalAccessException {
		   for (Field f : getClass().getDeclaredFields())
		       if (f.get(this) == null)
		           return true;
		   return false;
		}

	public LoginRequest(String loginEmail, String loginPassword) {
		super();
		this.loginEmail = loginEmail;
		this.loginPassword = loginPassword;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Override
	public String toString() {
		return "LoginRequest [loginEmail=" + loginEmail + ", loginPassword=" + loginPassword + "]";
	}
	
	
}
