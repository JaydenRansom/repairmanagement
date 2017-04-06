package com.heuzoo.repairmanager.bean;

import java.util.Date;

public class FaultReportInfo {

		@Override
	public String toString() {
		return "FaultReportInfo [reportNo=" + reportNo + ", reportDevice="
				+ reportDevice + ", reportCustomerId=" + reportCustomerId
				+ ", reportTime=" + reportTime + ", reportPrice=" + reportPrice
				+ ", reportFinish=" + reportFinish + ", reportState="
				+ reportState + "]";
	}
		private int reportNo;
		private int reportDevice;
		private String reportCustomerId;
		private Date reportTime;
		private double reportPrice;
		private Date reportFinish;
		private int reportState;
		
		
		public static final int STATE_PROCEEDING = 1;
		public static final int STATE_ACHIEVED = 2;
		public static final int STATE_REVOKE = 3;
		
		
		public FaultReportInfo() {
			super();
		}
		public FaultReportInfo(int reportNo, int reportDevice,
				String reportCustomerId, Date reportTime, double reportPrice,
				Date reportFinish, int reportState) {
			super();
			this.reportNo = reportNo;
			this.reportDevice = reportDevice;
			this.reportCustomerId = reportCustomerId;
			this.reportTime = reportTime;
			this.reportPrice = reportPrice;
			this.reportFinish = reportFinish;
			this.reportState = reportState;
		}
		public int getReportNo() {
			return reportNo;
		}
		public void setReportNo(int reportNo) {
			this.reportNo = reportNo;
		}
		public int getReportDevice() {
			return reportDevice;
		}
		public void setReportDevice(int reportDevice) {
			this.reportDevice = reportDevice;
		}
		public String getReportCustomerId() {
			return reportCustomerId;
		}
		public void setReportCustomerId(String reportCustomerId) {
			this.reportCustomerId = reportCustomerId;
		}
		public Date getReportTime() {
			return reportTime;
		}
		public void setReportTime(Date reportTime) {
			this.reportTime = reportTime;
		}
		public double getReportPrice() {
			return reportPrice;
		}
		public void setReportPrice(double reportPrice) {
			this.reportPrice = reportPrice;
		}
		public Date getReportFinish() {
			return reportFinish;
		}
		public void setReportFinish(Date reportFinish) {
			this.reportFinish = reportFinish;
		}
		public int getReportState() {
			return reportState;
		}
		public void setReportState(int reportState) {
			this.reportState = reportState;
		}
		
}
