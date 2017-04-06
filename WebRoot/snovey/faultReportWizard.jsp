<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.heuzoo.repairmanager.bean.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html lang="en">
<head>
  <base href="<%=basePath%>">


  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">

  <link rel="stylesheet" type="text/css" href="styles.css">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script type="javascript" src="Ajax.js"></script>

  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta name="description" content="Xenon Boostrap Admin Panel" />
  <meta name="author" content="" />

  <title>设备维修系统</title>
  <!-- Bootstrap -->
  <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
  <!-- Font Awesome -->
  <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <!-- NProgress -->
  <link href="vendors/nprogress/nprogress.css" rel="stylesheet">

  <!-- Custom Theme Style -->
  <link href="build/css/custom.min.css" rel="stylesheet">

  <link rel="stylesheet" href="http://fonts.useso.com/css?family=Arimo:400,700,400italic">
  <link rel="stylesheet" href="assets/css/fonts/linecons/css/linecons.css">
  <link rel="stylesheet" href="assets/css/fonts/fontawesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="assets/css/bootstrap.css">
  <link rel="stylesheet" href="assets/css/xenon-core.css">
  <link rel="stylesheet" href="assets/css/xenon-forms.css">
  <link rel="stylesheet" href="assets/css/xenon-components.css">
  <link rel="stylesheet" href="assets/css/xenon-skins.css">
  <link rel="stylesheet" href="assets/css/custom.css">
  <link rel="stylesheet" type="text/css" href="vendors/sweetalert/dist/sweetalert.css">

  <script src="assets/js/jquery-1.11.1.min.js"></script>

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
    <script src="assets/js/html5shiv.min.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->


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
          <h1 class="title">欢迎使用本系统</h1>
          <p class="description">Here Start Everything</p>
        </div>
          <!-- 这个是显示该页面的路径和依赖-->
        <div class="breadcrumb-env">

                <ol class="breadcrumb bc-1">
                  <li>
              <a href=#><i class="fa-home"></i>主页</a>
            </li>

                </ol>

        </div>

      </div>
    <!--页面的正文信息-->
    <div class="panel panel-default">
      <div class="panel-heading">
        <h3 class="panel-title">报修流程</h3>
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
        <div id="wizard" class="form_wizard wizard_horizontal">
          <ul class="wizard_steps">
            <li>
              <a href="#step-1">
                <span class="step_no">1</span>
                <span class="step_descr">
                  Step 1<br />
                  <small>设备信息</small>
                </span>
              </a>
            </li>
            <li>
              <a href="#step-2">
                <span class="step_no">2</span>
                <span class="step_descr">
                  Step 2<br />
                  <small>报修信息</small>
                </span>
              </a>
            </li>
            <li>
              <a href="#step-3">
                <span class="step_no">3</span>
                <span class="step_descr">
                  Step 3<br />
                  <small>确认订单</small>
                </span>
              </a>
            </li>
            <li>
              <a href="#step-4">
                <span class="step_no">4</span>
                <span class="step_descr">
                  Step 4<br />
                  <small>提交维修</small>
                </span>
              </a>
            </li>
          </ul>
          <div id="step-1">
            <form class="form-horizontal form-label-left" id="deviceInfo">

              <div class="form-group item">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">序列号 <span class="required">*</span>
                </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input type="text" class="form-control col-md-7 col-xs-12" placeholder="必填" id="deviceSeries" onblur="validate()">
                </div>
                <span class="form-control alert" id="checkSeries"></span>
              </div>
              <div class="form-group item input">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">产品类型 <span class="required">*</span>
                </label>
                <div class="col-md-6 col-sm-6 col-xs-12 input">
                  <script type="text/javascript">
                    jQuery(document).ready(function($)
                    {
                      $("#deviceType").selectBoxIt({
                        showEffect: 'fadeIn',
                        hideEffect: 'fadeOut'
                      });
                    });
                  </script>

                  <select class="form-control col-md-7 col-xs-12" id="deviceType" onchange="checkDeviceType()">
                    <option value="0">选择设备类型</option>
                    <option value="1">台式机</option>
                    <option value="2">笔记本</option>
                    <option value="3">投影仪</option>
                    <option value="4">打印机</option>
                    <option value="5">其他</option>
                  </select>
                </div>
                <span class="form-control alert" id="checkDevice"></span>
              </div>
              <div class="form-group input">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">机器品牌 </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input class="form-control col-md-7 col-xs-12" type="text" name="middle-name" id="deviceBrand">
                </div>
              </div>
              <div class="form-group input">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">机器型号 </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input class="form-control col-md-7 col-xs-12" type="text" name="middle-name" id="deviceModel">
                </div>
              </div>
              <div class="form-group input">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">缺少零件 </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input class="form-control col-md-7 col-xs-12" type="text" name="middle-name" id="deviceLack">
                </div>
              </div>
              <div class="form-group item input">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">机器故障现象 <span class="required">*</span>
                </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input class="form-control col-md-7 col-xs-12" type="text" name="middle-name" id="deviceFaultAppearance">
                </div>
                <span class="form-control item alert" id="checkFaultAppearance"></span>
              </div>
              <div class="form-group item input">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">故障类型 <span class="required">*</span>
                </label>
                <div class="col-md-6 col-sm-6 col-xs-12 input">
                  <script type="text/javascript">
                    jQuery(document).ready(function($)
                    {
                      $("#deviceFaultType").selectBoxIt({
                        showEffect: 'fadeIn',
                        hideEffect: 'fadeOut'
                      });
                    });
                  </script>

                  <select class="form-control col-md-7 col-xs-12" id="deviceFaultType">
                    <option>选择故障类型</option>
                    <option value="1">固定性故障</option>
                    <option value="2">间隙性故障</option>
                  </select>
                </div>
                  <span class="form-control item bad alert" id="checkFaultType">未选择故障类型</span>
              </div>
              <div class="form-group input">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">机器外观检查 </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input class="form-control col-md-7 col-xs-12" type="text" name="middle-name" id="deviceSurface">
                </div>
              </div>
              <div class="form-group input">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">开机口令 </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input class="form-control col-md-7 col-xs-12" type="text" name="middle-name" id="devicePassword">
                </div>
              </div>
              <div class="form-group input">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">重要资料 </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input type="text" name="last-name" required class="form-control col-md-7 col-xs-12" id="deviceImpFile">
                </div>
              </div>
              <div class="form-group input">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">HDD </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input class="form-control col-md-7 col-xs-12" type="text" name="middle-name" id="deviceHDD">
                </div>
              </div>
              <div class="form-group input">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">内存 </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input class="form-control col-md-7 col-xs-12" type="text" name="middle-name" id="deviceMemory">
                </div>
              </div>
              <div class="form-group input">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">外置PC卡 </label>
                <div class="col-md-6 col-sm-6 col-xs-12" id="devicePC">
                  <input class="form-control col-md-7 col-xs-12" type="text" name="middle-name">
                </div>
              </div>
              <div class="form-group input">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">AC适配器 </label>
                <div class="col-md-6 col-sm-6 col-xs-12" id="deviceAC">
                  <input class="form-control col-md-7 col-xs-12" type="text" name="middle-name">
                </div>
              </div>
              <div class="form-group input">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">电池 </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input class="form-control col-md-7 col-xs-12" type="text" name="middle-name" id="deviceBattery">
                </div>
              </div>
              <div class="form-group input">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">外接光驱 </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input class="form-control col-md-7 col-xs-12" type="text" name="middle-name" id="deviceDVD">
                </div>
              </div>
              <div class="form-group input">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">其他 </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input class="form-control col-md-7 col-xs-12" type="text" name="middle-name" id="deviceOther">
                </div>
              </div>
            </form>
          </div>
          <div id="step-2">
            <h2 class="StepTitle">Step 2 Content</h2>
            <form class="form-horizontal form-label-left">

              <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name" >报修设备 <span class="required">*</span>
                </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input type="text" required class="form-control col-md-7 col-xs-12" id="reportDevice" >
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">报修用户ID <span class="required">*</span>
                </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input type="text" id="reportCustomerId" name="device" required class="form-control col-md-7 col-xs-12" value="${customerInfo.customerId}">
                </div>
              </div>
              <div class="form-group">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">报修时间 </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input type="text" class="form-control datepicker col-md-7 col-xs-12" data-start-date="0d" data-end-date="+1w" id="reportTime">
                </div>
              </div>
              <div class="form-group">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">预估价格 </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input class="form-control col-md-7 col-xs-12" type="text" name="price" id="reportPrice">
                </div>
              </div>
              <div class="form-group">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">预估完成时间 </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input type="text" class="form-control datepicker col-md-7 col-xs-12" data-start-date="0d" data-end-date="+1w" id="reportFinish">
                </div>
              </div>
              <div class="form-group">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">报修状态 <span class="required">*</span>
                </label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <script type="text/javascript">
                    jQuery(document).ready(function($)
                    {
                      $("#reportState").selectBoxIt({
                        showEffect: 'fadeIn',
                        hideEffect: 'fadeOut'
                      });
                    });
                  </script>

                  <select class="form-control col-md-7 col-xs-12" id="reportState">
                    <option>选择报修状态</option>
                    <option value="1">进行中</option>
                    <option value="2">结束</option>
                    <option value="3">撤销</option>
                  </select>
                </div>
              </div>
            </form>
          </div>
          <div id="step-3">
            <h2 class="StepTitle">Step 4 Content</h2>
            <div class="row">
              <div class="col-sm-12">

                <!-- Table Model 2 -->
                <strong>Table Model 2</strong>
                <div id="printTable">
                  <table class="table table-bordered table-striped">
                    <tr>
                      <td colspan="4" style="text-align:center">***HEUZOO有限公司取机凭证***</td>
                    </tr>
                    <tr>
                      <td>接修日期</td>
                      <td><span id="mydate"></span></td>
                      <td>报修编号</td>
                      <td><span id="myreportno"></span></td>
                    </tr>
                    <tr>
                      <td>产品类型</td>
                      <td><span id="mytype"></span></td>
                      <td>机器品牌</td>
                      <td><span id="mybrand"></span></td>
                    </tr>
                    <tr>
                      <td>机器型号 </td>
                      <td><span id="mymodel"></span></td>
                      <td>系列号</td>
                      <td><span id=myseries></span></td>
                    </tr>
                    <tr>
                      <td>单位名称</td>
                      <td>${customerInfo.customerOffice}</td>
                      <td>联系人</td>
                      <td>${customerInfo.customerName}</td>
                    </tr>
                    <tr>
                      <td colspan="4" style="text-align:center">机器故障现象</td>
                    </tr>
                    <tr>
                      <td colspan="4" style="text-align:center"><span id="myfaultappearance"></span></td>
                    </tr>
                    <tr>
                      <td colspan="2"  style="text-align:center">缺少零件</td>
                      <td colspan="2"  style="text-align:center">随机附件</td>
                    </tr>
                    <tr>
                      <td colspan="2" style="text-align:center"><span id="mydevicelack"></span></td>
                      <td colspan="2" style="text-align:center"><span id="myfujian"></span></td>
                    </tr>
                  </table>
                  <div class="col-sm-12">
                    <table class="table responsive">
                      <tr>
                        <td>接机签字：</td>
                        <td></td>
                        <td>机主签字：</td>
                        <td></td>
                        <td>打印时间：</td>
                        <td></td>
                      </tr>
                    </table>
                  </div>
                </div>

              </div>
              <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3" style="text-align:center">
                          <button class="btn btn-success" type="submit" onclick="printIt()">打印订单</button>
                          <button class="btn btn-primary" type="submit" onclick="cancelOrder()">取消订单</button>
                        </div>
           </div>
         </div>
         <div id="step-4">
          <table class="table table-bordered table-striped">
            <thead>
             <tr>
              <th>报修编号</th>
              <th>维修状态</th>
            </tr>
          </thead>

          <tbody>
           <tr>
             <td><span id="reportNo"></span></td>
             <td><span id="repairState">待维修</span></td>
           </tr>
         </tbody>
       </table>
     </div>

   </div>
   <!-- End SmartWizard Content -->
 </div>
