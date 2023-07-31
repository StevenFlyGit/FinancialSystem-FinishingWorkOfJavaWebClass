<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<div class="pageContent">
	<form method="post" action="${ctx }//teacher_add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<input type="hidden" name="id"  value="${teacher.id}"/>
		<input type="hidden" name="dtype" /><!--要么是student，要么是管理员-->
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>姓名：</label>
				<input name="name" type="text" size="30" value="${teacher.name}" class="required lettersonly"/>
			</p>
			
			<p>
				<label>电话号码：</label>
				<input type="text" name="phone" value="${teacher.phone}" class="phone"/>
			</p>
			<p>
				<label>性别：</label>
				<select name="sex" class="required combox">
					<option value="">请选择</option>
					<option value="女" ${teacher.sex == '女' ? 'selected' : ''}>女</option>
					<option value="男" ${teacher.sex == '男' ? 'selected' : ''}>男</option>
				</select>
			</p>

		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
