package com.bridgelabz.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Student")
public class Student implements Serializable{

	private static final long serialVersionUID = -723583058586873479L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//this will generate automatic id number increment column filed
	@Column(name = "stuid",unique=true, nullable=false)
	private Integer stuId;
	//set the constraints on table column fields
	//add setters and getters
		@Column(name="stuname",nullable=false)
		private String stuName;
		
		@Column(name="stuaddress",nullable=false)
		private String stuAddress;
		
		@Column(name="stumarks",nullable=false)
		private Integer stuMarks;
		
		@Column(name="stuemail",nullable=false)
		private String stuEmail;
	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuAddress() {
		return stuAddress;
	}

	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}

	public Integer getStuMarks() {
		return stuMarks;
	}

	public void setStuMarks(Integer stuMarks) {
		this.stuMarks = stuMarks;
	}

	public String getStuEmail() {
		return stuEmail;
	}

	public void setStuEmail(String stuEmail) {
		System.out.println("45");
		this.stuEmail = stuEmail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}