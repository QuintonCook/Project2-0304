package com.example.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.example.dao.UserDao;
import com.example.model.LoginRequest;
import com.example.model.RegisterRequest;
import com.example.model.User;
import com.example.testphoto1.GrabPhoto;

@RestController
public class EmployeeCtrl {

	final String url = "https://s3.us-east-2.amazonaws.com/theupchuckbucket/";

	public static UserDao userDao = new UserDao();

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(20000000);
		return multipartResolver;
	}

	// UPDATE PROFILE REQUEST
	// @CrossOrigin(origins="http://localhost:4200") is used to handle the request
	// from a different origin
	@RequestMapping(value = "/updateprofile", method = RequestMethod.POST)
	public String updateProfile(@RequestParam(name = "file") MultipartFile p, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String email, @RequestParam String password,
			@RequestParam String description) {
		try {
			// modelMap.addAttribute("file", p);
			// modelMap.addAttribute("firstName", firstname);
			// modelMap.addAttribute("lastName", lastname);
			InputStream i = p.getInputStream();
			String photoName = GrabPhoto.grabPho(i);

			// System.out.println(email);

			User u = userDao.selectByCred(email);

			System.out.println(u);

			u.setProfilePic(url + photoName);
			u.setFirstname(firstName);
			u.setLastname(lastName);
			u.setEmail(email);
			u.setPassword(password);
			u.setDescription(description);

			userDao.updateUserProfile(u);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// LOGIN REQUEST
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody User login(@RequestParam LoginRequest l) {
		User u = userDao.selectByCred(l.getLoginEmail());

		// System.out.println(u);

		// catch null pointer exceptions later on
		try {
			if (u.getEmail().equals(l.getLoginEmail()) && u.getPassword().equals(l.getLoginPassword())) {
				return u;// go to home page
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	// REGISTER REQUEST
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody void login(@RequestParam RegisterRequest r)
	{
		userDao.insert(r.toUser());
	}
	
	// RESET PASSWORD REQUEST 
	@RequestMapping(value = "/passwordreset", method = RequestMethod.POST)
	public @ResponseBody void passwordReset(@RequestParam LoginRequest l) {
		User u = userDao.selectByCred(l.getLoginEmail());
		
		u.setPassword(l.getLoginPassword());
		
		userDao.updateUserProfile(u);
	}
	

}
