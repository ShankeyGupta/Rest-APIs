package com.ibm.db.model;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class College {

	@Id
	private int cid;
	private String cname;
	private String cloc;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCloc() {
		return cloc;
	}
	public void setCloc(String cloc) {
		this.cloc = cloc;
	}
	@Override
	public String toString() {
		return "College [cid=" + cid + ", cname=" + cname + ", cloc=" + cloc + "]";
	}
	
}

