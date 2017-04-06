package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heuzoo.repairmanager.bean.DeviceInfo;
import com.heuzoo.repairmanager.dao.DeviceInfoDao;

public class AddDevice extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 *
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String deviceType = request.getParameter("deviceType");
		String deviceBrand = request.getParameter("deviceBrand");
		String deviceModel = request.getParameter("deviceModel");
		String deviceSeries = request.getParameter("deviceSeries");
		String deviceLack = request.getParameter("deviceLack");
		String deviceFaultAppearance = request.getParameter("deviceFaultAppearance");
		String deviceFaultType = request.getParameter("deviceFaultType");
		String deviceSurface = request.getParameter("deviceSurface");
		String devicePassword = request.getParameter("devicePassword");
		String deviceImpFile = request.getParameter("deviceImpFile");
		String deviceHDD = request.getParameter("deviceHDD");
		String deviceMemory = request.getParameter("deviceMemory");
		String devicePC = request.getParameter("devicePC");
		String deviceAC = request.getParameter("deviceAC");
		String deviceBattery = request.getParameter("deviceBattery");
		String deviceDVD = request.getParameter("deviceDVD");
		String deviceOther = request.getParameter("deviceOther");

		DeviceInfo u = new DeviceInfo(0, Integer.parseInt(deviceType), deviceBrand, deviceModel, deviceSeries, deviceLack, deviceFaultAppearance, Integer.parseInt(deviceFaultType), deviceSurface, devicePassword, deviceImpFile, deviceHDD, deviceMemory, devicePC, deviceAC, deviceBattery, deviceDVD, deviceOther);
		//3.调用 DAO 里的方法，完成相关的业务逻辑
		DeviceInfoDao dao = new DeviceInfoDao();

		boolean result = dao.addDeviceInfo(u);
		//将查询到的数据放到request共享
		
		//4.根据业务逻辑的处理结果生成响应给客户端
		PrintWriter out = response.getWriter();
		int data=dao.queryDeviceNo();
//		System.out.println(result);
//		System.out.println(data);
		if (!result) {
			data = -1;
		}
		out.print(data);
		out.flush();


	}

}
