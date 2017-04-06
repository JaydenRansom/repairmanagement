package com.heuzoo.repairmanager.bean;

public class CustomerInfo {
	private String customerId = null;
	private int customerType = 0;
	private String customerOffice = null;
	private String customerTel = null;
	private String customerMobile = null;
	private String customerAddress = null;
	private int customerMail = 0;
	private String customerName = null;
	private String customerEmail = null;
	public String getCustomerId() {
		return customerId;
	}
	public CustomerInfo() {
		super();
	}
	public CustomerInfo(String customerId, int customerType,
			String customerOffice, String customerTel, String customerMobile,
			String customerAddress, int customerMail, String customerName,
			String customerEmail) {
		super();
		this.customerId = customerId;
		this.customerType = customerType;
		this.customerOffice = customerOffice;
		this.customerTel = customerTel;
		this.customerMobile = customerMobile;
		this.customerAddress = customerAddress;
		this.customerMail = customerMail;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public int getCustomerType() {
		return customerType;
	}
	public void setCustomerType(int customerType) {
		this.customerType = customerType;
	}
	public String getCustomerOffice() {
		return customerOffice;
	}
	public void setCustomerOffice(String customerOffice) {
		this.customerOffice = customerOffice;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public int getCustomerMail() {
		return customerMail;
	}
	public void setCustomerMail(int customerMail) {
		this.customerMail = customerMail;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

}
