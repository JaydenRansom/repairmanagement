package com.heuzoo.repairmanager.common;

public class ChangeUtils {
	public static int customerToInt(String customer) {
		int result = 0;;
		if(customer.equals("家庭用户")) {
			result = 1;
		}
		else if(customer.equals("单位用户")) {
			result = 2;
		}
		else if(customer.equals("代理商")) {
			result = 3;
		}
		else if(customer.equals("签约用户")) {
			result = 4;
		}
		return result;
	}
	public static String customerToString(int customer) {
		String result = null;
		if(customer == 1) {
			result = "家庭用户";
		}
		else if(customer == 2) {
			result = "单位用户";
		}
		else if(customer == 3) {
			result = "代理商";
		}
		else if(customer == 4) {
			result = "签约用户";
		}
		else if(customer == 0) {
			result = "请选择";
		}
		return result;
	}
	public static int reportStateToInt(String reportState) {
		int result = 0;
		if(reportState == "进行中") {
			result = 1;
		}
		else if(reportState == "结束") {
			result = 2;
		}
		else if(reportState == "撤销") {
			result = 3;
		}
		return result;
	}
	public static String reportToString(int reportState) {
		String result = null;
		if(reportState == 1) {
			result = "进行中";
		}
		else if(reportState == 2) {
			result = "结束";
		}
		else if(reportState == 3) {
			result = "撤销";
		}
		return result;
	}
	public static int deviceToInt(String device) {
		int result = 0;
		if(device == "台式机") {
			result = 1;
		}
		else if(device == "笔记本") {
			result = 2;
		}
		else if(device == "投影仪") {
			result = 3;
		}
		else if(device == "打印机") {
			result = 4;
		}
		else if(device == "其他") {
			result = 5;
		}
		return result;
	}
	public static String deviceToString(int device) {
		String result = null;
		if(device == 1) {
			result = "台式机";
		}
		else if(device == 2) {
			result = "笔记本";
		}
		else if(device == 3) {
			result = "投影仪";
		}
		else if(device == 4) {
			result = "打印机";
		}
		else if(device == 5) {
			result = "其他";
		}
		return result;
	}
	public static int faultToInt(String fault) {
		int result = 0;
		if(fault == "固定性故障") {
			result = 1;
		}
		else if(fault == "间歇性故障") {
			result = 2;
		}
		return result;
	}
	public static String faultToString(int fault) {
		String result = null;
		if(fault == 1) {
			result = "固定性故障";
		}
		else if(fault == 2) {
			result = "间歇性故障";
		}
		return result;
	}
	public static int repairStateToInt(String repairState) {
		int result = 0;
		if(repairState == "未分配") {
			result = 1;
		}
		else if(repairState == "已分配") {
			result = 2;
		}
		else if(repairState == "已维修") {
			result = 3;
		}
		else if(repairState == "撤销") {
			result = 4;
		}
		return result;
	}
	public static String repairStateToString(int repairState) {
		String result = null;
		if(repairState == 1){
			result = "未分配";
		}
		else if(repairState == 2) {
			result = "已分配";
		}
		else if(repairState == 3) {
			result = "已维修";
		}
		else if(repairState == 4) {
			result = "撤销";
		}
		return result;
	}
	public static int repairDelayToInt(String repairDelay) {
		int result = 0;
		if(repairDelay == "一般") {
			result = 1;
		}
		else if (repairDelay == "比较严重") {
			result = 2;
		}
		else if (repairDelay == "严重") {
			result = 3;
		}
		return result;
	}
	public static String repairDelayToString(int repairDelay) {
		String result = null;
		if(repairDelay == 1) {
			result = "一般";
		}
		else if (repairDelay == 2) {
			result = "比较严重";
		}
		else if (repairDelay == 3) {
			result = "严重";
		}
		return result;
	}
	public static int parterStateToInt(String parterState) {
		int result = 0;
		if(parterState == "正常") {
			result = 1;
		}
		else if (parterState == "临界") {
			result = 2;
		}
		else if (parterState == "警示") {
			result = 3;
		}
		else if (parterState == "缺货") {
			result = 4;
		}
		return result;
	}
	public static String parterStateToString(int parterState) {
		String result = null;
		if(parterState == 1) {
			result = "正常";
		}
		else if (parterState == 2) {
			result = "临界";
		}
		else if (parterState == 3) {
			result = "警示";
		}
		else if (parterState == 4) {
			result = "缺货";
		}
		return result;
	}

}
