<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<div class="pageContent">
	<form method="post" action="${ctx }//manager_add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<input type="hidden" name="id"  value="${manager.id}"/>
		<input type="hidden" name="dtype" /><!--要么是student，要么是管理员-->
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>姓名：</label>
				<input name="name" type="text" size="30" value="${manager.name}" class="required"/>
			</p>
			<p>
				<label>电话号码：</label>
				<input type="text" name="phone" value="${manager.phone}" class="phone"/>
			</p>
			<p>
				<label>性别：</label>
				<select name="sex" class="required combox">
					<option value="">请选择</option>
					<option value="女" ${manager.sex == '女' ? 'selected' : ''}>女</option>
					<option value="男" ${manager.sex == '男' ? 'selected' : ''}>男</option>
				</select>
			</p>
			<p>
				<label>年龄：</label>
				<input type="text" name="age" value="${manager.age}" class="required digits"/>
			</p>
			<p>
				<label>身份证号码：</label>
				<input type="text" name="idcard" value="${manager.idcard}" class="required digits"/>
			</p>
			<p>
				<label>月薪：</label>
				<input type="text" name="salary" value="${manager.salary}" class="required digits"/>
			</p>
			<p>
				<label>五险一金：</label>
				<input type="text" name="insurance" value="${manager.insurance}" class="digits"/>
			</p>
			<p>
				<label>年终奖金：</label>
				<input type="text" name="bonus" value="${manager.bonus}" class="digits"/>
			</p>
			<p>
				<label>赋税：</label>
				<input type="text" name="tax" value="${manager.tax}" class="digits"/>
			</p>
			<p>
				<label>职位：</label>
				<input type="text" name="position" value="${manager.position}" class="required "/>
			</p>
			<p>
				<label>邮箱：</label>
				<input type="text" name="email" value="${manager.email}" class=""/>
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
