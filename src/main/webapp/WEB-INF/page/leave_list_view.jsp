<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="head/head.jsp"%>
<div class="tpl-portlet-components">
	<div class="portlet-title">
		<div class="caption font-green bold">
			<span class="am-icon-code"></span> 查看请假
		</div>
		<div class="tpl-portlet-input tpl-fz-ml"></div>
	</div>
	<form
		action="${pageContext.request.contextPath }/lea/leave!find_lea_Page.action"
		method="post">
		<div class="am-g">
			<div class="am-u-sm-12 am-u-md-3"></div>
			<div class="am-u-sm-12 am-u-md-3">
				<div class="am-input-group am-input-group-sm">
					开始时间：<input type="date"
						value="<ftm:formatDate value='${beginTime }' pattern='yyyy-MM-dd'/>"
						class="am-form-field" name="beginTime"> <span
						class="am-input-group-btn"></span>
				</div>
			</div>
			<div class="am-input-group am-input-group-sm" style="width: 25%;">
				结束时间：<input type="date"
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
	</form>
	<div class="am-u-sm-12">
		<form class="am-form">
			<table id="dd"
				class="am-table am-table-striped am-table-hover table-main">
				<thead>
					<tr>
						<th class="table-id">编号</th>
						<th class="table-id">名称</th>
						<th class="table-date am-hide-sm-only">发起时间</th>
						<th class="table-date am-hide-sm-only">审批时间</th>
						<th class="table-title">审批意见</th>
						<th class="table-author am-hide-sm-only">审批状态</th>
						<th class="table-set">操作</th>
					</tr>
				</thead>
				<c:forEach items="${page.result }" var="lea">
					<tr>
						<td>${lea.id }</td>
						<td width="15%;">${lea.employeeSn.name}${lea.leavetype }${lea.leaveday }天</td>
						<td><ftm:formatDate value='${lea.starttime }'
								pattern='yyyy-MM-dd' /></td>
						<td><ftm:formatDate value='${lea.modifytime }'
								pattern='yyyy-MM-dd' /></td>
						<td class="am-hide-sm-only">${lea.approveOpinion }</td>
						<td class="am-hide-sm-only">${lea.status }</td>
						<td>
							<div class="am-btn-toolbar">
								<c:if test="${post=='manager' }">
									<c:if test="${lea.status == '待审批' }">
										<button
											class="am-btn am-btn-default am-btn-xs am-text-secondary">
											<span class="am-icon-pencil-square-o"></span> <a
												href="${pageContext.request.contextPath }/lea/leave!modify_lea_ById?leave.id=${lea.id}">审批</a>
										</button>
									</c:if>
								</c:if>
								<div class="am-btn-group am-btn-group-xs">
									<button class="am-btn am-btn-default am-btn-xs am-hide-sm-only">
										<span class="am-icon-copy"></span> <a
											href="${pageContext.request.contextPath }/lea/leave!find_Page_ById.action?leave.id=${lea.id}">
											查看</a>
									</button>
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
									href="${pageContext.request.contextPath }/lea/leave!find_lea_Page.action?currtent=1&beginTime=<ftm:formatDate value='${beginTime }' pattern='yyyy-MM-dd'/>&overTime=<ftm:formatDate value='${overTime }' pattern='yyyy-MM-dd'/>">首页</a></li>
							</c:if>
							<c:if test="${page.currtentPage != 1  }">
								<li><a
									href="${pageContext.request.contextPath }/lea/leave!find_lea_Page.action?currtent=${page.currtentPage-1}&beginTime=<ftm:formatDate value='${beginTime }' pattern='yyyy-MM-dd'/>&overTime=<ftm:formatDate value='${overTime }' pattern='yyyy-MM-dd'/>">«</a></li>
							</c:if>
							<c:if test="${page.currtentPage != null }">
								<li><input type="text" size="1"
									value="${page.currtentPage }"></li>
								<li class="am-disabled"><small>
										<button style="width: 100%; height: 10%; border-radius: 20px;"
											class="am-btn  am-btn-default am-btn-success tpl-am-btn-success am-icon-search"
											type="button"></button>
								</small></li>
							</c:if>
							<c:if test="${page.currtentPage != page.totalPage }">
								<li><a
									href="${pageContext.request.contextPath }/lea/leave!find_lea_Page.action?currtent=${page.currtentPage+1}&beginTime=<ftm:formatDate value='${beginTime }' pattern='yyyy-MM-dd'/>&overTime=<ftm:formatDate value='${overTime }' pattern='yyyy-MM-dd'/>">»</a></li>
							</c:if>
							<c:if test="${page.currtentPage != page.totalPage }">
								<li><a
									href="${pageContext.request.contextPath }/lea/leave!find_lea_Page.action?currtent=${page.totalPage}&beginTime=<ftm:formatDate value='${beginTime }' pattern='yyyy-MM-dd'/>&overTime=<ftm:formatDate value='${overTime }' pattern='yyyy-MM-dd'/>">尾页</a></li>
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
<script
	src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		
	})
</script>
<%@include file="tail/tail.jsp"%>