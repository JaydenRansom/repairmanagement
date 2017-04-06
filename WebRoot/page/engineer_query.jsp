<%@page import="java.util.*"%>
<%@page import="com.heuzoo.repairmanager.bean.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'newSattleResultShow.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="http://fonts.useso.com/css?family=Arimo:400,700,400italic">
	<link rel="stylesheet" href="assets/css/fonts/linecons/css/linecons.css">
	<link rel="stylesheet" href="assets/css/fonts/fontawesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/bootstrap.css">
	<link rel="stylesheet" href="assets/css/xenon-core.css">
	<link rel="stylesheet" href="assets/css/xenon-forms.css">
	<link rel="stylesheet" href="assets/css/xenon-components.css">
	<link rel="stylesheet" href="assets/css/xenon-skins.css">
	<link rel="stylesheet" href="assets/css/custom.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script src="assets/js/jquery-1.11.1.min.js"></script>

  </head>
  
  <body>
    <body class="page-body"> 


	
	<div class="page-container"><!-- add class "sidebar-collapsed" to close sidebar by default, "chat-visible" to make chat appear always -->
			
		<!-- Add "fixed" class to make the sidebar fixed always to the browser viewport. -->
		<!-- Adding class "toggle-others" will keep only one menu item open at a time. -->
		<!-- Adding class "collapsed" collapse sidebar root elements and show only icons. -->
		<div class="sidebar-menu toggle-others fixed">
			
			<div class="sidebar-menu-inner">	
				
				<header class="logo-env">
					
					<!-- logo -->
					<div class="logo">
						<a href="dashboard-1.html" class="logo-expanded">
							<img src="assets/images/logo@2x.png" width="80" alt="" />
						</a>
						
						<a href="dashboard-1.html" class="logo-collapsed">
							<img src="assets/images/logo-collapsed@2x.png" width="40" alt="" />
						</a>
					</div>
					
					<!-- This will toggle the mobile menu and will be visible only on mobile devices -->
					<div class="mobile-menu-toggle visible-xs">
						<a href="#" data-toggle="user-info-menu">
							<i class="fa-bell-o"></i>
							<span class="badge badge-success">7</span>
						</a>
						
						<a href="#" data-toggle="mobile-menu">
							<i class="fa-bars"></i>
						</a>
					</div>
					
					<!-- This will open the popup with user profile settings, you can use for any purpose, just be creative -->
					
					
								
				</header>
						
				
						
				<ul id="main-menu" class="main-menu">
					<!-- add class "multiple-expanded" to allow multiple submenus to open -->
					<!-- class "auto-inherit-active-class" will automatically add "active" class for parent elements who are marked already with class "active" -->
					<li>
						<a href="dashboard-1.html">
							<i class="linecons-cog"></i>
							<span class="title">客服角色模块</span>
						</a>
						<ul>
							<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">客户查询与报修</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">客户注册</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">报修信息查询</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">设备信息查询</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">结算管理</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">结算信息查询</span>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="/RepairManagement/page/sorry.html">
							<i class="linecons-desktop"></i>
							<span class="title">任务调度角色模块</span>
						</a>
						<ul>
							<li>
								<a href="/RepairManagement/page/sorry.html">
									<span class="title">维修管理模块</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/page/sorry.html">
									<span class="title">查询维修任务</span>
								</a>
							</li>							
						</ul>
					</li>
					<li>
						<a href="/RepairManagement/page/sorry.html">
							<i class="linecons-note"></i>
							<span class="title">技术工程师角色模块</span>
						</a>
						<ul>
							<li>
								<a href="/RepairManagement/page/FaultRepairUserServlet?type=3&emp_no=${sessionScope.userNo }">
									<span class="title">处理维修任务</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/page/FaultRepairUserServlet?type=4&emp_no=${sessionScope.userNo }">
									<span class="title">查询所有维修任务</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/page/engineer_sparepart.jsp">
									<span class="title">备件流水登记</span>
								</a>
							</li>							
						</ul>
					</li>
					<li>
						<a href="/RepairManagement/page/sorry.html">
							<i class="linecons-cog"></i>
							<span class="title">备件管理模块</span>
						</a>
						<ul>
							<li>
								<a href="/RepairManagement/page/sorry.html">
									<span class="title">备件登记</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/page/sorry.html">
									<span class="title">备件信息查询</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/page/sorry.html">
									<span class="title">备件入库</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/page/sorry.html">
									<span class="title">备件出库</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/page/sorry.html">
									<span class="title">备件入库流水查询</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/page/sorry.html">
									<span class="title">备件出库流水查询</span>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="mailbox-main.html">
							<i class="linecons-mail"></i>
							<span class="title">财务人员角色模块</span>
						</a>
						<ul>
							<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">结算信息查询</span>
								</a>
							</li>
						</ul>
					</li>	
					<li>
						<a href="ui-panels.html">
							<i class="linecons-note"></i>
							<span class="title">运营监督角色模块</span>
						</a>
						<ul>
							<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">监控报修</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">监控维修</span>
								</a>
							</li>
								<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">监控结算</span>
								</a>
							</li>
						</ul>
					</li>
					<li><a href="/RepairManagement/page/login.html">&nbsp;&nbsp;&nbsp;&nbsp;
					退出系统</a>
					</li>	
						</ul>
					</li>
				</ul>
						
			</div>
			
		</div>
		<!--到这里左边栏结束了-->
	  <div class="main-content">
			<!--这里是页面最上边一行显示的用户信息之类的东西-->		
			<!-- User Info, Notifications and Menu Bar -->
			<nav class="navbar user-info-navbar" role="navigation">
				
				<!-- Left links for user info navbar -->
				<ul class="user-info-menu left-links list-inline list-unstyled">
					
					<li class="hidden-sm hidden-xs">
						<a href="#" data-toggle="sidebar">
							<i class="fa-bars"></i>
						</a>
					</li>
					
					
					
				</ul>
				
				
				<!-- Right links for user info navbar -->
				<ul class="user-info-menu right-links list-inline list-unstyled">
					
					
					
					<li class="dropdown user-profile">
						<a href="#" data-toggle="dropdown">
							<img src="assets/images/user-4.png" alt="user-image" class="img-circle img-inline userpic-32" width="28" />
							<span>
								<%
									String name = (String)session.getAttribute("userName");
									int type = Integer.parseInt(String.valueOf(session.getAttribute("userType")));
								%>
								<%=name %>
								<i class="fa-angle-down"></i>
							</span>
						</a>
						
						<ul class="dropdown-menu user-profile-menu list-unstyled">
							<li>
								<a href="#edit-profile">
									<i class="fa-edit"></i>
									New Post
								</a>
							</li>
							<li>
								<a href="#settings">
									<i class="fa-wrench"></i>
									Settings
								</a>
							</li>
							<li>
								<a href="#profile">
									<i class="fa-user"></i>
									Profile
								</a>
							</li>
							<li>
								<a href="#help">
									<i class="fa-info"></i>
									Help
								</a>
							</li>
							<li class="last">
								<a href="extra-lockscreen.html">
									<i class="fa-lock"></i>
									Logout
								</a>
							</li>
						</ul>
					</li>
					
				</ul>
				
			</nav>
            <!--这里是正文的开头上面的那一部分（hint）-->
			<div class="page-title">
				<!--这个是这个页面的hint -->
			  <div class="title-env">
					<h1 class="title">维修单处理模块</h1>
					<p class="description">您可以在这里维护被分配给您的维修单信息</p>
				</div>
				
					
			</div>
		
            <!--页面的正文信息-->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">维修信息查询</h3>
					<div class="panel-options">
						<a href="#" data-toggle="panel">
							<span class="collapse-icon">&ndash;</span>
							<span class="expand-icon">+</span>
						</a>
						<a href="#" data-toggle="remove">
							&times;
						</a>
					</div>
				</div>
				<div class="panel-body">
                	<script type="text/javascript">
					jQuery(document).ready(function($)
					{
						$("#example-1").dataTable({
							aLengthMenu: [
								[10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]
							]
						});
					});
					</script>
					<table id="example-1" class="table table-striped table-bordered" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>维修单号</th>
								<th>维修记录</th>
								<th>工作量</th>
								<th>维修承诺</th>
								<th>人工费</th>
								<th>成本费</th>
								<th>维修单状态</th>
							</tr>
						</thead>
					
					
						<tbody>
							<c:forEach items="${data}" var="u">
								<tr>
									<td>${u.repairNo}</td>
									<td>${u.repairRepairRecord}</td>
									<td>${u.repairWorkload}</td>
									<td>${u.repairCommitment }</td>
									<td>${u.repairManualCost }</td>
									<td>${u.repairMaterialCost }</td>
									<td>
										<c:choose>
									      <c:when test="${u.repairState=='1'}">待处理</c:when>
									      <c:when test="${u.repairState=='2'}">已分配</c:when>
									      <c:when test="${u.repairState=='3'}">已完成</c:when>
									      <c:when test="${u.repairState=='4'}">已取消</c:when>
									    </c:choose>
									</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>	
			  </div>
			</div>
			<!-- Main Footer -->
			<!-- Choose between footer styles: "footer-type-1" or "footer-type-2" -->
			<!-- Add class "sticky" to  always stick the footer to the end of page (if page contents is small) -->
			<!-- Or class "fixed" to  always fix the footer to the end of page -->
			<footer class="main-footer sticky footer-type-1">
				
				<div class="footer-inner">
				
					<!-- Add your copyright text here -->
					<div class="footer-text" align="center">
						&copy; 2016 
						<strong>哈工程</strong> 
						动物园学习小组
					</div>
					
					
					<!-- Go to Top Link, just add rel="go-top" to any link to add this functionality -->
					<div class="go-up">
					
						<a href="#" rel="go-top">
							<i class="fa-angle-up"></i>
						</a>
						
					</div>
					
				</div>
				
			</footer>
		</div>
	<!-- Imported styles on this page -->
	<link rel="stylesheet" href="${basePath }assets/js/datatables/dataTables.bootstrap.css">

	<!-- Bottom Scripts -->
	<script src="${basePath }assets/js/bootstrap.min.js"></script>
	<script src="${basePath }assets/js/TweenMax.min.js"></script>
	<script src="${basePath }assets/js/resizeable.js"></script>
	<script src="${basePath }assets/js/joinable.js"></script>
	<script src="${basePath }assets/js/xenon-api.js"></script>
	<script src="${basePath }assets/js/xenon-toggles.js"></script>
	<script src="${basePath }assets/js/datatables/js/jquery.dataTables.min.js"></script>


	<!-- Imported scripts on this page -->
	<script src="${basePath }assets/js/datatables/dataTables.bootstrap.js"></script>
	<script src="${basePath }assets/js/datatables/yadcf/jquery.dataTables.yadcf.js"></script>
	<script src="${basePath }assets/js/datatables/tabletools/dataTables.tableTools.min.js"></script>
	<!-- Bottom Scripts -->
	<script src="${basePath }assets/js/bootstrap.min.js"></script>
	<script src="${basePath }assets/js/TweenMax.min.js"></script>
	<script src="${basePath }assets/js/resizeable.js"></script>
	<script src="${basePath }assets/js/joinable.js"></script>
	<script src="${basePath }assets/js/xenon-api.js"></script>
	<script src="${basePath }assets/js/xenon-toggles.js"></script>


	<!-- Imported scripts on this page -->
	<script src="${basePath }assets/js/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="${basePath }assets/js/jvectormap/regions/jquery-jvectormap-world-mill-en.js"></script>
	<script src="${basePath }assets/js/jvectormap/regions/jquery-jvectormap-it-mill-en.js"></script>


	<!-- JavaScripts initializations and stuff -->
	<script src="${basePath }assets/js/xenon-custom.js"></script>

</body>
  </body>
  <script>
	function doQuery(){
		document.forms[0].submit();
	}
	
	</script>
</html>
