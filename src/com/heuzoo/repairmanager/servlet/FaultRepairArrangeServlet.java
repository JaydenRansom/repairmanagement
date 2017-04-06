package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.RepaintManager;

import com.heuzoo.repairmanager.bean.FaultRepairInfo;
import com.heuzoo.repairmanager.bean.FaultReportInfo;
import com.heuzoo.repairmanager.bean.PartflowInfo;
import com.heuzoo.repairmanager.dao.FaultRepairDao;
import com.heuzoo.repairmanager.dao.FaultReportDao;
import com.heuzoo.repairmanager.dao.PartflowDao;


public class FaultRepairArrangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FaultRepairArrangeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int repair_no = 0;
		//取到要更改状态的维修单的单号
		repair_no = Integer.parseInt(request.getParameter("repair_no"));
		if(repair_no!=0){
			doPost(request, response);
		}else{
			System.out.println("没有取到维修单单号");
			PrintWriter pw = response.getWriter();
			
			pw.println("<script>");
				pw.println("alert('维修单号未找到');"
						+ "window.location.href='/RepairManagement/page/FaultRepairUserServlet'");
			pw.println("</script>");
			pw.flush();		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FaultRepairInfo faultrepair = new FaultRepairInfo();
		String page = (String) request.getAttribute("page");
		int repair_no = 0;
		int arrange_type = 0;
		
		//取到要更改状态的维修单的单号
		repair_no = Integer.parseInt(request.getParameter("repair_no"));
		arrange_type = Integer.parseInt(request.getParameter("type"));
				
		
		//创建DAO对象，调用方法完成查询
		//计算总页数，实现分页
		FaultRepairDao dao = new FaultRepairDao();
		
		ArrayList<FaultRepairInfo> result = dao.queryUser(faultrepair, repair_no);
		
		//令faultrepair被赋为查找到的唯一的维修单
		
		faultrepair = result.get(0);
		
		//arrange_type == 1 : 用户点击了分配按钮，下一步跳转至分配
		if(arrange_type == 1){
			PrintWriter pw = response.getWriter();
			pw.println("<script>");			
			pw.println("window.location.href='/RepairManagement/page/ArrangeConfirmServlet?repair_no="+repair_no+"'");
			pw.println("</script>");
			pw.flush();
		}
		//arrange_type == 2 : 用户点击了挂起按钮，下一步将维修单状态修改为挂起
		if(arrange_type == 2){
			faultrepair.setRepairState(FaultRepairInfo.STATE_REVOKE);
			boolean revoke_result = dao.updateFaultRepair(faultrepair);
			FaultReportInfo faultreport = new FaultReportInfo();
			FaultReportDao report_dao = new FaultReportDao();
			ArrayList<FaultReportInfo> report_result = report_dao.queryUser(faultreport, faultrepair.getRepairReportNo());
			faultreport = report_result.get(0);
			faultreport.setReportState(FaultReportInfo.STATE_REVOKE);
			report_dao.updateFaultReport(faultreport);
			PrintWriter pw = response.getWriter();
			pw.println("<script>");
			if(revoke_result){
			pw.println("alert('已将将订单撤销。');"
					+ "window.location.href='/RepairManagement/page/FaultRepairUserServlet?type=0'");
			}else
				pw.println("alert('订单撤销失败');"
						+ "window.location.href='/RepairManagement/page/FaultRepairUserServlet?type=1'");
			pw.println("</script>");
			pw.flush();
		}
		//将查询到的数据放到request中共享
		//将请求转发给Result.jsp显示查询结果
		
	}

}
