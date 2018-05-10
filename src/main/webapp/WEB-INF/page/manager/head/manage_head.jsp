<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="ftm" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>办公管理系统</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png"
	href="${pageContext.request.contextPath }/statics/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="${pageContext.request.contextPath }/statics/i/app-icon72x72@2x.png">
<link
	href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link
	href="${pageContext.request.contextPath }/statics/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link
	href="${pageContext.request.contextPath }/statics/css/nprogress.css"
	rel="stylesheet">
<!-- iCheck -->
<link href="${pageContext.request.contextPath }/statics/css/green.css"
	rel="stylesheet">
<!-- bootstrap-progressbar -->
<link
	href="${pageContext.request.contextPath }/statics/css/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet">
<!-- JQVMap -->
<link
	href="${pageContext.request.contextPath }/statics/css/jqvmap.min.css"
	rel="stylesheet" />
<!-- Custom Theme Style -->
<link
	href="${pageContext.request.contextPath }/statics/css/custom.min.css"
	rel="stylesheet">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/amazeui.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/admin.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/statics/css/app.css">
</head>
<body data-type="chart">

	<ol class="am-breadcrumb">待插入数据
	</ol>
	<header class="am-topbar am-topbar-inverse admin-header">
	<button
		class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
		data-am-collapse="{target: '#topbar-collapse'}">
		<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
	</button>
	<div class="am-collapse am-topbar-collapse" id="topbar-collapse">
		<ul
			class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
			<li class="am-hide-sm-only"><a href="javascript:;"
				id="admin-fullscreen" class="tpl-header-list-link"><span
					class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>

			<li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
				<a class="am-dropdown-toggle tpl-header-list-link"
				href="javascript:;"> <span class="tpl-header-list-user-nick">${empName }</span><span
					class="tpl-header-list-user-ico"> <img
						src="${pageContext.request.contextPath }/statics/img/user01.png"></span>
			</a>
				<ul class="am-dropdown-content">
					<li><a href="#"><span class="am-icon-bell-o"></span> 资料</a></li>
					<li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
					<li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
				</ul>
			</li>
			<li><a href="${pageContext.request.contextPath }/emp/out.action"
				class="tpl-header-list-link"><span
					class="am-icon-sign-out tpl-header-list-ico-out-size">out</span></a></li>
		</ul>
		<div class="am-topbar-brand">
			<h1>JBOA</h1>
		</div>
	</div>

	</header>

	<div class="tpl-page-container tpl-page-header-fixed">
		<div class="tpl-left-nav tpl-left-nav-hover" style="height: 500px;">
			<div class="tpl-left-nav-title">
				<h2>管理列表</h2>
			</div>
			<div class="tpl-left-nav-list">
				<ul class="tpl-left-nav-menu">
					<li class="tpl-left-nav-item"><span>&nbsp;</span></li>

					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-wpforms"></i> <span>报销单管理</span> <i
							class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
					</a>
						<ul class="tpl-left-nav-sub-menu">
							<li>
								<a
								href="
								${pageContext.request.contextPath }/cla/findPage_manager.action">
									<i class="am-icon-angle-right"></i> <span>查看报销单</span>
								</a>
							</li>
						</ul></li>
					<li class="tpl-left-nav-item"><span>&nbsp;</span></li>
					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-wpforms"></i> <span>请假管理</span> <i
							class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
					</a>
						<ul class="tpl-left-nav-sub-menu">
							<li><a href="${pageContext.request.contextPath }/lea/leave!find_lea_Page.action"> <i
									class="am-icon-angle-right"></i> <span>查看请假</span>
							</a>
						</ul></li>
					<li class="tpl-left-nav-item"><span>&nbsp;</span></li>
					<li class="tpl-left-nav-item"><a href="javascript:;"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-wpforms"></i> <span>统计报表</span> <i
							class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right"></i>
					</a>
						<ul class="tpl-left-nav-sub-menu">
							<li><a href="form-amazeui.html"> <i
									class="am-icon-angle-right"></i> <span>年度报表</span>
							</a> <a href="form-line.html"> <i class="am-icon-angle-right"></i>
							月度报表</a></li>
						</ul></li>
					<li class="tpl-left-nav-item"><span>&nbsp;</span></li>
					<li class="tpl-left-nav-item"><a href="login.html"
						class="nav-link tpl-left-nav-link-list"> <i
							class="am-icon-key"></i> <span>信息中心</span>
					</a></li>
				</ul>
			</div>
		</div>
		<div
			class="am-icon-list tpl-header-nav-hover-ico am-fl am-margin-right"></div>
		<div class="tpl-content-wrapper">
			<div class="tpl-content-page-title">办公管理系统</div>