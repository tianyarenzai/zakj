<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>jQuery自定义下拉框选择菜单DEMO演示</title>

<!---基础样式-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/statics/select/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/statics/select/css/demo.css">

<!---图标样式-->
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" />

<!---代码格式样式，可无视-->
<link rel="stylesheet" href="https://cdn.bootcss.com/SyntaxHighlighter/3.0.83/styles/shCore.css" type="text/css">
<link rel="stylesheet" href="https://cdn.bootcss.com/SyntaxHighlighter/3.0.83/styles/shThemeDefault.css" type="text/css">

<!---主要样式-->
<link rel="stylesheet" href="<%=request.getContextPath()%>/statics/select/css/selectmenu.css" type="text/css">

</head>
<body>

<div class="container">
	<h1 class="page-header">下拉菜单插件 <small>支持下拉，分页，键盘操作等功能</small></h1>
	<div class="row-fluid">
		<h2 class="page-header">1.经典使用场景 <small></small></h2>
		<div class="col-md-12">
			<div class="col-md-6">
				<p><strong>A</strong>. Select your favorite NBA team:
					<button type="button" class="btn btn-default" id="demoSingle">Select Team</button>
				</p>
				<div class="thumbnail">
					<img id="nbaTeamLogo">
					<div class="caption">
						<p id="nabTeamName"></p>
					</div>
				</div>
				<p>The NBA team logo images copyright comes form <a href="http://china.nba.com" target="_blank">china.nba.com</a></p>
			</div>
			<div class="col-md-6">
				<p><strong>B</strong>. Choose teams to follow team news:
					<button type="button" class="btn btn-default" id="demoMultiple">Select Teams</button>
			<div class="panel panel-default">
					<div class="panel-body" id="nbaTeamLists"></div>
				</div>
				</p>
				<div class="panel panel-default">
					<div class="panel-body" id="nbaTeamLists1"></div>
				</div>
			</div>
		</div>
	</div>

	<div class="row-fluid">
		<div class="col-md-12">
			<div class="col-md-6">
				<p><strong>C</strong>. Which site you want to visit ?</p>
				<p><button type="button" class="btn btn-default" id="demoBaseMenu">Select Menu <i class="fa fa-caret-down"></i></button></p>
			</div>
			<div class="col-md-6">
				<p><strong>D</strong>. Menu embedded to page</p>
				<div id="demoEmbedded"></div>
			</div>
		</div>
	</div>

	<div class="row-fluid">
		<div class="col-md-12">
			<div class="col-md-12">
				<strong>E</strong>. your mouse right click to call menu
				<div class="jumbotron" id="demoRightClick">
					<h2 class="text-center"><i class="fa fa-mouse-pointer"></i> 鼠标右键查看效果</h2>
				</div>
			</div>
		</div>
	</div>



	<div class="row-fluid">
		<h2 class="page-header">2.1 常规下拉菜单 <small></small></h2>
		<script type="syntaxhighlighter" class="brush:js">
<![CDATA[
//菜单使用的数据格式
/**
* content  [string]   : 菜单项目显示文本，支持HTML格式（设置内容为“sm_divider”可生成分隔栏）
* header   [boolean]  : 是否为子标题栏
* url      [string]   : 需要跳转的链接
* callback [function] : 需要执行的回调函数
* disabled [boolean]  : 是否禁用菜单项目
*/
var menuData = [
{content:'News Site',header: true},//定义子标题栏
{content:'163 NetEase',url : 'http://www.163.com'},//链接跳转型菜单项目
{content:'sm_divider'},//分隔栏
//使用HTML的方式设置菜单显示的内容，并定义菜单项目为禁用
{content:'<i class="fa fa-fw fa-facebook"></i> Facebook',url : 'https://www.facebook.com',disabled : true},
//点击后执行回调的菜单项目
{content:'Click this menu item to trigger your callback',callback : function(){
	bDialog.alert('you can do anything in callback!');
}}
];
]]>
</script>
		<button type="button" class="btn btn-default" id="baseMenu"><i class="fa fa-bars"></i> Select Menu</button>


		<script type="syntaxhighlighter" class="brush:js">
