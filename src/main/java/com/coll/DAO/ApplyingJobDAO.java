package com.coll.DAO;

import java.util.List;

import com.coll.Model.ApplyingJob;


public interface ApplyingJobDAO 
 {
	public boolean applyJob(ApplyingJob job);
	public boolean updateJob(ApplyingJob job);
	public List<ApplyingJob> listJobDetails();
	public ApplyingJob getJob(int applyjobid);
}
