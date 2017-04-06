package com.heuzoo.repairmanager.bean;
/***
 *@author Johnson
 *@date 2016年7月31日 上午11:37:11
 *@version 1.0
 ***/
public class RepairPartflowInfo {
		
	int repairPartflowNo ;
	int repairPartflowSparepart;
	int repairPartflowRepair;
	int repairPartflowCount;
		
	public RepairPartflowInfo(int repairPartflowNo,
			int repairPartflowSparepart, int repairPartflowRepair,
			int repairPartflowCount) {
		super();
		this.repairPartflowNo = repairPartflowNo;
		this.repairPartflowSparepart = repairPartflowSparepart;
		this.repairPartflowRepair = repairPartflowRepair;
		this.repairPartflowCount = repairPartflowCount;
	}
	public RepairPartflowInfo() {
		super();
	}
	@Override
	public String toString() {
		return "RepairPartflowInfo [repairPartflowNo=" + repairPartflowNo
				+ ", repairPartflowSparepart=" + repairPartflowSparepart
				+ ", repairPartflowRepair=" + repairPartflowRepair
				+ ", repairPartflowCount=" + repairPartflowCount + "]";
	}
	public int getRepairPartflowNo() {
		return repairPartflowNo;
	}
	public void setRepairPartflowNo(int repairPartflowNo) {
		this.repairPartflowNo = repairPartflowNo;
	}
	public int getRepairPartflowSparepart() {
		return repairPartflowSparepart;
	}
	public void setRepairPartflowSparepart(int repairPartflowSparepart) {
		this.repairPartflowSparepart = repairPartflowSparepart;
	}
	public int getRepairPartflowRepair() {
		return repairPartflowRepair;
	}
	public void setRepairPartflowRepair(int repairPartflowRepair) {
		this.repairPartflowRepair = repairPartflowRepair;
	}
	public int getRepairPartflowCount() {
		return repairPartflowCount;
	}
	public void setRepairPartflowCount(int repairPartflowCount) {
		this.repairPartflowCount = repairPartflowCount;
	}
	
	
}
