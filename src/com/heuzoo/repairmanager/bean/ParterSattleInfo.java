package com.heuzoo.repairmanager.bean;

public class ParterSattleInfo {
	private int parterId = 0;
	private String parterName = null;
	private String parterType = null;
	private int parterCount = 0;
	private double parterPrice = 0.0;
	public ParterSattleInfo(int parterId, String parterName, String parterType,
			int parterCount, double parterPrice) {
		super();
		this.parterId = parterId;
		this.parterName = parterName;
		this.parterType = parterType;
		this.parterCount = parterCount;
		this.parterPrice = parterPrice;
	}
	public ParterSattleInfo() {
		super();
	}
	public int getParterId() {
		return parterId;
	}
	public void setParterId(int parterId) {
		this.parterId = parterId;
	}
	public String getParterName() {
		return parterName;
	}
	public void setParterName(String parterName) {
		this.parterName = parterName;
	}
	public String getParterType() {
		return parterType;
	}
	public void setParterType(String parterType) {
		this.parterType = parterType;
	}
	public int getParterCount() {
		return parterCount;
	}
	public void setParterCount(int parterCount) {
		this.parterCount = parterCount;
	}
	public double getParterPrice() {
		return parterPrice;
	}
	public void setParterPrice(double parterPrice) {
		this.parterPrice = parterPrice;
	}
	
}
