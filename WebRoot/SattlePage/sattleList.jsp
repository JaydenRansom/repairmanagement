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
    
    <title>结算确认单打印界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta name="description" content="Xenon Boostrap Admin Panel" />
	<meta name="author" content="" />
	
	<title></title>

	<link rel="stylesheet" href="http://fonts.useso.com/css?family=Arimo:400,700,400italic">
	<link rel="stylesheet" href="assets/css/fonts/linecons/css/linecons.css">
	<link rel="stylesheet" href="assets/css/fonts/fontawesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/css/bootstrap.css">
	<link rel="stylesheet" href="assets/css/xenon-core.css">
	<link rel="stylesheet" href="assets/css/xenon-forms.css">
	<link rel="stylesheet" href="assets/css/xenon-components.css">
	<link rel="stylesheet" href="assets/css/xenon-skins.css">
	<link rel="stylesheet" href="assets/css/custom.css">

	<script src="assets/js/jquery-1.11.1.min.js"></script>
	<script src="/RepairManagement/jQuery.print-master/jQuery.print.js"></script>
	
  </head>
  
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
								<a href="/RepairManagement/CustomerInfo/form-findqi.jsp">
									<span class="title">客户查询与报修</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/CustomerInfo/form-nativeqi.jsp">
									<span class="title">客户注册</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/servlet/QueryFaultReport">
									<span class="title">报修信息查询</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/servlet/QueryDevice">
									<span class="title">设备信息查询</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/SattlePage/newSattleReady.jsp">
									<span class="title">结算管理</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/servlet/SattleViewServlet">
									<span class="title">结算信息查询</span>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="layout-variants.html">
							<i class="linecons-desktop"></i>
							<span class="title">任务调度角色模块</span>
						</a>
						<ul>
							<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">维修管理</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">查询维修任务</span>
								</a>
							</li>

						</ul>
					</li>
					<li>
						<a href="ui-panels.html">
							<i class="linecons-note"></i>
							<span class="title">技术工程师角色模块</span>
						</a>
						<ul>
							<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">维修管理</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">查询维修任务</span>
								</a>
							</li>
								<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">备件流水登记</span>
								</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="mailbox-main.html">
							<i class="linecons-mail"></i>
							<span class="title">库管角色模块</span>
						</a>
						<ul>
							<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">备件登记</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">备件信息查询</span>
								</a>
							</li>
							<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">备件入库</span>
								</a>
							</li>
														<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">备件出库</span>
								</a>
							</li>
														<li>
								<a href="/RepairManagement/sorry.html">
									<span class="title">备件入库流水查询</span>
								</a>
							</li>
														<li>
								<a href="/RepairManagement/sorry.html">
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
					<li><a href="/RepairManagement/login.html">&nbsp;&nbsp;&nbsp;&nbsp;
					退出系统</a>
					</li>	
					
						</ul>
					</li>
				</ul>
                        
            </div>
            
        </div>
        <div class="main-content">
            <!--ÕâÀïÊÇÒ³Ãæ×îÉÏ±ßÒ»ÐÐÏÔÊ¾µÄÓÃ»§ÐÅÏ¢Ö®ÀàµÄ¶«Î÷-->     
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
            <div class="page-title">
               
              <div class="title-env">
                    <h1 class="title">结算清单</h1>
                    <p class="description">在这里，您可以和您的客户一起确认维修信息</p>
                </div>
                    
              <div class="breadcrumb-env">
                    
                                <ol class="breadcrumb bc-1">
                                    <li>
                            <a href="/RepairManagement/Aindex.jsp"><i class="fa-home"></i>主页</a>
                        </li>
                               
                                </ol>
                                
                </div>
                    
            </div>
         <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title" align="center">结算清单确认</h3>
                    
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
        
								
	<!-- Bordered + Striped Table -->
	<strong>您的维修信息如下：</strong>
									
	<table class="table table-bordered table-striped" id="printtable">
		<tr>
        	<td colspan="4" align="center" >动物园维修站结算单</td>
            
        </tr>
        <tr>
        	<td align="center">维修单号：</td>
            <td align="center">${repairinfo.repairNo }</td>
            <td align="center"></td>
            <td align="center"></td>
        </tr>
        <tr>
        	<td align="center">接修日期：</td>
            <td align="center">${repairinfo.repairArrangeTime }</td>
            <td align="center">修复日期：</td>
            <td align="center">${repairinfo.repairRepairTime }</td>
        </tr>
        <tr>
        	<td align="center">产品类型：</td>
            <td align="center">${stringDeviceType }</td>
            <td align="center">机器品牌：</td>
            <td align="center">${device.deviceBrand }</td>
        </tr>
        <tr>
        	<td align="center">机器型号：</td>
            <td align="center">${device.deviceModel }</td>
            <td align="center">机器序列号：</td>
            <td align="center">${device.deviceSeries }</td>
        </tr>
        <tr>
        	<td align="center">单位名称：</td>
            <td align="center">${customer.customerOffice }</td>
            <td align="center">维修联系人：</td>
            <td align="center">${customer.customerName }</td>
        </tr>
        <tr>
        	<td align="center">合计金额：</td>
            <td align="center">${allcharge }</td>
            <td align="center">人工及材料费：</td>
            <td align="center">${manualmatercharge }</td>
        </tr>
       <tr>
        	<td colspan="4" align="center">机器故障现象：</td>
            
  </tr>
        <tr>
        	<td colspan="4" align="center">${device.deviceFaultAppearance }</td>
            
  </tr>
        <tr>
        	<td colspan="2" align="center">保修承诺：</td>
            
            <td colspan="2" align="center">我司承诺在维修后的十五天内内出现问题免费再次维修</td>
            
  </tr>
        <tr>
        	<td colspan="2" align="center">注意事项：</td>
            
            <td colspan="2" align="center">硬件维修过后要小心使用，软件要避免破坏性使用</td>
            
  		</tr>
        <tr>
        	<td align="center">部件名称：</td>
            <td align="center">型号</td>
            <td align="center">数量</td>
            <td align="center">单价</td>
        </tr>
        <c:forEach items="${partersattleinfo}" var="u">
        <tr>
        	<td align="center">${u.parterName }</td>
            <td align="center">${u.parterType }</td>
            <td align="center">${u.parterCount }</td>
            <td align="center">${u.parterPrice }</td>
        </tr>
        </c:forEach>
	</table>
</div>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h3>客户签字：
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客服签字：</h3>
<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-info" onclick="jQuery('#printtable').print({iframe:false})">打印确认单</button>
<a href="/RepairManagement/servlet/SattleServlet?repairno=${repairinfo.repairNo }"><button class="btn btn-blue" align="right">确认无误并提交</button></a>
</div>
<footer class="main-footer sticky footer-type-1">
                
                <div class="footer-inner">
                
                    <!-- Add your copyright text here -->
                    <div class="footer-text">
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
        <link rel="stylesheet" href="assets/js/datatables/dataTables.bootstrap.css">

    <!-- Bottom Scripts -->
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/TweenMax.min.js"></script>
    <script src="assets/js/resizeable.js"></script>
    <script src="assets/js/joinable.js"></script>
    <script src="assets/js/xenon-api.js"></script>
    <script src="assets/js/xenon-toggles.js"></script>


    <!-- JavaScripts initializations and stuff -->
    <script src="assets/js/xenon-custom.js"></script>
    </div>
    <script src="/RepairManagement/jQuery.print-master/jQuery.print.js"></script>
</body>
</html>
