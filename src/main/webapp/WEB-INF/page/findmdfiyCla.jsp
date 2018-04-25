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
			<td>编&nbsp;号：${voucher.id }</td>
			<td>填写人：${voucher.sysEmployeeByCreateSn.name }</td>
			<td>部&nbsp;门：${voucher.sysEmployeeByCreateSn.sysDepartment.name }</td>
			<td>职&nbsp;位：${voucher.sysEmployeeByCreateSn.sysPosition.nameCn }</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>总金额：${voucher.totalAccount }</td>
			<td>填报时间：${voucher.createTime }</td>
			<td>状态：${voucher.status }</td>
			<td>待处理人： <c:if
					test="${voucher.sysEmployeeByNextDealSn.name != null}">
			    ${voucher.sysEmployeeByNextDealSn.name }
			    </c:if> <c:if test="${voucher.sysEmployeeByNextDealSn.name == null}">
			    	${voucher.sysEmployeeByCreateSn.name }
			    </c:if>
			</td>
		</tr>
	</table>
	<br>
	<hr>
	<table style="width: 100%;">
		<tr>
			<td>项目类别</td>
			<td>项目金额</td>
			<td>费用说明</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<c:forEach items="${details }" var="details">
			<tr>
				<td>${details.item }</td>
				<td>${details.account }</td>
				<td>${details.des }</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<a href="javascript:history.back(-1)"><span class="tpl-label-info">返回
			<i class="am-icon-share"></i>
	</span></a>
</div>

<%@include file="tail/tail.jsp"%>