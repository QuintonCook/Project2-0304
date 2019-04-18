package com.example.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="USERS")
public class User {
	
	@Column(name="description")
	private String description; 
	
	@Column(name="profilepic")
	private String profilePic;
	
	@Column(name="firstname", nullable=false)
	private String firstname;
	
	@Column(name="lastname", nullable=false)
	private String lastname;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Id
	@Column(name="email", nullable=false)
	private String email;
	
	@OneToMany(mappedBy="key", fetch=FetchType.EAGER)
	@JsonManagedReference
	private List<Post> postList;
	
	public User() {
		
	}

	public User(String email) {
		super();
		this.email = email;
	}

	public void addPost(Post p) {
		this.postList.add(p);
	}

	public User(String firstname, String lastname, String email, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.postList = new ArrayList<Post>();
		this.profilePic = "";
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	@Override
	public String toString() {
		return "User [description=" + description + ", profilePic=" + profilePic + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", password=" + password + ", email=" + email + ", postList=" + postList
				+ "]";
	}

	
}
