package com.coll.DAO;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.Model.Friend;
import com.coll.Model.UserDetail;

@Repository("friendDAO")
//@Transactional
public class FriendDAOImpl implements FriendDAO {
    @Autowired
    SessionFactory sessionFactory;

	@Override
	public List<Friend> showFriendList(String loginname) {

		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where (loginname=:myloginname or friendloginname=:friendlogin) and status='A'");
		query.setParameter("myloginname", loginname);
		query.setParameter("friendlogin", loginname);
		
		List<Friend> listFriends=(List<Friend>)query.list();
		session.close();
		return listFriends;
	}

	@Override
	public List<Friend> showPendingFriendRequest(String loginname) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Friend where friendloginname=:myloginname and status='P'");
		query.setParameter("myloginname",loginname);
		List<Friend> listFriends=query.list();
		session.close();
		return listFriends;
	}

	@Override
	public List<UserDetail> showSuggestedFriend(String loginname) {
		Session session=sessionFactory.openSession();
		Query sqlQuery=session.createQuery("select loginname from UserDetail where loginname not in (select friendloginname from Friend where loginname='"+loginname+"') and loginname not in(select loginname from Friend where friendloginname='"+loginname+"' and status='A') and loginname!='"+loginname+"'");
		List<String> listUsers=(List<String>)sqlQuery.list();
		
		ArrayList<UserDetail> listUserDetail=new ArrayList<UserDetail>();
		int i=0;
		while(i<listUsers.size())
		{
			UserDetail userDetail=session.get(UserDetail.class, listUsers.get(i).toString().trim());
			listUserDetail.add(userDetail);
			i++;
		}
		
		session.close();
		return listUserDetail;
	}
  @Transactional
	@Override
	public boolean sendFriendRequest(Friend friend) {
		try
		{
			friend.setStatus("P");
			sessionFactory.getCurrentSession().save(friend);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
  @Transactional
	@Override
	public boolean acceptFriendRequest(int friendId) {
	  try
		{
		Session session=sessionFactory.openSession();
		Friend friend=session.get(Friend.class,friendId);
		session.close();
		friend.setStatus("A");
		sessionFactory.getCurrentSession().update(friend);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Transactional
	@Override
	public boolean deleteFriendRequest(int friendId) {
		try
		{
			Session session=sessionFactory.openSession();
			Friend friend=session.get(Friend.class, friendId);
			session.close();
			
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	
}
