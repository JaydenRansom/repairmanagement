<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.heuzoo.repairmanager.bean.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">

    <title>My JSP 'queryResult.jsp' starting page</title>

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
    <div>
      <table align="center" border="1" style="border-collapse: collapse;">
          <tr bgcolor="cyan">
              <th>接修日期</th>
              <th>维修编号</th>
              <th>产品类型</th>
              <th>机器品牌</th>
              <th>机器型号</th>
              <th>系列号</th>
              <th>单位名称</th>
              <th>联系人</th>
              <th>机器故障现象</th>
              <th>缺少零件</th>
          </tr>

          <tr>
              <td>${data.reportTime}</td>
              <td>${data.reportNo}</td>
              <td>${data.deviceType}</td>
              <td>${data.deviceBrand}</td>
              <td>${data.deviceModel}</td>
              <td>${data.deviceSeries}</td>
              <td>${data.customerName}</td>
              <td>${data.customerOffice}</td>
              <td>${data.deviceFaultAppearance}</td>
              <td>${data.deviceLack}</td>
          </tr>

      </table>
    </div>
  </body>
</html>