<![CDATA[
//HTML按钮
<button type="button" id="btnMenu" >Select Team</button>
//javascript 设置
$('#btnMenu').click(function(){
$(this).selectMenu({
	//设置常规菜单模式
	regular : true,
	data : menuData
});
});
]]>
		</script>
		<div class="alert alert-info" role="alert">
			示例中，带回调的菜单项目中的弹出窗口为 <a href="https://terryz.github.io/bdialog/index.html" target="_blank"><strong>bDialog</strong></a> 插件
		</div>
	</div>

	<div class="row-fluid">
		<h4 class="heading">2.2 带标题栏的菜单 <small></small></h4>
		<button type="button" class="btn btn-default" id="baseMenuHeader"><i class="fa fa-header"></i> Select Menu</button>
		<script type="syntaxhighlighter" class="brush:js">
<![CDATA[
$('#btnMenu').click(function(){
$(this).selectMenu({
	title : '<i class="fa fa-fw fa-thumbs-o-up"></i> I can have a title bar',
	regular : true,
	data : menuData
});
});
]]>
		</script>
	</div>

	<div class="row-fluid">
		<h4 class="heading">2.3 带子标题菜单项目的菜单 <small></small></h4>
		<button type="button" class="btn btn-default" id="baseMenuSubHeader"><i class="fa fa-list-ul"></i> Select Menu</button>
		<script type="syntaxhighlighter" class="brush:js">
<![CDATA[
//设置数据中项目header : true，即可指定为子标题栏
var menuData = [
{content:'News Site',header: true}
];
//javascript 设置
$('#btnMenu').click(function(){
$(this).selectMenu({
	regular : true,
	data : menuData
});
});
]]>
		</script>
	</div>

	<div class="row-fluid">
		<h4 class="heading">2.4 带箭头的菜单 <small></small></h4>
		<button type="button" class="btn btn-default" id="baseMenuArrow"><i class="fa fa-arrow-up"></i> 带箭头的菜单</button>
		<button type="button" class="btn btn-default" id="baseMenuRight"><i class="fa fa-arrow-right"></i> 菜单右对齐</button>
		<button type="button" class="btn btn-default" id="baseMenuCenter"><i class="fa fa-arrow-down"></i> 菜单居中对齐</button>
		<script type="syntaxhighlighter" class="brush:js">
<![CDATA[
$('#btnMenu').click(function(){
$(this).selectMenu({
	arrow : true,//打开菜单箭头，默认不带箭头
	position : 'right',//可设置'left'(default),'center','right'
	regular : true,
	data : menuData
});
});
]]>
		</script>
	</div>


	<div class="row-fluid">
		<h2 class="page-header">3.1 高级下拉菜单 <small></small></h2>
		<script type="syntaxhighlighter" class="brush:js">
<![CDATA[
//菜单使用的示例数据格式
//数据格式与常规菜单模式的固定格式不同，该模式下，数据格式可以完全自定义
//并通过设置keyField、showField、searchField等参数进行指定具体使用的数据节点
var selectMenuData = [
{id:1 ,name:'Chicago Bulls',desc:'芝加哥公牛',abbr:'CHI'},
{id:2 ,name:'Cleveland Cavaliers',desc:'克里夫兰骑士',abbr:'CLE'},
{id:3 ,name:'Detroit Pistons',desc:'底特律活塞',abbr:'DET'},
{id:4 ,name:'Indiana Pacers',desc:'印第安纳步行者',abbr:'IND'},
{id:5 ,name:'Milwaukee Bucks',desc:'密尔沃基雄鹿',abbr:'MIL'}
];
]]>
		</script>
		<button type="button" class="btn btn-default" id="selectMenuBase"><i class="fa fa-server"></i> Select Menu</button>
		<script type="syntaxhighlighter" class="brush:js">
