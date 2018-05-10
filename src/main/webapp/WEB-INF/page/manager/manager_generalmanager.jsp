<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="head/manage_head.jsp" %>
<div class="tpl-portlet-components">
	<div class="portlet-title">
		<div class="caption font-green bold">
			<span class="am-icon-code"></span> 审核报销单
		</div>
		<div class="tpl-portlet-input tpl-fz-ml"></div>
	</div>
		<form id="formId"
		action="${pageContext.request.contextPath }/cla/modify_manager.action"
		method="post">
		<p>
			<strong>基本信息</strong>
		</p>
		<table style="width: 100%;">
			<tr>
				<td>编&nbsp;号：<input name="claimVoucher.id" type="text" value="${voucher.id }" style="border: none;"/></td>
				<td>填写人：${voucher.sysEmployeeByCreateSn.name }</td>
				<td>部&nbsp;门：${voucher.sysEmployeeByCreateSn.sysDepartment.name }</td>
				<td>职&nbsp;位：${voucher.sysEmployeeByCreateSn.sysPosition.nameCn }</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>总金额：<input type="text" name="claimVoucher.totalAccount" value="${voucher.totalAccount }" id="totalC" style="border: none;"/></td>
				<td>填报时间：<input type="text" name="claimVoucher.createTime" value="${voucher.createTime }" style="border: none;"/></td>
				<td>状态：${voucher.status }</td>
				<td>待处理人： 
			    ${voucher.sysEmployeeByNextDealSn.name }
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
				<td>审批人：${result.checkerSn.name }(${ result.checkerSn.sysPosition.nameCn})</td>
				<td>审批时间：${result.checkTime}</td>
				<td>审核：${result.result}</td>
				<td>审核意见：${result.comm}</td>
			</tr>
			<tr>
				<td colspan="4"><hr></td>
			</tr>
			<tr>
				<td colspan="3">*审批意见： <textarea name="checkResult.comm"
						style="outline: none; width: 80%; border: 1px solid #D0D0D0; border-radius: 15px;"></textarea>
				</td>
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
				<input type="hidden" id="vll" name="claimVoucher.status" value="">
				<input type="hidden" id="result" name="checkResult.result" value="">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs" style="float: none;">
							<button id="sptg"
								style="border-radius: 15px;" type="button"
								class="am-btn am-btn-default am-btn-secondary">
								<span class="am-icon-save"></span>审批通过
							</button>
						</div>
						<div class="am-btn-group am-btn-group-xs" style="float: none;">
							<button id="spjj"
								style="border-radius: 15px;" type="button"
								class="am-btn am-btn-default am-btn-warning">
								<span class="am-icon-archive"></span>审批拒绝
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
			$("#vll").attr("value","已审核");
			$("#result").attr("value","通过");
			$("#formId").submit();
		});
		$("#spjj").click(function() {
			$("#vll").attr("value","已终止");
			$("#result").attr("value","拒绝");
			$("#formId").submit();
		});
		$("#dh").click(function() {
			$("#vll").attr("value","已打回");
			$("#result").attr("value","打回");
			$("#formId").submit();
		});
	});
</script>
<%@include file="tail/tail.jsp" %>