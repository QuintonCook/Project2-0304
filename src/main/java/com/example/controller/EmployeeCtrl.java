package com.example.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.example.dao.PostDao;
import com.example.dao.UserDao;
import com.example.model.LoginRequest;
import com.example.model.Post;
import com.example.model.RegisterRequest;
import com.example.model.SearchRequest;
import com.example.model.User;
import com.example.testphoto1.GrabPhoto;

@RestController
public class EmployeeCtrl {

	final String url = "https://s3.us-east-2.amazonaws.com/theupchuckbucket/";

	@Autowired
	public UserDao userDao;

	@Autowired
	public PostDao postDao;

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(20000000);
		return multipartResolver;
	}

	@RequestMapping(value = "/insertpost", method = RequestMethod.POST)
	public void insertPost(@RequestParam(name = "file", required = false) MultipartFile p, @RequestParam String body, 
			@RequestParam String email) throws IOException
	{
		String photoName = null;
		if (p != null) {
			InputStream i = p.getInputStream();
			photoName = GrabPhoto.grabPho(i);
		}
		
		User u = userDao.selectByCred(email);

		Post post = new Post(photoName, body, u);
		
		postDao.insert(post);
	}
	
	@RequestMapping(value = "/updateprofile", method = RequestMethod.POST)
	public void updateProfile(@RequestParam(name = "file", required = false) MultipartFile p,
			@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
			@RequestParam String password, @RequestParam String description) throws IOException {

		String photoName = null;
		if (p != null) {
			InputStream i = p.getInputStream();
			photoName = GrabPhoto.grabPho(i);
		}

		User u = userDao.selectByCred(email);

		if (u != null) {

			u.setProfilePic(url + photoName);
			u.setFirstname(firstName);
			u.setLastname(lastName);
			u.setEmail(email);
			u.setPassword(password);
			u.setDescription(description);

			userDao.updateUserProfile(u);
		}

	}

	// LOGIN REQUEST
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody User login(@RequestBody LoginRequest l) throws IllegalAccessException {

		if (!l.isNull()) {
			User u = userDao.selectByCred(l.getLoginEmail());
			return u;
		} else {
			return null;
		}

	}

	// REGISTER REQUEST
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody void register(@RequestBody RegisterRequest r) throws IllegalAccessException {

		if (!r.isNull()) {
			userDao.insert(r.toUser());
		}

	}

	// RESET PASSWORD REQUEST
	@RequestMapping(value = "/passwordreset", method = RequestMethod.POST)
	public @ResponseBody void passwordReset(@RequestBody LoginRequest l) throws IllegalAccessException {

		if (!l.isNull()) {
			User u = userDao.selectByCred(l.getLoginEmail());
			u.setPassword(l.getLoginPassword());
			userDao.updateUserProfile(u);
		}
	}

	// GET POST
	@RequestMapping(value = "/getpost", method = RequestMethod.GET)
	public @ResponseBody List<Post> getPosts(@RequestParam User u) {
		List<Post> postList = postDao.searchByPoster(u);

		return postList;
	}

	// GET SEARCH USER BY FIRSTNAME AND LASTNAME
	@RequestMapping(value = "/searchuser", method = RequestMethod.GET)
	public @ResponseBody List<User> getSearch(@RequestParam SearchRequest s) {
		List<User> userList = userDao.searchByFirstLast(s.getFirstName(), s.getLastName());

		return userList;
	}

	// GET SEARCH USER BY EMAIL
	@RequestMapping(value = "/searchuseremail", method = RequestMethod.GET)
	public @ResponseBody User getSearchEmail(@RequestParam String email) {
		User u = userDao.selectByCred(email);

		return u;
	}

	// POST NUMBER OF LIKES
	@RequestMapping(value = "/likepost", method = RequestMethod.POST)
	public @ResponseBody void updateNumberOfLikes(@RequestParam Post p) {
		postDao.updatePostLikes(p);

	}

}
