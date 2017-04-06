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
import javax.servlet.http.HttpSession;



import com.heuzoo.repairmanager.bean.PartflowInfo;
import com.heuzoo.repairmanager.bean.SparepartInfo;
import com.heuzoo.repairmanager.dao.PartflowDao;
import com.heuzoo.repairmanager.dao.SparepartDao;

/**
 * Servlet implementation class SparepartInServlet
 */
public class SparepartInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sparepartNo = Integer.parseInt(request.getParameter("sparepart_no"));
		int sparepartIncrease = Integer.parseInt(request.getParameter("sparepart_increase"));
		int sparepartTemp ;
		String sparepartDate = request.getParameter("sparepart_date");
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-mm-dd");
		Date date = null;		
		try {
			date = f.parse(sparepartDate);
		} catch (ParseException e) {
			System.out.println("����ת����̳���");
			e.printStackTrace();
		}
		
		//1.����������Ϣ�����Ϣ������Ӧ���
		SparepartInfo sparepart = null;
		SparepartDao sparepartdao = new SparepartDao();
		sparepart = sparepartdao.getSparepartInfo(sparepartNo);
		
		if(sparepart!=null){
			sparepartTemp = sparepart.getSparepartTotal();
			
			sparepart.setSparepartTotal(sparepartTemp + sparepartIncrease);
			
			if((sparepartTemp + sparepartIncrease) > sparepart.getSparepartWarn()){
				sparepart.setSparepartState(SparepartInfo.STATE_NORMAL);
			}else if((sparepartTemp + sparepartIncrease) == sparepart.getSparepartWarn()){
				sparepart.setSparepartState(SparepartInfo.STATE_CRISIS);
			}else if((sparepartTemp + sparepartIncrease) < sparepart.getSparepartWarn()){
				sparepart.setSparepartState(SparepartInfo.STATE_WARN);
			}
			
			if((sparepartTemp + sparepartIncrease) == 0 ){
				sparepart.setSparepartState(SparepartInfo.STATE_LACK);
			}
			
			sparepartdao.updateSparepart(sparepart);
		}else{
			System.out.println("�Ҳ���ָ��ID�ı�������ϸ��Ϣ");
			PrintWriter pw = response.getWriter();
			
			pw.println("<script>");
			pw.println("alert('�Ҳ���ָ��ID');window.location.href='/RepairManagement/page/sparepart_in.html'");
			pw.println("</script>");
			pw.flush();			
			
		}
		
		//2.�������ѳɹ���ģ�������������ˮ�?
		PartflowInfo partflow = new PartflowInfo(0, PartflowInfo.PARTFLOW_TYPE_IN, sparepartIncrease , sparepartNo , date);
		PartflowDao parflowdao = new PartflowDao();
		boolean partflowresult = parflowdao.addPartflow(partflow);
		
		//��ݴ�������ת����Ӧ��ҳ����ʾ
		PrintWriter pw = response.getWriter();
		
		pw.println("<script>");
		if(partflowresult)
			pw.println("alert('���ɹ���');window.location.href='/RepairManagement/page/SparepartUserServlet'");
		else
			pw.println("alert('���ʧ�ܡ�');window.location.href='/RepairManagement/page/sparepart_in.jsp'");
		pw.println("</script>");
		pw.flush();	
	}

}
