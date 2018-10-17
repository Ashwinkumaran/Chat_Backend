package com.coll.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.coll.DAO.JobDAO;

import com.coll.Model.Job;

public class JobTest {                                                                                                                  

	
	static JobDAO jobDAO;
	@BeforeClass
	public static void setup()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		jobDAO=(JobDAO)context.getBean("jobDAO");
		
	}
	//@Ignore
	@Test
	public void addjobTest()
	{
		Job job =new Job(); 
		job.setJobdesc("IT");
		job.setCompanyname("HCL");
		job.setExperience(5);
		job.setDesgination("Sofware Engnieer");
	    job.setExpiryDate(new java.util.Date());
		job.setSalary(2000);
		job.setSkills("computer Language");
		assertTrue("problem in adding in job",jobDAO.postJob(job));
	}
	@Ignore
	@Test
	public void updateJobTest()
	{
	    Job job=jobDAO.getJob(982);	
		job.setDesgination("Java Devolper");
		job.setExperience(2);
		job.setSalary(22000);
		assertTrue("Problem in adding Blog",jobDAO.updateJob(job));
	}
	@Test
	public void listJobDetailTest()
	{
		List<Job> listJobs=jobDAO.listJobDetails();
		assertTrue("problem in Listing Blog",listJobs.size()>0);
		for(Job job:listJobs)
		{
			System.out.print(job.getJobid()+"::");
			System.out.print(job.getCompanyname()+"::");
			System.out.print(job.getJobdesc()+"::");
			//System.out.print(job.getDesgination()+"::");
			//System.out.print(job.getExperience()+"::");
			//System.out.print(job.getSalary()+"::");
			//System.out.print(job.getSkills()+"::");
			//System.out.print(job.getExpiryDate()+"::");
			
		}
		
		
	}
}
