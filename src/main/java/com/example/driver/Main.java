package com.example.driver;

import java.util.List;

import com.example.dao.PostDao;
import com.example.dao.UserDao;
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
		 User user = new User("Quinton", "Cook", "Quinton_Cook@gamil.com","qc1" );
		User user1 = new User("Meme", "Lopez", "Meme_Lopez@gmail.com", "ml1");
		User user2 = new User("Daniel", "Serna", "Daniel_Serna@gmail.com", "ds1");
		User user3 = new User("David", "Deyoung", "David_Deyounge@gmail.com","dd1" );
		User user4 = new User("test", "test", "test@gmail.com", "test" );
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
		
		System.out.println(userDao.selectByCred("Quinton_Cook@gamil.com"));
		
		HibernateUtil.closeSes();
	}


}
