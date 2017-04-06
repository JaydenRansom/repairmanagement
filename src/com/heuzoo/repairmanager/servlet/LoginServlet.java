package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heuzoo.repairmanager.bean.EmployeeInfo;
import com.heuzoo.repairmanager.dao.EmployeeUserDao;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//获取用户名密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		EmployeeInfo u = new EmployeeInfo();
		u.setEmployeeUsername(username);
		u.setEmployeePassword(password);
		
		//调用dao完成业务逻辑
		EmployeeUserDao dao = new EmployeeUserDao();
		u = dao.login(u);
		
		//根据处理结果跳转到相应的页面提示
		String url = null;
		if(u != null){
			System.out.println(u.toString());
			switch(u.getEmployeeType()){
			case EmployeeInfo.TYPE_A:url="/Aindex.jsp";break;
			case EmployeeInfo.TYPE_B:url="/Bindex.jsp";break;
			case EmployeeInfo.TYPE_C:url="/Cindex.jsp";break;
			case EmployeeInfo.TYPE_D:url="/Dindex.jsp";break;
			case EmployeeInfo.TYPE_E:url="/Eindex.jsp";break;
			case EmployeeInfo.TYPE_F:url="/Findex.jsp";break;
			}
			HttpSession session = request.getSession();
			session.setAttribute("userName", u.getEmployeeName());
			session.setAttribute("userType", u.getEmployeeType());
			session.setAttribute("userNo", u.getEmployeeNo());
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
		}
		else{
			PrintWriter pw = response.getWriter();
			pw.println("<script>");
			pw.println("alert('用户名或密码错误');window.location.href='/RepairManagement/login.html'");
			pw.println("</script>");
		}
		
		
	}

}
