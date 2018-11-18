<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>工资项管理</title>

<script type="text/javascript" src="../js/publicMethods.js"></script>
<link href="../js/miniui/themes/bootstrap/skin.css" rel="stylesheet"
	type="text/css" />
<script src="../js/boot.js" type="text/javascript"></script>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../js/jquery.idTabs.min.js"></script>
<link href="../js/miniui/themes/jqueryui-cupertino/skin.css"
	rel="stylesheet" type="text/css" />
<link href="../js/miniui/themes/default/large-mode.css" rel="stylesheet"
	type="text/css" />



</head>






<body>

	<%-- 	<s:hidden id="orgId" name="orgId"></s:hidden>
		<s:hidden id="employeeId" name="employeeId"></s:hidden> --%>



	
 

			<div class="mini-toolbar" style="border-bottom:0;padding:0px;width:100%;">
				<table style="width:100%;">
					<tr>
						<td style="white-space:nowrap;"><a  class="mini-button" iconCls="icon-add" onclick="add()">增加</a>	<a class="mini-button" iconCls="icon-edit" onclick="edit()">编辑</a>
							<a  class="mini-button" iconCls="icon-remove"
							onclick="remove()">删除</a> </td>
						<td style="width:48%;"></td>
						<td style="white-space:nowrap;"></td>
					</tr>
				</table>

			</div>
	 
		<!-- 缴费 -->
		<div id="datagrid1" class="mini-datagrid"
			style="width:100%;height:380px;" allowResize="true"
			showSummaryRow="true" url="" idField="id">
			<div property="columns">
				<div type="indexcolumn"></div>
				<div type="checkcolumn"></div>
			</div>
		</div>
	





	<script type="text/javascript">
		$("#usual1 ul").idTabs();
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>




<script language="javascript">
	mini.parse();
	var grid = mini.get("datagrid1");
	grid.load({
		pageIndex : 0,
		pageSize : 20,
		sortField : "",
		sortOrder : "asc",
	});

	//汇总管理
	function detail1() {

		document.getElementById("detail").src = "../workers/chaRegester!detail.action?orgId="
				+ orgId; 
		

	}

	function add() {
		mini.open({
			url : bootPATH + "../wages/wages_category_add.jsp",
			title : "新增工资项管理",
			width : 1150,
			height : 800,
			onload : function() {
				var iframe = this.getIFrameEl();
				var data = {
					action : "new"
				};
				iframe.contentWindow.SetData(data);
			},
			ondestroy : function(action) {
				grid.reload();
			}
		});
	}
	function edit() {
		var row = grid.getSelected();

		if (row) {
			mini.open({ 
				url : bootPATH + "../wages/wages_category_add.jsp",
				title : "编辑工资项管理",
				width : 1150,
				height : 800,
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
			alert("请选中一条记录");
		}

	}
	//删除
	function remove() {
		//  alert("1111");
		var rows = grid.getSelecteds();
		if (rows.length > 0) {
			if (confirm("确定删除选中记录？")) {
				var ids = [];
				for (var i = 0, l = rows.length; i < l; i++) {
					var r = rows[i];
					ids.push(r.student_id);
				}
				var id = ids.join(',');
				grid.loading("操作中，请稍后......");
				$.ajax({
					url : "../app/student!remove.action?id=" + id,
					success : function(text) {
						grid.reload();
					},
					error : function() {
					}
				});
			}
		} else {
			alert("请选中一条记录");
		}
	}

	////////////////////////////////////////////////////

	function IsyesOrNot(e) {

		if (e.value == "1")
			return "是";
		else
			return "否";
	}

	///////////////////////////////////////////////////////       
	var Genders = [ {
		id : 1,
		text : '男'
	}, {
		id : 2,
		text : '女'
	} ];

	////////////////////////////////////////////////////////////////////////////////////
</script>

</html>
