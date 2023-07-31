<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form id="pagerForm" method="post" action="demo_page1.html">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<%-- <input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" /> --%>
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="${ctx}/teacher_list" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					姓名：<input type="text" name="name" />
				</td>
				<td>
					<select class="combox" name="sex">
						<option value="">性别</option>
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
				</td>
				<td>
					电话号码：<input type="text" name="phone"/>
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="${com}/teacher_add.jsp" target="dialog"><span>添加</span></a></li>
			<li><a class="delete" href="${ctx}/teacher_delete?id={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="${ctx}/teacher_add?id={sid_user}" target="dialog"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80">序号</th>
				<th width="120">姓名</th>
				<th width="80" align="center">性别</th>
				<th width="250">电话号</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach items="${list}" var="teacher" varStatus="status">
		        <tr target="er" rel="${teacher.id}">
		            <td>${status.count}</td>
		            <td>${teacher.name}</td>
		            <td>${teacher.sex}</td>
		            <td>${teacher.phone}</td>
		        </tr>
		    </c:forEach>
			<!-- <tr target="sid_user" rel="1">
				<td>1</td>
				<td>A120113196309052434</td>
				<td>男</td>
				<td>13013485135</td>
			</tr> -->
			
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
			<!-- 分页项单页记录条数更改 -->
				<option value="20"
				     <c:if test="${page.numPerPage == 20}"> 
				     selected="selected"
				     </c:if>> 20
				</option>
				<option value="50"
				     <c:if test="${page.numPerPage == 50}"> 
				     selected="selected"
				     </c:if>> 50
                </option>
				<option value="100"
				     <c:if test="${page.numPerPage == 100}"> 
				     selected="selected"
				     </c:if>> 100
				</option>
				<option value="200"
				     <c:if test="${page.numPerPage == 200}"> 
				     selected="selected"
				     </c:if>> 200
				</option>
			</select>
			<span>条，共${Page.totalCount}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" 
		totalCount="${Page.totalCount}"
		numPerPage="${Page.numPerPage}" 
		pageNumShown="${Page.pageNumShown}"
		currentPage="${Page.currentPage}">
		</div>

	</div>
</div>
