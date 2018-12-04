package com.coll.DAO;

import java.util.List;

import com.coll.Model.Friend;
import com.coll.Model.UserDetail;

public interface FriendDAO
{
	public List<Friend> showFriendList(String loginname);
	public List<Friend> showPendingFriendRequest(String loginname);
	public List<UserDetail> showSuggestedFriend(String loginname);
	
	public boolean sendFriendRequest(Friend friend);
	public boolean acceptFriendRequest(int friendId);
	public boolean deleteFriendRequest(int friendId);
}
