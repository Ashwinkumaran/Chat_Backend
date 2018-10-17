package com.coll.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.Model.Blog;
import com.coll.Model.Forum;
@Repository("forumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO
{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean addForum(Forum forum) {

		try
		{
			sessionFactory.getCurrentSession().save(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised :"+e);
			return false;
		}
	
	}

	@Override
	public boolean deleteForum(Forum forum) {

		try
		{
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised :"+e);
			return false;
		}
	}

	@Override
	public boolean updateForum(Forum forum) {
		try
		{
			sessionFactory.getCurrentSession().update(forum);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised :"+e);
			return false;
		}
	}

	@Override
	public List<Forum> listForums() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Forum");
		List<Forum> listForums=query.list();

		return listForums;
	}

	@Override
	public Forum getForum(int forumId) {

		Session session=sessionFactory.openSession();
		Forum forum=(Forum)session.get(Forum.class,forumId);
		session.close();
		
		return forum;
	
	}

}
