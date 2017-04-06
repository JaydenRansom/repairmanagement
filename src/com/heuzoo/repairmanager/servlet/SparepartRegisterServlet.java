package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.bean.SparepartInfo;
import com.heuzoo.repairmanager.dao.SparepartDao;

/**
 * Servlet implementation class SparepartServlet
 */
public class SparepartRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SparepartRegisterServlet() {
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String sparepartName;
		String sparepartType;
		double sparepartPrice;
		int sparepartWarn;
		
		int sparepartTotal = 0;
		//当前库存为0，必定为缺货
		int sparepartState = SparepartInfo.STATE_LACK;
		
		sparepartName = request.getParameter("sparepart_name");
		sparepartType = request.getParameter("sparepart_type");
		sparepartPrice = Double.parseDouble(request.getParameter("sparepart_price"));
		sparepartWarn = Integer.parseInt(request.getParameter("sparepart_warn"));
		
		SparepartInfo sparepart = new SparepartInfo(0, sparepartName, sparepartType, 
				sparepartPrice, sparepartTotal, sparepartWarn, sparepartState);
		
		SparepartDao dao = new SparepartDao();
		boolean result = dao.addSparepart(sparepart);
		
		PrintWriter pw = response.getWriter();
		
		
		pw.println("<script>");
		if(result)
			pw.println("alert('操作成功!');window.location.href='/RepairManagement/page/SparepartUserServlet'");
		else
			pw.println("alert('操作失败~');window.location.href='/RepairManagement/page/sparepart_create.jsp'");
		pw.println("</script>");
		pw.flush();	
		
	}

}
