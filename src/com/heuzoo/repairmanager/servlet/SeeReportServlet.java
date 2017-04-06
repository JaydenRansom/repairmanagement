package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.bean.FaultReportInfo;
import com.heuzoo.repairmanager.dao.FaultReportInfoDao;

public class SeeReportServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<FaultReportInfo> reportInfo = new ArrayList<FaultReportInfo>();
		reportInfo = FaultReportInfoDao.queryFaultReport();
		request.setAttribute("reportInfo", reportInfo);
		RequestDispatcher dis = request.getRequestDispatcher("/snovey/seeReport.jsp");
		dis.forward(request, response);
	}

}
