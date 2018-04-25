<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="head/head.jsp"%>
<div class="tpl-portlet-components">
	<div class="portlet-title">
		<div class="caption font-green bold">
			<span class="am-icon-code"></span> 查看报销单
		</div>
		<div class="tpl-portlet-input tpl-fz-ml"></div>
	</div>
	<p>
		<strong>基本信息</strong>
	</p>
	<form method="post" action="${pageContext.request.contextPath }/lea/leave!save_laeve">
	<table style="width: 100%;">
		<tr>
			<td>姓&nbsp;名：${employee.name }</td>
			<td>部&nbsp;门：${employee.sysDepartment.name }</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>开始时间：<input type="date" name="leave.starttime" style="border: 1px solid #D0D0D0; border-radius: 15px; padding-left: 8px; padding-top: 2px; padding-bottom: 2px;"></td>
			<td>结束时间：<input type="date" name="leave.endtime" style="border: 1px solid #D0D0D0; border-radius: 15px; padding-left: 8px; padding-top: 2px; padding-bottom: 2px;"></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>请假天数：<input type="number" name="leave.leaveday" style="border: 1px solid #D0D0D0; border-radius: 15px; padding-left: 8px; padding-top: 2px; padding-bottom: 2px;">(天)</td>
			<td>休假类型：<select name="leave.leavetype">
				<option>年假</option>
				<option>事假</option>
				<option>婚假</option>
				<option>病假</option>
			</select></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>请假事由：<textarea name="leave.reason"
						style="outline: none; width: 80%; border: 1px solid #D0D0D0; border-radius: 15px;"></textarea></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>下一审批人:<input type="text" value="${employpos.name }"></td>
		</tr>
	</table>
	<hr>
	<div class="am-btn-group am-btn-group-xs" style="float: none;">
							<button
								style="border-radius: 15px;" type="submit"
								class="am-btn am-btn-default am-btn-warning">
								<span class="am-icon-archive"></span>提交流程
							</button>
						</div>
	<a href="javascript:history.back(-1)"><span class="tpl-label-info">返回
			<i class="am-icon-share"></i>
	</span></a>
	</form>
</div>
<%@include file="tail/tail.jsp"%>