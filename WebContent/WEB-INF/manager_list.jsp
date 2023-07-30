<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form id="pagerForm" method="post" action="demo_page1.html">
	<input type="hidden" name="status" value="${param.status}">
	<input type="hidden" name="keywords" value="${param.keywords}" />
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="${ctx}/manager_list" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			    <td>
					<select class="combox" name="sex">
						<option value="">性别</option>
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
				</td>
				<td>
					姓名：<input type="text" name="name" />
				</td>
				<td>
					电话号码：<input type="text" name="phone"/>
				</td>
				<td>
					身份证号：<input type="text" name="idcard"/>
				</td>
				<td>
					年龄：<input type="text" name="age"/>
				</td>
				<td>
					职位：<input type="text" name="position"/>
				</td>
				<td>
					月薪：<input type="text" name="salary"/>
				</td>
				<td>
					五险一金：<input type="text" name="insurance"/>
				</td>
				<td>
					年终奖金：<input type="text" name="bonus"/>
				</td>
				<td>
					赋税：<input type="text" name="tax"/>
				</td>
				<td>
					邮箱：<input type="text" name="email"/>
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
			<li><a class="add" href="${com}/manager_add.jsp" target="dialog"><span>添加</span></a></li>
			<li><a class="delete" href="${ctx}/manager_delete?id={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="${ctx}/manager_add?id={sid_user}" target="dialog"><span>修改</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="3%" align="center">序号</th>
				<th width="5%" align="center">姓名</th>
				<th width="10%" align="center">电话号</th>
				<th width="3%" align="center">性别</th>
				<th width="3%" align="center">年龄</th>
				<th width="14%" align="center">身份证号码</th>
				<th width="8%" align="center">月薪</th>
				<th width="8%" align="center">五险一金</th>
				<th width="8%" align="center">年终奖金</th>
				<th width="8%" align="center">赋税</th>
				<th width="6%" align="center">职位</th>
				<th width="10%" align="center">邮箱</th>
			</tr>
		</thead>
		<tbody>
		    <c:forEach items="${list}" var="manager" varStatus="status">
		        <tr target="sid_user" rel="${manager.id}">
		            <td>${status.count}</td>
		            <td>${manager.name}</td>
		            <td>${manager.phone}</td>
		            <td>${manager.sex}</td>
		            <td>${manager.age}</td>
		            <td>${manager.idcard}</td>
		            <td>${manager.salary}</td>
		            <td>${manager.insurance}</td>
		            <td>${manager.bonus}</td>
		            <td>${manager.tax}</td>
		            <td>${manager.position}</td>
		            <td>${manager.email}</td>
		        </tr>
		    </c:forEach>
			
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				
                <option value="10" ${page.numPerPage== 10 ?'selected':''}>10</option>
				<option value="20" ${page.numPerPage== 20 ?'selected':''}>20</option>
				<option value="50" ${page.numPerPage== 50 ?'selected':''}>50</option>
			</select>
			<span>条，共${totalCount}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" 
		totalCount="${Page.totalCount}"
		numPerPage="${Page.numPerPage}" 
		pageNumShown="${Page.pageNumShown}"
		currentPage="${Page.currentPage}">
		</div>

	</div>
</div>
