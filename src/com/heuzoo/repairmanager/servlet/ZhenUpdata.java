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

public class ZhenUpdata extends HttpServlet {

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

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String no=request.getParameter("customerId");
		
		System.out.println(no);
		//创建dao对象 调用删除方法
		
		CustomerInfoDao dao=new CustomerInfoDao();
		
		boolean result = dao.deleteUser(no);
		
		if(result)
		System.out.println(1);
		
		String cusid =request.getParameter("customerId");
		String custype =request.getParameter("customerType");
		String cusoffice=request.getParameter("customerOffice");
		String custel=request.getParameter("customerTel");
		String cusmobile=request.getParameter("customerMobile");
		String cusaddress=request.getParameter("customerAddress");
		String cusmail=request.getParameter("customerMail");
		String cusName=request.getParameter("customerName");
		String cusEmail=request.getParameter("customerEmail");
		
		int ctype = ChangeUtils.customerToInt(custype);
		
		CustomerInfo u=new CustomerInfo(cusid,ctype,cusoffice,custel,cusmobile,cusaddress,Integer.parseInt(cusmail),cusName,cusEmail);
	
		boolean Result=dao.addCustomerInfo(u);
		
		
		
       
		
		CustomerInfo cus=new CustomerInfo();
		
		cus.setCustomerId(no);
		
		CustomerInfo re = dao.queryCus(cus);
		
		String s = ChangeUtils.customerToString(re.getCustomerType());
		
		request.setAttribute("data", re);
		request.setAttribute("type", s);
		
		
		if(Result)
		{
			RequestDispatcher dis=request.getRequestDispatcher("/CustomerInfo/tableqi.jsp");
			dis.forward(request,response);
		}

		
	}

}
