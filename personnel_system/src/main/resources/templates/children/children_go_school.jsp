<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>学生面板</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

 
<script type="text/javascript"
		src="<%=request.getContextPath()%>/statics/libs/boot.js"></script>

 

<style type="text/css">
body {
	padding: 0;
	margin: 0;
	border: 0;
	height: 100%;
}


form  table  tr   {
	height :50px;
}

#form1 div table  tr td {
	font-family: Tahoma, Verdana, 宋体 !important;
	font-size: 9pt;
}


</style>
</head><!-- overflow:scroll;  -->
<!-- overflow-y:scroll;  overflow-y:scroll;-->
<body style="height:100%;">
	<div style="height:90%;">
		<form id="form1" method="post">
			<input id ="childrenId"  value="${children.childrenId}" name="childrenId" class="mini-hidden" />
            <input id ="orgId"  value="${children.orgId}" name="orgId" class="mini-hidden" />

			<!-- <div style="padding-left:18px;padding-bottom:5px;"> -->
				<table style="table-layout:fixed;">

					<tr>

						<td style="width:90px;">年 级:</td>
						<td style="width:170px;"><input id="gradeId" name="gradeId"
							class="mini-combobox" valueField="grade_id"
							textField="grade_year_name" required="true" showNullItem="true"
							 onclick="onGrade()" emptyText="请选择年级" /></td>
					</tr>
					<tr>
						<td style="width:90px;">班 &nbsp;级:</td>
						<td style="width:170px;"><input id="clazzId" name="clazzId"  onclick="onClazz()"
							class="mini-combobox" required="true" valueField="clazz_id"
							textField="sys_clazz_name" emptyText="请选择班级" /></td>

					</tr>



				</table>
		<!-- 	</div>
 -->
			<div style="text-align:center;padding:10px;">
				<a class="mini-button" iconCls="icon-ok" onclick="onOk" style="width:60px;margin-right:20px;">确定</a>
				<a class="mini-button" iconCls="icon-close" onclick="onCancel">取消</a>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		////////////////////
		//标准方法接口定义
		
		
		
	function onGrade() {
		var orgId = mini.get("orgId").getValue();
		var gradeId = mini.get("gradeId");	 
		 url="<%=request.getContextPath()%>/student/grade/gradeYearName?org_id="+orgId
		gradeId.setUrl(url);
	}
	 
		 
	function onClazz() {
		var gradeId = mini.get("gradeId").getValue();
	 
		var clazzId = mini.get("clazzId");
		var url = "<%=request.getContextPath()%>/student/grade/clazzName?grade_id=" + gradeId;
		 clazzId.setUrl(url);
	}
	 
		

		function onOk(e) {
			var clazzId = mini.get("clazzId").getValue();
			var gradeId = mini.get("gradeId").getValue();
				var childrenId = mini.get("childrenId").getValue();
		 
			if (gradeId == "") {
				mini.alert("请选择年级");
					return false;
			}
			if (clazzId == "") {
				mini.alert("请选择班");
					return false;
			}

			$.ajax({
				url : "<%=request.getContextPath()%>/student/children/goStudent" ,
				type : 'post',
				data : {
					clazzId : clazzId,
					gradeId : gradeId,
					childrenId : childrenId
				},
				cache : false,
				success : function(text) {

					alert(text);
					CloseWindow();
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert(jqXHR.responseText);
					CloseWindow();
				}
			});
		}

		 
		 
		function onCancel(e) {
				CloseWindow("save");
		}
		
			function CloseWindow(action) {
			if (action == "close" && form.isChanged()) {
				if (confirm("数据被修改了，是否先保存？")) {
					return false;
				}
			}
			if (window.CloseOwnerWindow)
				return window.CloseOwnerWindow(action);
			else
				window.close();
		}
	</script>
</body>
</html>









