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
	<table style="width: 100%;">
		<tr>
			<td>姓&nbsp;名：${lea.employeeSn.name }</td>
			<td>部&nbsp;门：${lea.employeeSn.sysDepartment.name }</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>开始时间：${lea.starttime }</td>
			<td>结束时间：${lea.endtime }</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>请假天数：${lea.leaveday }</td>
			<td>休假类型：${lea.leavetype }</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>请假事由：${lea.reason }</td>
			<td>审批状态：${lea.status }</td>
		</tr>
	</table>
	<br>
	<hr>
	<table style="width: 100%;">
		<tr>
			<td>审批意见：${lea.approveOpinion}</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	</table>
	<hr>
	<a href="javascript:history.back(-1)"><span class="tpl-label-info">返回
			<i class="am-icon-share"></i>
	</span></a>
</div>
<%@include file="tail/tail.jsp"%>