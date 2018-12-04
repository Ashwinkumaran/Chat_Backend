package com.coll.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.Model.ProfilePicture;
@Repository("profilePictureDAO")
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO {
    @Autowired
    SessionFactory sessionFactory;
	@Override
	public void save(ProfilePicture profilePicture) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(profilePicture);
		session.flush();
	//	session.close();
	}

	@Override
	public ProfilePicture getProfilePicture(String loginname) {
		Session session=sessionFactory.openSession();
	ProfilePicture profilePicture=(ProfilePicture)session.get(ProfilePicture.class,loginname);
	return profilePicture;
	}

}
