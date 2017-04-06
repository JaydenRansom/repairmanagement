<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.heuzoo.repairmanager.bean.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sattleReady.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <a href="/RepairManagement/servlet/FinishedQueryServlet"><button>显示已完成的</button></a>
    <a href="/RepairManagement/servlet/NoFinishedQueryServlet"><button>显示未显示完成的</button></a>
    <br/>
    <table align="center" border="1" style="border-collapse:collapse;">
    	<tr>
    		<th>维修单号</th>
    		<th>维修人</th>
    		<th>人工费</th>
    		<th>材料费</th>
    		<th>维修设备</th>
    		<th>选择结算</th>
    	</tr>
    	<c:forEach items="${showInfo}" var="u">
    		<tr>
    			<td>${u.repairNo }</td>
    			<td>${u.repairPerson }</td>
    			<td>${u.repairManualCost }</td>
    			<td>${u.repairMaterialCost }</td>
    			<td></td>
    			<td><a href="/RepairManagement/servlet/PrintSattleList?repairno=${u.repairNo}"><button>结算</button></a></td>
    		</tr>
    	</c:forEach>
    </table>
  </body>
</html>
