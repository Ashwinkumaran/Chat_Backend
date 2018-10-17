package com.coll.DAO;

import com.coll.Model.Friend;

public interface FriendDAO
{
	public boolean registerFriend(Friend friend);
	public boolean updateProfile(Friend friend);
	public boolean deleteFriend(Friend friend);
	public Friend getFriend(String friendloginname);
}
