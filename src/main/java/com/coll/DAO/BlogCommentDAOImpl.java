package com.coll.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.Model.Blog;
import com.coll.Model.BlogComment;
@Repository("blogCommentDAO")
@Transactional
public class BlogCommentDAOImpl implements BlogCommentDAO {
  @Autowired
  SessionFactory sessionFactory;
	@Override
	public boolean addComment(BlogComment blogcomment) {
		try
		{
			sessionFactory.getCurrentSession().save(blogcomment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised :"+e);
			return false;
		}
	}

	@Override
	public boolean deleteComment(BlogComment blogcomment) {
		try
		{
			sessionFactory.getCurrentSession().delete(blogcomment);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised :"+e);
			return false;
		}
	}

	@Override
	public BlogComment getBlogComment(int commentId) {
		Session session=sessionFactory.openSession();
		BlogComment blogComment=(BlogComment)session.get(BlogComment.class,commentId);
		session.close();
		
		return blogComment;
		
	}

	@Override
	public List<BlogComment> listBlogComments(int blogId) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from BlogComment where blogId=:myBlogId");
		query.setParameter("myBlogId",blogId);
		List<BlogComment> listBlogComments=query.list();

		return listBlogComments;
	}

}
