package com.coll.DAO;

import java.util.List;

import com.coll.Model.Blog;

public interface BlogDAO
{
	public boolean addBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public List<Blog> listBlogs();
	public Blog getBlog(int blogId);
	public boolean incrementLikes(int blogId);
	public boolean incrementDisLikes(int blogId);
	public boolean approvedBlog(Blog blog);
	public boolean rejectBlog(Blog blog);
}
