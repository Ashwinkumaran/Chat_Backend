package com.coll.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.Model.UserDetail;
@Repository("userdetailDAO")
@Transactional
public class UserDetailDAOImpl implements UserDetailDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean registerUser(UserDetail user) {
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised :"+e);
			return false;
		}
	}

	@Override
	public boolean updateProfile(UserDetail user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised :"+e);
			return false;
		}
	}

	@Override
	public UserDetail getUser(String loginname) {
		Session session=sessionFactory.openSession();
		UserDetail user=(UserDetail)session.get(UserDetail.class,loginname);
		session.close();
		return user;
	}

	@Override
	public UserDetail checkUserValidation(String loginname, String password) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserDetail where loginname=:myloginname and password=:mypassword");
		query.setParameter("myloginname", loginname);
		query.setParameter("mypassword",password);
		List<UserDetail> listUserDetail=query.list();
		if(listUserDetail.size()>0)
		{
		UserDetail user=listUserDetail.get(0);
		return user;
	
		}
		return null;

	}
}

