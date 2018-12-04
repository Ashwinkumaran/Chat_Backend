package com.coll.Model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="jobidseq",sequenceName="jobidseq",allocationSize = 1)
public class Job
{
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="jobidseq")
 private int jobid;
private String desgination;
private String jobdesc;
String companyname;
private int salary;
private String location;
private String lastDateToApply;
public int getJobid() {
	return jobid;
}
public void setJobid(int jobid) {
	this.jobid = jobid;
}
public String getDesgination() {
	return desgination;
}
public void setDesgination(String desgination) {
	this.desgination = desgination;
}
public String getJobdesc() {
	return jobdesc;
}
public void setJobdesc(String jobdesc) {
	this.jobdesc = jobdesc;
}
public String getCompanyname() {
	return companyname;
}
public void setCompanyname(String companyname) {
	this.companyname = companyname;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public String getLastDateToApply() {
	return lastDateToApply;
}
public void setLastDateToApply(String lastDateToApply) {
	this.lastDateToApply = lastDateToApply;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}


}