<![CDATA[
//HTML按钮
<button type="button" id="btnMenu" >Select Team</button>
//javascript 设置
$('#btnMenu').click(function(){
$(this).selectMenu({
	showField : 'name',//指定显示文本的字段
	keyField : 'id',//指定id的字段
	data : selectMenuData
});
});
]]>
</script>
	</div>

	<div class="row-fluid">
		<h4 class="heading">3.2 不需要快速搜索的下拉菜单 <small></small></h4>
		<button type="button" class="btn btn-default" id="selectMenuNoSearch"><i class="fa fa-server"></i> Select Menu</button>
		<script type="syntaxhighlighter" class="brush:js">
<![CDATA[
$('#btnMenu').click(function(){
$(this).selectMenu({
	showField : 'name',
	keyField : 'id',
	search : false,//关闭搜索栏
	data : selectMenuData
});
});
]]>
</script>
	</div>

	<div class="row-fluid">
		<h4 class="heading">3.3 指定菜单显示项目个数 <small></small></h4>
		<button type="button" class="btn btn-default" id="selectMenuListSize"><i class="fa fa-server"></i> Select Menu</button>
		<script type="syntaxhighlighter" class="brush:js">
<![CDATA[
$('#btnMenu').click(function(){
$(this).selectMenu({
	showField : 'name',
	keyField : 'id',
	search : false,
	title : false,//关闭标题栏
	listSize : 5,//设置显示的菜单项目个数（菜单高度）
	data : selectMenuData
});
});
]]>
</script>
	</div>

	<div class="row-fluid">
		<h4 class="heading">3.4 多分组数据下拉菜单、多选模式 <small></small></h4>
		<script type="syntaxhighlighter" class="brush:js">
<![CDATA[
//多分组格式数据，要求数据必须按照以下格式设置，但list节点内的数据，与不分组的数据格式一样，可以自由定义
var selectMenuGroupData = [{
title : 'East',
list :[
	{id:1 ,name:'Chicago Bulls',desc:'芝加哥公牛',abbr:'CHI'},
	{id:2 ,name:'Cleveland Cavaliers',desc:'克里夫兰骑士',abbr:'CLE'}
]
},{
title : 'West',
list : [
	{id:16,name:'Denver Nuggets',desc:'丹佛掘金',abbr:'DEN'},
	{id:17,name:'Minnesota Timberwolves',desc:'明尼苏达森林狼',abbr:'MIN'}
]}
];
]]>
		</script>
		<button type="button" class="btn btn-default" id="selectMenuGroup"><i class="fa fa-server"></i> Select Menu</button>
		<script type="syntaxhighlighter" class="brush:js">
<![CDATA[
$('#btnMenu').click(function(){
$(this).selectMenu({
	showField : 'name',
	keyField : 'id',
	multiple : true,//打开多选模式
	data : selectMenuGroupData
});
});
]]>
</script>
	</div>

	<div class="row-fluid">
		<h4 class="heading">3.5 初始化选中项目 <small></small></h4>
		<button type="button" class="btn btn-default" id="selectMenuInit"><i class="fa fa-server"></i> Select Menu</button>
		<script type="syntaxhighlighter" class="brush:js">
<![CDATA[
$('#btnMenu').click(function(){
$(this).selectMenu({
	showField : 'name',
	keyField : 'id',
	arrow : true,
	initSelected : 1,
	data : selectMenuData
});
});
]]>
</script>
	</div>

	<div class="row-fluid">
		<h4 class="heading">3.6 自定义项目显示模板 <small></small></h4>
		<button type="button" class="btn btn-default" id="selectMenuFormat"><i class="fa fa-server"></i> Select Menu</button>
		<script type="syntaxhighlighter" class="brush:js">
