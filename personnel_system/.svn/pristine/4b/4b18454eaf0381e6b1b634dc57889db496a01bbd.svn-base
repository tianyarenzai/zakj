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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>预注册</title>

<link href="<%=request.getContextPath()%>/statics/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
		src="<%=request.getContextPath()%>/statics/libs/boot.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/statics/libs/jquery.json-2.4.min.js"></script>

	<style type="text/css">
    html,body
    {
        width:100%;
        height:99%;
        border:0;
        margin:0;
        padding:0;
        overflow:visible;
    }
    </style>
</head>

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


  



		<div class="mini-toolbar"    
			style="border-bottom:0;padding:0px;width:97%;margin-left:1.5%;">
			<table style="width:100%;">
				<tr>
					<td style="width:100%;"></td>
					<td style="white-space:nowrap;"><input id="childName"
						class="mini-textbox" emptyText="请输入学生姓名" style="width:150px;"
						onenter="onKeyEnter" />
						<a class="mini-button" iconCls="icon-search" onclick="searchChildren()">查询</a>
					</td>
				</tr>
			</table>
		</div>
	<div class="mini-fit">
		<div id="datagrid1" class="mini-datagrid"
			style="width:100%;height:100%;width:97%;margin-left:1.5%;"
			allowResize="true" url="<%=request.getContextPath()%>/student/children/list"
			idField="dormitoryId">
			<div property="columns">
				<div type="checkcolumn"></div>
				<div field="child_name" width="80" headerAlign="center"
					align="center" allowSort="true">姓名</div>
				<div field="child_gender" width="60" headerAlign="center"
					align="center" allowSort="true">性别</div>
				<div field="child_dentity" width="120" headerAlign="center"
					align="center" allowSort="true">身份证号</div>
				<div field="child_minority" width="80" headerAlign="center"
					align="center" allowSort="true">民族</div>
				<div field="child_place" width="120" headerAlign="center"
					align="center" allowSort="true">籍贯</div>
				<div field="child_address" width="120" headerAlign="center"
					align="center" allowSort="true">现住址</div>
				<div field="child_parent" width="120" headerAlign="center"
					align="center" allowSort="true">家长电话</div>
				<div field="child_school_name" width="120" headerAlign="center"
					align="center" allowSort="true">学校</div>
				<div field="child_birthday" width="100" headerAlign="center"
					align="center" dateFormat="yyyy-MM-dd" allowSort="true">出身日期</div>
				<div field="child_create_time" width="100" headerAlign="center"
					align="center" dateFormat="yyyy-MM-dd" allowSort="true">创建日期</div>
				<div field="into_school" width="120" headerAlign="center"
					renderer="intoSchool" align="center" allowSort="true">转入</div>
				<div name="action" width="100" headerAlign="center">操作</div>
			</div>
		</div>

	</div>

 









</body>
<script language="javascript">
	mini.parse();

	var grid = mini.get("datagrid1");
	grid.load({

		key : "", //自定义
		childParent : "",
		pageIndex : 0,
		pageSize : 20,
		sortField : "",
		sortOrder : "asc",
		childName : ""
	});
	//	grid.frozenColumns(0, 2);
	grid
			.on(
					"drawcell",
					function(e) {
						var record = e.record, column = e.column, field = e.field, value = e.value;
						//action列，超连接操作按钮
						if (column.name == "action") {
							e.cellStyle = "text-align:center";
							e.cellHtml = '<a href="javascript:giveNewStudent(\''
									+ record.children_id
									+ '\')">转入新生</a>&nbsp; '
									+ '<a href="javascript:delchildren(\''
									+ record.children_id + '\')">删除</a>'
						}
						//将性别文本替换成图片
						if (column.field == "gender") {
							if (e.value == 1) {
								e.cellHtml = "<span class='icon-female'></span>"
							} else {
								e.cellHtml = "<span class='icon-boy'></span>"
							}
						}

						//设置行样式
						if (record.gender == 1) {
							e.rowCls = "myrow";
						}

					});

	function edit(rowid) {
		alert("编辑: " + rowid);
	}
	function del(rowid) {
		alert("删除: " + rowid);
	}

	function intoSchool(e) {
		if (e.value == "2")
			return "已转入";
		else
			return "未转入";
	}
	function delchildren(record) {

		grid.loading("操作中，请稍后......");
		$.ajax({
			url : "../workers/children!delete.action?id=" + record,
			success : function(text) {
				grid.reload();
			},
			error : function() {
			}
		});

	}

/* 	function giveNewStudent(record) {
		var row = grid.getSelected();
		var intoSchool = row.into_school;
		if (intoSchool == null) {
			grid.loading("操作中，请稍后......");
			$.ajax({
				url : "../workers/children!giveNewStudent.action?id=" + record,
				success : function(text) {
					alert(text);
					grid.reload();
				},
				error : function() {
				}
			});

		} else {
			alert("已经转入不能再次转入");
		}

	} */

	function searchChildren() {
		var childParent = "";// mini.get("childParent").getValue();
		var childName = mini.get("childName").getValue();

		grid.load({
			childParent : childParent,
			pageIndex : 0,
			pageSize : 20,
			sortField : "",
			sortOrder : "asc",
			childName : childName
		});
	}
	function onKeyEnter(e) {
		searchChildren();
	}
	function giveNewStudent() {
	var grid = mini.get("datagrid1");
		var row = grid.getSelected();
		var intoSchool = row.into_school;
 
		if (intoSchool == '0') {

			mini.open({
			
				url : "<%=request.getContextPath()%>/student/children/goSchool?children_id="+row.children_id+"&org_id="+row.org_id,
				title : "转入新生",
				width : 350,
				height : 300,
				onload : function() {
					},
				ondestroy : function(action) {
					grid.reload();
				}
			});

		} else {
			alert("已经转入不能再次转入");
		}

	}
</script>
</html>

