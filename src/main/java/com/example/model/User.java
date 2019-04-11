package com.example.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	
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
	private List<Post> postList;
	
	public User() {
		
	}

	public User(String firstname, String lastname, String password, String email, List<Post> postList) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.postList = postList;
	}

	public User(String firstname, String lastname, List<Post> postList) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.postList = postList;
	}

	public User(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}

	public User(List<Post> postList, String password, String email) {
		super();
		this.password = password;
		this.email = email;
		this.postList = postList;
	}

	public User(String firstname, String lastname, String password, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
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
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", password=" + password + ", email=" + email
				+ "]";
	}
	
	
	

}
