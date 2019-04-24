package com.example.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.example.email.EmailHandler;
import com.example.model.LoginRequest;
import com.example.model.Post;
import com.example.model.RegisterRequest;
import com.example.model.User;
import com.example.testphoto1.GrabPhoto;

@RestController
public class EmployeeCtrl {

	final String url = "https://s3.us-east-1.amazonaws.com/kfccrispy/";

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

	//tested
	@CrossOrigin
	@RequestMapping(value = "/insertpost", method = RequestMethod.POST)
	public void insertPost(@RequestParam(name = "file", required = false) MultipartFile p, @RequestParam String body, 
			@RequestParam String email) throws IOException
	{
		User u = userDao.selectByCred(email);
		String photoName = null;
		Post post = new Post(body, u);
		
		if (p != null) {
			InputStream i = p.getInputStream();
			photoName = GrabPhoto.grabPho(i);
			post.setUrl(url+photoName);
		}
		
		u.addPost(post);
		postDao.insert(post);
	}
	
	//tested
	@CrossOrigin
	@RequestMapping(value = "/updateprofile", method = RequestMethod.POST)
	public void updateProfile(@RequestParam(name = "file", required = false) MultipartFile file,
			@RequestParam(name = "firstname") String firstname, @RequestParam(name = "lastname") String lastname, @RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password, @RequestParam(name = "description") String description) throws IOException {

		String photoName = null;
		User u = userDao.selectByCred(email);
		
		if (file != null) {
			InputStream i = file.getInputStream();
			photoName = GrabPhoto.grabPho(i);
			u.setProfilePic(url + photoName);
		}
		
		if (u != null) {

			
			u.setFirstname(firstname);
			u.setLastname(lastname);
			u.setEmail(email);
			u.setPassword(password);
			u.setDescription(description);

			userDao.updateUserProfile(u);
		}

	}

	// TESTED LOGIN REQUEST
	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody User login(@RequestBody LoginRequest l) throws IllegalAccessException {

		if (!l.isNull()) {
			User u = userDao.selectByCred(l.getLoginEmail());
			return u;
		} else {
			return null;
		}

	}

	// TESTED REGISTER REQUEST
	@CrossOrigin
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody void register(@RequestBody RegisterRequest r) throws IllegalAccessException {

		if (!r.isNull()) {
			userDao.insert(r.toUser());
		}

	}

	// TESTED RESET PASSWORD REQUEST
	@CrossOrigin
	@RequestMapping(value = "/passwordreset", method = RequestMethod.GET)
	public @ResponseBody void passwordReset(@RequestParam String email,@RequestParam String password) throws IllegalAccessException {
System.out.println(email+" email shit");
System.out.println(password+" pword shit");
		if (email != null) {
			User u = userDao.selectByCred(email);
			
			if(u != null && !password.equals("")) {
				u.setPassword(password);
				userDao.updateUserProfile(u);
			}			
		}
	}

	// TESTED GET POST
	@CrossOrigin
	@RequestMapping(value = "/getpost", method = RequestMethod.GET)
	public @ResponseBody List<Post> getPosts(@RequestParam String email) {
		
		List<Post> postList = postDao.searchByPoster(userDao.selectByCred(email));

		return postList;
	}

	// TESTED GET SEARCH USER BY FIRSTNAME AND LASTNAME
	@CrossOrigin
	@RequestMapping(value = "/searchuser", method = RequestMethod.GET)
	public @ResponseBody List<User> getSearch(@RequestParam(required = false) String first, @RequestParam(required = false) String last) {
		List<User> userList = userDao.searchByFirstLast(first, last);

		return userList;
	}

	// TESTED GET SEARCH USER BY EMAIL
	@CrossOrigin
	@RequestMapping(value = "/searchuseremail", method = RequestMethod.GET)
	public @ResponseBody User getSearchEmail(@RequestParam String email) {
		User u = userDao.selectByCred(email);

		return u;
	}

	// TESTED POST NUMBER OF LIKES
	@CrossOrigin
	@RequestMapping(value = "/likepost", method = RequestMethod.GET)
	public @ResponseBody void updateNumberOfLikes(@RequestParam int id) {
		
		System.out.println(id);
		Post p = postDao.getPost(id);
		
		p.addLike();
		
		postDao.updatePostLikes(p);
	}
	
	// GET ALL POSTS
	@CrossOrigin
	@RequestMapping(value = "/allposts", method = RequestMethod.GET)
	public @ResponseBody List<Post> getAllPosts()
	{
		List<Post> allPosts = postDao.selectAll();
		
		return allPosts;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/reset",method = RequestMethod.GET)
	public @ResponseBody void resetPassword(@RequestParam String email) throws Throwable
	{
		EmailHandler.setReciever(email);
		EmailHandler.sendEmail();
	}

}
