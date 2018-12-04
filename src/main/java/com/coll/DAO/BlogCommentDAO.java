package com.coll.DAO;

import java.util.List;

import com.coll.Model.BlogComment;

public interface BlogCommentDAO 
{
public boolean addComment(BlogComment blogcomment);
public boolean deleteComment(BlogComment blogcomment);
public BlogComment getBlogComment(int commentId);
public List<BlogComment> listBlogComments(int blogId);
}