<![CDATA[
$('#btnMenu').click(function(){
$(this).selectMenu({
	showField : 'name',
	keyField : 'id',
	initSelected : 1,
	//自定义菜单项目显示模板
	formatItem : function(row){
		var html = '<div class=""><div class="col-md-3">';
		html += '<img src="image.jpg" width="64" height="64">';
		html += '</div>';
		html += '<div class="col-md-7">';
		html += row.name + row.name + '<br>' + row.desc;
		html += '</div></div>';
		return html;
	},
	data : selectMenuData
});
});
]]>
</script>
	</div>


	<div class="row-fluid">
		<h2 class="page-header">4.1 鼠标右键打开菜单模式 <small>仅右键可打开</small></h2>
		<div class="row">
			<div class="col-md-6">
				<p>常规模式菜单嵌入</p>
				<div class="jumbotron" id="selectMenuRightClickBase">
					<h3 class="text-center"><i class="fa fa-mouse-pointer"></i> Mouse right click this area</h3>
				</div>
				<script type="syntaxhighlighter" class="brush:js">
<![CDATA[
//html元素定义
<div class="jumbotron" id="selectMenuRightClickBase">
<h3 class="text-center">
	<i class="fa fa-mouse-pointer"></i>
	Mouse right click this area
</h3>
</div>
//javascript代码
$('#selectMenuRightClickBase').selectMenu({
title : 'Regular menu',
//常规菜单模式
regular : true,
//打开鼠标右键模式
rightClick : true,
data : baseMenuHeaderData
});
]]>
				</script>
			</div>
			<div class="col-md-6">
				<p>多功能模式菜单嵌入</p>
				<div class="jumbotron" id="selectMenuRightClickAdv">
					<h3 class="text-center"><i class="fa fa-mouse-pointer"></i> Mouse right click this area</h3>
				</div>
				<script type="syntaxhighlighter" class="brush:js">
<![CDATA[
//html元素定义
<div class="jumbotron" id="selectMenuRightClickAdv">
<h3 class="text-center">
	<i class="fa fa-mouse-pointer"></i>
	Mouse right click this area
</h3>
</div>
//javascript代码
$('#selectMenuRightClickAdv').selectMenu({
title : 'Advanced menu',
showField : 'name',
keyField : 'id',
//打开鼠标右键模式
rightClick : true,
data : selectMenuData
});
]]>
				</script>
			</div>
		</div>
	</div>


	<div class="row-fluid">
		<h2 class="page-header">5.1 菜单使用动态数据 <small></small></h2>
		<p>
			<button type="button" class="btn btn-default" id="btnAddRow">Add row</button>
			<button type="button" class="btn btn-default" id="selectMenuDynamic"><i class="fa fa-server"></i> Select Menu</button>
		</p>
		<div class="row-fluid">
			<ul class="list-group col-md-3" id="ulDynamicMenu">
				<li class="list-group-item">SelectPage</li>
				<li class="list-group-item">SelectMenu</li>
				<li class="list-group-item">bDialog</li>
				<li class="list-group-item">bPage</li>
				<li class="list-group-item">bTabs</li>
			</ul>
		</div>

		<script type="syntaxhighlighter" class="brush:js">
<![CDATA[
$(this).selectMenu({
title : 'Dynamic data menu',
regular : true,
data : function(){
	var d = new Array();
	$('#ulDynamicMenu li').each(function(i,row){
		var rd = { content : $(row).text(), url : 'https://aaa.com' };
		d.push(rd);
	});
	return d;
}
});
]]>
</script>
	</div>


	<div class="row-fluid">
		<h2 class="page-header">6.1 菜单嵌入网页模式 <small>不以弹出的形式展现</small></h2>
		<div class="row">
			<div class="col-md-6">
				<p>常规模式菜单嵌入</p>
				<div id="selectMenuEmbedBase"></div>
			</div>
			<div class="col-md-6">
				<p>多功能模式菜单嵌入</p>
				<div id="selectMenuEmbedAdv"></div>
			</div>
		</div>

		<script type="syntaxhighlighter" class="brush:js">
<![CDATA[
//html元素定义，注意，一定要使用DIV，使用其它容器无效
<div id="selectMenuEmbedBase"></div>
//javascript代码
$('#selectMenuEmbedBase').selectMenu({
showField : 'name',
keyField : 'id',
embed : true,//设置打开嵌入网页模式
data : selectMenuGroupData
});
]]>
		</script>

	</div>

	
	
