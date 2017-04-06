package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.dao.SparepartDao;

/**
 * Servlet implementation class SparepartDeleteServlet
 */
public class SparepartDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sparepart_no = Integer.parseInt(request.getParameter("id"));
		
		SparepartDao dao = new SparepartDao();
		
		boolean result = dao.deleteSparepart(sparepart_no);
		
		PrintWriter pw = response.getWriter();
		
		pw.println("<script>");
		if(result)
			pw.println("alert('É¾³ý³É¹¦');window.location.href='/RepairManagement/page/SparepartUserServlet'");
		else pw.println("alert('É¾³ýÊ§°Ü');window.location.href='/RepairManagement/page/SparepartUserServlet'");
		pw.println("</script>");
		pw.flush();		
	}


}
