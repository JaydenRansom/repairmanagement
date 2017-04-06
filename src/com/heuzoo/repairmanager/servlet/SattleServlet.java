package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.bean.FaultRepairInfo;
import com.heuzoo.repairmanager.bean.SattleInfo;
import com.heuzoo.repairmanager.dao.SattleDao;
import com.heuzoo.repairmanager.sattle.ChargeCalculate;

public class SattleServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String repairNo = request.getParameter("repairno");
//		ChargeCalculate calculate = new ChargeCalculate();
		double charge = ChargeCalculate.calculateResult(Integer.parseInt(repairNo));
		double allCharge = 0.0;
		FaultRepairInfo repairInfo = SattleDao.getInfoByRepairNo(Integer.parseInt(repairNo));
		allCharge = ChargeCalculate.allCalculateResult(Integer.parseInt(repairNo), repairInfo.getRepairManualCost(), repairInfo.getRepairMaterialCost());
		SattleInfo sattleInfo = new SattleInfo();
		sattleInfo.setRepairNo(repairInfo.getRepairNo());
		sattleInfo.setManualCharge(repairInfo.getRepairManualCost());
		sattleInfo.setMaterCharge(repairInfo.getRepairMaterialCost());
		sattleInfo.setParterCharge(charge);
		sattleInfo.setAllCharge(allCharge);
		boolean insertResult = SattleDao.insertSattle(sattleInfo);
		System.out.println(insertResult);
		String message="喵！未结算成功呦";
		//产品类型什么的还没有添加
		if(insertResult) {
			message = "喵！结算成功辣！";
		}
		
		PrintWriter out = response.getWriter(); 
		out.println("<script>");
		out.println("alert('"+message+"');"+"window.location.href='/RepairManagement/servlet/SattleViewServlet'");
		out.println("</script>");
		out.flush();	
	}
}
