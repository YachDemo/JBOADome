<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="head/manage_head.jsp"%>
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
		</tr>
	</table>
	<br>
	<hr>
	<form id="formId" method="post" action="${pageContext.request.contextPath }/lea/leave!modify_lea_managerById">
	<table style="width: 100%;">
		<tr>
			<td>审批意见：
			<textarea name="leave.approveOpinion"
						style="outline: none; width: 80%; border: 1px solid #D0D0D0; border-radius: 15px;"></textarea>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
	<tr style="text-align: center;">
			<td>
				<a href="javascript:history.back(-1)"><span class="tpl-label-info">返回
				<i class="am-icon-share"></i>
		</span></a>
			</td>
				<td colspan="3" align="center">
				<input type="hidden" id="vll" name="leave.status" value="">
				<input type="hidden" name="leave.id" value="${leave.id }">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs" style="float: none;">
							<button id="sptg"
								style="border-radius: 15px;" type="button"
								class="am-btn am-btn-default am-btn-secondary">
								<span class="am-icon-save"></span>审批通过
							</button>
						</div>
						<div class="am-btn-group am-btn-group-xs" style="float: none;">
							<button id="dh"
								style="border-radius: 15px;" type="button"
								class="am-btn am-btn-default am-btn-warning">
								<span class="am-icon-archive"></span>打回
							</button>
						</div>
					</div>
				</td>
			</tr>
		</table>
		</form>
</div>
<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#sptg").click(function() {
			alert("sd");
			$("#vll").attr("value","已审批");
			$("#result").attr("value","通过");
			$("#formId").submit();
		});
		$("#dh").click(function() {
			$("#vll").attr("value","已打回");
			$("#result").attr("value","打回");
			$("#formId").submit();
		});
	});
</script>
<%@include file="tail/tail.jsp"%>