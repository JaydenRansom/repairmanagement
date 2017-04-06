package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.bean.DeviceInfo;
import com.heuzoo.repairmanager.dao.DeviceInfoDao;

public class QueryDevice extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ArrayList<DeviceInfo> deviceInfo = new ArrayList<DeviceInfo>();
		deviceInfo = DeviceInfoDao.getAllDevice();
		request.setAttribute("allDevice", deviceInfo);
		RequestDispatcher dis = request.getRequestDispatcher("/snovey/showDevice.jsp");
		dis.forward(request, response);
	}

}
