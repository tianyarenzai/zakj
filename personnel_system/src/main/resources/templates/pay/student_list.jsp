<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学籍管理</title>
<script src="../js/jquery-1.6.2.min.js" type="text/javascript"></script>
<script src="../js/boot.js" type="text/javascript"></script>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
  <link href="../js/miniui/themes/bootstrap/skin.css" rel="stylesheet"
	type="text/css" />
<link href="../js/miniui/themes/jqueryui-cupertino/skin.css"
	rel="stylesheet" type="text/css" />  
图标库css
<link type="text/css" href="../css/awesome/css/font-awesome.min.css"
	rel="stylesheet" />
权限
<script src="../button/button.js" type="text/javascript"></script>
<script type="text/javascript">
	$.buttonGrant({
		"div" : ".mini-toolbar table tr:eq(0) td:eq(0)"
	});
</script>

<style type="text/css">
html,body {
	width: 100%;
	height: 99%;
	border: 0;
	margin: 0;
	padding: 0;
	overflow: visible;
}
</style>
 -->
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
</head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>学籍管理</title>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li>
				<a href="#">工作台</a>
			</li>
			<li>
				<a href="#">学籍管理</a>
			</li>
		</ul>
	</div>


	<div style="width:97%;margin-left:1.5%;">
		<div class="mini-toolbar" style="border-bottom:0;padding:0px;">
			<table style="width:100%;margin-left:0%;">
				<tr>

					<td style="white-space:nowrap;"></td>
				</tr>
				<tr>

					<td>
							<input id="studentSchool" name="orgId" class="mini-combobox"
							valueField="orgId" textField="orgName"
							url="../app/organization!getSchool.action" style="width:180px;"
							emptyText="请选择学校" onvaluechanged="orgId(e)" />
						<input id="grade" style="width:150px;" name="grade_id"
							class="mini-combobox" onvaluechanged="onGrade(e)"
							valueField="grade_id" textField="grade_year_name"
							showNullItem="true" emptyText="请选择年级" />
						<input id="class" onclick="onClazz(e)" name="clazzId"
							class="mini-combobox" valueField="clazzId" style="width:180px;"
							textField="clazzName" emptyText="请选择班级" />
						<input style="width:100px;" id="enrollmentNumber_1"
							class="mini-textbox" emptyText="请输入学号" />
						<input style="width:100px;" id="studentName_1"
							class="mini-textbox" emptyText="请输入姓名" />
						<a class="mini-button" onclick="search_1()">查询</a>
						<!--  <a	class="mini-button" onclick="bing()">解绑</a> -->
					</td>
				</tr>
			</table>
		</div>
	</div>

	<div class="mini-fit">

		<div id="datagrid1" class="mini-datagrid" allowAlternating="true"
			style="width:97%;height:100%;float:left;margin-left:1.5%;"
			allowResize="true" sizeList="[10,20,25,30,50,100,500]"
			url="<%=request.getContextPath()%>/student/student/list" idField="id">
			<div property="columns">
				<div type="indexcolumn"></div>
				<div type="checkcolumn"></div>
				<div field="org_name" width="100" allowSort="true" align="center"
					headerAlign="center">学校</div>
				<div field="student_grade" width="40" align="center"
					allowSort="true" headerAlign="center">年级</div>
				<div field="grade_year_name" width="40" align="center"
					allowSort="true" headerAlign="center">入学年级</div>
				<div field="sys_clazz_name" width="30" align="center"
					allowSort="true" headerAlign="center">班</div>

				<div field="student_name" width="40px" headerAlign="center"
					allowSort="true" align="center">姓名</div>
				<div field="student_gender" width="40px" align="center"
					allowSort="true" headerAlign="center" renderer="onGenderRenderer">性别</div>
				<div field="student_id_number" width="80px" headerAlign="center"
					allowSort="true" align="center">身份证号码</div>
				<div field="enrollment_number" width="80px" headerAlign="center"
					allowSort="true" align="center">学号</div>
				<div field="student_entrance_number" width="80" align="center"
					allowSort="true" headerAlign="center" renderer="onBirthdayRenderer">入学年月</div>

				<div field="student_birth" width="80" align="center"
					allowSort="true" headerAlign="center" renderer="onBirthdayRenderer">出生日期</div>
				<div field="student_new_address" width="80" align="center"
					allowSort="true" headerAlign="center">现住址</div>
				<div field="student_minority" width="30" align="center"
					allowSort="true" headerAlign="center">民族</div>
				<div field="u_phone" width="80" align="center" allowSort="true"
					headerAlign="center">是否绑定小程序</div>

			</div>



		</div>
	</div>

</body>