</div>
<!-- Main Footer -->
<!-- Choose between footer styles: "footer-type-1" or "footer-type-2" -->
<!-- Add class "sticky" to  always stick the footer to the end of page (if page contents is small) -->
<!-- Or class "fixed" to  always fix the footer to the end of page -->
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
<!-- Imported styles on this page -->
<link rel="stylesheet" href="assets/js/datatables/dataTables.bootstrap.css">

<!-- Bottom Scripts -->
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/TweenMax.min.js"></script>
<script src="assets/js/resizeable.js"></script>
<script src="assets/js/joinable.js"></script>
<script src="assets/js/xenon-api.js"></script>
<script src="assets/js/xenon-toggles.js"></script>
<script src="assets/js/datatables/js/jquery.dataTables.min.js"></script>
<script src="assets/js/moment.min.js"></script>


<!-- Imported scripts on this page -->
<script src="assets/js/datatables/dataTables.bootstrap.js"></script>
<script src="assets/js/datatables/yadcf/jquery.dataTables.yadcf.js"></script>
<script src="assets/js/datatables/tabletools/dataTables.tableTools.min.js"></script>
<script src="assets/js/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="assets/js/jvectormap/regions/jquery-jvectormap-world-mill-en.js"></script>
<script src="assets/js/jvectormap/regions/jquery-jvectormap-it-mill-en.js"></script>


