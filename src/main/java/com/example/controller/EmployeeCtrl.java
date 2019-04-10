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


import com.example.testphoto1.GrabPhoto;

@RestController
public class EmployeeCtrl {

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
	   CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	   multipartResolver.setMaxUploadSize(20000000);
	   return multipartResolver;
	}
	
	
	// @CrossOrigin(origins="http://localhost:4200") is used to handle the request from a different origin
		@RequestMapping(value="/upload", method=RequestMethod.POST)
		public String uploadPhoto(@RequestParam(name="file")MultipartFile p, ModelMap modelMap) 
		{
			try {
				modelMap.addAttribute("file", p);
				InputStream i = p.getInputStream();
				GrabPhoto.grabPho(i);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
		
		
}
