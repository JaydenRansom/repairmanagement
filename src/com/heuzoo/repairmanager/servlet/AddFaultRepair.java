package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.bean.FaultRepairInfo;
import com.heuzoo.repairmanager.dao.FaultRepairInfoDao;

public class AddFaultRepair extends HttpServlet {

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

		String reportNo = request.getParameter("reportNo");
		String repairState = request.getParameter("repairState");


		FaultRepairInfo u = new FaultRepairInfo();
		System.out.println("hello " + reportNo);
		u.setRepairReportNo(Integer.parseInt(reportNo));
		u.setRepairState(Integer.parseInt(repairState));
		//3.调用 DAO 里的方法，完成相关的业务逻辑
		FaultRepairInfoDao dao = new FaultRepairInfoDao();

		boolean result = dao.addFaultRepairInfo(u);

		//4.根据业务逻辑的处理结果生成响应给客户端
		PrintWriter out = response.getWriter();
		System.out.println(result);
		String message = null;
		if (result) {
			message = "YES";
		} else {
			message = "NO";
		}
		out.print(message);

//		RequestDispatcher dis = request.getRequestDispatcher(url);
//		dis.forward(request, response);
	}

}