<!-- Imported scripts on this page -->
<script src="assets/js/daterangepicker/daterangepicker.js"></script>
<script src="assets/js/datepicker/bootstrap-datepicker.js"></script>
<script src="assets/js/timepicker/bootstrap-timepicker.min.js"></script>
<script src="assets/js/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="assets/js/select2/select2.min.js"></script>
<script src="assets/js/jquery-ui/jquery-ui.min.js"></script>
<script src="assets/js/selectboxit/jquery.selectBoxIt.min.js"></script>
<script src="assets/js/tagsinput/bootstrap-tagsinput.min.js"></script>
<script src="assets/js/typeahead.bundle.js"></script>
<script src="assets/js/handlebars.min.js"></script>
<script src="assets/js/multiselect/js/jquery.multi-select.js"></script>


<!-- JavaScripts initializations and stuff -->
<script src="assets/js/xenon-custom.js"></script>
<!-- jQuery -->
<script src="vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="vendors/nprogress/nprogress.js"></script>
<!-- jQuery Smart Wizard -->
<script src="vendors/jQuery-Smart-Wizard/js/jquery.smartWizard.js"></script>
<!-- Custom Theme Scripts -->
<script src="build/js/custom.min.js"></script>
<!-- validator -->
<script src="vendors/validator/validator.js"></script>
<script src="vendors/sweetalert/dist/sweetalert.min.js""></script>
<script src="vendors/jQueryPrint/jQuery.print.js"></script>


