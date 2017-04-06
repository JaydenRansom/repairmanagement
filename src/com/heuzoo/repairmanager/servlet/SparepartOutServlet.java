package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.bean.PartflowInfo;
import com.heuzoo.repairmanager.bean.SparepartInfo;
import com.heuzoo.repairmanager.dao.PartflowDao;
import com.heuzoo.repairmanager.dao.SparepartDao;

/**
 * Servlet implementation class SparepartOutServlet
 */
public class SparepartOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sparepartNo = Integer.parseInt(request.getParameter("sparepart_no"));
		int sparepartDecrease = Integer.parseInt(request.getParameter("sparepart_decrease"));
		int sparepartTemp ;
		String sparepartDate = request.getParameter("sparepart_date");
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
		Date date = null;		
		try {
			date = f.parse(sparepartDate);
		} catch (ParseException e) {
			System.out.println("日期转换过程出错");
			e.printStackTrace();
		}
		
		//1.将零件库存信息里的信息作出对应更改
		SparepartInfo sparepart = null;
		SparepartDao sparepartdao = new SparepartDao();
		sparepart = sparepartdao.getSparepartInfo(sparepartNo);
		
		if(sparepart!=null){
			sparepartTemp = sparepart.getSparepartTotal();
			
			sparepart.setSparepartTotal(sparepartTemp - sparepartDecrease);
			//当此时库存量少于0，说明出库量>库存量
			if(sparepart.getSparepartTotal() < 0){
				System.out.println("库存量不够出库用了");
				PrintWriter pw = response.getWriter();
				
				pw.println("<script>");
				pw.println("alert('库存量不够使用');window.location.href='/RepairManagement/page/sparepart_out.jsp'");
				pw.println("</script>");
				pw.flush();	
			}
			
			if(sparepart.getSparepartTotal()  > sparepart.getSparepartWarn()){
				sparepart.setSparepartState(SparepartInfo.STATE_NORMAL);
			}else if(sparepart.getSparepartTotal()  == sparepart.getSparepartWarn()){
				sparepart.setSparepartState(SparepartInfo.STATE_CRISIS);
			}else if(sparepart.getSparepartTotal()  < sparepart.getSparepartWarn()){
				sparepart.setSparepartState(SparepartInfo.STATE_LACK);
			}
			
			if(sparepart.getSparepartTotal()  == 0 ){
				sparepart.setSparepartState(SparepartInfo.STATE_LACK);
			}
			
			sparepartdao.updateSparepart(sparepart);
		}else{
			System.out.println("找不到指定ID的备件的详细信息");
			PrintWriter pw = response.getWriter();
			
			pw.println("<script>");
			pw.println("alert('找不到指定ID');window.location.href='/RepairManagement/page/sparepart_out.jsp'");
			pw.println("</script>");
			pw.flush();			
			
		}
		
		//2.零件库存已成功更改，将操作加入流水表，
		PartflowInfo partflow = new PartflowInfo(0, PartflowInfo.PARTFLOW_TYPE_OUT, sparepartDecrease , sparepartNo , date);
		PartflowDao parflowdao = new PartflowDao();
		boolean partflowresult = parflowdao.addPartflow(partflow);
		
		//根据处理结果跳转到相应的页面提示
//				String url = null;
//				if(partflowresult){
//					url = "/page/welcome.html";
//				}
//				else{
//					url = "/page/sparepart_out.html";
//				}
//				
//				RequestDispatcher dis = request.getRequestDispatcher(url);
//				dis.forward(request, response);
		PrintWriter pw = response.getWriter();
		
		pw.println("<script>");
		if(partflowresult)
			pw.println("alert('操作成功!');window.location.href='/RepairManagement/page/SparepartUserServlet'");
		else
			pw.println("alert('操作失败~');window.location.href='/RepairManagement/page/sparepart_out.jsp'");
		pw.println("</script>");
		pw.flush();	
	}	

}
