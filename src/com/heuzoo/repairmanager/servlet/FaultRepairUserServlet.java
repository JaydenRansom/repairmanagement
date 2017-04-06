package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heuzoo.repairmanager.bean.FaultRepairInfo;
import com.heuzoo.repairmanager.bean.FaultReportInfo;
import com.heuzoo.repairmanager.bean.SparepartInfo;
import com.heuzoo.repairmanager.dao.FaultRepairDao;
import com.heuzoo.repairmanager.dao.SparepartDao;

/**
 * Servlet implementation class FaultRepairUserServlet
 */
public class FaultRepairUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "1");
    	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int type = Integer.parseInt(request.getParameter("type"));
		FaultRepairInfo faultrepair = new FaultRepairInfo();
		String page = (String) request.getAttribute("page");
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
		FaultRepairDao dao = new FaultRepairDao();
		totalRows = dao.queryUserTotalRows(faultrepair);
		pages =(int) Math.ceil(totalRows/(double)pageSize);
		if(page !=null){
			currentPage = Integer.parseInt(page);
		}
		startPosition = (currentPage-1)*pageSize;
		
		if(type == 1){
		//获取所有未分配维修单信息
		ArrayList<FaultRepairInfo> result = dao.queryUser(FaultRepairInfo.STATE_BLOCK,faultrepair,startPosition,pageSize);
		
		//将查询到的数据放到request中共享
		request.setAttribute("data", result);
		RequestDispatcher dis = request.getRequestDispatcher("/page/faultrepair_arrange_list.jsp");
		dis.forward(request, response);
		}else if(type==2){
			//获取所有维修单信息
			ArrayList<FaultRepairInfo> result = dao.queryUser(0,faultrepair,startPosition,pageSize);
			
			//将查询到的数据放到request中共享
			request.setAttribute("data", result);
			RequestDispatcher dis = request.getRequestDispatcher("/page/faultrepair_whole_list.jsp");
			dis.forward(request, response);
		}else if(type==3){
			int empNo = Integer.parseInt(request.getParameter("emp_no"));
			//最后一个参数赋1：只查询所有不在已完成或者已撤销状态的
			ArrayList<FaultRepairInfo> result = dao.queryUser(FaultRepairInfo.STATE_ARRANGED,faultrepair,empNo,1);			
			//将查询到的数据放到request中共享
			request.setAttribute("data", result);
			RequestDispatcher dis = request.getRequestDispatcher("/page/engineer_faultrepair.jsp");
			dis.forward(request, response);
		}else if(type==4){
			int empNo = Integer.parseInt(request.getParameter("emp_no"));
			ArrayList<FaultRepairInfo> result = dao.queryUser(FaultRepairInfo.STATE_ARRANGED,faultrepair,empNo,0);			
			//将查询到的数据放到request中共享
			request.setAttribute("data", result);
			RequestDispatcher dis = request.getRequestDispatcher("/page/engineer_query.jsp");
			dis.forward(request, response);
		}
	}

}
