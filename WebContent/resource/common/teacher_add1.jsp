<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<div class="pageContent">
	<form method="post" action="demo/common/ajaxDone.html" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input type="hidden" name="id" />
		<input type="hidden" name="dtype" /><!--要么是student，要么是管理员-->
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>姓名：</label>
				<input name="name" type="text" size="30" value="" class="required lettersonly"/>
			</p>
			
			<p>
				<label>电话号码：</label>
				<input type="text"  value="" name="phone" class="phone"/>
			</p>
			<p>
				<label>性别：</label>
				<select name="type" class="required combox">
					<option value="">请选择</option>
					<option value="女">女</option>
					<option value="男">男</option>
				</select>
			</p>
			<p>
				<label>密码：</label>
				<input type="password" value="" id="password" minlength="6" maxlength="20" class="required"/>
			</p>
			<p>
				<label>确认密码：</label>
				<input type="password" value="" name="password2" equalto="#password" class="required"/>
			</p>
			<p>
				<label>年龄：</label>
				<input type="age" value="" name="age" min="20" max="25" class="number"/>
			</p>
			
			<p>
                <label>出生日期</label>
                <input type="text" name="date2" value="2000-01-15" class="date" minDate="1990-01-01" maxDate="2020-12-31" readonly="true"/>
                <a class="inputDateButton" href="javascript:;">选择</a>
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
