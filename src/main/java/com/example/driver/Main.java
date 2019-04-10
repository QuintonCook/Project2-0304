package com.example.driver;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.PostDao;
import com.example.dao.UserDao;
import com.example.model.Post;
import com.example.model.User;
import com.example.util.HibernateUtil;

public class Main {
	public static UserDao userDao = new UserDao();
	public static PostDao postDao = new PostDao();
	
	public static void main(String[] args) {
		insertInitialValues();
		System.out.println("done");
		
	}
	
	public static void insertInitialValues() {
		//Users
		 User user = new User("Quinton", "Cook", "qc1", "Quinton_Cook@gamil.com");
		User user1 = new User("Meme", "Lopez", "ml1", "Meme_Lopez@gmail.com");
		User user2 = new User("Daniel", "Serna", "ds1", "Daniel_Serna@gmail.com");
		User user3 = new User("David", "Deyoung", "dd1", "David_Deyoung@gmail.com");
		User user4 = new User("test", "test", "test", "test@gmail.com");
		User test = new User();
		test.setEmail(user4.getEmail());
		test.setFirstname("tester");
		test.setLastname("asdfasd");
		test.setPassword("pass");
		
		 userDao.insert(user);
		userDao.insert(user1);
		userDao.insert(user2);
		userDao.insert(user3);
		userDao.insert(user4);
		userDao.updateUserProfile(test);
		
		User p = new User();
		p = userDao.selectByCred("Meme_Lopez@gmail.com");
		System.out.println(p.toString());
		
		List<User> myList = userDao.selectAll();
		for (User x: myList) {
	         System.out.println(x.toString());
	      }
		
//		Post p = new Post("this@gmail.com", "Post1");
//		Post p1 = new Post("that@gmail.com", "Post2");
//		Post p2 = new Post("what@gmail.com", "Post3");
//		postDao.insert(p);
//		postDao.insert(p1);
//		postDao.insert(p2);
		
//		List<Post> myList = postDao.selectAll();
//		for(Post x: myList) {
//			System.out.println(x.toString());
//		}
		
		// User u1 = new User("user", "user", "uu1", "user@gmail.com");
		/*User u2 = new User("fn", "lm", "fl", "firstLast@gmail.com");
		Post p4 = new Post("url1", "post", u1);
		Post p5 = new Post("url2", "post2", u2);
		postDao.insert(p4);
		postDao.insert(p5);*/
//		List<Post> myList = postDao.searchByPoster(u1);
//		for(Post x: myList) {
//			System.out.println(x.toString());
//		}
		
		
		
		
		System.out.println(userDao.selectByCred("Quinton_Cook@gamil.com"));
		
		HibernateUtil.closeSes();
	}


}
