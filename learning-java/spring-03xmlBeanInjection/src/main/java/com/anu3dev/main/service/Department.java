package com.anu3dev.main.service;

public class Department {
	private Integer dpNo;
	private String dpName;
	
	public Integer getDpNo() {
		return dpNo;
	}
	public void setDpNo(Integer dpNo) {
		this.dpNo = dpNo;
	}
	
	public String getDpName() {
		return dpName;
	}
	public void setDpName(String dpName) {
		this.dpName = dpName;
	}

	public Department() {
		super();
		System.out.println("Department Bean created");
	}
	
	@Override
	public String toString() {
		return "Department [dpNo=" + dpNo + ", dpName=" + dpName + "]";
	}
}