</div>


<script type="text/javascript" src="<%=request.getContextPath()%>/statics/select/js/jquery-1.11.0.min.js"></script>

<!---代码格式样式，可无视-->
<script type="text/javascript" src="https://cdn.bootcss.com/SyntaxHighlighter/3.0.83/scripts/shCore.js" ></script>
<script type="text/javascript" src="https://cdn.bootcss.com/SyntaxHighlighter/3.0.83/scripts/shBrushXml.js" ></script>
<script type="text/javascript" src="https://cdn.bootcss.com/SyntaxHighlighter/3.0.83/scripts/shBrushCss.js" ></script>
<script type="text/javascript" src="https://cdn.bootcss.com/SyntaxHighlighter/3.0.83/scripts/shBrushJava.js" ></script>
<script type="text/javascript" src="https://cdn.bootcss.com/SyntaxHighlighter/3.0.83/scripts/shBrushJScript.js" ></script>



<script type="text/javascript" src="<%=request.getContextPath()%>/statics/select/js/selectmenu.min.js" ></script>    
<script type="text/javascript">
$(function(){
	var selectMenuData = [
		{id:1 ,name:'Chicago Bulls',desc:'芝加哥公牛',abbr:'CHI'},
		{id:2 ,name:'Cleveland Cavaliers',desc:'克里夫兰骑士',abbr:'CLE'},
		{id:3 ,name:'Detroit Pistons',desc:'底特律活塞',abbr:'DET'},
		{id:4 ,name:'Indiana Pacers',desc:'印第安纳步行者',abbr:'IND'},
		{id:5 ,name:'Milwaukee Bucks',desc:'密尔沃基雄鹿',abbr:'MIL'},
		{id:6 ,name:'Brooklyn Nets',desc:'布鲁克林篮网',abbr:'BKN'},
		{id:7 ,name:'Boston Celtics',desc:'波士顿凯尔特人',abbr:'BOS'},
		{id:8 ,name:'New York Knicks',desc:'纽约尼克斯',abbr:'NYK'},
		{id:9 ,name:'Philadelphia 76ers',desc:'费城76人',abbr:'PHI'},
		{id:10,name:'Toronto Raptors',desc:'多伦多猛龙',abbr:'TOR'},
		{id:11,name:'Atlanta Hawks',desc:'亚特兰大老鹰',abbr:'ATL'},
		{id:12,name:'Charlotte Hornets',desc:'夏洛特黄蜂',abbr:'CHA'},
		{id:13,name:'Miami Heat',desc:'迈阿密热火',abbr:'MIA'},
		{id:14,name:'Orlando Magic',desc:'奥兰多魔术',abbr:'ORL'},
		{id:15,name:'Washington Wizards',desc:'华盛顿奇才',abbr:'WAS'},
		{id:16,name:'Denver Nuggets',desc:'丹佛掘金',abbr:'DEN'},
		{id:17,name:'Minnesota Timberwolves',desc:'明尼苏达森林狼',abbr:'MIN'},
		{id:18,name:'Oklahoma City Thunder',desc:'俄克拉荷马雷霆',abbr:'OKC'},
		{id:19,name:'Portland Trail Blazers',desc:'波特兰开拓者',abbr:'POR'},
		{id:20,name:'Utah Jazz',desc:'犹他爵士',abbr:'UTA'},
		{id:21,name:'Golden State Warriors',desc:'金州勇士',abbr:'GSW'},
		{id:22,name:'Los Angeles Clippers',desc:'洛杉矶快船',abbr:'LAC'},
		{id:23,name:'Los Angeles Lakers',desc:'洛杉矶湖人',abbr:'LAL'},
		{id:24,name:'Phoenix Suns',desc:'菲尼克斯太阳',abbr:'PHX'},
		{id:25,name:'Sacramento Kings',desc:'萨克拉门托国王',abbr:'SAC'},
		{id:26,name:'Dallas Mavericks',desc:'达拉斯小牛',abbr:'DAL'},
		{id:27,name:'Houston Rockets',desc:'休斯顿火箭',abbr:'HOU'},
		{id:28,name:'Memphis Grizzlies',desc:'孟菲斯灰熊',abbr:'MEM'},
		{id:29,name:'New Orleans Pelicans',desc:'新奥尔良鹈鹕',abbr:'NOP'},
		{id:30,name:'San Antonio Spurs',desc:'圣安东尼奥马刺',abbr:'SAS'}
	];
	var selectMenuGroupData = [{
		title : 'East',
		list :[
			{id:1 ,name:'Chicago Bulls',desc:'芝加哥公牛',abbr:'CHI'},
			{id:2 ,name:'Cleveland Cavaliers',desc:'克里夫兰骑士',abbr:'CLE'},
			{id:3 ,name:'Detroit Pistons',desc:'底特律活塞',abbr:'DET'},
			{id:4 ,name:'Indiana Pacers',desc:'印第安纳步行者',abbr:'IND'},
			{id:5 ,name:'Milwaukee Bucks',desc:'密尔沃基雄鹿',abbr:'MIL'},
			{id:6 ,name:'Brooklyn Nets',desc:'布鲁克林篮网',abbr:'BKN'},
			{id:7 ,name:'Boston Celtics',desc:'波士顿凯尔特人',abbr:'BOS'},
			{id:8 ,name:'New York Knicks',desc:'纽约尼克斯',abbr:'NYK'},
			{id:9 ,name:'Philadelphia 76ers',desc:'费城76人',abbr:'PHI'},
			{id:10,name:'Toronto Raptors',desc:'多伦多猛龙',abbr:'TOR'},
			{id:11,name:'Atlanta Hawks',desc:'亚特兰大老鹰',abbr:'ATL'},
			{id:12,name:'Charlotte Hornets',desc:'夏洛特黄蜂',abbr:'CHA'},
			{id:13,name:'Miami Heat',desc:'迈阿密热火',abbr:'MIA'},
			{id:14,name:'Orlando Magic',desc:'奥兰多魔术',abbr:'ORL'},
			{id:15,name:'Washington Wizards',desc:'华盛顿奇才',abbr:'WAS'}
		]
	},{
		title : 'West',
		list : [
			{id:16,name:'Denver Nuggets',desc:'丹佛掘金',abbr:'DEN'},
			{id:17,name:'Minnesota Timberwolves',desc:'明尼苏达森林狼',abbr:'MIN'},
			{id:18,name:'Oklahoma City Thunder',desc:'俄克拉荷马雷霆',abbr:'OKC'},
			{id:19,name:'Portland Trail Blazers',desc:'波特兰开拓者',abbr:'POR'},
			{id:20,name:'Utah Jazz',desc:'犹他爵士',abbr:'UTA'},
			{id:21,name:'Golden State Warriors',desc:'金州勇士',abbr:'GSW'},
			{id:22,name:'Los Angeles Clippers',desc:'洛杉矶快船',abbr:'LAC'},
			{id:23,name:'Los Angeles Lakers',desc:'洛杉矶湖人',abbr:'LAL'},
			{id:24,name:'Phoenix Suns',desc:'菲尼克斯太阳',abbr:'PHX'},
			{id:25,name:'Sacramento Kings',desc:'萨克拉门托国王',abbr:'SAC'},
			{id:26,name:'Dallas Mavericks',desc:'达拉斯小牛',abbr:'DAL'},
			{id:27,name:'Houston Rockets',desc:'休斯顿火箭',abbr:'HOU'},
			{id:28,name:'Memphis Grizzlies',desc:'孟菲斯灰熊',abbr:'MEM'},
			{id:29,name:'New Orleans Pelicans',desc:'新奥尔良鹈鹕',abbr:'NOP'},
			{id:30,name:'San Antonio Spurs',desc:'圣安东尼奥马刺',abbr:'SAS'}
		]}
	];
	var baseMenuData = [
		{content:'163 NetEase',url : 'http://www.163.com'},
		{content:'Sina',url : 'http://www.sina.com'},
		{content:'sm_divider'},
		{content:'<i class="fa fa-fw fa-github"></i> GitHub',url : 'https://github.com'},
		{content:'<i class="fa fa-fw fa-reddit"></i> Reddit',url : 'https://www.reddit.com'},
		{content:'<i class="fa fa-fw fa-facebook"></i> Facebook',url : 'https://www.facebook.com',disabled : true},
		{content:'<i class="fa fa-fw fa-twitter"></i> Twitter',url : 'https://twitter.com',disabled : true},
		{content:'sm_divider'},
		{content:'Click this menu item to trigger your callback',callback : function(){
			bDialog.alert('you can do anything in callback!');
		}}
	];
	var baseMenuHeaderData = [
		{content:'News Site',header: true},
		{content:'163 NetEase',url : 'http://www.163.com'},
		{content:'Sina',url : 'http://www.sina.com'},
		{content:'sm_divider'},
		{content:'Technology Site',header: true},
		{content:'<i class="fa fa-fw fa-github"></i> GitHub',url : 'https://github.com'},
		{content:'<i class="fa fa-fw fa-reddit"></i> Reddit',url : 'https://www.reddit.com'},
		{content:'<i class="fa fa-fw fa-facebook"></i> Facebook',url : 'https://www.facebook.com',disabled : true},
		{content:'<i class="fa fa-fw fa-twitter"></i> Twitter',url : 'https://twitter.com',disabled : true},
		{content:'sm_divider'},
		{content:'Actions',header: true},
		{content:'Click this menu item to trigger your callback',callback : function(){
			bDialog.alert('you can do anything in callback!');
		}}
	];
	$('#selectMenuBase').click(function(){
		$(this).selectMenu({
			showField : 'name',
			keyField : 'id',
			search : true,
			data : selectMenuData
		});
	});
	$('#selectMenuNoSearch').click(function(){
		$(this).selectMenu({
			showField : 'name',
			keyField : 'id',
			search : false,
			data : selectMenuData
		});
	});
	$('#selectMenuListSize').click(function(){
		$(this).selectMenu({
			showField : 'name',
			keyField : 'id',
			search : false,
			title : false,
			listSize : 5,
			data : selectMenuData
		});
	});
	$('#selectMenuGroup').click(function(){
		$(this).selectMenu({
			showField : 'name',
			keyField : 'id',
			listSize : 7,
			multiple : true,
			data : selectMenuGroupData
		});
	});
	$('#selectMenuInit').click(function(){
		$(this).selectMenu({
			showField : 'name',
			keyField : 'id',
			arrow : true,
			initSelected : 1,
			data : selectMenuData
		});
	});
	$('#selectMenuFormat').click(function(){
		$(this).selectMenu({
			showField : 'name',
			keyField : 'id',
			initSelected : 1,
			formatItem : function(row){
				var logoUrl = 'http://china.nba.com/media/img/teams/logos/';
				var html = '<div class=""><div class="col-md-3">';
				html += '<img src="'+logoUrl+row.abbr+'_logo.svg" width="64" height="64">';
				html += '</div>';
				html += '<div class="col-md-7">';
				html += row.name + '<br>' + row.desc;
				html += '</div></div>';
				return html;
			},
			data : selectMenuData
		});
	});
	$('#selectMenuRightClickBase').selectMenu({
		title : 'Regular menu',
		regular : true,
		rightClick : true,
		data : baseMenuHeaderData
	});
	$('#selectMenuRightClickAdv').selectMenu({
		title : 'Advanced menu',
		showField : 'name',
		keyField : 'id',
		rightClick : true,
		data : selectMenuData
	});
	$('#btnAddRow').click(function(){
		var li = $('<li>').addClass('list-group-item').html('new menu item ' + ($('#ulDynamicMenu li').size()+1));
		$('#ulDynamicMenu').append(li);
	});
	$('#selectMenuDynamic').click(function(){
		$(this).selectMenu({
			title : 'Dynamic data menu',
			regular : true,
			data : function(){
				var d = new Array();
				$('#ulDynamicMenu li').each(function(i,row){
					var rd = { content : $(row).text(), url : 'https://github.com/TerryZ/SelectPage' };
					d.push(rd);
				});
				return d;
			}
		});
	});






	$('#baseMenu').click(function(){
		$(this).selectMenu({
			regular : true,
			arrow : false,
			data : baseMenuData
		});
	});
	$('#baseMenuArrow').click(function(){
		$(this).selectMenu({
			regular : true,
			arrow : true,
			data : baseMenuData
		});
	});
	$('#baseMenuRight').click(function(){
		$(this).selectMenu({
			regular : true,
			arrow : true,
			position : 'right',
			data : baseMenuData
		});
	});
	$('#baseMenuCenter').click(function(){
		$(this).selectMenu({
			regular : true,
			arrow : true,
			position : 'center',
			data : baseMenuData
		});
	});
	$('#baseMenuHeader').click(function(){
		$(this).selectMenu({
			regular : true,
			title : '<i class="fa fa-fw fa-thumbs-o-up"></i> I can have a title bar',
			data : baseMenuData
		});
	});
	$('#baseMenuSubHeader').click(function(){
		$(this).selectMenu({
			title : 'SelectMenu ',
			regular : true,
			data : baseMenuHeaderData
		});
	});

	$('#demoSingle').click(function(){
		$(this).selectMenu({
			showField : 'name',
			keyField : 'id',
			search : true,
			data : selectMenuData,
			eSelect : function(data){
				if(data && data.length > 0){
					$('#nbaTeamLogo').attr('src','http://china.nba.com/media/img/teams/logos/'+data[0].abbr+'_logo.svg');
					$('#nabTeamName').html(data[0].name + '(' + data[0].desc + ')');
				}
			}
		});
	});
	$('#nbaTeamLists').click(function(){
		$(this).selectMenu({
			showField : 'name',
			keyField : 'id',
			multiple : true,
			lang : 'en',
			position : 'right',
			data : selectMenuGroupData,
			eSelect : function(data){
				$('#nbaTeamLists').empty();
				if(data && data.length > 0){
					$.each(data,function(i,row){
					$('#nbaTeamLists').append(row.abbr+'-'+row.name+'(' + row.desc + ')'+',');
			
					//	$('#nbaTeamLists').append('<p><strong>'+row.abbr+'</strong> - '+row.name+'(' + row.desc + ')</p>');
					});
				}
			}
		});
	});
	$('#demoMultiple').click(function(){
		$(this).selectMenu({
			showField : 'name',
			keyField : 'id',
			multiple : true,
			lang : 'en',
			position : 'right',
			data : selectMenuGroupData,
			eSelect : function(data){
				$('#nbaTeamLists').empty();
				if(data && data.length > 0){
					$.each(data,function(i,row){
					$('#nbaTeamLists').append(row.abbr+'-'+row.name+'(' + row.desc + ')'+',');
			
					//	$('#nbaTeamLists').append('<p><strong>'+row.abbr+'</strong> - '+row.name+'(' + row.desc + ')</p>');
					});
				}
			}
		});
	});
	
	$('#demoBaseMenu').click(function(){
		$(this).selectMenu({
			title : 'SelectMenu ',
			regular : true,
			data : baseMenuHeaderData
		});
	});
	$('#demoEmbedded,#selectMenuEmbedBase').selectMenu({
		title : 'The menu is Embedded to page',
		embed : true,
		regular : true,
		data : baseMenuHeaderData
	});
	$('#demoRightClick').selectMenu({
		title : 'This is mouse right click menu',
		regular : true,
		rightClick : true,
		data : baseMenuHeaderData
	});
	$('#selectMenuEmbedAdv').selectMenu({
		showField : 'name',
		keyField : 'id',
		embed : true,
		multiple : true,//打开多选模式
		data : selectMenuGroupData
	});
	SyntaxHighlighter.all();
});
</script>

<div style="text-align:center;clear:both">
<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script>
</div>

</body>
</html>