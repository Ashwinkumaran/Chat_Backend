package com.coll.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.DAO.BlogDAO;
import com.coll.Model.Blog;
 
public class BlogTest {
	static BlogDAO blogDAO;
	@BeforeClass
	public static void setup()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		blogDAO=(BlogDAO)context.getBean("blogDAO");
		
	}
	//@Ignore
	@Test
	public void addblogTest()
	{
		Blog blog=new Blog();
		//blog.setBlogId(1001);
		blog.setBlogName("pythonblog");
		blog.setBlogDesc("This Blog is for python Learning");
		blog.setCreatedate(new java.util.Date());
		blog.setLikes(0);
		blog.setDislikes(0);
		blog.setLoginname("Ashwin");
		blog.setStatus("NA");
		assertTrue("Problem in adding Blog",blogDAO.addBlog(blog));
	}
	@Ignore
	@Test
	public void deleteBlogTest()
	{
		Blog blog=blogDAO.getBlog(952);
		assertTrue("Problem in adding Blog",blogDAO.deleteBlog(blog));
	}
	@Ignore
	@Test
	public void updateBlogTest()
	{
	    Blog blog=blogDAO.getBlog(952);	
		blog.setBlogName("balagurusamy java core");
		assertTrue("Problem in adding Blog",blogDAO.updateBlog(blog));
	}
	
	@Test
	public void listBlogTest()
	{
		List<Blog> listBlogs=blogDAO.listBlogs();
		assertTrue("problem in Listing Blog",listBlogs.size()>0);
		for(Blog blog:listBlogs)
		{
			System.out.print(blog.getBlogId()+"::");
			System.out.print(blog.getBlogName()+"::");
			System.out.print(blog.getBlogDesc()+"::");
		}
		
		
	}
    @Ignore	
	@Test
	public void approvedBlogTest()
	{
		
		Blog blog=blogDAO.getBlog(952);	
		blog.setStatus("A");
		assertTrue("Problem in approving Blog",blogDAO.approvedBlog(blog));
	}
	@Ignore
	@Test
	public void rejectBlogTest()
	{
		
		Blog blog=blogDAO.getBlog(952);	
		blog.setStatus("NA");
		assertTrue("Problem in rejecting Blog",blogDAO.rejectBlog(blog));
	}
	 @Ignore
	@Test
	public void incrementlikesTest()
	{
		assertTrue("problem in incrmenting likes",blogDAO.incrementLikes(952));
	}
    @Ignore
	@Test
	public void incrementDislikesTest()
	{
		assertTrue("problem in incrmenting Dislikes",blogDAO.incrementDisLikes(952));
	}
}


