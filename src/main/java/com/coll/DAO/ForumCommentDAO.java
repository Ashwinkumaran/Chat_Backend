package com.coll.DAO;

import java.util.List;

import com.coll.Model.ForumComment;

public interface ForumCommentDAO 
{
	public boolean addComment(ForumComment comment);
	public boolean deleteComment(ForumComment comment);
	public ForumComment getForumComment(int commentId);
	public List<ForumComment> listForumComments(int forumId);
}
