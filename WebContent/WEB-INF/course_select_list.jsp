<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<form id="pagerForm" method="post" action="demo_page1.html">

	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
</form>


<div class="pageHeader">

	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>当前总学分：</label>
				<input type="text" disabled="disabled" value="4"/>
			</li>
		</ul>
		
		
	</div>
</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="course_list.html" target="navTab" ><span>选课</span></a></li>
			<li><a class="delete" href="demo/common/ajaxDone.html?uid={sid_user}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80">序号</th>
				<th width="120">课程名</th>
				<th>学分</th>
				<th width="100">任课老师</th>
				
			</tr>
		</thead>
		<tbody>
			<tr target="sid_user" rel="1">
				<td>1</td>
				<td>语文</td>
				<td>12</td>
				<td>李四</td>
			</tr>
			
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select>
			<span>条，共${totalCount}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="200" numPerPage="20" pageNumShown="10" currentPage="1"></div>

	</div>
</div>
