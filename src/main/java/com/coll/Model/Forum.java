package com.coll.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
@SequenceGenerator(name="forumidseq",sequenceName="myforumseq")
	public class Forum 
	 {
	 @Id
	 @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="forumidseq")
	 int forumid;
	 String forumname;
	 String forumContext;
	 Date createDate;
	 String loginname;
	 String status;
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public String getForumname() {
		return forumname;
	}
	public void setForumname(String forumname) {
		this.forumname = forumname;
	}
	public String getForumContext() {
		return forumContext;
	}
	public void setForumContext(String forumContext) {
		this.forumContext = forumContext;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 
	 }
