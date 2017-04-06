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


public class SnoveyQueryFaultReport extends HttpServlet {

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

		// //获取查询数据
		// String no = request.getParameter("Report_no");
		// String name = request.getParameter("Report_name");
		// String device = request.getParameter("Report_Device");
		// String customerId = request.getParameter("Report_Customer_Id");
		// String time = request.getParameter("Report_time");
		// String finish = request.getParameter("Report_finish");
		// String state = request.getParameter("Report_state");
		String page = request.getParameter("page");
		FaultReportInfo fri = new FaultReportInfo();

		//定义分页展示所需数据
		int totalRows = 0; //总的数据量
		int pageSize  = 5; //每页的数据量
		int pages = 0; //总页数
		int currentPage = 1; //当前页
		int startPosition = 0; //每页起始位置
		//创建 DAO 对象，调用方法，完成查询逻辑
		FaultReportInfoDao dao = new FaultReportInfoDao();
		totalRows = dao.queryReporttotalRows(fri);
		pages = (totalRows-1)/pageSize+1;
//		pages = (int) Math.ceil(totalRows/(double)pageSize);

		if (page != null) {
			currentPage = Integer.parseInt(page);
		}
		startPosition = (currentPage-1)*pageSize;

		ArrayList<FaultReportInfo> result = dao.queryFaultReport(fri, startPosition, pageSize);

		//将查询到的数据放到request共享
		request.setAttribute("data", result);
		//将分页信息放到request共享
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);

		//将请求转发给 queryResult.jsp 展示查询结果
		RequestDispatcher dis = request.getRequestDispatcher("/queryFaultReport.jsp");
		dis.forward(request, response);
	}

}
