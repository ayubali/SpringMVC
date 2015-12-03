package com.sarker.beans;

import java.util.ArrayList;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sarker.validator.IsValidHobby;

public class Student {
	@Pattern(regexp = "[^0-9]*")
	private String studentName;
	@Size(min = 4, max = 30)
	@IsValidHobby(listOfValidHobbies="Music|Football|Cricket|Hockey")
	private String studentHobby;
	@Max(5000)
	@Min(1000)
	private int rollNumber;
	private Long studentMobile;
	@Past
	private Date studentDOB;
	private ArrayList<String> studentSkills;

	private Address studentAddress;

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentHobby() {
		return studentHobby;
	}

	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}

	public Long getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}

	public Date getStudentDOB() {
		return studentDOB;
	}

	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}

	public ArrayList<String> getStudentSkills() {
		return studentSkills;
	}

	public void setStudentSkills(ArrayList<String> studentSkills) {
		this.studentSkills = studentSkills;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentHobby="
				+ studentHobby + ", rollNumber=" + rollNumber
				+ ", studentMobile=" + studentMobile + ", studentDOB="
				+ studentDOB + ", studentSkills=" + studentSkills
				+ ", studentAddress=" + studentAddress + "]";
	}

}
