<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<title>人员编辑</title>
	<script type="text/javascript" src="<%=request.getContextPath() %>/statics/libs/boot.js" ></script>
</head>
<body>
<form id="operator_edit_form">
	<div style="padding:5px;">
		<table style="width:100%" cellpadding="1" cellspacing="1">
			<tr>
				<td style="width:80px;">员工账号：</td>
				<td style="width:150px;">
					<input class="mini-hidden" id="cmsoid" name="cmsoid" />
					<input  class="mini-textbox" id="cmsologinname" name="cmsologinname" />
				</td>
				<td style="width:80px;">性别：</td>
				<td style="width:150px;">
					<select name="cmsosex" class="mini-radiobuttonlist">
						<option value="1">男</option>
						<option value="2">女</option>
					</select>
				</td>
			</tr>
			<tr>
				<td >年龄：</td>
				<td >
					<input name="cmsoage" class="mini-spinner" value="25" minValue="1" maxValue="200" />
				</td>
				<td >真实姓名：</td>
				<td >
					<input class="mini-textbox" id="cmsorealname" name="cmsorealname"  />
				</td>
			</tr>
			<tr>
				<td >电话：</td>
				<td >
					<input class="mini-textbox" id="cmsophone" name="cmsophone" vtype="phone" required="true" requiredErrorText="电话不能为空"/>
				</td>
				<td >邮箱：</td>
				<td >
					<input class="mini-textbox" id="cmsoemail" name="cmsoemail" vtype="email" required="true" requiredErrorText="邮箱不能为空" />
				</td>
			</tr>
			<tr>
				<td >生日：</td>
				<td colspan="3">
					<input class="mini-datepicker" format="yyyy-MM-dd" id="cmsbirthday" name="cmsbirthday" />
				</td>
			</tr>
			<tr>
				<td >地址：</td>
				<td colspan="3">
					<input class="mini-textarea" name="cmsoaddress" style="width:410px;" />
				</td>
			</tr>
		</table>
	</div>
</form>
<script type="text/javascript">
	mini.parse();
	var operaflg = ${operaflg};  //0:新增页面  1：修改页面  2：详情页面
	var operatorbean = '${operatorbean}';
	$(function(){
		if(operaflg > 0){ //修改页赋值
			var operatordata = mini.decode(operatorbean);   //反序列化成对象
			var operator_edit_form = new mini.Form("#operator_edit_form");
			operator_edit_form.setData(operatordata);
		}
	});

	//表单提交
	function onSbForm(){
		//判断表单验证
		var cmsologinname = mini.get("cmsologinname").getValue();
		var cmsorealname = mini.get("cmsorealname").getValue();

		if($.trim(cmsologinname).length == 0){
			mini.alert("登录名不能为空！");
			return false;
		}
		if($.trim(cmsorealname).length == 0){
			mini.alert("真实姓名不能为空！");
			return false;
		}
		//数据保存
		saveData();
	}

	function saveData(){
		mini.parse();
		var form = new mini.Form("operator_edit_form");
		var formData  = form.getData();//获取数据源
		form.validate();//表单验证
		if (form.isValid() == false) return;
		var json = mini.encode(formData);
		$.ajax({
			url : "<%=request.getContextPath() %>/ajax/jdsp/saveOperatorEditData",
			type : "post",
			data : {"data" : json},
			cache : false,
			success : function(data) {
				//alert(JSON.stringify(data));
				if(data.status > 0){
					mini.alert("保存成功");
					//调用父页面的关闭方法
					window.parent.fn_win_operator_close();
				}else{
					mini.alert("保存失败");
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				salert(jqXHR.responseText);
			}
		});
	}

</script>
</body>
</html>

