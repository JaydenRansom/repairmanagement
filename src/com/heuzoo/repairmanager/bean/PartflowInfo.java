package com.heuzoo.repairmanager.bean;

import java.util.Date;

/***
 *@author Johnson
 *@date 2016年7月24日 下午2:20:26
 *@version 1.0
 ***/
public class PartflowInfo {
	
	

	public int partflowNo;
    public int partflowType;
    public int partflowAmount;
    public int partflowSparepart;
	public Date partflowDate;
    
	public final static int PARTFLOW_TYPE_IN = 1;
	public final static int PARTFLOW_TYPE_OUT = 2;
	
	public PartflowInfo() {
		super();
	}
	
	public PartflowInfo(int partflowNo, int partflowType, int partflowAmount,
			int partflowSparepart, Date partflowDate) {
		super();
		this.partflowNo = partflowNo;
		this.partflowType = partflowType;
		this.partflowAmount = partflowAmount;
		this.partflowSparepart = partflowSparepart;
		this.partflowDate = partflowDate;
	}
	
	@Override
	public String toString() {
		return "PartflowInfo [partflowNo=" + partflowNo + ", partflowType="
				+ partflowType + ", partflowAmount=" + partflowAmount
				+ ", partflowSparepart=" + partflowSparepart
				+ ", partflowDate=" + partflowDate + "]";
	}

	public int getPartflowNo() {
		return partflowNo;
	}

	public void setPartflowNo(int partflowNo) {
		this.partflowNo = partflowNo;
	}

	public int getPartflowType() {
		return partflowType;
	}

	public void setPartflowType(int partflowType) {
		this.partflowType = partflowType;
	}

	public int getPartflowAmount() {
		return partflowAmount;
	}

	public void setPartflowAmount(int partflowAmount) {
		this.partflowAmount = partflowAmount;
	}

	public int getPartflowSparepart() {
		return partflowSparepart;
	}

	public void setPartflowSparepart(int partflowSparepart) {
		this.partflowSparepart = partflowSparepart;
	}

	public Date getPartflowDate() {
		return partflowDate;
	}

	public void setPartflowDate(Date partflowDate) {
		this.partflowDate = partflowDate;
	}

	public static int getPartflowTypeIn() {
		return PARTFLOW_TYPE_IN;
	}

	public static int getPartflowTypeOut() {
		return PARTFLOW_TYPE_OUT;
	}
	
	
}
