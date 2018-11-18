<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>表格添加</title>
    <%-- <link rel="stylesheet"
        href="<%=request.getContextPath()%>/statics/libs/src/css/layui.css">
     --%>
    <style>
        body {
            padding: 20px;
        }
    </style>
    <script type="text/javascript"
            src="<%=request.getContextPath()%>/statics/libs/boot.js"></script>
    <script type="text/javascript"
            src="<%=request.getContextPath()%>/statics/libs/jquery.json-2.4.min.js"></script>
</head>
<body>
<form id="form1" method="post">
    <input name="config_pay_id" class="mini-hidden"/>
    <div style="padding-left:11px;padding-bottom:5px;">
        <table style="table-layout:fixed;">
            <tr>
                <td style="width:70px;">单位：</td>
                <td style="width:150px;">
                    <input name="tenant_id"
                           class="mini-combobox" valueField="tenant_id" textField="tenant_name"
                           url="<%=request.getContextPath()%>/ajax/jdsp/getTenant" required="true"
                           emptyText="请选择单位"/>
                </td>
                <td style="width:70px;">支付名称：</td>
                <td style="width:150px;"><input name="pay_name"
                                                class="mini-textbox" required="true" emptyText="请输入支付名称"/></td>

            </tr>
            <tr>
                <td>交易密钥：</td>
                <td><input name="key" class="mini-textbox" required="true" emptyText="请输入交易密钥"/>
                </td>
                <td>商户号：</td>
                <td><input name="mch_id" class="mini-textbox" required="true" emptyText="请输入商户号"/></td>
            </tr>
            <tr>
                <td style="width:70px;">支付类型</td>
                <td style="width:150px;"><input name="pay_type" emptyText="请输入支付类型"
                                                class="mini-textbox" required="true"/></td>
                <td style="width:70px;">编号：</td>
                <td><input name="pay_number"
                           class="mini-spinner" maxValue="999999" required="true" emptyText="请输入编号"/></td>

            </tr>
            <tr>
                <td style="width:70px;">app_id</td>
                <td style="width:150px;"><input name="app_id" emptyText="请输入app_id"
                                                class="mini-textbox" required="true"/></td>
                <td style="width:70px;">版本：</td>
                <td><input name="version"
                           class="mini-textbox" required="true" emptyText="请输入版本"/></td>

            </tr>
            <tr>
                <td>服务url：</td>
                <td colspan="3"><input name="service" class="mini-textarea"
                                       style="width:378px;" required="true" emptyText="请输入服务请求url"/></td>
            </tr>
            <tr>
                <td>支付请求url：</td>
                <td colspan="3"><input name="req_url" class="mini-textarea"
                                       style="width:378px;" required="true" emptyText="请输入支付请求url"/></td>
            </tr>
            <tr>
                <td>通知商户url：</td>
                <td colspan="3"><input name="notify_url" class="mini-textarea"
                                       style="width:378px;" required="true" emptyText="请输入通知商户url"/></td>
            </tr>
        </table>
    </div>

    <div style="text-align:center;padding:10px;">
        <a class="mini-button" onclick="onOk" iconCls="icon-ok">确定</a>
        <a class="mini-button" onclick="onCancel" iconCls="icon-close">取消</a>
    </div>
</form>


<script>

    mini.parse();

    var form = new mini.Form("form1");

    function SaveData() {
        var o = form.getData();
        form.validate();
        if (form.isValid() == false) return;
        var json = mini.encode([o]);
        $.ajax({
            url: "<%=request.getContextPath()%>/ajax/jdsp/saveAdd",
            type: 'post',
            data: {data: json},
            cache: false,
            success: function (text) {
                if (text.status > 0) {
                    mini.alert("保存成功", "提示", function () {
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
    }


</script>
</body>
</html>
