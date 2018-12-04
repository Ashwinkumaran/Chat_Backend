package com.coll.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
@Component
@Entity
@Table
@SequenceGenerator(name="applyjobidseq",sequenceName="myapplyjobseq",initialValue = 1, allocationSize = 1)
public class ApplyingJob 
{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="applyjobidseq")
	int applyjobId;
	int jobid;
	String loginname;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
	Date appliedDate;
	public int getApplyjobId() {
		return applyjobId;
	}
	public void setApplyjobId(int applyjobId) {
		this.applyjobId = applyjobId;
	}
	public int getJobId() {
		return jobid;
	}
	public void setJobId(int jobId) {
		jobid = jobId;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public Date getAppliedDate() {
		return appliedDate;
	}
	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}
	
}
