package com.coll.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.Model.ApplyingJob;

@Repository("applyingjobDAO")
@Transactional

public class ApplyingJobDAOImpl implements ApplyingJobDAO {
 @Autowired
 SessionFactory sessionFactory;
	@Override
	public boolean applyJob(ApplyingJob job) {
		try
		{
			sessionFactory.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised :"+e);
			return false;
		}
	}

	@Override
	public boolean updateJob(ApplyingJob job) {
		try
		{
			sessionFactory.getCurrentSession().update(job);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception arised :"+e);
			return false;
		}
	}

	@Override
	public List<ApplyingJob> listJobDetails() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from ApplyingJob");
		List<ApplyingJob> listJobs=query.list();
		return listJobs;
	}

	@Override
	public ApplyingJob getJob(int applyjobid) {
		Session session=sessionFactory.openSession();
		ApplyingJob applyingjob=(ApplyingJob)session.get(ApplyingJob.class,applyjobid);
		session.close();
		
		return applyingjob;
	}

}
