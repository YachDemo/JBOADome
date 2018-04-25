<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="head/head.jsp"%>
<div class="tpl-portlet-components">
	<div class="portlet-title">
		<div class="caption font-green bold">
			<span class="am-icon-code"></span> 添加报销单
		</div>
		<div class="tpl-portlet-input tpl-fz-ml"></div>
	</div>
	<form id="formId"
		action="${pageContext.request.contextPath }/cla/addECla.action"
		method="post">
		<table style="width: 100%;">
			<tr>
				<td>填报人：${emp.name }</td>
				<td>填报日期：<ftm:formatDate value="${date }" pattern="yyyy-MM-dd" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>总金额：<input name="claimVoucher.totalAccount"
					readonly="readonly" id="totalC" type="number"
					style="border: 1px solid #D0D0D0; border-radius: 15px; padding-left: 8px; padding-top: 2px; padding-bottom: 2px;"></td>
				<td>状态：<input type="text" value="新创建" readonly="readonly"
					style="border: 1px solid #D0D0D0; border-radius: 15px; padding-left: 8px; padding-top: 2px; padding-bottom: 2px;"></td>
			</tr>
		</table>
		<hr>
		<table style="width: 80%;">
			<tr>
				<td>费用类别</td>
				<td>项目金额</td>
				<td>费用说明</td>
				<td>操作</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
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
						style="outline: none; width: 80%; border: 1px solid #D0D0D0; border-radius: 15px;"></textarea>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>

			<tr style="text-align: center;">
				<td colspan="4" align="center"><input type="hidden" id="vll"
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
	</form>
</div>
<script
	src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/statics/myJs/add.js"></script>
<%@include file="tail/tail.jsp"%>