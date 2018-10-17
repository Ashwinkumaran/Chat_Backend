package com.coll.DAO;

import java.util.List;

import com.coll.Model.Job;

public interface JobDAO 
{
	public boolean postJob(Job job);
	public boolean updateJob(Job job);
	public List<Job> listJobDetails();
	public Job getJob(int jobid);
	
}
