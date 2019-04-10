package com.example.dao;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.model.User;
import com.example.model.User;
import com.example.util.HibernateUtil;

public class UserDao {
	
	public UserDao() {
	}
	
	public void insert(User myUser) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(myUser);
		tx.commit();
	}
	
	public User selectByCred(String username) {
		Session ses = HibernateUtil.getSession();
		
		User myUser = ses.get(User.class, username);
		
		return myUser;
	}
	
	public List<User> searchByFirstLast(String firstname, String lastname){
		Session ses = HibernateUtil.getSession();
		
		Query<User> query = ses.createQuery("from User where firstname = :firstname and lastname = :lastname");
		query.setParameter("firstname", firstname);
		query.setParameter("lastname", lastname);
		
		List<User> list = query.list();
		return list;
	}
	
	public void updateUserProfile(User us) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.update(us);
		tx.commit();
	}
	
	public List<User> selectAll(){
		Session ses = HibernateUtil.getSession();
		List<User> userList = ses.createCriteria(User.class).list();
		return userList;
	}

}
