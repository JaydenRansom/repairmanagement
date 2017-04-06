package com.heuzoo.repairmanager.bean;

public class ParterFlowInfo {
	private int repairPartFlowNo = 0;
	private int repairPartFlowSparepart = 0;
	private int repairPartFlowRepair = 0;
	private int repairPartFlowCount = 0;
	public ParterFlowInfo(int repairPartFlowNo, int repairPartFlowSparepart,
			int repairPartFlowRepair, int repairPartFlowCount) {
		super();
		this.repairPartFlowNo = repairPartFlowNo;
		this.repairPartFlowSparepart = repairPartFlowSparepart;
		this.repairPartFlowRepair = repairPartFlowRepair;
		this.repairPartFlowCount = repairPartFlowCount;
	}
	public ParterFlowInfo() {
		super();
	}
	public int getRepairPartFlowNo() {
		return repairPartFlowNo;
	}
	public void setRepairPartFlowNo(int repairPartFlowNo) {
		this.repairPartFlowNo = repairPartFlowNo;
	}
	public int getRepairPartFlowSparepart() {
		return repairPartFlowSparepart;
	}
	public void setRepairPartFlowSparepart(int repairPartFlowSparepart) {
		this.repairPartFlowSparepart = repairPartFlowSparepart;
	}
	public int getRepairPartFlowRepair() {
		return repairPartFlowRepair;
	}
	public void setRepairPartFlowRepair(int repairPartFlowRepair) {
		this.repairPartFlowRepair = repairPartFlowRepair;
	}
	public int getRepairPartFlowCount() {
		return repairPartFlowCount;
	}
	public void setRepairPartFlowCount(int repairPartFlowCount) {
		this.repairPartFlowCount = repairPartFlowCount;
	}
	
	
}
