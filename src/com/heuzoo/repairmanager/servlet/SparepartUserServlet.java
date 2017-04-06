package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heuzoo.repairmanager.bean.SparepartInfo;
import com.heuzoo.repairmanager.dao.SparepartDao;


/**
 * Servlet implementation class SparepartUserServlet
 */
public class SparepartUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SparepartUserServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	req.setAttribute("page", "1");
    	doPost(req, resp);
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				SparepartInfo sparepart = new SparepartInfo();
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
				SparepartDao dao = new SparepartDao();
				totalRows = dao.queryUserTotalRows(sparepart);
				pages =(int) Math.ceil(totalRows/(double)pageSize);
				if(page !=null){
					currentPage = Integer.parseInt(page);
				}
				startPosition = (currentPage-1)*pageSize;
				
				ArrayList<SparepartInfo> result = dao.queryUser(sparepart,startPosition,pageSize);
				
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
					RequestDispatcher dis = request.getRequestDispatcher("/page/sparepart_list.jsp");
					dis.forward(request, response);
		
	}

}
