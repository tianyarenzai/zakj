<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Expires" content="0"/>		<!-- 缓存时间 -->
    <meta http-equiv="kiben" content="no-cache"/> <!-- 不适用缓存 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>BeiJing.ZhenAn</title>

    <link rel="stylesheet" href="<%=request.getContextPath() %>/statics/css/base.css"/>
    <style>
        .cc-header {
            width: 100%;
            height: 80px;
            line-height: 80px;
            background-image: -webkit-linear-gradient(bottom, #0dd1b7, #000000);
            background-image: -moz-linear-gradient(bottom, #0dd1b7, #000000);
            background-image: -o-linear-gradient(bottom, #0dd1b7, #000000);
            background-image: linear-gradient(to bottom, #0dd1b7, #000000);
        }

        .cc-header > h3 {
            font-size: 32px;
            color: #FFFFFF;
            margin-left: 5px;
            float: left;
        }

        .cc-header > .login-status-bar {
            float: right;
            color: #FFFFFF;
            font-size: 14px;
            margin-right: 32px;
        }

        .cc-header > .login-status-bar > p {
            display: inline-block;
            margin-left: 5px;
        }

        .cc-header > .login-status-bar > img {
            width: 50px;
            height: 50px;
            border-radius: 32px;
            margin-left: 3px;
        }

        .cc-header > .login-status-bar > a {
            display: inline-block;
            margin-left: 8px;
        }

        .cc-sidebar {
            width: 160px;
            height: auto;
            display: inline-block;
            color: #FFFFFF;
            background-image: -webkit-linear-gradient(bottom, #777777, #000000);
            background-image: -moz-linear-gradient(bottom, #777777, #000000);
            background-image: -o-linear-gradient(bottom, #777777, #000000);
            background-image: linear-gradient(to bottom, #777777, #000000);
            text-align: center;
        }

        .cc-sidebar > .sidebar-first-menu {
            border-bottom: 1px solid #FFFFFF;
        }

        .cc-sidebar > .sidebar-first-menu div {
            height: 50px;
            line-height: 50px;
            font-size: 18px;
            cursor: pointer;
            font-weight: 400;
        }

        .cc-sidebar > .sidebar-first-menu div.hover {
            background: #000000;
            color: #FFFFFF;
        }

        .cc-sidebar > .sidebar-first-menu ul {
            display: none;
        }

        .cc-sidebar > .sidebar-first-menu li {
            height: 40px;
            line-height: 40px;
            background: #BBBBBB;
            color: #333333;
            font-family: 16px;
            width:100%;
            cursor: pointer;
            border-top: 1px solid #FFFFFF;
            position: relative;
        }

        .cc-sidebar > .sidebar-first-menu li.hover {
            background: #a8eac4;
            color: #000000;
        }

        .cc-sidebar > .sidebar-first-menu li.selected {
            background: #0dd1b7;
            color: #000000;
        }

        .cc-content {
            position: absolute;
            top: 100px;
            left: 180px;
        }
        .cursora{cursor: pointer;}
        #newordernummsg{
            width: 25px;
            height: 25px;
            font-style: normal;
            background: red;
            color: white;
            border-radius: 25px;
            /* padding: 2px 6px; */
            position: absolute;
            top: -5px;
            left: 100px;
            line-height: 25px;
        }
    </style>
    <script type="text/javascript" src="<%=request.getContextPath() %>/statics/libs/boot.js" ></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/statics/libs/jquery.json-2.4.min.js" ></script>
<%--     <script type="text/javascript" src="<%=request.getContextPath() %>/statics/lib/jquery.min.js" ></script> --%>
<%--     <script type="text/javascript" src="<%=request.getContextPath() %>/statics/lib/miniui/miniui.js"></script> --%>
<%--     <script type="text/javascript" src="<%=request.getContextPath() %>/statics/lib/miniui/locale/zh_CN.js" ></script> --%>
<%--     <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/statics/lib/miniui/themes/default/miniui.css"  />         --%>
<%--     <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/statics/lib/miniui/themes/bootstrap/skin.css" /> --%>
<%-- 	<link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/statics/lib/miniui/themes/jqueryui-cupertino/skin.css"/> --%>
    
    <script>
        var reqparam="";
        function clockRun() {
            var clock_timer = new Date();
            var year = clock_timer.getFullYear();
            var month = (clock_timer.getMonth() + 1).toString();
            if (month.length === 1) {
                month = "0" + month;
            }
            var day = (clock_timer.getDate()).toString();
            ;
            if (day.length === 1) {
                day = "0" + day;
            }
            var hours = (clock_timer.getHours()).toString();
            if (hours.length === 1) {
                hours = "0" + hours;
            }
            var minutes = (clock_timer.getMinutes()).toString();
            if (minutes.length === 1) {
                minutes = "0" + minutes;
            }
            var seconds = (clock_timer.getSeconds()).toString();
            if (seconds.length === 1) {
                seconds = "0" + seconds;
            }
            $(".cc-header .login-status-bar").children().eq(0).html("" + year + "-" + month + "-" + day + "");
            $(".cc-header .login-status-bar").children().eq(1).html("" + hours + ":" + minutes + ":" + seconds + "");
            var timeID = setTimeout("clockRun()", 1000);
        }
        
        $(function () {
			setInterval(function(){
				notifyMe();
			}, 300000);
            clockRun();
            $(".cc-sidebar").css("height", document.documentElement.clientHeight);
            $(".sidebar-first-menu div").click(function () {
                $(this).siblings().slideToggle();
            }).hover(function () {
                $(this).addClass("hover");
            }, function () {
                $(this).removeClass("hover");
            })
            $(".sidebar-second-menu").click(function () {
                $(".sidebar-second-menu").each(function () {
                    $(this).removeClass("selected").removeClass("hover");
                })
                $(this).addClass("selected");
                refershView($(this).attr("data-url"));
            }).hover(function () {
                $(this).addClass("hover");
            }, function () {
                if ($(this).hasClass("selected")) {

                } else {
                    $(this).removeClass("hover");
                }
            })
           /* $(".sidebar-second-menu").click(function(){

            })*/
        })

        function refershView(url){
            if(url != ""){
                if(url.indexOf("?") > 0){
                    reqparam = url.substring(url.indexOf("?"),url.length)
                }else{
                    reqparam = "";
                }
            }
            if (url.indexOf("oclist.html")>=0){
                $("#newordernummsg").html(0);
                var myAuto = document.getElementById('myaudio');
                myAuto.pause();
            }
            $.ajax({
                type: "get",
                url: url,
                dataType: "html",
                success: function (data) {
                    $(".cc-content").html("");
                    $(".cc-content").html(data);
                }
            })
        }

        //启动定时任务获取最新订单数量
        function getNewOrderCountInterval(){
            getNewOrderCount();
            setInterval("getNewOrderCount()",300000);
        }

        function quitlogin(){
            var quit = confirm("确认退出系统？");
            if(quit){
                window.location.href="<%=request.getContextPath() %>/passport/logout";
            }
        }

    	
    </script>
</head>
<body>
<header class="cc-header clearfix">
    <h3>
       <a href="javascript:;" class="logo"><img src="<%=request.getContextPath() %>/statics/images/icon_logo.png" alt=""></a>
    </h3>

    <div class="login-status-bar clearfix">
        <p></p>

        <p></p>
<!--         <img src="../img/cjavatar.jpg"/> -->

        <p class="userinfop">ljj</p><a class="cursora" onclick="quitlogin()">注销</a>
    </div>
</header>
<div class="cc-sidebar">
    <div class="sidebar-first-menu">
        <div>员工（demo）</div>
        <ul>
            <li class="sidebar-second-menu" data-url="<%=request.getContextPath() %>/jdsp/operatorlistpage">人员信息</li>
            <li class="sidebar-second-menu" data-url="<%=request.getContextPath() %>/jdsp/operatorlistpage1">人员信息1</li>

        </ul>
    </div>
    <div class="sidebar-first-menu">
        <div>系统管理</div>
        <ul>
            <li class="sidebar-second-menu" data-url="<%=request.getContextPath() %>/ajax/system/sysoperatorinit">操作员管理</li>
            <li class="sidebar-second-menu" data-url="<%=request.getContextPath() %>/ajax/system/sysmenulistinit">权限管理</li>
            <li class="sidebar-second-menu" data-url="<%=request.getContextPath() %>/ajax/system/sysrolelistinit">角色管理</li>
        </ul>
    </div>
</div>
<div class="cc-content"></div>
<footer class="cc-footer"></footer>
<div class="body_shadow"></div>
<div id="provcitypop" ></div>
<!-- <div id="sider_img_div_cont" style="display:none">
		<div id="sider_img_div_elem">
			   <i class="close_show_div"></i>
			   <div class="sider_img_div"></div>
			   		
		</div>
</div> -->
</body>
</html>