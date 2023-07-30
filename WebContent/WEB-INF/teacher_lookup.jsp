<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<div class="pageHeader">
	<form rel="pagerForm" id="pagerForm" method="post" action="demo/database/dwzOrgLookup.html" onsubmit="return dwzSearch(this, 'dialog');">
		<input type="hidden" name="pageNum" value="1" />
		<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>教师姓名:</label>
				<input class="textInput" name="name" value="" type="text">
			</li>	  
			
		</ul>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">

	<table class="table" layoutH="118" targetType="dialog" width="100%">
		<thead>
			<tr>
				<th>序号</th>
				<th>教师姓名</th>
				<th >教师性别</th>
				<th width="80">电话号码</th>
				<th width="80">查找带回</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>李四</td>
				<td>男</td>
				<td>132416546</td>
				<td>
					<a class="btnSelect" href="javascript:$.bringBack({id:'2', name:'李四'})" title="查找带回">选择</a>
				</td>
			</tr>
			
		</tbody>
	</table>

	<div class="panelBar">
		<div class="pages">
			<span>每页</span>

			<select name="numPerPage" onchange="dwzPageBreak({targetType:dialog, numPerPage:'10'})">
				<option value="10" selected="selected">10</option>
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
			</select>
			<span>条，共2条</span>
		</div>
		<div class="pagination" targetType="dialog" totalCount="2" numPerPage="10" pageNumShown="1" currentPage="1"></div>
	</div>
</div>