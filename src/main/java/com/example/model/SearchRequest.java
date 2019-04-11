package com.example.model;

public class SearchRequest {

	String firstName; 
	String lastName; 
	
	public SearchRequest() {}

	public SearchRequest(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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

	@Override
	public String toString() {
		return "SearchRequest [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
