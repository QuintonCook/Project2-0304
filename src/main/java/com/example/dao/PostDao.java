package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.model.Post;
import com.example.model.User;
import com.example.util.HibernateUtil;

public class PostDao {
	
	public PostDao() {
		
	}
	
	public void insert(Post po) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(po);
		tx.commit();
	}
	
	public List<Post> searchByPoster(User email){
		Session ses = HibernateUtil.getSession();
		
		@SuppressWarnings("unchecked")
		Query<Post> query = ses.createQuery("from Post where key = :email");
		query.setParameter("email", email.getEmail());
		
		List<Post> list = query.list();
		return list;
	}
	
	public List<Post> selectAll(){
		Session ses = HibernateUtil.getSession();
		
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Post> postList = ses.createCriteria(Post.class).list();
		return postList;
	}

}
