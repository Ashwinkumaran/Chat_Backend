package com.coll.DAO;

import java.util.List;

import com.coll.Model.ApplyingJob;
import com.coll.Model.Job;

public interface JobDAO 
{
	public boolean addJob(Job job);

	public boolean deleteJob(Job job);

	public boolean updateJob(Job job);

	public Job getJob(int jobid);

	public List<Job> listAllJobs();

	public boolean applyJob(ApplyingJob applyJob);

	public List<ApplyingJob> getAllAppliedJobDetails(String loginname);
	
}
