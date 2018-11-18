<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>支付后台管理</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/statics/libs/src/css/layui.css">
</head>
<body>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">支付后台管理</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          admin
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a onclick="signOut()">退了</a></li>
    </ul>



		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item layui-nav-itemed"><a class=""
						href="javascript:;">支付管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a onclick="onfig();">树</a>
							</dd>
						</dl>
						<dl class="layui-nav-child">
							<dd>
								<a onclick="list();">学籍管理</a>
							</dd>
						</dl>
						<dl class="layui-nav-child">
							<dd>
								<a onclick="newStudent();">新生管理</a>
							</dd>
						</dl>
						<dl class="layui-nav-child">
							<dd>
								<a onclick="move();">异动管理</a>
							</dd>
						</dl>
							<dl class="layui-nav-child">
							<dd>
								<a onclick="approval();">异动审核</a>
							</dd>
						</dl>
							<dl class="layui-nav-child">
							<dd>
								<a onclick="grow();">成长档案</a>
							</dd>
						</dl>
							</dl>
							<dl class="layui-nav-child">
							<dd>
								<a onclick="moveClazz();">调班</a>
							</dd>
						</dl>
						</li>
					<li class="layui-nav-item"><a href="javascript:;">订单管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a onclick="onPay('../pay/orderList.html');">订单列表</a>
							</dd>
							<!-- <dd><a href="javascript:;">列表二</a></dd> -->
						</dl></li>
					<li class="layui-nav-item"><a href="javascript:;">日志管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a onclick="onLog('../pay/logList.html');">系统日志</a>
							</dd>
							<dd>
								<a onclick="payLog();">支付日志</a>
							</dd>
							<!-- <dd><a href="javascript:;">列表二</a></dd> -->
						</dl></li>
						
						<li class="layui-nav-item"><a href="javascript:;">用户管理</a>
						<dl class="layui-nav-child">
							<dd>
								<a onclick="user();">用户管理</a>
							</dd>
							<dd>
								<a onclick="user1();">用户管理1</a>
							</dd>
							<!-- <dd><a href="javascript:;">列表二</a></dd> -->
						</dl></li>
						
				</ul>
			</div>
		</div>

		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 0px;">

				<%-- data-url="<%=request.getContextPath() %>/jdsp/operatorlistpage1"
    --%>
				<iframe src="<%=request.getContextPath()%>/sys/user/select"
					frameborder="0" id="demoAdmin" style="width:100%; height: 100%;"></iframe>
			</div>
		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->

		</div>
	</div>
	<script src="<%=request.getContextPath()%>/statics/libs/src/layui.js"></script>
	<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;
			var ss = document.getElementById("demoAdmin");
			//ss.src="<%=request.getContextPath()%>/passport/tabel1";
	
		});
	
		function list() {
			var ss = document.getElementById("demoAdmin");
			ss.src = "<%=request.getContextPath()%>/sys/user/studentList";
		//ss.src=e;
		}
		
		function newStudent() {
			var ss = document.getElementById("demoAdmin");
			ss.src = "<%=request.getContextPath()%>/sys/user/newStudent";
		//ss.src=e;
		}
		
		
		function move() {
			var ss = document.getElementById("demoAdmin");
			ss.src = "<%=request.getContextPath()%>/sys/user/move";
		//ss.src=e;
		}
	
	
	
	function approval() {
			var ss = document.getElementById("demoAdmin");
			ss.src = "<%=request.getContextPath()%>/sys/user/approval";
		//ss.src=e;
		}
	
	function grow() {
			var ss = document.getElementById("demoAdmin");
			ss.src = "<%=request.getContextPath()%>/sys/user/grow";
		//ss.src=e;
		}
		
			function moveClazz() {
			var ss = document.getElementById("demoAdmin");
			ss.src = "<%=request.getContextPath()%>/sys/user/moveClazz";
		//ss.src=e;
		}
		
		function onfig() {
			var ss = document.getElementById("demoAdmin");
			ss.src = "<%=request.getContextPath()%>/sys/user/select";
		//ss.src=e;
		}
	
		//订单
		function onPay(e) {
			var ss = document.getElementById("demoAdmin");
			ss.src = "<%=request.getContextPath()%>/pay/order_list";
		//ss.src=e;
		}
		//日志
		function onLog(f) {
			var ss = document.getElementById("demoAdmin");
			ss.src = "<%=request.getContextPath()%>/pay/log_list";
		//ss.src=f;
		}
		//系统日志
		function payLog() {
			var ss = document.getElementById("demoAdmin");
			ss.src = "<%=request.getContextPath()%>/pay/pay_log_list";
		//ss.src=f;
		}
		
		
		function user() {
			var ss = document.getElementById("demoAdmin");
			ss.src = "<%=request.getContextPath()%>/sys/user/user";
		//ss.src=f;
		}
		
		function signOut(){
		
		var quit = confirm("确认退出系统？");
            if(quit){
                window.location.href="<%=request.getContextPath() %>/account/logout";
            }
		}
	</script>
</body>
</html>
