package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.bean.FaultRepairInfo;
import com.heuzoo.repairmanager.dao.SattleDao;
//Can connected by the sattlePage.jsp
public class NoFinishedQueryServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("The NoFinishedQueryServlet is beginning.");
		SattleDao sattleDao = new SattleDao();
		ArrayList<FaultRepairInfo> noFinishedQueryResult = new ArrayList<FaultRepairInfo>();
		noFinishedQueryResult = sattleDao.repairNoFinishQuery();
		System.out.println(noFinishedQueryResult);
		request.setAttribute("showInfo", noFinishedQueryResult);
		RequestDispatcher dis = request.getRequestDispatcher("/SattlePage/newSattleReady.jsp");
		dis.forward(request, response);
		System.out.println("The NoFinishedQueryServlet is ending.");
	}
}
