package com.heuzoo.repairmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heuzoo.repairmanager.bean.SattleInfo;
import com.heuzoo.repairmanager.dao.SattleDao;

public class SeeSattleServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<SattleInfo> result = new ArrayList<SattleInfo>();
		ArrayList<SattleInfo> finalResult = new ArrayList<SattleInfo>();
		result = SattleDao.getSattleInfo();
		finalResult = SattleDao.getFinalSattleInfo(result);
		request.setAttribute("sattleInfo", finalResult);
		RequestDispatcher dis = request.getRequestDispatcher("/SattlePage/seeSattleResultShow.jsp");
		dis.forward(request, response);
	}
}
