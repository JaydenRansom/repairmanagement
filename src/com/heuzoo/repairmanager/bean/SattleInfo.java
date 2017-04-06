package com.heuzoo.repairmanager.bean;

public class SattleInfo {
	private int sattleNo = 0;
	private int repairNo = 0;
	private double manualCharge = 0.0;
	private double materCharge = 0.0;
	private double parterCharge = 0.0;
	private double allCharge = 0.0;
	//这个是什么还不确定
	private String productType = null;
	private String productInfo = null;
	private String productBrand = null;
	private String productModel = null;
	public SattleInfo(int sattleNo, int repairNo, double manualCharge,
			double materCharge, double parterCharge, double allCharge,
			String productType, String productInfo, String productBrand,
			String productModel, String repairInfo) {
		super();
		this.sattleNo = sattleNo;
		this.repairNo = repairNo;
		this.manualCharge = manualCharge;
		this.materCharge = materCharge;
		this.parterCharge = parterCharge;
		this.allCharge = allCharge;
		this.productType = productType;
		this.productInfo = productInfo;
		this.productBrand = productBrand;
		this.productModel = productModel;
		this.repairInfo = repairInfo;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getProductModel() {
		return productModel;
	}
	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}
	private String repairInfo = null;
	public SattleInfo(int sattleNo, int repairNo, double manualCharge,
			double materCharge, double parterCharge, double allCharge,
			String productType, String productInfo, String repairInfo) {
		super();
		this.sattleNo = sattleNo;
		this.repairNo = repairNo;
		this.manualCharge = manualCharge;
		this.materCharge = materCharge;
		this.parterCharge = parterCharge;
		this.allCharge = allCharge;
		this.productType = productType;
		this.productInfo = productInfo;
		this.repairInfo = repairInfo;
	}
	public SattleInfo() {
		super();
	}
	public int getSattleNo() {
		return sattleNo;
	}
	public void setSattleNo(int sattleNo) {
		this.sattleNo = sattleNo;
	}
	public int getRepairNo() {
		return repairNo;
	}
	public void setRepairNo(int repairNo) {
		this.repairNo = repairNo;
	}
	public double getManualCharge() {
		return manualCharge;
	}
	public void setManualCharge(double manualCharge) {
		this.manualCharge = manualCharge;
	}
	public double getMaterCharge() {
		return materCharge;
	}
	public void setMaterCharge(double materCharge) {
		this.materCharge = materCharge;
	}
	public double getParterCharge() {
		return parterCharge;
	}
	public void setParterCharge(double parterCharge) {
		this.parterCharge = parterCharge;
	}
	public double getAllCharge() {
		return allCharge;
	}
	public void setAllCharge(double allCharge) {
		this.allCharge = allCharge;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public String getRepairInfo() {
		return repairInfo;
	}
	public void setRepairInfo(String repairInfo) {
		this.repairInfo = repairInfo;
	}
	
}
