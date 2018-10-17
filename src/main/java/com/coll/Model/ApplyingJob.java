package com.coll.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ApplyingJob 
{
	@Id
	int applyjobId;
	int JobId;
	String loginname;
	Date applyingDate;
	public int getApplyjobId() {
		return applyjobId;
	}
	public void setApplyjobId(int applyjobId) {
		this.applyjobId = applyjobId;
	}
	public int getJobId() {
		return JobId;
	}
	public void setJobId(int jobId) {
		JobId = jobId;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public Date getApplyingDate() {
		return applyingDate;
	}
	public void setApplyingDate(Date applyingDate) {
		this.applyingDate = applyingDate;
	}
}
