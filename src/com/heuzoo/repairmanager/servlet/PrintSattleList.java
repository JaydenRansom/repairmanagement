package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.bean.CustomerInfo;
import com.heuzoo.repairmanager.bean.DeviceInfo;
import com.heuzoo.repairmanager.bean.FaultRepairInfo;
import com.heuzoo.repairmanager.bean.ParterSattleInfo;
import com.heuzoo.repairmanager.common.ChangeUtils;
import com.heuzoo.repairmanager.dao.SattleDao;
import com.heuzoo.repairmanager.sattle.ChargeCalculate;

public class PrintSattleList extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8"); 
		
		String repairNo = request.getParameter("repairno");
		//查询报修人信息
		CustomerInfo customer = new CustomerInfo();
		customer = SattleDao.getCustomerInfo(Integer.parseInt(repairNo));
		
		//查询维修设备信息
		DeviceInfo device = new DeviceInfo();
		device = SattleDao.getDeviceInfo(Integer.parseInt(repairNo));
		String changedDeviceType = ChangeUtils.deviceToString(device.getDeviceType());
		//查询配件信息
		ArrayList<ParterSattleInfo> temp = new ArrayList<ParterSattleInfo>();
		temp = SattleDao.getFirstCollection(Integer.parseInt(repairNo));
		ArrayList<ParterSattleInfo> parterSattleInfo = new ArrayList<ParterSattleInfo>();
		parterSattleInfo = SattleDao.getSecondCollection(temp);
		
		//查询维修信息
		FaultRepairInfo repairInfo = new FaultRepairInfo();
		repairInfo = SattleDao.getInfoByRepairNo(Integer.parseInt(repairNo));
		//手工材料费的计算
		double manualMaterCharge = repairInfo.getRepairManualCost() + repairInfo.getRepairMaterialCost();
		//全部费用的计算
		double allCharge = ChargeCalculate.allCalculateResult(Integer.parseInt(repairNo), repairInfo.getRepairManualCost(), repairInfo.getRepairMaterialCost());
		
		request.setAttribute("stringDeviceType", changedDeviceType);
		request.setAttribute("customer", customer);
		request.setAttribute("device", device);
		request.setAttribute("repairinfo", repairInfo);
		request.setAttribute("allcharge", allCharge);
		request.setAttribute("manualmatercharge", manualMaterCharge);
		request.setAttribute("partersattleinfo", parterSattleInfo);
		RequestDispatcher dis = request.getRequestDispatcher("/SattlePage/sattleList.jsp");
		dis.forward(request, response);
	}
}
