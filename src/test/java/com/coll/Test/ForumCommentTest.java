package com.coll.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.coll.DAO.ForumCommentDAO;

import com.coll.Model.ForumComment;

public class ForumCommentTest {

	 static ForumCommentDAO forumCommentDAO;
	   @BeforeClass
	   public static void setUp()
	   {
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.coll");
			context.refresh();
			forumCommentDAO=(ForumCommentDAO)context.getBean("forumCommentDAO");
			
		}
	   @Test
	   public void addCommentTest()
	   {
		   ForumComment comment=new ForumComment();
		   comment.setForumId(954);;
		   comment.setCommentText("test1");
		   comment.setLoginname("Ashwin");
		   comment.setCommentDate(new java.util.Date());
		   assertTrue("Problem in adding comment:",forumCommentDAO.addComment(comment));
	   }
	   @Ignore
	   @Test
		public void deleteCommentTest()
		{
			ForumComment comment=forumCommentDAO.getForumComment(952);
			assertTrue("Problem in adding Blog",forumCommentDAO.deleteComment(comment));
		}
	   @Test
		public void listCommentsTest()
		{
			List<ForumComment> listComments=forumCommentDAO.listForumComments(954);
			assertTrue("problem in Listing Blog",listComments.size()>0);
			for(ForumComment comment:listComments)
			{
				System.out.print(comment.getCommentId()+"::");
				System.out.print(comment.getCommentText()+"::");
				System.out.print(comment.getLoginname()+"::");
			}
			
			
		}
	}


