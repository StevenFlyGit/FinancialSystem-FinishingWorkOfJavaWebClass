<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网络公司管理系统</title>
<%-- <link href="${css}/login.css" rel="stylesheet" type="text/css" /> --%>
<link href="${css}/login_style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	 <h1>User Login</h1>
     <div class="avtar">
	       <img src="${thm}/default/images/avtar.png" />
     </div>
	 <div class="login-form">
		<p>New user?<a href="#">Register here!</a></p>
			<form action="/salary/LoginServlet_worker" method="post">
				<div class="form-text">
					<input type="text" class="text" value="USERNAME" name="workername" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'USERNAME';}" >
					<input type="password" value="Password" name="password" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Password';}">
				</div>
					<input type="submit"value="GO" >
			</form>
	</div>
<!--/User-Login-->
<!--start-copyright-->
<div class="copy-right">
	<p>欢迎使用网络公司管理系统</p> 
</div>
	      
</body>
</html>