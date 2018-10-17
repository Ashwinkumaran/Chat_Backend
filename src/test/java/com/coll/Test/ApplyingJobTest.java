package com.coll.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.DAO.ApplyingJobDAO;
import com.coll.Model.ApplyingJob;
import com.coll.Model.Job;

public class ApplyingJobTest {

	static ApplyingJobDAO applyingjobDAO;
	@BeforeClass
	public static void setup()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		applyingjobDAO=(ApplyingJobDAO)context.getBean("applyingjobDAO");
	}

 	//@Ignore
    @Test
   public void addapplyjobTest()
   {
 		ApplyingJob job=new ApplyingJob();
 		job.setJobId(100);
 		job.setApplyingDate(new java.util.Date());
 		job.setLoginname("Ashwin");
 		assertTrue("Problem Adding Applying Job",applyingjobDAO.applyJob(job));
   }
 	@Ignore
	@Test
	public void updateJobTest()
	{
 		ApplyingJob job=applyingjobDAO.getJob(100);
 		job.setApplyingDate(new java.util.Date());
 		assertTrue("Problem in updating",applyingjobDAO.updateJob(job));
	}
 	@Test
	public void listJobDetailTest()
	{
		List<ApplyingJob> listJobs=applyingjobDAO.listJobDetails();
		assertTrue("problem in Listing Blog",listJobs.size()>0);
		for(ApplyingJob job:listJobs)
		{
			System.out.print(job.getApplyjobId()+"::");
			System.out.print(job.getJobId()+"::");
			System.out.print(job.getLoginname()+"::");
		}

	}
}
