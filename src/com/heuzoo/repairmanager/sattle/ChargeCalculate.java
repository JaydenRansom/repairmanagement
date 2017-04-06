package com.heuzoo.repairmanager.sattle;

import java.util.ArrayList;

import com.heuzoo.repairmanager.bean.FaultRepairInfo;
import com.heuzoo.repairmanager.bean.ParterFlowInfo;
import com.heuzoo.repairmanager.dao.SattleDao;

public class ChargeCalculate {
	//用来计算零件费用
	public static double calculateResult(int repairNo) {
		System.out.println("开始计算了");
		double result = 0.0;
		ArrayList<ParterFlowInfo> parterCollection = new ArrayList<ParterFlowInfo>();
		SattleDao sattleDao = new SattleDao();
		parterCollection = sattleDao.parterPriceQuery(repairNo);
		for(ParterFlowInfo x : parterCollection) {
			int count = x.getRepairPartFlowCount();
			System.out.println("!"+count);
			double price = SattleDao.getPrice(x.getRepairPartFlowSparepart());
			System.out.println("!"+price);
			result = result + (count * price);
		}
		return result;
	}
	//用来计算全部
	public static double allCalculateResult(int repairNo,double manualCost, double materialCost) {
		FaultRepairInfo repairInfo = new FaultRepairInfo();
		double result = 0.0;
		result = calculateResult(repairNo) + manualCost + materialCost;
		return result;
	}
}