<!-- jQuery Smart Wizard -->
<script>
  $(document).ready(function(){
      // Smart Wizard
      $('#wizard').smartWizard({
        onLeaveStep:leaveAStepCallback,
        onFinish:onFinishCallback
      });

      function leaveAStepCallback(obj, context){
          //alert("Leaving step " + context.fromStep + " to go to step " + context.toStep);
          return validateSteps(context.fromStep); // return false to stay on step and true to continue navigation
          // return true;
        }

        function onFinishCallback(objs, context){
            if(validateAllSteps()){
              var flag = false;
              $.ajax({
                type:"post",//post方法
                async:false,
                url:"/RepairManagement/servlet/AddFaultRepair",
                data:{
                  'reportNo':$("#reportNo").html(),
                  'repairState':'1',},
                //ajax成功的回调函数
                success:function(data){
                  flag = true;
                }
              });
              return flag;
          }
        }

      // Your Step validation logic
      function validateSteps(stepnumber){
          // var isStepValid = true;
          // validate step 1
          if (stepnumber == 1) {
              var flag = false;
              $.ajax({
                type:"post",//post方法
                async:false,
                url:"/RepairManagement/servlet/AddDevice",
                data:{
                  'deviceSeries':$("#deviceSeries").val(),
                  'deviceType':$("#deviceType").val(),
                  'deviceBrand':$("#deviceBrand").val(),
                  'deviceModel':$("#deviceModel").val(),
                  'deviceLack':$("#deviceLack").val(),
                  'deviceFaultAppearance':$("#deviceFaultAppearance").val(),
                  'deviceFaultType':$("#deviceFaultType").val(),
                  'deviceSurface':$("#deviceSurface").val(),
                  'devicePassword':$("#devicePassword").val(),
                  'deviceImpFile':$("#deviceImpFile").val(),
                  'deviceHDD':$("#deviceHDD").val(),
                  'deviceMemory':$("#deviceMemory").val(),
                  'devicePC':$("#devicePC").val(),
                  'deviceAC':$("#deviceAC").val(),
                  'deviceBattery':$("#deviceBattery").val(),
                  'deviceDVD':$("#deviceDVD").val(),
                  'deviceOther':$("#deviceOther").val(),},
                //ajax成功的回调函数
                success:function(data){
                 if(data!= -1) {
                     flag = true;
                     $("#reportDevice").val(data);
                     } else {
                       flag = false;
                     }

                  }
              });
              return flag;
              // Your step validation logic
              // set isStepValid = false if has errors
          } else if  (stepnumber == 2) {
              document.getElementById("mydate").innerHTML=document.getElementById("reportTime").value;
              document.getElementById("mytype").innerHTML=document.getElementById("deviceType").options[document.getElementById("deviceType").selectedIndex].text;
              document.getElementById("mybrand").innerHTML=document.getElementById("deviceBrand").value;
              document.getElementById("mymodel").innerHTML=document.getElementById("deviceModel").value;
              document.getElementById("myseries").innerHTML=document.getElementById("deviceSeries").value;
              document.getElementById("myfaultappearance").innerHTML=document.getElementById("deviceFaultAppearance").value;
              document.getElementById("mydevicelack").innerHTML=document.getElementById("deviceLack").value;
              var flag = false;
              $.ajax({
                type:"post",//post方法
                async:false,
                url:"/RepairManagement/servlet/AddFaultReport",
                data:{
                  'reportDevice':$("#reportDevice").val(),
                  'reportCustomerId':$("#reportCustomerId").val(),
                  'reportTime':$("#reportTime").val(),
                  'reportPrice':$("#reportPrice").val(),
                  'reportFinish':$("#reportFinish").val(),
                  'reportState':$("#reportState").val(),},
                //ajax成功的回调函数
                success:function(data){
                    if(data != -1){
                        $("#myreportno").html(data);
                        $("#reportNo").html(data);
                        flag = true;
                    }
                }
              });
              return flag;
          } else if  (stepnumber == 3) {
              return true;
          } else if  (stepnumber == 4) {
              return true;
          }
        }
        function validateAllSteps(){
          var isStepValid = true;
          swal({
          title: "报修成功",
          text: "3 秒钟后将跳转至首页",
          type: "success",
          timer: 3000,
          showConfirmButton: false,
          animation: "slide-from-top"
        }, function () {window.open('http://localhost:8888/RepairManagement/Aindex.jsp','_self')});
          // all step validation logic
          return isStepValid;
        }
      });
  $(document).ready(function() {
    $('#wizard').smartWizard();

    $('#wizard_verticle').smartWizard({
      transitionEffect: 'slide'
    });

    $('.buttonNext').addClass('btn btn-success');
    $('.buttonPrevious').addClass('btn btn-primary');
    $('.buttonFinish').addClass('btn btn-default');
  });
