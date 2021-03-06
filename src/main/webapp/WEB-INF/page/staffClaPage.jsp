<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="head/head.jsp"%>

<div class="tpl-portlet-components">
	<div class="portlet-title">
		<div class="caption font-green bold">
			<span class="am-icon-code"></span> 报销单列表
		</div>
		<div class="tpl-portlet-input tpl-fz-ml">
			<div class="portlet-input input-small input-inline">
				<div class="input-icon right"></div>
			</div>
		</div>
	</div>
	<div class="tpl-block" style="text-align: center;">
		<form
			action="${pageContext.request.contextPath }/cla/findPageCla.action"
			method="post">
			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-3">
					<div class="am-form-group">
						<select name="claimVoucher.status"
							data-am-selected="{btnSize: 'sm'}" style="display: none;">
							<option value="all">全部状态</option>
							<option value="新创建"
								<c:if test="${stauts =='新创建'}">selected="selected"</c:if>>新创建</option>
							<option value="已付款"
								<c:if test="${stauts =='已付款'}">selected="selected"</c:if>>已付款</option>
							<option value="已审批"
								<c:if test="${stauts =='已审批'}">selected="selected"</c:if>>已审批</option>
							<option value="已打回"
								<c:if test="${stauts =='已打回'}">selected="selected"</c:if>>已打回</option>
							<option value="已终止"
								<c:if test="${stauts =='已终止'}">selected="selected"</c:if>>已终止</option>
							<option value="已提交"
								<c:if test="${stauts =='已提交'}">selected="selected"</c:if>>已提交</option>
							<option value="待审批"
								<c:if test="${stauts =='待审批'}">selected="selected"</c:if>>待审批</option>
						</select>
					</div>
				</div>
				<div class="am-u-sm-12 am-u-md-3"></div>
				<div class="am-u-sm-12 am-u-md-3">
					<div class="am-input-group am-input-group-sm">
						<input type="date"
							value="<ftm:formatDate value='${beginTime }' pattern='yyyy-MM-dd'/>"
							class="am-form-field" name="beginTime"> <span
							class="am-input-group-btn"></span>
					</div>
					<div class="am-input-group am-input-group-sm">
						<input type="date"
							value="<ftm:formatDate value='${overTime }' pattern='yyyy-MM-dd'/>"
							class="am-form-field" name="overTime"> <span
							class="am-input-group-btn"> </span> <span
							class="am-input-group-btn">
							<button
								class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search"
								type="submit"></button>
						</span>
					</div>
				</div>
			</div>
		</form>
		<div class="am-u-sm-12">
			<form class="am-form">
				<table id="dd"
					class="am-table am-table-striped am-table-hover table-main">
					<thead>
						<tr>
							<th class="table-id">编号</th>
							<th class="table-date am-hide-sm-only">填报日期</th>
							<th class="table-title">填报人</th>
							<th class="table-author am-hide-sm-only">总金额</th>
							<th class="table-type">状态</th>
							<th class="table-author am-hide-sm-only">待处理人</th>
							<th class="table-set">操作</th>
						</tr>
					</thead>

					<c:forEach items="${page.result }" var="cla">
						<tr>
							<td>${cla.id }</td>
							<td>${cla.createTime }</td>
							<td>${cla.sysEmployeeByCreateSn.name }</td>
							<td class="am-hide-sm-only">${cla.totalAccount }</td>
							<td class="am-hide-sm-only">${cla.status }</td>
							<td class="am-hide-sm-only">${cla.sysEmployeeByNextDealSn.name }</td>
							<td>
								<div class="am-btn-toolbar">
									<div class="am-btn-group am-btn-group-xs">
										<c:if test="${cla.status == '新创建' or cla.status == '已打回'}">
											<button
												class="am-btn am-btn-default am-btn-xs am-text-secondary">
												<span class="am-icon-pencil-square-o"></span> <a
													href="${pageContext.request.contextPath }/cla/modifyECla?claimVoucher.id=${cla.id }">编辑</a>
											</button>
										</c:if>
										<button
											class="am-btn am-btn-default am-btn-xs am-hide-sm-only">
											<span class="am-icon-copy"></span> <a style="color: black;"
												href="${pageContext.request.contextPath }/cla/findEClaById?claimVoucher.id=${cla.id }">
												查看</a>
										</button>
										<c:if test="${cla.status == '新创建' or cla.status == '已打回'}">
											<button name="del" value="${cla.id }"
												class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only">
												<span class="am-icon-trash-o"></span> 删除
											</button>
										</c:if>
									</div>
								</div>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>

				<div class="am-cf">
					<div class="am-fr">
						<ul class="am-pagination tpl-pagination">
							<c:if test="${t == 'tt' }">
								<li>没有该报销单,<a href="#" id="bks">点击返回</a></li>
							</c:if>
							<c:if test="${t != 'tt' }">
								<c:if test="${page.currtentPage != 1 }">
									<li><a
										href="${pageContext.request.contextPath }/cla/findPageCla?currtent=1&claimVoucher.status=${stauts}&beginTime=<ftm:formatDate value='${beginTime }' pattern='yyyy-MM-dd'/>&overTime=<ftm:formatDate value='${overTime }' pattern='yyyy-MM-dd'/>">首页</a></li>
								</c:if>
								<c:if test="${page.currtentPage != 1  }">
									<li><a
										href="${pageContext.request.contextPath }/cla/findPageCla?currtent=${page.currtentPage-1}&claimVoucher.status=${stauts}&beginTime=<ftm:formatDate value='${beginTime }' pattern='yyyy-MM-dd'/>&overTime=<ftm:formatDate value='${overTime }' pattern='yyyy-MM-dd'/>">«</a></li>
								</c:if>
								<c:if test="${page.currtentPage != null }">
									<li><input type="text" size="1"
										value="${page.currtentPage }"></li>
									<li class="am-disabled"><small>
											<button
												style="width: 100%; height: 10%; border-radius: 20px;"
												class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search"
												type="button"></button>
									</small></li>
								</c:if>
								<c:if test="${page.currtentPage != page.totalPage }">
									<li><a
										href="${pageContext.request.contextPath }/cla/findPageCla?currtent=${page.currtentPage+1}&claimVoucher.status=${stauts}&beginTime=<ftm:formatDate value='${beginTime }' pattern='yyyy-MM-dd'/>&overTime=<ftm:formatDate value='${overTime }' pattern='yyyy-MM-dd'/>">»</a></li>
								</c:if>
								<c:if test="${page.currtentPage != page.totalPage }">
									<li><a
										href="${pageContext.request.contextPath }/cla/findPageCla?currtent=${page.totalPage}&claimVoucher.status=${stauts}&beginTime=<ftm:formatDate value='${beginTime }' pattern='yyyy-MM-dd'/>&overTime=<ftm:formatDate value='${overTime }' pattern='yyyy-MM-dd'/>">尾页</a></li>
								</c:if>
							</c:if>
							<li>共${page.totalPage }页</li>
						</ul>
					</div>
				</div>
				<hr>
			</form>
		</div>
	</div>
</div>
<script
	src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("[name='del']")
				.click(
						function() {
							if (confirm("确认删除该报销单吗？该操作将不可撤回！")) {
								var id = $(this).val();
								var url = "${pageContext.request.contextPath}/cla/delECla.action?claimVoucher.id="
										+ id;
								$
										.ajax({
											url : url,
											type : "GET",
											success : function(data) {
												if (data == "isTrue") {
													alert("删除成功!");
													$("#dd").parent().parent()
															.remove();
												} else {
													alert("删除失败!");
												}
												//$("body").append(backdata);
											},
											error : function(ajax) {
												alert("异常");
											}
										});
							}
						});
		$("body")
				.on(
						"click",
						"[id='bks']",
						function() {
							$("[name='beginTime']").attr("value", "");
							$("[name='overTime']").attr("value", "");
							window.location.href = "${pageContext.request.contextPath }/cla/findPageCla.action?beginTime=&overTime=";
						});
	});
</script>
<%@include file="tail/tail.jsp"%>
