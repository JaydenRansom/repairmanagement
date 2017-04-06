package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.dao.DeviceInfoDao;

public class SnoveyQueryDevice extends HttpServlet {

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String deviceSeries = request.getParameter("deviceSeries");
		System.out.println(deviceSeries);
		DeviceInfoDao d = new DeviceInfoDao();
		boolean result = d.queryDeviceInfo(deviceSeries);
		String message = null;
		PrintWriter out = response.getWriter();
		request.setAttribute("data", deviceSeries);
		if (result) {
			message = "YES";
		} else {
			message = "NO";
		}
		out.print(message);
        out.flush();
	}

}
