package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.bean.FaultRepairInfo;
import com.heuzoo.repairmanager.bean.FaultReportInfo;
import com.heuzoo.repairmanager.bean.SparepartInfo;
import com.heuzoo.repairmanager.dao.FaultRepairDao;
import com.heuzoo.repairmanager.dao.FaultReportDao;
import com.heuzoo.repairmanager.dao.SparepartDao;

public class RepairCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RepairCompleteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int repairNo = Integer.parseInt(request.getParameter("repair_no"));
		String repairExaminationRecord = request.getParameter("repair_examination_record");
		String repairRepairRecord = request.getParameter("repair_repair_record");
		String repairWorkload = request.getParameter("repair_workload");
		double repairManualCost = Double.parseDouble(request.getParameter("repair_manual_cost"));
		double repairMaterialCost = Double.parseDouble(request.getParameter("repair_material_cost"));
		String repairCommitment = request.getParameter("repair_commitment");
		String repairNoticePoints = request.getParameter("repair_notice_points");
		int repairDelayDegree = Integer.parseInt(request.getParameter("repair_delay_degree"));
		
		FaultRepairInfo faultrepair = null;
		FaultRepairDao repair_dao = new FaultRepairDao();
		faultrepair = (repair_dao.queryUser(faultrepair, repairNo)).get(0);
		faultrepair.setRepairRepairTime(new Date());
		faultrepair.setRepairCommitment(repairCommitment);
		faultrepair.setRepairDelayDegree(repairDelayDegree);
		faultrepair.setRepairExaminationRecord(repairExaminationRecord);
		faultrepair.setRepairManualCost(repairManualCost);
		faultrepair.setRepairWorkload(repairWorkload);
		faultrepair.setRepairNoticePoints(repairNoticePoints);
		faultrepair.setRepairMaterialCost(repairMaterialCost);
		faultrepair.setRepairRepairRecord(repairRepairRecord);
		faultrepair.setRepairState(FaultRepairInfo.STATE_ACHIEVED);
		boolean repairResult = repair_dao.updateFaultRepair(faultrepair);
		
		FaultReportInfo faultreport = new FaultReportInfo();
		FaultReportDao report_dao = new FaultReportDao();
		ArrayList<FaultReportInfo> report_result = report_dao.queryUser(faultreport, faultrepair.getRepairReportNo());
		faultreport = report_result.get(0);
		faultreport.setReportFinish(new Date());
		faultreport.setReportState(FaultReportInfo.STATE_ACHIEVED);
		boolean reportResult = report_dao.updateFaultReport(faultreport);
		
		
		PrintWriter pw = response.getWriter();
		pw.println("<script>");
		if(repairResult&&reportResult)
			pw.println("alert('操作成功!');window.location.href='/RepairManagement/page/FaultRepairUserServlet?type=4&emp_no="
					+faultrepair.getRepairPerson()+ "'");
		else
			pw.println("alert('操作失败~');window.location.href='/RepairManagement/page/EngineerConfirmServlet?repair_no="
					+faultrepair.getRepairNo()+ "'");
		pw.println("</script>");
		pw.flush();	
	}

}
