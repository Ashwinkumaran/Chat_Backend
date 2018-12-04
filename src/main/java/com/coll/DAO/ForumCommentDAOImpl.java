package com.coll.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.Model.BlogComment;
import com.coll.Model.ForumComment;
@Repository("forumCommentDAO")
@Transactional
public class ForumCommentDAOImpl implements ForumCommentDAO {
	 @Autowired
	  SessionFactory sessionFactory;
	@Override
	public boolean addComment(ForumComment forumcomment) {
		try
		{
			sessionFactory.getCurrentSession().save(forumcomment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised :"+e);
			return false;
		}
	}

	@Override
	public boolean deleteComment(ForumComment forumcomment) {
		try
		{
			sessionFactory.getCurrentSession().delete(forumcomment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised :"+e);
			return false;
		}
	}

	@Override
	public ForumComment getForumComment(int commentId) {
		Session session=sessionFactory.openSession();
		ForumComment forumComment=(ForumComment)session.get(ForumComment.class,commentId);
		session.close();
		
		return forumComment;
	}

	@Override
	public List<ForumComment> listForumComments(int forumId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from ForumComment where forumId=:myForumId");
		query.setParameter("myForumId",forumId);
		List<ForumComment> listForumComments=query.list();

		return listForumComments;
	}

}
