package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.bean.CustomerInfo;
import com.heuzoo.repairmanager.common.ChangeUtils;
import com.heuzoo.repairmanager.dao.CustomerInfoDao;

public class UpdataServlet extends HttpServlet {

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

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String no=request.getParameter("no");
		
		CustomerInfo cus=new CustomerInfo();
		
		cus.setCustomerId(no);
		
		CustomerInfoDao dao=new CustomerInfoDao();
		
		CustomerInfo result = dao.queryCus(cus);
		String s = ChangeUtils.customerToString(result.getCustomerType());
		
		request.setAttribute("data", result);
		request.setAttribute("type", s);
		
		RequestDispatcher dis = request.getRequestDispatcher("/CustomerInfo/updataqi.jsp");
		dis.forward(request, response);
	}

}
