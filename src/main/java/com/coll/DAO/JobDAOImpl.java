package com.coll.DAO;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coll.Model.ApplyingJob;
import com.coll.Model.Job;
@Repository("jobDAO")
@Transactional
@Service
public class JobDAOImpl implements JobDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	public JobDAOImpl(SessionFactory sf) {
		super();
		this.sessionFactory = sf;
	}
	@Transactional
	public boolean addJob(Job job) {
		try {
			sessionFactory.getCurrentSession().save(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean deleteJob(Job job) {
		try {
			sessionFactory.getCurrentSession().delete(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean updateJob(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public Job getJob(int jobid) {
		try {
			Session session = sessionFactory.openSession();
			Job job = session.get(Job.class, jobid);
			return job;
		} catch (Exception e) {
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Job> listAllJobs() {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<Job> jobList = new ArrayList<Job>();
			Query query = session.createQuery("FROM Job");
			jobList = query.list();
			return jobList;
		} catch (Exception e) {
			return null;
		}
	}
	@Transactional
	@Override
	public boolean applyJob(ApplyingJob applyJob) {
		try {
			sessionFactory.getCurrentSession().save(applyJob);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<ApplyingJob> getAllAppliedJobDetails(String loginname) {
		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			List<ApplyingJob> appliedjobList = new ArrayList<ApplyingJob>();
			Query query = session.createQuery("FROM ApplyingJob where loginname=:myloginname");
			query.setParameter("myloginname", loginname);
			appliedjobList = query.list();
			return appliedjobList;
		} catch (Exception e) {
			return null;
		}
	}
	}
	

