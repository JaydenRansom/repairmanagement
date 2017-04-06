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

  <body>
    <div>
      <form action = "/RepairManagement/servlet/AddFaultReport" method = "post">
        <table>
          <tr>
            <td>设备编号</td>
            <td>${data}</td>
          </tr>
          <tr>
            <td>客户ID</td>
            <td><input type="text" name="customerId"></td>
          </tr>
          <tr>
            <td>提交时间</td>
            <td><input type="text" name="time"></td>
          </tr>
          <tr>
            <td>预估价格</td>
            <td><input type="text" name="price"></td>
          </tr>
          <tr>
            <td>预估完成时间</td>
            <td><input type="text" name="finish"></td>
          </tr>
          <tr>
            <td>报修状态</td>
            <td><input type="text" name="state"></td>
          </tr>
        </table>
      </form>
      <button onclick="commitFaultReport()">commit</button>
    </div>
  </body>
  <script type="text/javascript">
    function commitFaultReport() {
      document.forms[0].submit();
    }
  </script>
</html>
