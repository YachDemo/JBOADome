<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="head/manage_head.jsp"%>
<div class="tpl-portlet-components">
	<div class="portlet-title">
		<div class="caption font-green bold">
			<span class="am-icon-code"></span> 审核报销单
		</div>
		<div class="tpl-portlet-input tpl-fz-ml"></div>
	</div>
	<form id="formId"
		action="${pageContext.request.contextPath }/cla/modifyCla.action"
		method="post">
		<p>
			<strong>基本信息</strong>
		</p>
		<table style="width: 100%;">
			<tr>
				<td>编&nbsp;号：<input name="claimVoucher.id" type="text"
					value="${voucher.id }" style="border: none;" /></td>
				<td>填写人：${voucher.sysEmployeeByCreateSn.name }</td>
				<td>部&nbsp;门：${voucher.sysEmployeeByCreateSn.sysDepartment.name }</td>
				<td>职&nbsp;位：${voucher.sysEmployeeByCreateSn.sysPosition.nameCn }</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>总金额：<input type="text" name="claimVoucher.totalAccount"
					value="${voucher.totalAccount }" id="totalC" style="border: none;" /></td>
				<td>填报时间：<input type="text" name="claimVoucher.createTime"
					value="${voucher.createTime }" style="border: none;" /></td>
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
			<tr>
				<td colspan="4"><hr></td>
			</tr>
			<tr>
				<td colspan="3">*审批意见： <textarea name=""
						style="outline: none; width: 80%; border: 1px solid #D0D0D0; border-radius: 15px;"></textarea>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>

			<tr style="text-align: center;">
				<td><a href="javascript:history.back(-1)"><span
						class="tpl-label-info">返回 <i class="am-icon-share"></i>
					</span></a></td>
			</tr>
		</table>
	</form>
</div>

<%@include file="tail/tail.jsp"%>