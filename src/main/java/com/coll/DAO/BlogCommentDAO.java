package com.coll.DAO;

import java.util.List;

import com.coll.Model.BlogComment;

public interface BlogCommentDAO 
{
public boolean addComment(BlogComment comment);
public boolean deleteComment(BlogComment comment);
public BlogComment getBlogComment(int commentId);
public List<BlogComment> listBlogComments(int blogId);
}
