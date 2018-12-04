package com.coll.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.DAO.BlogCommentDAO;

import com.coll.Model.BlogComment;

public class BlogcommentTest 
{
   static BlogCommentDAO blogCommentDAO;
   @BeforeClass
   public static void setUp()
   {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		blogCommentDAO=(BlogCommentDAO)context.getBean("blogCommentDAO");
		
	}
   @Test
   public void addCommentTest()
   {
	   BlogComment comment=new BlogComment();
	   comment.setBlogId(953);
	   comment.setCommentText("very nice Blog");
	   comment.setLoginname("Ashwin");
	   comment.setCommentDate(new java.util.Date());
	   assertTrue("Problem in adding comment:",blogCommentDAO.addComment(comment));
   }
   @Ignore
   @Test
	public void deleteCommentTest()
	{
		BlogComment comment=blogCommentDAO.getBlogComment(962);
		assertTrue("Problem in adding Blog",blogCommentDAO.deleteComment(comment));
	}
   @Ignore
   @Test
	public void listCommentsTest()
	{
		List<BlogComment> listComments=blogCommentDAO.listBlogComments(952);
		assertTrue("problem in Listing Blog",listComments.size()>0);
		for(BlogComment comment:listComments)
		{
			System.out.print(comment.getCommentId()+"::");
			System.out.print(comment.getCommentText()+"::");
			System.out.print(comment.getLoginname()+"::");
		}
		
		
	}
}

