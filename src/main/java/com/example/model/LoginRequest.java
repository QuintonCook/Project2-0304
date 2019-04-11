package com.example.model;

public class LoginRequest {

	String loginEmail;
	String loginPassword; 
	
	public LoginRequest()
	{
		
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
