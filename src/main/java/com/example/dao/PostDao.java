package com.example.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.model.Post;
import com.example.model.User;
import com.example.util.HibernateUtil;

@Repository("postDao")
@Transactional
@Component
public class PostDao {
	
	public PostDao() {
		
	}
	
	public void insert(Post po) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.save(po);
		tx.commit();
	}
	
	public List<Post> searchByPoster(User user){
		Session ses = HibernateUtil.getSession();
		
		@SuppressWarnings("unchecked")
		Query<Post> query = ses.createQuery("from Post where key = :email");
		query.setParameter("email", user);
		
		List<Post> list = query.list();
		return list;
	}
	
	public List<Post> selectAll(){
		Session ses = HibernateUtil.getSession();
		
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Post> postList = ses.createCriteria(Post.class).list();
		return postList;
	}
	
	public void updatePostLikes(Post po) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		
		ses.merge(po);
		tx.commit();
		
	}
	
	public Post getPost(int id)
	{
		Session ses = HibernateUtil.getSession(); 
		
		return ses.get(Post.class, id);		 
	}

}
