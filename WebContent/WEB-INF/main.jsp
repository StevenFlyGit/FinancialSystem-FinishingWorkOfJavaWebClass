<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>郑航学生选课系统</title>

<link href="${thm}/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${css}/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${css}/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="${upl}/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="${css}/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->
<style type="text/css">
	#header{height:85px}
	#leftside, #container, #splitBar, #splitBarProxy{top:90px}
</style>

<!--[if lte IE 9]>
<script src="${js}/speedup.js" type="text/javascript"></script>
<![endif]-->
<script src="${js}/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="${js}/jquery.cookie.js" type="text/javascript"></script>
<script src="${js}/jquery.validate.js" type="text/javascript"></script>
<script src="${js}/jquery.bgiframe.js" type="text/javascript"></script>
<script src="${xhe}/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="${xhe}/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="${js}/scripts/jquery.uploadify.min.js" type="text/javascript"></script>

<script src="${res}/bin/dwz.min.js" type="text/javascript"></script>
<script src="{js}/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	DWZ.init("${res}/dwz.frag.xml", {
//		loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"themes"});
			//setTimeout(function() {$("#sidebar .toggleCollapse div").trigger("click");}, 10);
			setTimeout(function() {$("#navMenu .selected>a").trigger("click");}, 10);
		}
	});
});
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="#">标志</a>
				<ul class="nav">
					<li><a href="#">欢迎： ${realname }</a></li>
					<li><a href="login.html">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>
		
			<div id="navMenu">
				<ul>
					<li  class="selected"><a href="${res}/common/select_course_manage.html"><span>选课管理</span></a></li>
					<li><a href="${res}/common/user_manage.jsp"><span>用户管理</span></a></li>
					<li><a href="${res}/common/course_manage.html"><span>课程管理</span></a></li>
				</ul>
			</div>
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>

				

			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<div class="alertInfo">
								<h2>随便写点什么吧！</h2>
								
							</div>
							<div class="right">
								<p>右上</p>
								<p>右下</a></p>
							</div>
							<p><span>郑航学生选课系统</span></p>
							<p>快来试试看</p>
						</div>
						<div class="pageFormContent" layoutH="80">
							这里你可以写点欢迎通知之类的
						</div>
					</div>
					
				</div>
			</div>
		</div>

	</div>

	<div id="footer">Copyright &copy; 2014 <a href="demo_page2.html" target="dialog">郑航团队</a></div>
</body>
</html>