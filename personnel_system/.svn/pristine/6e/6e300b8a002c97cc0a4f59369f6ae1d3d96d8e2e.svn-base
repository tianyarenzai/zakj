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
<title>支付参数配置</title>
<style>
body {
	padding: 5px;
}
</style>
</head>
<body>


	<div style="width:100%;">
		<div class="mini-toolbar" style="border-bottom:0;padding:0px;">
			<table style="width:100%;">
				<tr>
					<td style="width:100%;"><a class="mini-button"
						iconCls="icon-add" onclick="add()">增加</a> <a class="mini-button"
						iconCls="icon-add" onclick="edit()">编辑</a> <a class="mini-button"
						iconCls="icon-remove" onclick="del()">删除</a></td>
					<td style="white-space:nowrap;"><input id="pay_name"
						class="mini-textbox" emptyText="请输入姓名" style="width:150px;"
						onenter="onKeyEnter" /> <a class="mini-button" onclick="search()">查询</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<div id="datagrid1" class="mini-datagrid"
		style="width:100%;height:470px;" allowResize="true"
		url="<%=request.getContextPath()%>/ajax/jdsp/list" idField="id"
		multiSelect="true">
		<div property="columns">
			<div type="indexcolumn"></div>
			<div type="checkcolumn"></div>
			<div field="pay_name" width="120" headerAlign="center"
				allowSort="true">支付名称</div>
			<div field="mch_id" width="120" headerAlign="center" allowSort="true">商户号</div>

			<div field="key" width="120">交易密钥</div>
			<div field="req_url" width="100">支付请求url</div>
			<div field="notify_url" align="right" width="100" allowSort="true">通知商户url</div>
			<div field="tenant_name" width="100">单位</div>
			<div field="pay_type" width="100" allowSort="true">支付类型</div>
			<div field="pay_number" width="100">编号</div>
			<div field="app_id" width="100">app_id</div>
			<div field="service" width="100">服务url</div>
			<div field="version" width="100">版本</div>
		</div>
	</div>

	<script type="text/javascript"
		src="<%=request.getContextPath()%>/statics/libs/boot.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/statics/libs/jquery.json-2.4.min.js"></script>


	<script type="text/javascript">
		mini.parse();
		var grid = mini.get("datagrid1");
		grid.load({
			pageIndex : 0,
			pageSize : 15,
			sortField : "",
			sortOrder : "asc",
			pay_name : "",
		});
	
		//查询
		function search() {
			var pay_name = mini.get("pay_name").getValue();
	
			grid.load({
				pageIndex : 0,
				pageSize : 12,
				sortField : "",
				sortOrder : "asc",
				pay_name : pay_name
			});
		}
		function onKeyEnter(e) {
			search();
		}
	
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
					var pay_names=[];
					for (var i = 0, l = rows.length; i < l; i++) {
						var r = rows[i];
						ids.push(r.config_pay_id);
						pay_names.push(r.pay_name);
					}
					var id = ids.join(',');
					var pay_name = pay_names.join(',');
					grid.loading("操作中，请稍后......");
					  $.ajax({
						 url : '<%=request.getContextPath()%>/ajax/jdsp/del',
				                type: 'post',
				                data : {
									config_pay_id : id,
									pay_name : pay_name
								},
				                cache: false,
				                success: function (text) {
				               
				                	if (text.status > 0) {
										mini.showTips({
											content : "<b>成功</b> <br/>数据删除成功",
											state : 'success',
											x : 500,
											y : 300,
											timeout : 3000
										});
				                	}
										grid.reload();
				                      
				                },
				                error: function (jqXHR, textStatus, errorThrown) {
				                    alert(jqXHR.responseText);
				                    
				                }
				            });  
					 <%--  $.ajax({
						url : '<%=request.getContextPath()%>/ajax/jdsp/del',
						type : 'post',
						data : {
							config_pay_id : id
						},
						cache : false,
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
					});   --%>
				}
			} else {
				alert("请选中一条记录");
			}
		}
	</script>

</body>
</html>
