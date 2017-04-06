package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.bean.EmployeeInfo;
import com.heuzoo.repairmanager.bean.FaultRepairInfo;
import com.heuzoo.repairmanager.bean.FaultReportInfo;
import com.heuzoo.repairmanager.dao.EmployeeUserDao;
import com.heuzoo.repairmanager.dao.FaultRepairDao;
import com.heuzoo.repairmanager.dao.FaultReportDao;


public class ArrangeConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int repair_no = 0;
		repair_no = Integer.parseInt(request.getParameter("repair_no"));
		
		FaultRepairInfo faultrepair = new FaultRepairInfo();
		FaultRepairDao repair_dao = new FaultRepairDao();
		ArrayList<FaultRepairInfo> repair_result = repair_dao.queryUser(faultrepair, repair_no);
		faultrepair = repair_result.get(0);
		
		FaultReportInfo faultreport = new FaultReportInfo();
		FaultReportDao report_dao = new FaultReportDao();
		ArrayList<FaultReportInfo> report_result = report_dao.queryUser(faultreport, faultrepair.getRepairReportNo());
		faultreport = report_result.get(0);
		
		
		ArrayList<EmployeeInfo> empResult = null;
		EmployeeUserDao emp_dao = new EmployeeUserDao();
		empResult = emp_dao.getEngineer();
		
		request.setAttribute("data1", faultrepair);
		request.setAttribute("data2", faultreport);
		System.out.println(faultreport.toString());
		request.setAttribute("data3", empResult);
		
		RequestDispatcher dis = request.getRequestDispatcher("/page/faultrepair_arrangement.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
