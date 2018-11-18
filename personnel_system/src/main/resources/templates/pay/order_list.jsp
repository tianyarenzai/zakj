<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<title>支付订单配置</title>
<style>
body {
	padding: 5px;
}
</style>
</head>
<body>

	<div class="mini-toolbar"
		style="border-bottom:0;padding:0px;width:100%;">
		<table style="width:100%;">
			<tr>
				<td style="width:80%;"><input id="tenant_id"
					class="mini-combobox" valueField="tenant_id"
					textField="tenant_name"
					url="<%=request.getContextPath()%>/ajax/jdsp/getTenant"
					 emptyText="请选择单位" onvaluechanged="tenant_name(e)" />
					<input id="semester_id" class="mini-combobox"
					valueField="semester_id" textField="semester" style="width:150px;"
					showNullItem="true" emptyText="请选择学期" /> <input id="config_pay_id"
					style="width:150px;" class="mini-combobox"
					valueField="config_pay_id" textField="pay_name" showNullItem="true"
					emptyText="请选支付方式" /> <input id="start_month" class="Wdate"
					placeholder="开始时间" type="text"
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',skin:'whyGreen',maxDate:'%y-%M-%d'})" />
					<input id="end_month" type="text" class="Wdate" placeholder="结束时间"
					onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'start_month\');}'})" />

					<!-- <a class="mini-button"
					iconCls="icon-add" onclick="add()">增加</a> <a class="mini-button"
					iconCls="icon-add" onclick="edit()">编辑</a> <a class="mini-button"
					iconCls="icon-remove" onclick="del()">删除</a> --></td>
				<td style="white-space:nowrap;"><input id="student_name"
					class="mini-textbox" emptyText="请输入姓名" style="width:150px;"
					onenter="onKeyEnter" /> <a class="mini-button" onclick="search()">查询</a>
				</td>
			</tr>
		</table>
	</div>

	<div id="datagrid1" class="mini-datagrid"
		style="width:100%;height:470px;" allowResize="true"
		url="<%=request.getContextPath()%>/ajax/jdsp/queryOrder" idField="id"
		multiSelect="true">
		<div property="columns">
			<div type="indexcolumn"></div>
			<div type="checkcolumn"></div>
			<div field="out_trade_no" width="120" headerAlign="center"
				allowSort="true">订单号</div>
			<div field="student_name" width="120" headerAlign="center"
				allowSort="true">学生姓名</div>
			<div field="org_name" width="120">学校名称</div>
			<div field="grade_year_name" width="100">年级</div>
			<div field="clazz_name" width="100">班</div>
			<div field="charge_date" align="right" width="100" allowSort="true">订单状态</div>
			<div field="chage_trade_no" width="100">第三方订单号</div>
			<div field="payment_amount" width="100" allowSort="true">金额</div>
			<div name="action" width="120" align="center" headerAlign="center">操作</div>


		</div>
	</div>

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/statics/libs/boot.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/statics/libs/jquery.json-2.4.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/statics/libs/My97DatePicker/WdatePicker.js"></script>

	<script type="text/javascript">
		mini.parse();
		var grid = mini.get("datagrid1");
		grid.load({
			pageIndex : 0,
			pageSize : 15,
			sortField : "",
			sortOrder : "asc",
			tenant_id : "",
			semester_id : "",
			config_pay_id : "",
			student_name : "",
			start_month : "",
			end_month : ""
		});
	
	
		grid
			.on(
				"drawcell",
				function(e) {
					var record = e.record,
						column = e.column,
						field = e.field,
						value = e.value;
					//action列，超连接操作按钮
					if (column.name == "action") {
						e.cellStyle = "text-align:center";
						e.cellHtml = '<a href="javascript:complete(\''
							+ record.charge_id + '\',\''
							+ record.out_trade_no + '\',\''
							+ record.payment_amount + '\')">恢复</a> &nbsp;';
	
					}
	
				});
	
	
		//查询
		function search() {
	
			var student_name = mini.get("student_name").getValue();
			var tenant_id = mini.get("tenant_id").getValue();
			var semester_id = mini.get("semester_id").getValue();
			var config_pay_id = mini.get("config_pay_id").getValue();
			var start_month = $("#start_month").val();
			var end_month = $("#end_month").val();
			var grid = mini.get("datagrid1");
			grid.load({
				pageIndex : 0,
				pageSize : 12,
				sortField : "",
				sortOrder : "asc",
				student_name : student_name,
				tenant_id : tenant_id,
				semester_id : semester_id,
				config_pay_id : config_pay_id,
				start_month : start_month,
				end_month : end_month
			});
		}
		function onKeyEnter(e) {
			search();
		}
	
	
	
		function complete(charge_id,out_trade_no,payment_amount) {
		 mini.alert(out_trade_no);
			$.ajax({
				url : "<%=request.getContextPath()%>/ajax/jdsp/updateOrder",
				type : 'post',
				data : {
					charge_id : charge_id,
					out_trade_no :out_trade_no,
					payment_amount : payment_amount
				},
				cache : false,
				success : function(text) {
	
					if (text.status > 0) {
						mini.alert("保存成功", "提示", function() {
	
							CloseWindow("save");
	
						});
					}
	
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert(jqXHR.responseText);
					CloseWindow();
				}
			});
			
		}
	
	
	
		function tenant_name(e) {
			var config_pay = mini.get("config_pay_id");
			var semester = mini.get("semester_id");
	
	
			var url1 = "<%=request.getContextPath()%>/ajax/jdsp/getConfigPay?tenant_id=" + e.value;
			var url2 = "<%=request.getContextPath()%>/ajax/jdsp/getSemester?tenant_id=" + e.value;
			config_pay.setUrl(url1);
			semester.setUrl(url2);
		//   mini.get("class").setValue("");
		}
	
	
	
	
	
	
	<%-- 
		function add() {
			mini.open({
				targetWindow : window,
	
				url : '<%=request.getContextPath()%>/pay/add',
				title : "新增",
				width : 600,
				height : 400,
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
					url : '<%=request.getContextPath()%>/pay/edit?config_pay_id=' + row.config_pay_id,
					title : "编辑",
					width : 600,
					height : 400,
					onload : function() {
						var iframe = this.getIFrameEl();
						var data = {
							action : "edit",
							id : row.config_pay_id
						};
						iframe.contentWindow.SetData(data);
	
					},
					ondestroy : function(action) {
						//var iframe = this.getIFrameEl();
	
						grid.reload();
	
					}
				});
			} else {
				alert("请选中一条记录");
			}
		}
		function del() {
			var rows = grid.getSelecteds();
			if (rows.length > 0) {
				if (confirm("确定删除选中记录？")) {
					var ids = [];
					for (var i = 0, l = rows.length; i < l; i++) {
						var r = rows[i];
						ids.push(r.config_pay_id);
					}
					var id = ids.join(',');
					grid.loading("操作中，请稍后......");
					$.ajax({
						url : '<%=request.getContextPath()%>/ajax/jdsp/del?config_pay_id=' + id,
						success : function(text) {
							if (text.status > 0) {
								mini.showTips({
									content : "<b>成功</b> <br/>数据删除成功",
									state : 'success',
									x : 500,
									y : 300,
									timeout : 3000
								});
								grid.reload();
							}
						},
						error : function() {}
					});
				}
			} else {
				alert("请选中一条记录");
			}
		} --%>
	</script>

</body>
</html>
