package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heuzoo.repairmanager.bean.FaultReportInfo;
import com.heuzoo.repairmanager.dao.FaultReportInfoDao;

public class AddFaultReport extends HttpServlet {

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

		String device = request.getParameter("reportDevice");
		String customerId = request.getParameter("reportCustomerId");
		String time = request.getParameter("reportTime");
		String price = request.getParameter("reportPrice");
		String finish = request.getParameter("reportFinish");
		String state = request.getParameter("reportState");
		System.out.println(customerId);
		System.out.println(customerId.length());

		//SimpleDateFormat 负责字符串与日期相互转换
		SimpleDateFormat ts = new SimpleDateFormat("MM/dd/yyyy");
		Date tm = null;
		Date fnh = null;

		try {
			tm = ts.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fnh = ts.parse(finish);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(tm);
//		System.out.println(state);

		FaultReportInfo u = new FaultReportInfo(0, Integer.parseInt(device), customerId, tm, Double.parseDouble(price), fnh, Integer.parseInt(state));
		//3.调用 DAO 里的方法，完成相关的业务逻辑
		FaultReportInfoDao dao = new FaultReportInfoDao();

		boolean result = dao.addFaultReportInfo(u);

		//4.根据业务逻辑的处理结果生成响应给客户端
		int data = dao.queryReportNo();
		System.out.println(result);
		if (!result) {
			data = -1;
		}
		System.out.println("reportno="+data);
		PrintWriter out = response.getWriter();
		out.print(data);
		out.flush();
		

	}

}
