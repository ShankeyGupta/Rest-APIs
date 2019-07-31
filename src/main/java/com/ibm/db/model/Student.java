package com.ibm.db.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student 
{
	@Id
	private int sid;
	private String sname;
	private String sbranch;
	
	@ManyToOne
	@JoinColumn(name="cid", referencedColumnName="cid")
	private College college;
	 

	public College getCollege() {
		return college;
	}


	public void setCollege(College college) {
		this.college = college;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public String getSbranch() {
		return sbranch;
	}


	public void setSbranch(String sbranch) {
		this.sbranch = sbranch;
	}


	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sbranch=" + sbranch + "]";
	}
	
	
}
