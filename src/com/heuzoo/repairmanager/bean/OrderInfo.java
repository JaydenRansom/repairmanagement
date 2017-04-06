package com.heuzoo.repairmanager.bean;

import java.util.Date;

public class OrderInfo {
	private Date reportTime;
	private int reportNo;
	private String deviceType;
	private String deviceBrand;
	private String deviceModel;
	private String deviceSeries;
	private String customerName;
	private String customerOffice;
	private String deviceFaultAppearance;
	private String deviceLack;
	public OrderInfo(Date reportTime, int reportNo, String deviceType,
			String deviceBrand, String deviceModel, String deviceSeries,
			String customerName, String customerOffice,
			String deviceFaultAppearance, String deviceLack) {
		super();
		this.reportTime = reportTime;
		this.reportNo = reportNo;
		this.deviceType = deviceType;
		this.deviceBrand = deviceBrand;
		this.deviceModel = deviceModel;
		this.deviceSeries = deviceSeries;
		this.customerName = customerName;
		this.customerOffice = customerOffice;
		this.deviceFaultAppearance = deviceFaultAppearance;
		this.deviceLack = deviceLack;
	}
	public OrderInfo() {
		super();
	}
	public Date getReportTime() {
		return reportTime;
	}
	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}
	public int getReportNo() {
		return reportNo;
	}
	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	public String getDeviceBrand() {
		return deviceBrand;
	}
	public void setDeviceBrand(String deviceBrand) {
		this.deviceBrand = deviceBrand;
	}
	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	public String getDeviceSeries() {
		return deviceSeries;
	}
	public void setDeviceSeries(String deviceSeries) {
		this.deviceSeries = deviceSeries;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerOffice() {
		return customerOffice;
	}
	public void setCustomerOffice(String customerOffice) {
		this.customerOffice = customerOffice;
	}
	public String getDeviceFaultAppearance() {
		return deviceFaultAppearance;
	}
	public void setDeviceFaultAppearance(String deviceFaultAppearance) {
		this.deviceFaultAppearance = deviceFaultAppearance;
	}
	public String getDeviceLack() {
		return deviceLack;
	}
	public void setDeviceLack(String deviceLack) {
		this.deviceLack = deviceLack;
	}

}
