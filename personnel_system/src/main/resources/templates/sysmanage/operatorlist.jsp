<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<title>人员信息</title>
	<style type="text/css">
		
	</style>
</head>
<body>
<div style="width:100%;">
    <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
        <table style="width:100%;">
            <tr>
                <td style="width:100%;">
                    <a class="mini-button" iconCls="icon-add" id="dadd" value="showAtEl" onclick="editOperator(0);" plain="true" tooltip="增加...">增加</a>
                    <span class="separator"></span>
                    <a class="mini-button" iconCls="icon-edit" onclick="editOperator(1);" plain="true">修改</a>
                    <span class="separator"></span>
                    <a class="mini-button" iconCls="icon-remove" onclick="removeOperator();" plain="true">删除</a>
                    <span class="separator"></span>
                    <a class="mini-button" iconCls="icon-cut" onclick="clearFilter();" plain="true">清除过滤条件</a>
                </td>
                <td style="white-space:nowrap;">
                    <input id="searchtext" class="mini-textbox" emptyText="请输入查询内容" style="width:150px;" onenter="onKeyEnter"/>
                    <a class="mini-button" onclick="search()">查询</a>
                </td>
            </tr>
        </table>
    </div>
</div>
<div id="datagrid1" class="mini-datagrid" style="width:100%;height:auto;"
     url="<%=request.getContextPath() %>/ajax/jdsp/queryoperatorlist2" ajaxType="GET" idField="cmsoid"
     allowResize="true" pageSize="20"
     allowCellEdit="false" allowCellSelect="true" multiSelect="true" showFilterRow="true"
     editNextOnEnterKey="true"  editNextRowCell="true">
    <div property="columns" class="cls_gridcolumns">
        <div type="indexcolumn"></div>
        <div type="checkcolumn"></div>
        <div field="cmsologinname" width="120" headerAlign="center" allowSort="true" >员工帐号
            <input id="cmsologinnameFilter" property="filter" class="mini-textbox" style="width:100%;" onvaluechanged="onFilterChanged" />
        </div>
        <div field="cmsorealname" width="80" headerAlign="center" allowSort="true" >真实姓名
            <input id="cmsorealnameFilter" property="filter" class="mini-textbox" style="width:100%;" onvaluechanged="onFilterChanged" />
        </div>
        <div field="cmsoage" width="60" headerAlign="center" allowSort="true" >年龄
            <input id="cmsoageFilter" property="filter" class="mini-filteredit" filterData="ageFilters" style="width:100%;"
                   onvaluechanged="onFilterChanged" showClose="true" />
            <!--                 <input id="cmsoageFilter" property="filter" class="mini-spinner"  minValue="0" maxValue="200"  style="width:100%;"/> -->
        </div>
        <div field="cmsbirthdaydisp" width="100" headerAlign="center" allowSort="true" dateFormat="yyyy-MM-dd">出生日期
            <input id="cmsbirthdayFilter" property="filter" class="mini-datepicker" format="yyyy-MM-dd" style="width:100%;" onvaluechanged="onFilterChanged" />
        </div>
        <!--ComboBox：本地数据-->
        <div field="cmsosex" type="comboboxcolumn" autoShowPopup="true" width="80" allowSort="true"  align="center" headerAlign="center">性别
            <input property="editor" class="mini-combobox" style="width:100%;" data="Genders" />
            <input id="cmsosexFilter" property="filter" class="mini-combobox" style="width:100%;" data="Genders" onvaluechanged="onFilterChanged"/>
        </div>
        <div field="cmsophone" width="80" headerAlign="center" allowSort="true">电话
            <input id="cmsophoneFilter" property="filter" class="mini-textbox" style="width:100%;" onvaluechanged="onFilterChanged" />
        </div>
        <div field="cmsoemail" width="120" headerAlign="center" allowSort="true">邮箱
            <input id="cmsoemailFilter" property="filter" class="mini-textbox" style="width:100%;" onvaluechanged="onFilterChanged" />
        </div>
        <div field="cmsoaddress" width="180" headerAlign="center" allowSort="true">地址
            <input id="cmsoaddressFilter" property="filter" class="mini-textbox" style="width:100%;" onvaluechanged="onFilterChanged" />
        </div>
    </div>
</div>

<div id="win_operator_eidt" class="mini-window" title="编辑" style="width:550px;height:300px;" iconCls="icon-edit"
     showMaxButton="false" showCollapseButton="false" showShadow="true" showModal="true"
     showToolbar="true" showFooter="true"  allowResize="true" allowDrag="true"
     url="">
    <div class="operator_eidt_footer" property="footer" style="text-align:right;padding:5px;padding-right:15px;">
        <div style="text-align:center;">
            <a class="mini-button mini-button-info" iconCls="icon-save" onclick="fn_saveoperator();" style="width:60px;margin-right:20px;">确定</a>
            <a class="mini-button mini-button-info" iconCls="icon-cancel" onclick="fn_win_operator_close();" style="width:60px;">取消</a>
        </div>
    </div>
