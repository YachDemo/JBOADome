<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>用户登录</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
  

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/animate.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css">


	<!-- Modernizr JS -->
	<script src="${pageContext.request.contextPath }/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>

		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center">
					<ul class="menu">
						<li class="active"><h2>JBOA</h2></li>
					</ul>
				</div>
			</div>
            <div class="copyrights">Collect from </div>
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<!-- Start Sign In Form -->
					<form action="${pageContext.request.contextPath }/emp/login.action" method="post" class="fh5co-form animate-box" data-animate-effect="fadeIn">
						<h2>请登录</h2>
						<div class="form-group">
							<label for="username" class="sr-only">Username</label>
							<input type="text" class="form-control" name="employee.sn" placeholder="Username" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="password" class="sr-only">Password</label>
							<input type="password" class="form-control" name="employee.password" placeholder="Password" autocomplete="off">
						</div>
						<div class="form-group">
							<input type="submit" value="登录" class="btn btn-primary">
							<input type="reset" value="重置" class="btn btn-primary">
						</div>
					</form>
					<!-- END Sign In Form -->

				</div>
			</div>
			<div class="row" style="padding-top: 60px; clear: both;">
				<div class="col-md-12 text-center"><p><small>&copy; All Rights Yach. More Templates </small></p></div>
			</div>
		</div>
	
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath }/statics/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath }/statics/js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="${pageContext.request.contextPath }/statics/js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="${pageContext.request.contextPath }/statics/js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="${pageContext.request.contextPath }/statics/js/main.js"></script>
	</body>
</html>