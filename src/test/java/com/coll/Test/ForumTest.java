package com.coll.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.DAO.ForumDAO;
import com.coll.Model.Forum;



public class ForumTest {

	static ForumDAO forumDAO;
	@BeforeClass
	public static void setup()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		forumDAO=(ForumDAO)context.getBean("forumDAO");
		
	}
	//@Ignore
	@Test
	public void addforumTest()
	{
		Forum forum=new Forum();
		forum.setForumname("test");
		forum.setForumContent("Test");
		forum.setLoginname("Ashwin");
		forum.setStatus("NA");
		forum.setCreateDate(new java.util.Date());
	assertTrue("Problem in adding new Forum",forumDAO.addForum(forum));
	
	}
	@Ignore
	@Test
	public void deleteForumTest()
	{
	Forum forum=forumDAO.getForum(100);
		assertTrue("Problem in adding Forum",forumDAO.deleteForum(forum));
	}
	@Ignore
	@Test
	public void updateForumTest()
	{
	    Forum forum=forumDAO.getForum(952);	
		forum.setForumname("test1");;
		assertTrue("Problem in adding forum",forumDAO.updateForum(forum));
	}
	@Test
	public void listForumTest()
	{
		List<Forum> listForums=forumDAO.listForums();
		assertTrue("problem in Listing Blog",listForums.size()>0);
		for(Forum forum:listForums)
		{
			System.out.print(forum.getForumId()+"::");
			System.out.print(forum.getForumname()+"::");
			System.out.print(forum.getForumContent()+"::");
		}
		
		
	}
}
