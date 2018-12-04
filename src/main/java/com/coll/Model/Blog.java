package com.coll.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table
@SequenceGenerator(name="blogidseq",sequenceName="myblogseq")
public class Blog
{
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="blogidseq")
int blogId;
String blogName;
String blogDesc;
@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
Date createdate;
String loginname;
String status;
int likes;
int dislikes;
public int getBlogId() {
	return blogId;
}
public void setBlogId(int blogId) {
	this.blogId = blogId;
}
public String getBlogName() {
	return blogName;
}
public void setBlogName(String blogName) {
	this.blogName = blogName;
}
public String getBlogDesc() {
	return blogDesc;
}
public void setBlogDesc(String blogDesc) {
	this.blogDesc = blogDesc;
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
public int getLikes() {
	return likes;
}
public void setLikes(int likes) {
	this.likes = likes;
}
public int getDislikes() {
	return dislikes;
}
public void setDislikes(int dislikes) {
	this.dislikes = dislikes;
}
public Date getCreatedate() {
	return createdate;
}
public void setCreatedate(Date createdate) {
	this.createdate = createdate;
}

}
