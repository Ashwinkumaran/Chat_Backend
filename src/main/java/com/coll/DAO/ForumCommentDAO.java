package com.coll.DAO;

import java.util.List;

import com.coll.Model.ForumComment;

public interface ForumCommentDAO 
{
	public boolean addComment(ForumComment forumcomment);
	public boolean deleteComment(ForumComment forumcomment);
	public ForumComment getForumComment(int commentId);
	public List<ForumComment> listForumComments(int forumId);
}
