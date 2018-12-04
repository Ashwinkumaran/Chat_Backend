package com.coll.Test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.coll.DAO.JobDAO;
import com.coll.Model.ApplyingJob;
import com.coll.Model.Job;

public class JobTest {                                                                                                                  

	
	private static JobDAO jobDAO;
	private Job job;
	private ApplyingJob applyJob;
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
	public void insertjobTest() throws ParseException
	{
	    job =new Job(); 
        job.setDesgination("");
        job.setCompanyname("");
        job.setJobdesc("");
        job.setLastDateToApply("");
        job.setSalary(0);
        job.setLocation("");
         ;
         assertEquals("Success",true,jobDAO.addJob(job));
         System.out.println("Success");
	}
	@Ignore
	@Test
	public void updateJobTest()  throws ParseException
	{
	    job=jobDAO.getJob(01);
	    job.setDesgination("");
	    job.setCompanyname("");
	    job.setJobdesc("");
	    assertEquals("Sucess",true,jobDAO.updateJob(job));
	    System.out.println("Success");
	}
	
	@Ignore
	@Test
	public void testGetTest()
	{
      job=jobDAO.getJob(0);
      assertEquals("Sucess","AssociateER",job.getDesgination());
      System.out.println("Success");

		}
	@Ignore
	@Test
	public void testGetAllJob() {
		assertEquals("Success",jobDAO.listAllJobs());
		System.out.println("jobs:"+jobDAO.listAllJobs().size());
		System.out.println("Success");
		
		
	}
	@Ignore
	@Test
	public void testDeleteJob() {
		job = jobDAO.getJob(0);
		assertEquals("Successfully deleted job details from the table", true, jobDAO.deleteJob(job));
		System.out.println("Success");
	}
	@Ignore
	@Test
	public void testApplyJob() 
	{
		applyJob=new ApplyingJob();
		job=new Job();
		applyJob.setAppliedDate(new Date());
		applyJob.setLoginname("");
		applyJob.setJobId(job.getJobid());
		assertEquals("sucess",true,jobDAO.applyJob(applyJob));
		System.out.println("Success");
	}
	}
