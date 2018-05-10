<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="head/head.jsp"%>
<div class="tpl-portlet-components">
	<div class="portlet-title">
		<div class="caption font-green bold">
			<span class="am-icon-code"></span> 修改报销单
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
					<td><input namedd="voucherDetail.account" type="text"
						value="${details.account }" style="border: none;" /></td>
					<td>${details.des }</td>
					<td>
						<div class="am-btn-group am-btn-group-xs">
							<button type='button' value="${details.id }" name='delTds'
								class='am-btn am-btn-default am-btn-danger'>
								<span class='am-icon-trash-o'></span>
							</button>
						</div>
					</td>
				</tr>
			</c:forEach>
			<tr class="hidd">
				<td><input class="hidds" namedd="voucherDetail.item"
					type="text"
					style="border: 1px solid #D0D0D0; border-radius: 15px; padding-left: 8px; padding-top: 2px; padding-bottom: 2px;">
					<input type="hidden" name="item" value="" /></td>
				<td><input class="hidds" names="tj_0"
					namedd="voucherDetail.account" type="number"
					style="border: 1px solid #D0D0D0; border-radius: 15px; padding-left: 8px; padding-top: 2px; padding-bottom: 2px;">
					<input type="hidden" name="account" value="" /></td>
				<td><input class="hidds"
					namedd="voucherDetail.bizClaimVoucher.event" type="text"
					style="border: 1px solid #D0D0D0; border-radius: 15px; padding-left: 8px; padding-top: 2px; padding-bottom: 2px;">
					<input type="hidden" name="event" value="" /></td>
				<td>
					<div class="am-btn-group am-btn-group-xs">
						<button name="addTd" type="button"
							class="am-btn am-btn-default am-btn-success">
							<span class="am-icon-plus"></span>
						</button>
					</div>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td colspan="3">*事由： <textarea name="claimVoucher.event"
						style="outline: none; width: 80%; border: 1px solid #D0D0D0; border-radius: 15px;">${voucher.event }</textarea>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>

			<tr style="text-align: center;">
				<td><a href="javascript:history.back(-1)"><span
						class="tpl-label-info">返回 <i class="am-icon-share"></i>
					</span></a></td>
				<td colspan="3" align="center"><input type="hidden" id="vll"
					name="claimVoucher.status" value="">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs" style="float: none;">
							<button id="cj" value="新创建" style="border-radius: 15px;"
								type="button" class="am-btn am-btn-default am-btn-secondary">
								<span class="am-icon-save"></span> 保存
							</button>
						</div>
						<div class="am-btn-group am-btn-group-xs" style="float: none;">
							<button id="sp" value="待审批" style="border-radius: 15px;"
								type="button" class="am-btn am-btn-default am-btn-warning">
								<span class="am-icon-archive"></span> 审核
							</button>
						</div>
					</div></td>
			</tr>
		</table>
		<hr>
	</form>
</div>

<%@include file="tail/tail.jsp"%>
<script
	src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/myJs/modify.js"></script>