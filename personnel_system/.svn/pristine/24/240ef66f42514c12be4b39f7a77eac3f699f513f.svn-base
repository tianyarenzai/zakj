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
<title>系统日志</title>
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
				<td style="white-space:nowrap;width:96%;"><%-- <input id="tenant_id"
					class="mini-combobox" valueField="tenant_id"
					textField="tenant_name"
					url="<%=request.getContextPath()%>/ajax/jdsp/getTenant"
					 emptyText="请选择单位" onvaluechanged="tenant_name(e)" />
					<input id="semester_id" class="mini-combobox"
					valueField="semester_id" textField="semester" style="width:150px;"
					showNullItem="true" emptyText="请选择学期" /> <input id="config_pay_id"
					style="width:150px;" class="mini-combobox"
					valueField="config_pay_id" textField="pay_name" showNullItem="true"
					emptyText="请选支付方式" /> --%> 
					<input id="username"
					class="mini-textbox" emptyText="请输入用户名" style="width:150px;"
					onenter="onKeyEnter" /> 
					<input id="params"
					class="mini-textbox" emptyText="请输入日志内容" style="width:150px;"
					onenter="onKeyEnter" /> 
					
					
					<!-- <input
						style="width:100px;" id="username" class="mini-textbox"
						emptyText="请输入用户名" /> --><input id="start_month" class="Wdate"
					placeholder="开始时间" type="text"
					onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',skin:'whyGreen',maxDate:'%y-%M-%d'})" />
					<input id="end_month" type="text" class="Wdate" placeholder="结束时间"
					onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'start_month\');}'})" />

					</td>
				<td style="white-space:nowrap;"><a class="mini-button" onclick="search()">查询</a>
				</td>
			</tr>
		</table>
	</div>

	<div id="datagrid1" class="mini-datagrid"
		style="width:100%;height:470px;" allowResize="true"
		url="<%=request.getContextPath()%>/ajax/log/list" idField="id"
		multiSelect="true">
		<div property="columns">
			<div type="indexcolumn"></div>			
			<div field="username" width="50" headerAlign="center"
				allowSort="true">用户名</div>
			<div field="operation" width="60" headerAlign="center"
				allowSort="true">用户操作</div>
			<div field="method" width="120">请求方法</div>
			<div field="params" width="400">请求参数</div>
			<div field="ip" width="80">IP地址</div>
			<div field="createDate"   dateFormat="yyyy-MM-dd HH:mm:ss" width="80" allowSort="true">创建时间</div>
			<div name="action" width="40" align="center" headerAlign="center">操作</div>


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
			 
		});
		grid.frozenColumns(0, 2);
	
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
						e.cellHtml = '<a href="javascript:look(\''
							+ record.id + '\')">查看</a> &nbsp;';
	
					}
	
				});
	
	
		//查询
		function search() {	
			var username = mini.get("username").getValue();
			var params = mini.get("params").getValue();
			
			/* var tenant_id = mini.get("tenant_id").getValue();
			var semester_id = mini.get("semester_id").getValue();
			var config_pay_id = mini.get("config_pay_id").getValue(); */
			var start_month = $("#start_month").val();
			var end_month = $("#end_month").val();
			var grid = mini.get("datagrid1");
			grid.load({
				pageIndex : 0,
				pageSize : 12,
				sortField : "",
				sortOrder : "asc",
				username : username,
				params : params,
				start_month : start_month,
				end_month : end_month
				/* tenant_id : tenant_id,
				semester_id : semester_id,
				config_pay_id : config_pay_id,
				 */
			});
		}
		function onKeyEnter(e) {
			search();
		}
	
	function look(e) {
		
			if (e) {
				mini.open({
					url : '<%=request.getContextPath()%>/log/look?id=' + e,
					title : "查看",
					width : 700,
					height : 500,
					onload : function() {
						var iframe = this.getIFrameEl();
						var data = {
							action : "look",
							id : e
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
	
		
	
	
	
	
	
	
	
	</script>

</body>
</html>
