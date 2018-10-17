package com.coll.DAO;

import java.util.List;
import com.coll.Model.Forum;

public interface ForumDAO
{
	public boolean addForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public boolean updateForum(Forum forum);
	public List<Forum> listForums();
	public Forum getForum(int forumId);
}
