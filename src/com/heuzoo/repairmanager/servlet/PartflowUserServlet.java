package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heuzoo.repairmanager.bean.PartflowInfo;
import com.heuzoo.repairmanager.bean.SparepartInfo;
import com.heuzoo.repairmanager.common.Utils;
import com.heuzoo.repairmanager.dao.PartflowDao;
import com.heuzoo.repairmanager.dao.SparepartDao;

/**
 * Servlet implementation class PartflowUserServlet
 */
public class PartflowUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "1");
		System.out.println("收到用户GET请求");
    	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PartflowInfo partflow = new PartflowInfo();
		String page = (String) request.getAttribute("page");
		int type = Integer.parseInt(request.getParameter("type"));
				
		if(page == null){
			//如果不是通过get方法到达，说明是用户点击翻页
			page = request.getParameter("page");
		}
		//定义分页显示所需数据
		int totalRows = 0;//总数据量
		int pageSize = 10;//每页的数据量
		int pages = 0;//总页数
		int currentPage = 1;//当前所在的页数
		int startPosition = 0;//起始页
		
		
		//创建DAO对象，调用方法完成查询
		//计算总页数，实现分页
		PartflowDao dao = new PartflowDao();
		totalRows = dao.queryUserTotalRows(partflow);
		pages =(int) Math.ceil(totalRows/(double)pageSize);
		if(page !=null){
			currentPage = Integer.parseInt(page);
		}
		startPosition = (currentPage-1)*pageSize;
		
		
		
		ArrayList<PartflowInfo> result = dao.queryUser(type,partflow,startPosition,pageSize);
		
		//将查询到的数据放到request中共享
		request.setAttribute("data", result);
		//将分页数放到request中共享
		request.setAttribute("pages",pages);
		request.setAttribute("currentPage",currentPage);
		request.setAttribute("totalRows",totalRows);
		
		HttpSession session = request.getSession();
		session.setAttribute("pages", pages);
		session.setAttribute("currentPage",currentPage);
		//将请求转发给Result.jsp显示查询结果
		
		RequestDispatcher dis = request.getRequestDispatcher("/page/sparepart_partflow_in_list.jsp");
		dis.forward(request, response);
		
	}

	
	
	
}
