package com.heuzoo.repairmanager.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.bean.CustomerInfo;
import com.heuzoo.repairmanager.common.ChangeUtils;
import com.heuzoo.repairmanager.dao.CustomerInfoDao;

public class RegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
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
	
		CustomerInfoDao dao=new CustomerInfoDao();
		
		boolean result=dao.addCustomerInfo(u);
		
		String url=null;
		
        String no=request.getParameter("customerId");
		
		CustomerInfo cus=new CustomerInfo();
		
		cus.setCustomerId(no);
		
		
		
		CustomerInfo re = dao.queryCus(cus);
		String s = ChangeUtils.customerToString(re.getCustomerType());
		
		request.setAttribute("data", re);
		request.setAttribute("type", s);
		
		if(result)
		{url="/CustomerInfo/tableqi.jsp";}
		else
		{url="/CustomerInfo/form-nativeqi.jsp";}
		
		
		RequestDispatcher dis=request.getRequestDispatcher(url);
		dis.forward(request,response);
		
		
	}
}
