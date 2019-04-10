package com.example.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.example.dao.UserDao;
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
	
	
	// @CrossOrigin(origins="http://localhost:4200") is used to handle the request from a different origin
		@RequestMapping(value="/updateprofile", method=RequestMethod.POST)
		public String updateProfile(@RequestParam(name="file")MultipartFile p, @RequestParam String firstName, 
				@RequestParam String lastName, @RequestParam String email, @RequestParam String password) 
		{
			try {
				// modelMap.addAttribute("file", p);
//				modelMap.addAttribute("firstName", firstname);
//				modelMap.addAttribute("lastName", lastname);
				InputStream i = p.getInputStream();
				String photoName = GrabPhoto.grabPho(i);
				
				// System.out.println(email);
				
				User u = userDao.selectByCred(email);
				
				System.out.println(u);
				
				u.setProfilePic(url+photoName);
				u.setFirstname(firstName);
				u.setLastname(lastName);
				u.setEmail(email);
				u.setPassword(password);
				
				
				
				userDao.updateUserProfile(u);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		
		
}
