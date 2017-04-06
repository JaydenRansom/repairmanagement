package com.heuzoo.repairmanager.bean;

import java.util.Date;

public class FaultRepairInfo {
	
	@Override
	public String toString() {
		return "FaultRepairInfo [repairNo=" + repairNo + ", repairPerson="
				+ repairPerson + ", repairReportNo=" + repairReportNo
				+ ", repairArrangeTime=" + repairArrangeTime
				+ ", repairExaminationRecord=" + repairExaminationRecord
				+ ", repairRepairRecord=" + repairRepairRecord
				+ ", repairRepairTime=" + repairRepairTime
				+ ", repairWorkload=" + repairWorkload + ", repairManualCost="
				+ repairManualCost + ", repairMaterialCost="
				+ repairMaterialCost + ", repairCommitment=" + repairCommitment
				+ ", repairNoticePoints=" + repairNoticePoints
				+ ", repairState=" + repairState + ", repairDelayDegree="
				+ repairDelayDegree + "]";
	}
	private int repairNo;
	private int repairPerson;
	private int repairReportNo;
	private Date repairArrangeTime;
	private String repairExaminationRecord;
	private String repairRepairRecord;
	private Date repairRepairTime;
	private String repairWorkload;
	private double repairManualCost;
	private double repairMaterialCost;
	private String repairCommitment;
	private String repairNoticePoints;
	private int repairState;
	private int repairDelayDegree;
	private String changedRepairPerson;
	
	public String getChangedRepairPerson() {
		return changedRepairPerson;
	}
	public void setChangedRepairPerson(String changedRepairPerson) {
		this.changedRepairPerson = changedRepairPerson;
	}
	public static final int STATE_BLOCK = 1;
	public static final int STATE_ARRANGED = 2;
	public static final int STATE_ACHIEVED = 3;
	public static final int STATE_REVOKE = 4;
	
	
	public FaultRepairInfo() {
		super();
	}
	public FaultRepairInfo(int repairNo, int repairPerson, int repairReportNo,
			Date repairArrangeTime, String repairExaminationRecord,
			String repairRepairRecord, Date repairRepairTime,
			String repairWorkload, double repairManualCost,
			double repairMaterialCost, String repairCommitment,
			String repairNoticePoints, int repairState, int repairDelayDegree) {
		super();
		this.repairNo = repairNo;
		this.repairPerson = repairPerson;
		this.repairReportNo = repairReportNo;
		this.repairArrangeTime = repairArrangeTime;
		this.repairExaminationRecord = repairExaminationRecord;
		this.repairRepairRecord = repairRepairRecord;
		this.repairRepairTime = repairRepairTime;
		this.repairWorkload = repairWorkload;
		this.repairManualCost = repairManualCost;
		this.repairMaterialCost = repairMaterialCost;
		this.repairCommitment = repairCommitment;
		this.repairNoticePoints = repairNoticePoints;
		this.repairState = repairState;
		this.repairDelayDegree = repairDelayDegree;
	}
	public int getRepairNo() {
		return repairNo;
	}
	public void setRepairNo(int repairNo) {
		this.repairNo = repairNo;
	}
	public int getRepairPerson() {
		return repairPerson;
	}
	public void setRepairPerson(int repairPerson) {
		this.repairPerson = repairPerson;
	}
	public int getRepairReportNo() {
		return repairReportNo;
	}
	public void setRepairReportNo(int repairReportNo) {
		this.repairReportNo = repairReportNo;
	}
	public Date getRepairArrangeTime() {
		return repairArrangeTime;
	}
	public void setRepairArrangeTime(Date repairArrangeTime) {
		this.repairArrangeTime = repairArrangeTime;
	}
	public String getRepairExaminationRecord() {
		return repairExaminationRecord;
	}
	public void setRepairExaminationRecord(String repairExaminationRecord) {
		this.repairExaminationRecord = repairExaminationRecord;
	}
	public String getRepairRepairRecord() {
		return repairRepairRecord;
	}
	public void setRepairRepairRecord(String repairRepairRecord) {
		this.repairRepairRecord = repairRepairRecord;
	}
	public Date getRepairRepairTime() {
		return repairRepairTime;
	}
	public void setRepairRepairTime(Date repairRepairTime) {
		this.repairRepairTime = repairRepairTime;
	}
	public String getRepairWorkload() {
		return repairWorkload;
	}
	public void setRepairWorkload(String repairWorkload) {
		this.repairWorkload = repairWorkload;
	}
	public double getRepairManualCost() {
		return repairManualCost;
	}
	public void setRepairManualCost(double repairManualCost) {
		this.repairManualCost = repairManualCost;
	}
	public double getRepairMaterialCost() {
		return repairMaterialCost;
	}
	public void setRepairMaterialCost(double repairMaterialCost) {
		this.repairMaterialCost = repairMaterialCost;
	}
	public String getRepairCommitment() {
		return repairCommitment;
	}
	public void setRepairCommitment(String repairCommitment) {
		this.repairCommitment = repairCommitment;
	}
	public String getRepairNoticePoints() {
		return repairNoticePoints;
	}
	public void setRepairNoticePoints(String repairNoticePoints) {
		this.repairNoticePoints = repairNoticePoints;
	}
	public int getRepairState() {
		return repairState;
	}
	public void setRepairState(int repairState) {
		this.repairState = repairState;
	}
	public int getRepairDelayDegree() {
		return repairDelayDegree;
	}
	public void setRepairDelayDegree(int repairDelayDegree) {
		this.repairDelayDegree = repairDelayDegree;
	}
	
}
