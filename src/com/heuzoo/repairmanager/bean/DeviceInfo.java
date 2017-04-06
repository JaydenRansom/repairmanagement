package com.heuzoo.repairmanager.bean;
/**
 *
 *
 *
 *
 * */
public class DeviceInfo {
	private int deviceNo = 0;
	private int deviceType = 0;
	private String deviceBrand = null;
	private String deviceModel = null;
	private String deviceSeries = null;
	private String deviceLack = null;
	private String deviceFaultAppearance = null;
	private int deviceFaultType = 0;
	private String deviceSurface = null;
	private String devicePassword = null;
	private String deviceImpFile = null;
	private String deviceHDD = null;
	private String deviceMemory = null;
	private String devicePC = null;
	private String deviceAC = null;
	private String deviceBattery = null;
	private String deviceDVD = null;
	private String deviceOther = null;

	public DeviceInfo() {
		super();
	}
	public DeviceInfo(int deviceNo, int deviceType, String deviceBrand,
			String deviceModel, String deviceSeries, String deviceLack,
			String deviceFaultAppearance, int deviceFaultType,
			String deviceSurface, String devicePassword, String deviceImpFile,
			String deviceHDD, String deviceMemory, String devicePC,
			String deviceAC, String deviceBattery, String deviceDVD,
			String deviceOther) {
		super();
		this.deviceNo = deviceNo;
		this.deviceType = deviceType;
		this.deviceBrand = deviceBrand;
		this.deviceModel = deviceModel;
		this.deviceSeries = deviceSeries;
		this.deviceLack = deviceLack;
		this.deviceFaultAppearance = deviceFaultAppearance;
		this.deviceFaultType = deviceFaultType;
		this.deviceSurface = deviceSurface;
		this.devicePassword = devicePassword;
		this.deviceImpFile = deviceImpFile;
		this.deviceHDD = deviceHDD;
		this.deviceMemory = deviceMemory;
		this.devicePC = devicePC;
		this.deviceAC = deviceAC;
		this.deviceBattery = deviceBattery;
		this.deviceDVD = deviceDVD;
		this.deviceOther = deviceOther;
	}
	public int getDeviceNo() {
		return deviceNo;
	}
	public void setDeviceNo(int deviceNo) {
		this.deviceNo = deviceNo;
	}
	public int getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(int deviceType) {
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
	public String getDeviceLack() {
		return deviceLack;
	}
	public void setDeviceLack(String deviceLack) {
		this.deviceLack = deviceLack;
	}
	public String getDeviceFaultAppearance() {
		return deviceFaultAppearance;
	}
	public void setDeviceFaultAppearance(String deviceFaultAppearance) {
		this.deviceFaultAppearance = deviceFaultAppearance;
	}
	public int getDeviceFaultType() {
		return deviceFaultType;
	}
	public void setDeviceFaultType(int deviceFaultType) {
		this.deviceFaultType = deviceFaultType;
	}
	public String getDeviceSurface() {
		return deviceSurface;
	}
	public void setDeviceSurface(String deviceSurface) {
		this.deviceSurface = deviceSurface;
	}
	public String getDevicePassword() {
		return devicePassword;
	}
	public void setDevicePassword(String devicePassword) {
		this.devicePassword = devicePassword;
	}
	public String getDeviceImpFile() {
		return deviceImpFile;
	}
	public void setDeviceImpFile(String deviceImpFile) {
		this.deviceImpFile = deviceImpFile;
	}
	public String getDeviceHDD() {
		return deviceHDD;
	}
	public void setDeviceHDD(String deviceHDD) {
		this.deviceHDD = deviceHDD;
	}
	public String getDeviceMemory() {
		return deviceMemory;
	}
	public void setDeviceMemory(String deviceMemory) {
		this.deviceMemory = deviceMemory;
	}
	public String getDevicePC() {
		return devicePC;
	}
	public void setDevicePC(String devicePC) {
		this.devicePC = devicePC;
	}
	public String getDeviceAC() {
		return deviceAC;
	}
	public void setDeviceAC(String deviceAC) {
		this.deviceAC = deviceAC;
	}
	public String getDeviceBattery() {
		return deviceBattery;
	}
	public void setDeviceBattery(String deviceBattery) {
		this.deviceBattery = deviceBattery;
	}
	public String getDeviceDVD() {
		return deviceDVD;
	}
	public void setDeviceDVD(String deviceDVD) {
		this.deviceDVD = deviceDVD;
	}
	public String getDeviceOther() {
		return deviceOther;
	}
	public void setDeviceOther(String deviceOther) {
		this.deviceOther = deviceOther;
	}
}
