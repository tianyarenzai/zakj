<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ include file="/include.inc.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Expires" content="0"/>		<!-- 缓存时间 -->
    <meta http-equiv="kiben" content="no-cache"/> <!-- 不适用缓存 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>BeiJing.ZhenAn</title>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/statics/css/layui.css" />
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/statics/css/layui.mobile.css"/>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/statics/css/main.css"/>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/statics/css/webnet.css"/>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/statics/fonts/iconfont.css"/>
    <script type="text/javascript" src="<%=request.getContextPath() %>/statics/libs/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/statics/fonts/iconfont.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/statics/libs/layui.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/statics/libs/element.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/statics/libs/view.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/statics/js/index.js"></script>
</head>
<body>
<div class="body">
    <div class="dl_header con">
        <div class="dl_logo">
            <a href=""><img src="<%=request.getContextPath() %>/statics/images/logo.png" alt=""/></a>
            <p class="">智慧教育云平台-海量资源免费提供,翻转学习的最佳平台！</p>
        </div>
    </div>
    <div class="banner">
        <div class="con">
            <div class="banner_img">
                <a href="javascript:;"><img src="<%=request.getContextPath() %>/statics/images/dl_pic.png" alt="" /></a>
            </div>
            <div class="banner_dl">
                <form class="login_form" action="<%=request.getContextPath() %>/sys/user/login1" method="get">
                    <input type="hidden" name="token" value="123456"   />
                    <div class="form">
                        <h3><img src="<%=request.getContextPath() %>/statics/images/icon_dl.png" alt="" />欢迎登录</h3>
                        <p><input type="text" class="login_username" name="user_login" id="staffid" /></p>
                        <p><input type="password" class="login_password" name="user_pwd" id="password" /></p>
                        <p class="checkbox_title">
                        	<span class="pull-right"><a href="">忘记密码？</a></span>
                            <input class="checkbox" type="checkbox" id="ab" />
                            <label for="ab">记住我的登录信息</label>
                        </p>
                        <p><input type="button" class="btn_tj login_btn" value="登    录" /></p>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="footer con">
        <p>网站备案号 粤ICP备16120418号      版权信息：北京振安教育科技公司</p>
        <p>技术支持：<a href="javascript:;">北京振安教育科技公司</a></p>
    </div>
</div>
<script>
var root_contextRoot = "${contextRoot}";
var type =  "${logintype}";

$(function () {
	$(".login_btn").click(function(){
		$(".login_form")[0].submit();
	}).hover(function(){
		$(this).find("img").attr("src",root_contextRoot+"/resources/assets/img/login_btn_hover.png");
	}, function(){
		$(this).find("img").attr("src",root_contextRoot+"/resources/assets/img/login_btn.png");
	});
	
});

</script>
</body></html>