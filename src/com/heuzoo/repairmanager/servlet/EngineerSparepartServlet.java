package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.bean.RepairPartflowInfo;
import com.heuzoo.repairmanager.dao.RepairPartflowDao;

public class EngineerSparepartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EngineerSparepartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int repairPartflowSparepart = Integer.parseInt(request.getParameter("repair_partflow_sparepart"));
		int repairPartflowCount = Integer.parseInt(request.getParameter("repair_partflow_count"));
		int repairPartflowRepair = Integer.parseInt(request.getParameter("repair_partflow_repair"));
		
		RepairPartflowDao dao = new RepairPartflowDao();
		RepairPartflowInfo repairPartflow = new RepairPartflowInfo();
		repairPartflow.setRepairPartflowNo(0);
		repairPartflow.setRepairPartflowRepair(repairPartflowRepair);
		repairPartflow.setRepairPartflowSparepart(repairPartflowSparepart);
		repairPartflow.setRepairPartflowCount(repairPartflowCount);
		boolean result = dao.addPartflow(repairPartflow);
		
		
		PrintWriter pw = response.getWriter();		
		pw.println("<script>");
		if(result)			
			pw.println("alert('记录成功！');window.location.href='/RepairManagement/Cindex.jsp'");
		else
			pw.println("alert('记录失败，请检查您的输入信息。');window.location.href='/RepairManagement/page/engineer_sparepart.jsp'");
		pw.println("</script>");
		pw.flush();	
	}
}


