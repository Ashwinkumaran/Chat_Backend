package com.coll.Test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.coll.DAO.FriendDAO;
import com.coll.Model.Friend;


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
	//@Ignore
		@Test
		public void registerFriendTest()
		{
			Friend friend=new Friend();
			friend.setFriendloginname("vinoth");
			friend.setLoginname("Ashwin");
			friend.setStatus("a");
			assertTrue("problem in adding friend",friendDAO.registerFriend(friend));
		}
		 @Ignore
		 @Test
		 public void updateFriendTest()
		   {
			Friend friend=friendDAO.getFriend("vinoth");
			friend.setStatus("NA");
			assertTrue("problem in updating the user",friendDAO.updateProfile(friend));
		  }

		@Ignore
		 @Test
		 public void deletefriendTest()
		   {
			Friend friend=friendDAO.getFriend("vinoth");
			
			assertTrue("problem in updating the user",friendDAO.deleteFriend(friend));
		  }
}