<script type="text/javascript">
	 
	mini.parse();
	$(document).ready(
			function() {
 
				$.ajax({
					url : "<%=request.getContextPath()%>/student/clazz/system",
					success : function(text) {
                           
						var o = mini.decode(text);
						var grid = mini.get("datagrid1");
						var orgId = mini.get("studentSchool");
						var gradeId = mini.get("grade");
						var clazzId = mini.get("class");
						
						orgId.setValue(o.orgId);
						gradeId.setValue(o.gradeId);
						clazzId.setValue(o.clazzId);
						var url = "<%=request.getContextPath()%>/student/clazz/gradeYearName?id="
								+ o.orgId;
						gradeId.setUrl(url);
						var url = "<%=request.getContextPath()%>/student/clazz/clazzName?id="
								+ o.gradeId;
						clazzId.setUrl(url);

						grid.load({
					
							pageIndex : 0,
							pageSize : 20,
							sortField : "",
							sortOrder : "asc",
							studentSchool : o.orgId,
							studentName : "",
							gradeId : o.gradeId,
							clazzId : o.clazzId,
							enrollmentNumber : "",
							studentTelephone : "",
						
							chargeYear : o.semesterId,
						});
						grid.frozenColumns(0, 2);

					},
					error : function() {
					}
				});

			});

	function edit() {
		var grid = mini.get("datagrid1");
		var row = grid.getSelected();

		if (row) {
			mini.open({
				url : bootPATH + "../school/student_add_1.html",
				title : "编辑学生",
				width : 1000,
				height : 580,
				onload : function() {
					var iframe = this.getIFrameEl();
					var data = {
						action : "edit",
						id : row.student_id
					};
					iframe.contentWindow.SetData(data);
				},
				ondestroy : function(action) {
					grid.reload();
				}
			});
		} else {
			mini.alert("请选中一个学生");
		}

	}

	function bing() {
		var grid = mini.get("datagrid1");
		var rows = grid.getSelected();
		if (rows) {

			if (rows.u_phone == null) {
				mini.alert("该生还未绑定，无需解绑");
				return;
			}
			if (confirm("确定为该生解除解绑信息？")) {

				grid.loading("操作中，请稍后......");
				$.ajax({
					url : "../stu/studentBinding!unBundling.action?stuId="
							+ rows.student_id,
					success : function(text) {
						mini.alert(text);
						grid.reload();
					},
					error : function() {
					}
				});
			}
		} else {
			mini.alert("请选择学生");
		}

	}

	////////////////////////////////

	////////////////////////////////////////////////////
	function onBirthdayRenderer(e) {
		var value = e.value;
		if (value)
			return mini.formatDate(value, 'yyyy-MM-dd');
		return "";
	}

	function search_1() {
		mini.parse();

		var grid = mini.get("datagrid1");
		var studentName = mini.get("studentName_1").getValue();
		var enrollmentNumber = mini.get("enrollmentNumber_1").getValue();
		var gradeId = mini.get("grade").getValue();
		var clazzId = mini.get("class").getValue();
		var studentSchool = mini.get("studentSchool").getValue();
		var chargeYear =""; //mini.get("semesterId").getValue();
		var str = true;
		//	var pattern = new RegExp("[^0-9\-]");

	
		grid.load({

			studentName : studentName,
			enrollmentNumber : enrollmentNumber,
			clazzId : clazzId,
			gradeId : gradeId,
			studentSchool : studentSchool,
			pageIndex : 0,
			pageSize : 20,
			sortField : "",
			sortOrder : "asc",
			str : "",
			chargeYear : chargeYear,
		});
		/* }
		mini.parse(); */

	}

	/////////////////////////////////////////////
	mini.parse();

	var studentSchool = mini.get("studentSchool");
	
	function orgId(e) {
	
		var gradeId = mini.get("grade");
		
	  //  var clazzId = mini.get("class");
		var url = "../workers/grade!gradeYearName1.action?id=" + e.value;
		gradeId.setUrl(url);
		mini.get("class").setValue("");
	}
	//班级联动
	function onClazz() {
		var gradeId = mini.get("grade").getValue();		
		var clazz = mini.get("class");
		var url = "../workers/grade!clazzName1.action?id=" + gradeId;
		clazz.setUrl(url);
	}
	function onGrade(e) {
		mini.get("class").setValue("");
	}

	//为新生添加状态
	function haha() {

		grid.loading("操作中，请稍后......");
		$.ajax({
			url : "../app/comment!getStudent.action",
			success : function(text) {
				if (text == "e") {
					alert("操作异常了");
				} else if (text == "f") {
					alert("您的问题提交失败了");
				} else if (text == "s") {
					alert("您的问题提交成功了");
				}
			},
			error : function() {
			}
		});

	}

	//导出学生信息
	function getDbToExcel() {
		var orgId = mini.get("studentSchool").getValue();
		var clazzId = mini.get("class").getValue();
		var gradeId = mini.get("grade").getValue();
        var semesterId = mini.get("semesterId").getValue();
		var actionName = "../app/student!getDbToExcel.action?orgId=" + orgId
				+ "&clazzId=" + clazzId + "&gradeId=" + gradeId+"&semesterId="+semesterId;

		var form = $("<form>"); //定义一个form表单
		form.attr('style', 'display:none'); //在form表单中添加查询参数
		form.attr('target', '');
		form.attr('method', 'post');
		form.attr('action', actionName);

		$('body').append(form); //将表单放置在web中

		form.submit(); //表单提交

	}

	//解绑
</script>