</script>
<script>
  var req;
  function validate() {
          //获取表单提交的内容
          var idField = document.getElementById("deviceSeries");
          // alert(idField.value);
          //访问validate.do这个servlet，同时把获取的表单内容idField加入url字符串，以便传递给validate.do
          var url = "/RepairManagement/servlet/SnoveyQueryDevice?deviceSeries=" + escape(idField.value);
          //创建一个XMLHttpRequest对象req
          if(window.XMLHttpRequest) {
              //IE7, Firefox, Opera支持
              req = new XMLHttpRequest();
            }else if(window.ActiveXObject) {
              //IE5,IE6支持
              req = new ActiveXObject("Microsoft.XMLHTTP");
            }
          /*
           open(String method,String url, boolean )函数有3个参数
           method参数指定向servlet发送请求所使用的方法，有GET,POST等
           boolean值指定是否异步，true为使用，false为不使用。
           我们使用异步才能体会到Ajax强大的异步功能。
           */
           req.open("GET", url, true);
          //onreadystatechange属性存有处理服务器响应的函数,有5个取值分别代表不同状态
          req.onreadystatechange = callback;
          //send函数发送请求
          req.send(null);
        }

        function callback() {
          if(req.readyState == 4 && req.status == 200) {
            var check = req.responseText;
            show (check);
          }
        }

        function show(str) {
          if(str == "YES") {
              document.getElementById("checkSeries").innerHTML="已检测到该设备";
              $("#checkSeries").css("background-color","#72a230");
              $("#checkSeries").css("opacity","1");
              $(".input").fadeOut();

          }
          else if( str == "NO") {
              document.getElementById("checkSeries").innerHTML="未检测到该设备";
              $("#checkSeries").css("background-color","#CE5454");
              $("#checkSeries").css("opacity","1");
              $(".input").fadeIn();
          }
        }
      </script>
      <!-- /jQuery Smart Wizard -->
      <!-- validator -->
    <script>
      // initialize the validator function
      validator.message.date = 'not a real date';

      // validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
      $('form')
        .on('blur', 'input[required], input.optional, select.required', validator.checkField)
        .on('change', 'select.required', validator.checkField)
        .on('keypress', 'input[required][pattern]', validator.keypress);

      $('.multi.required').on('keyup blur', 'input', function() {
        validator.checkField.apply($(this).siblings().last()[0]);
      });

      $('form').submit(function(e) {
        e.preventDefault();
        var submit = true;

        // evaluate the form using generic validaing
        if (!validator.checkAll($(this))) {
          submit = false;
        }

        if (submit)
          this.submit();

        return false;
      });
    </script>
    <!-- /validator -->
    <script type="text/javascript">
      function printIt() {
        $("#printTable").print({iframe: false});
      }
    </script>
    <script type="text/javascript">
      function cancelOrder() {
          swal({
          title: "确定取消订单么？",
          text: "您需要重新填写报修信息",
          type: "warning",
          showCancelButton: true,
          confirmButtonColor: "#DD6B55",
          confirmButtonText: "是",
          cancelButtonText: "否",
          closeOnConfirm: false
      }, function() {
          swal({
          title: "订单已取消",
          text: "3 秒钟后将跳转至报修页面",
          type: "success",
          timer: 3000,
          showConfirmButton: false,
          animation: "slide-from-top"
          }, function () {
              window.location.reload();
          });
        });
      }
    </script>
    <script type="text/javascript">
        function checkDeviceType() {
            if($("#deviceType").val() === 0) {
                alert($("#deviceType").val());
                document.getElementById("checkDevice").innerHTML="未选择设备类型";
                $("#checkDevice").css("opacity","1");
            } else {
                $("#checkDevice").css("opacity","0");
            }
        }
    </script>
    </body>
    </html>
