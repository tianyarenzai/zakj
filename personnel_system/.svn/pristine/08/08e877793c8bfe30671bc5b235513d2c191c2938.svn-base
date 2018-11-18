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
<title>添加缴费学年</title>

<script src="../js/boot.js" type="text/javascript"></script>
<link href="../js/miniui/themes/default/large-mode.css" rel="stylesheet" type="text/css" />
<link href="../js/miniui/themes/bootstrap/skin.css" rel="stylesheet" type="text/css" />
    
<style type="text/css">
html,body {
	font-size: 12px;
	padding: 0;
	margin: 0;
	border: 0;
	height: 100%;
	overflow: hidden;
}
</style>
</head>

<body>
    
    <div class="formbody">   
    <form id="form1" method="post">
	
	    <input name="chargeItemId" class="mini-hidden" />    
		<div style="padding-left:11px;padding-bottom:5px;">				 
			<table style="table-layout:fixed;">			
				<tr>
					<td style="width:70px;">收费项：</td>
					<td style="width:150px;">
						<input name="item"  class="mini-textbox" required="true"
							emptyText="请输入收费项" />
					</td>
					</tr>
					<tr>
					<td style="width:70px;">收费类型：</td>
					<td style="width:180px;">
					<select name="itemType" class="mini-radiobuttonlist">
							<option value="1">应收</option>
							<option value="2">代收</option>
							<option value="3">其他</option>
					</select></td>
					</tr><tr>
					<td style="width:70px;">收费标准：</td>
					<td style="width:150px;">
						<input name="itemStandard"  class="mini-textbox" required="true"
							emptyText="请输入收费标准" />
					</td>
					</tr><tr>
					
					<td style="width:70px;">所属校区：</td>
					<td style="width:150px;">
						<input name="belongSchool"  class="mini-textbox" required="true"
							emptyText="请输入所属校区" />
					</td>
					</tr><tr>
					<td style="width:70px;">所属学年：</td>
					<td style="width:150px;">
						<input name="belongYear"  class="mini-textbox" required="true"
							emptyText="请输入所属学年" />
					</td>
					</tr><tr>
					<td style="width:70px;">所属学期：</td>
					<td style="width:150px;">
						<input name="belongSeason"  class="mini-textbox" required="true"
							emptyText="请输入所属学期" />
					</td>
					</tr> 
				
			</table>
		</div>
		
		<div style="text-align:center;padding:10px;width:300px;">
			<a class="mini-button mini-button-info" onclick="onOk"
					style="width:60px;margin-right:20px;">确定</a> <a class="mini-button mini-button-info"
					onclick="onCancel" style="width:60px;">取消</a>
		</div>
	</form> 
   
       
	</div> 

    
  


</body>
<script type="text/javascript">
		$(document).ready(function() {
		/* $("fieldset div:gt(0)").toggle(); */
		$("fieldset div").toggle();
		$("fieldset legend").click(function() {

			$(this).parent().find("div").toggle();
		});
	});

	mini.parse();

	var form = new mini.Form("form1");

	function SaveData() {
		var o = form.getData();

		form.validate();
		if (form.isValid() == false)
			return;

		var json = mini.encode([ o ]);
		//alert(" json:::" + json);
		$.ajax({
			url : "../workers/chargeItem!SaveChargeItems.action",
			type : 'post',
			data : {
				data : json
			},
			cache : false,
			success : function(text) {
				CloseWindow("save");
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert(jqXHR.responseText);
				CloseWindow();
			}
		});
	}

	////////////////////
	//标准方法接口定义
	function SetData(data) {

		if (data.action == "edit") {
			//跨页面传递的数据对象，克隆后才可以安全使用
			data = mini.clone(data);

			//alert(" data.id:::"+data.id);
			$.ajax({
				url : "../workers/chargeItem!GetChargeItem.action",
				data : "id=" + data.id,
				cache : false,
				success : function(text) {
					//alert(" text:::"+text);
					var o = mini.decode(text);
					form.setData(o);
					form.setChanged(false);

					onDeptChanged();
					mini.getbyName("chargeItemId").setValue(o.chargeItemId);
				}
			});
		}
	}

	function GetData() {
		var o = form.getData();
		return o;
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
	function onOk(e) {
		//	alert("----");
		SaveData();
	}
	function onCancel(e) {
		CloseWindow("cancel");
	}
	//////////////////////////////////
	function onDeptChanged(e) {
		var deptCombo = mini.getbyName("deptId");
		var positionCombo = mini.getbyName("positionId");
		var deptId = deptCombo.getValue();

		positionCombo
				.load("../app/employee!GetPositionsByDepartmenId.action?id="
						+ deptId);
		//positionCombo.setValue("");
	}
	</script>
</html>
