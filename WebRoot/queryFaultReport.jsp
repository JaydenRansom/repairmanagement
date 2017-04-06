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
              <th>报告编号</th>
              <th>产品类型</th>
              <th>客户ID</th>
              <th>报修时间</th>
              <th>预估价格</th>
              <th>预估完成时间</th>
              <th>报修状态</th>
              <th>提交至维修</th>
              <th>打印订单</th>
          </tr>
      <c:forEach items="${data}" var="u">
          <tr>
              <td>${u.reportNo}</td>
              <td>${u.reportDevice}</td>
              <td>${u.reportCustomerId}</td>
              <td>${u.reportTime}</td>
              <td>${u.reportPrice}</td>
              <td>${u.reportFinish}</td>
              <td>${u.reportState}</td>
              <td><a href="/RepairManagement/servlet/AddFaultRepair?reportNo=${u.reportNo}">×</a></td>
              <td><a href="/RepairManagement/servlet/PrintConfirmOrder?reportNo=${u.reportNo}">√</a></td>
          </tr>
      </c:forEach>
      </table>
    </div>
    <p align="center">总共${pages}页，当前是${currentPage}页&nbsp;&nbsp;&nbsp;
    <c:forEach begin="1" end="${pages}" var="p">
    <a href="javascript:goPage('${p}')">${p}</a>&nbsp;
    </c:forEach>
    </p>
    <form action="/repairmanagement/servlet/QueryFaultReport" method="post">
        <input type="hidden" name="" value="" />
        <input type="hidden" name="page" id="page" value="" />
    </form>
  </body>
  <script type="text/javascript">
    function goPage(p) {
        var page = document.getElementById("page");
        page.value = p;
        document.forms[0].submit();
    }
  </script>
</html>
