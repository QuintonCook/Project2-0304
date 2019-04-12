package com.example.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="POSTS")
public class Post {
	
	@Column(name="numberoflikes")
	private Integer numberOfLikes; 
	
	@Column(name="url")
	private String url;
	
	@Column(name="body")
	private String body;
	
	@Id
	@Column(name="postid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="email")
	@JsonBackReference
	private User key;
	
	public Post() {
		
	}

	public Post(String url, String body, int postId, User key) {
		super();
		this.url = url;
		this.body = body;
		this.postId = postId;
		this.key = key;
	}

	public Post(String url, String body, int postId) {
		super();
		this.url = url;
		this.body = body;
		this.postId = postId;
	}
	
	public Post(String url, String body, User key) {
		super();
		this.url = url;
		this.body = body;
		this.key = key;
		
		numberOfLikes = 0;
	}

	public Post(String url, int postId) {
		super();
		this.url = url;
		this.postId = postId;
	}

	public Post(int postId, String body) {
		super();
		this.body = body;
		this.postId = postId;
	}

	public Post(String url, String body) {
		super();
		this.url = url;
		this.body = body;
	}

	public Integer getNumberOfLikes() {
		return numberOfLikes;
	}

	public void setNumberOfLikes(Integer numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public User getKey() {
		return key;
	}

	public void setKey(User key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Post [numberOfLikes=" + numberOfLikes + ", url=" + url + ", body=" + body + ", postId=" + postId
				+ ", key=" + key + "]";
	}

}
