package com.coll.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.coll.DAO.FriendDAO;
import com.coll.Model.Friend;
import com.coll.Model.UserDetail;


public class FriendTest {

	static FriendDAO friendDAO;
	@BeforeClass
	public static void setup()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
        friendDAO=(FriendDAO)context.getBean("friendDAO");
	}
	
 @Ignore
   @Test
   public void  showFriendListTest()
   {
	   List<Friend> listFriends=friendDAO.showFriendList("Ashwin");
	   assertTrue("Problem in getting The friend List:",listFriends.size()>0);
	   for(Friend friend:listFriends)
	   {
		   System.out.println(friend.getLoginname());
		   System.out.println(friend.getFriendloginname());
		   System.out.println(friend.getStatus());
		   
	   }
   }
  @Ignore
  @Test
  public void showpendingFriendRequestTest()
  {
	  List<Friend> listFriends=friendDAO.showPendingFriendRequest("Ashwin");
	  assertTrue("Problem in getting the Friend List:",listFriends.size()>0);
	  for(Friend friend:listFriends)
	   {
		   System.out.println(friend.getLoginname());
		   System.out.println(friend.getFriendloginname());
		   System.out.println(friend.getStatus());
		   
	   }
  }
 //@Ignore
  @Test
  public void sendFriendRequest() 
  {
	  Friend friend=new Friend();
	  friend.setLoginname("Ashwin");
	  friend.setFriendloginname("vinoba");
	  assertTrue("Problem in Sernding friend Request",friendDAO.sendFriendRequest(friend));
	  }
 // @Ignore
  @Test
  public void acceptFriendRequestTest()
  {
	  assertTrue("Problem in accepting friend request",friendDAO.acceptFriendRequest(972));
	  
  }
@Ignore
@Test
public void showSuggestedFriendList()
{
	List<UserDetail> friendList=friendDAO.showSuggestedFriend("Ashwin");
    assertTrue("Problem in Showing Suggested Friend List:",friendList.size()>0);
    for(UserDetail friend:friendList)
	{
		System.out.print(friend.getLoginname()+"         ");
		System.out.print(friend.getUsername()+"         ");
		System.out.println(friend.getAddress());
	}
}
@Ignore
@Test
public void deleteFriendRequestTest() 
{
	assertTrue("Problem in accepting Friend Request",friendDAO.deleteFriendRequest(972));
}
}




