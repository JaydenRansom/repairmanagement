package com.heuzoo.repairmanager.bean;


public class EmployeeInfo {
	
	private int employeeNo;
	private String employeeName;
	private int employeeType;
	private String employeeUsername;
	private String employeePassword;
	
	public static final int TYPE_A = 1;
	public static final int TYPE_B = 2;
	public static final int TYPE_C = 3;
	public static final int TYPE_D = 4;
	public static final int TYPE_E = 5;
	public static final int TYPE_F = 6;

	public int getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(int employeeType) {
		this.employeeType = employeeType;
	}
	public String getEmployeeUsername() {
		return employeeUsername;
	}
	public void setEmployeeUsername(String employeeUsername) {
		this.employeeUsername = employeeUsername;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	@Override
	public String toString() {
		return "EmployeeInfo [employeeNo=" + employeeNo + ", employeeName="
				+ employeeName + ", employeeType=" + employeeType
				+ ", employeeUsername=" + employeeUsername
				+ ", employeePassword=" + employeePassword + "]";
	}
	public EmployeeInfo(int employeeNo, String employeeName, int employeeType,
			String employeeUsername, String employeePassword) {
		super();
		this.employeeNo = employeeNo;
		this.employeeName = employeeName;
		this.employeeType = employeeType;
		this.employeeUsername = employeeUsername;
		this.employeePassword = employeePassword;
	}
	public EmployeeInfo() {
		super();
	}
	
	
	
}
