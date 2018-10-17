package com.coll.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.Model.Friend;

@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO {
    @Autowired
    SessionFactory sessionFactory;
	@Override
	public boolean registerFriend(Friend friend) {
		try
		{
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised :"+e);
			return false;
		}
	}

	@Override
	public boolean updateProfile(Friend friend) {
		try
		{
			sessionFactory.getCurrentSession().update(friend);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised :"+e);
			return false;
		}
	}

	@Override
	public Friend getFriend(String friendloginname) {
		Session session=sessionFactory.openSession();
		Friend friend=(Friend)session.get(Friend.class,friendloginname);
		session.close();
		return friend;
	}

	@Override
	public boolean deleteFriend(Friend friend) {
		try
		{
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised :"+e);
			return false;
		}
	}

}