</div>

<script type="text/javascript">
    var Genders = [{ id: 1, text: '男' }, { id: 2, text: '女'}];
    var ageFilters = [{ text: '大于', value: '>' }, { text: '小于', value: '<' }, { text: '等于', value: '=='}];

    mini.parse();
    var grid = mini.get("datagrid1");
    grid.load();

    function search() {
        var searchtext = mini.get("searchtext").getValue();
//             alert(encodeURI($.trim(key)));
        grid.load({ "searchtext": encodeURI($.trim(searchtext)) });
    }

    function onKeyEnter(e) {
        search();
    }

    function onFilterChanged() {
        //获取搜索框值
        var cmsologinnameVal = mini.get("cmsologinnameFilter").getValue();
        var cmsorealnameVal = mini.get("cmsorealnameFilter").getValue();
        var cmsoageVal = mini.get("cmsoageFilter").getValue();
        var cmsoageFilterVal = mini.get("cmsoageFilter").getFilterValue().toLowerCase();
        var cmsbirthdayVal = mini.get("cmsbirthdayFilter").getFormValue();
        var cmsosexVal = mini.get("cmsosexFilter").getValue();
        var cmsophoneVal = mini.get("cmsophoneFilter").getValue();
        var cmsoemailVal = mini.get("cmsoemailFilter").getValue();
        var cmsoaddressVal = mini.get("cmsoaddressFilter").getValue();

        //组装json和后台交互
        var cmsobj = {};
        cmsobj.cmsologinname = cmsologinnameVal;
        cmsobj.cmsorealname = cmsorealnameVal;
        cmsobj.cmsoageStr = cmsoageVal;
        cmsobj.cmsoageFilterOpflg = cmsoageFilterVal;
        cmsobj.cmsbirthday = cmsbirthdayVal;
        cmsobj.cmsosexStr = cmsosexVal;
        cmsobj.cmsophone = cmsophoneVal;
        cmsobj.cmsoemail = cmsoemailVal;
        cmsobj.cmsoaddress = cmsoaddressVal;

        var jsondata = JSON.stringify(cmsobj);
        grid.load({"searchdata": encodeURI(jsondata)});

    }



    //编辑方法（弹出window）
    function editOperator(opflg){
        var cmsoid = 0;
        var win = mini.get("win_operator_eidt");
        var url = "<%=request.getContextPath() %>/jdsp/popOperatorEditPage";
        if(opflg == 1){
            var rows = grid.getSelecteds();
            if (rows.length == 1) {
                cmsoid = rows[0].cmsoid;
                url += "?cmsoid="+cmsoid;
            } else {
                mini.alert("请选中一条记录");
                return;
            }
        }
        win.setUrl(url);
        win.showAtPos("center", "middle");
    }

    //关闭window弹出窗口
    function fn_win_operator_close(){
        grid.reload();
        mini.get("win_operator_eidt").hide();
    }

    function fn_saveoperator(){
        var win = mini.get("win_operator_eidt");
        //找到子页面iframe,调用子页面的保存方法
        var iframe = win.getIFrameEl();
        iframe.contentWindow.onSbForm();
    }

    //删除方法
    function removeOperator(){
        var rows = grid.getSelecteds();
        if (rows.length > 0) {
            mini.confirm("确定删除选中记录？","确认",function(oc){
                if (oc == "ok") {
                    grid.loading("操作中，请稍后......");
                    var ids = [];
                    for (var i = 0; i < rows.length;  i++) {
                        var row = rows[i];
                        ids.push(row.cmsoid);
                    }
                    var cmsoids = ids.join(',');
                    $.ajax({
                        url : "<%=request.getContextPath() %>/ajax/jdsp/removeOperators",
                        type : "post",
                        data : {"data" : cmsoids},
                        cache : false,
                        success : function(data) {
                            if(data.status > 0){
                                mini.alert("删除成功");
                                grid.reload();
                            }else{
                                mini.alert("删除失败");
                            }
                            grid.unmask();//取消遮罩
                        },
                        error : function(jqXHR, textStatus, errorThrown) {
                            salert(jqXHR.responseText);
                        }
                    });
                }
            });
        } else {
            mini.alert("请选择需要删除的记录");
        }
    }

    //清除过滤条件
    function clearFilter() {
        mini.get("cmsologinnameFilter").setValue("");
        mini.get("cmsorealnameFilter").setValue("");
        mini.get("cmsoageFilter").setValue("");
        mini.get("cmsoageFilter").setFilterValue("");
        mini.get("cmsbirthdayFilter").setValue("");
        mini.get("cmsosexFilter").setValue("");
        mini.get("cmsophoneFilter").setValue("");
        mini.get("cmsoemailFilter").setValue("");
        mini.get("cmsoaddressFilter").setValue("");
        grid.load();
    }
</script>
</html>