<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="accordion" fillSpace="sideBar">
	<div class="accordionHeader">
		<h2><span>Folder</span>学生管理</h2>
	</div>
	<div class="accordionContent">
		<ul class="tree treeFolder">
			<li><a href="WEB-INF/user_list.html?type=student" target="navTab" rel="studentlist">学生一览</a></li>
		</ul>
	</div>
	<div class="accordionHeader">
		<h2><span>Folder</span>教师管理</h2>
	</div>
	<div class="accordionContent">
		<ul class="tree treeFolder">
			<li><a href="teacher_list" target="navTab" rel="teacherlist">教师一览</a></li>
		</ul>
	</div>
	<div class="accordionHeader">
		<h2><span>Folder</span>管理员用户管理</h2>
	</div>
	<div class="accordionContent">
		<ul class="tree">
			<li><a href="WEB-INF/user_list.html?type=admin" target="navTab" rel="dlg_page">管理员一览</a></li>
		</ul>
	</div>
</div>

