package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.bean.FaultRepairInfo;
import com.heuzoo.repairmanager.dao.FaultRepairDao;

public class SeeRepairServlet extends HttpServlet {

	public SeeRepairServlet() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		FaultRepairInfo faultrepair = new FaultRepairInfo();
		
		
		//创建DAO对象，调用方法完成查询
			FaultRepairDao dao = new FaultRepairDao();
			//获取所有维修单信息
			ArrayList<FaultRepairInfo> result = dao.queryUser(0,faultrepair,0,0);
			
			//将查询到的数据放到request中共享
			request.setAttribute("data", result);
			RequestDispatcher dis = request.getRequestDispatcher("/snovey/seeRepair.jsp");
			dis.forward(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
