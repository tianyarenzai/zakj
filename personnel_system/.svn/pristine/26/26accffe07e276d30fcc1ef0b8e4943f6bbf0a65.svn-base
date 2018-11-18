<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>表格添加</title>
<%-- <link rel="stylesheet"
	href="<%=request.getContextPath()%>/statics/libs/src/css/layui.css">
 --%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/statics/libs/boot.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/statics/libs/jquery.json-2.4.min.js"></script>

<style>
body {
	padding: 20px;
}
 form div table tr {
 width:500px;
 height :60px;
 } 
</style>
</head>
<body>
	<form id="form1" method="post">
		<input name="config_pay_id" class="mini-hidden" />
		<div style="padding-left:11px;padding-bottom:5px;padding-right:11px;">
			<table style="table-layout:fixed;width:25%;">
				<tr>
					<td style="width:100px;">用户名：</td>
					<td style="width:150px;">
					  ${log.username}
					</td>
					<td style="width:100px;">IP地址：</td>
					<td style="width:150px;">  ${log.ip}</td>
			
				</tr>
				<tr>
					<td style="width:100px;">用户操作：</td>
					<td > ${log.operation}</td>
					<td style="width:100px;">时间：</td>
					<td> <fmt:formatDate value="${log.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td></tr>
				 
					<tr>
						<td style="width:100px;">请求方法：</td>
						<td colspan="3">
						${log.method}
						</td>
					</tr>
					<tr>
						<td style="width:100px;">请求参数：</td>
						<td colspan="3" style="word-break: break-all; word-wrap:break-word">
					 ${log.params} 
						<%-- <input     value="${log.params}"   
							style="width:378px;"  /> --%>
						 </td>
					</tr>	<!-- style="width:378px;"   -->
					 
			</table>
		</div>
	
		<!-- <div style="text-align:center;padding:10px;">
			<a class="mini-button" onclick="onOk"
				style="width:60px;margin-right:20px;">确定</a> <a class="mini-button"
				onclick="onCancel" style="width:60px;">取消</a>
		</div> -->
	</form>


	<script>
	
	 mini.parse();

        <%-- var form = new mini.Form("form1");
        function SaveData() {
            var o = form.getData();            
            form.validate();
            if (form.isValid() == false) return;
            var json = mini.encode([o]);
            $.ajax({
            url : "<%=request.getContextPath()%>/ajax/jdsp/saveData",
                type: 'post',
                data: { data: json },
                cache: false,
                success: function (text) {
                 if(text.status>0){
                mini.alert("保存成功","提示",function(){
                                     CloseWindow("save");
                });
                }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    alert(jqXHR.responseText);
                    CloseWindow();
                }
            });
        }

	
	  function GetData() {
            var o = form.getData();
            return o;
        }
	
	 function onOk(e) {
	  
            SaveData();
        }
        function onCancel(e) {
            CloseWindow("cancel");
        }
	
  function CloseWindow(action) {            
            if (action == "close" && form.isChanged()) {
                if (confirm("数据被修改了，是否先保存？")) {
                    return false;
                }
            }
            if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
            else window.close();            
        } --%>
	
	
	</script>
</body>
</html>
