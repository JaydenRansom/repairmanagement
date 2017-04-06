package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.bean.EmployeeInfo;
import com.heuzoo.repairmanager.bean.FaultRepairInfo;
import com.heuzoo.repairmanager.bean.FaultReportInfo;
import com.heuzoo.repairmanager.dao.EmployeeUserDao;
import com.heuzoo.repairmanager.dao.FaultRepairDao;
import com.heuzoo.repairmanager.dao.FaultReportDao;


public class ArrangeCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ArrangeCompleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int arrange_person = Integer.parseInt(request.getParameter("repair_arrange"));
		int repair_no = Integer.parseInt(request.getParameter("repair_no"));
		
		FaultRepairInfo faultrepair = new FaultRepairInfo();
		FaultRepairDao repair_dao = new FaultRepairDao();
		ArrayList<FaultRepairInfo> repair_result = repair_dao.queryUser(faultrepair, repair_no);
		faultrepair = repair_result.get(0);
		
		FaultReportInfo faultreport = new FaultReportInfo();
		FaultReportDao report_dao = new FaultReportDao();
		ArrayList<FaultReportInfo> report_result = report_dao.queryUser(faultreport, faultrepair.getRepairReportNo());
		faultreport = report_result.get(0);
		
		faultrepair.setRepairPerson(arrange_person);
		EmployeeUserDao emp_dao = new EmployeeUserDao();
		EmployeeInfo employee = null;
		employee = emp_dao.queryUser(employee, arrange_person).get(0);
		
		if(employee.getEmployeeType() != EmployeeInfo.TYPE_C){
			PrintWriter pw = response.getWriter();
			pw.println("<script>");
			pw.println("alert('您所指定的员工不是技术工程师，请重新指定！');window.location.href='/RepairManagement/page/"
					+ "ArrangeConfirmServlet?&repair_no="+repair_no+"'");
			pw.println("</script>");
			pw.flush();
		}else{		
			faultrepair.setRepairState(FaultRepairInfo.STATE_ARRANGED);
			faultrepair.setRepairArrangeTime(new Date());
			repair_dao.updateFaultRepair(faultrepair);
			faultreport.setReportState(FaultReportInfo.STATE_PROCEEDING);
			report_dao.updateFaultReport(faultreport);
			RequestDispatcher dis = request.getRequestDispatcher("/page/FaultRepairUserServlet?type=4&emp_no="+faultrepair.getRepairPerson());
			dis.forward(request, response);
		}
	}


}
