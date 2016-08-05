<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- BEGIN HEAD -->
<head>
<title>Login</title>

<link rel="stylesheet" href="<c:url value='/css/bootstrap.css'/>">
<link rel="stylesheet" href="<c:url value='/css/bootstrap-theme.css'/>">
<link rel="stylesheet" href="<c:url value='/css/myStyle.css'/>">
<link rel="stylesheet" href="<c:url value='/css/plugins.css'/>">

<link rel="stylesheet" href="<c:url value='/css/login/layout.css'/>">
<link rel="stylesheet" href="<c:url value='/css/login/login-soft.css'/>">
<link rel="stylesheet" href="<c:url value='/css/login/font-awesome.min.css'/>">
<link rel="stylesheet" href="<c:url value='/css/login/uniform.default.css'/>">
<link rel="stylesheet" href="<c:url value='/css/login/simple-line-icons.min.css'/>">
<link rel="stylesheet" href="<c:url value='/css/login/default.css'/>" type="text/css"/>
<link id="style_color" href="<c:url value='/css/login/select2.css'/>" rel="stylesheet" />
<link id="style_color" href="<c:url value='/css/login/components-md.css'/>" rel="stylesheet"/>

<script type="text/javascript" src="<c:url value='/js/jquery-1.11.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/login/jquery-migrate.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/bootstrap.js'/>"></script>

<script type="text/javascript" src="<c:url value='/js/login/jquery.blockui.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/login/jquery.uniform.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/login/jquery.validate.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/login/jquery.backstretch.min.js'/>"></script>


<script type="text/javascript" src="<c:url value='/js/login/metronic.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/login/layout.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/login/demo.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/login/login-soft.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/login/select2.min.js'/>"></script>

<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico"/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-md login">
<img alt="full screen background image" src="<c:url value='images/backstretch.jpg' />" 
	id="full-screen-background-image">

	<!-- BEGIN LOGO -->
	<div class="logo">
		<a href="">
		<img src="<c:url value='/images/logo.png'/>" width="216" height="70" alt=""/>
		</a>
	</div>
	<!-- END LOGO -->
	<!-- BEGIN LOGIN -->
	<div class="content">
		<!-- BEGIN LOGIN FORM -->
		<form id="formLogin" class="login-form" action="j_spring_security_check" method="post">
			<h3 class="form-title">Login to your account</h3>
			
			<c:set var="count" scope="session" value="${countLogin}" ></c:set>
			<c:choose>
				<c:when test="${count >= 3}">
					<div class="alert alert-danger alert-dismissible" role="alert">
					  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					  <strong>Warning!</strong> Can't login. Login fail 3 times.
					</div>
					
					<!-- remove action in form -->
					<script type="text/javascript">
						$(document).ready(function() {
							$("#formLogin").removeAttr("action");
						});
					</script>
				</c:when>
				<c:when test="${count > 0}">
					<div class="alert alert-danger alert-dismissible" role="alert">
					  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					  <strong>Warning!</strong> Login fail <c:out value="${count}"></c:out> of 3.
					</div>
				</c:when>
			</c:choose>
			
			<div class="alert alert-danger display-hide">
				<button class="close" data-close="alert"></button>
				<span>
				Enter any username and password. </span>
			</div>
			<div class="form-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">Username</label>
				<div class="input-icon">
					<i class="fa fa-user"></i>
					<input id="j_username" name="j_username" class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="Username"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">Password</label>
				<div class="input-icon">
					<i class="fa fa-lock"></i>
					<input id="j_password" name="j_password" class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="Password"/>
				</div>
			</div>
			<div class="form-actions">
				<c:choose>
					<c:when test="${count >= 3}">
						<button  type="submit" class="btn blue pull-right save" disabled="disabled">
						Login <i class="m-icon-swapright m-icon-white"></i>
						</button>
					</c:when>
					<c:otherwise>
						<button type="submit" class="btn blue pull-right save">
						Login <i class="m-icon-swapright m-icon-white"></i>
						</button>
					</c:otherwise>
				</c:choose>
			</div>
		</form>
		<!-- END LOGIN FORM -->
	</div>
	<!-- END LOGIN -->

	<!-- start footer -->
	<%@ include file="models/footer.jsp"%>

<!-- END PAGE LEVEL SCRIPTS -->
	<script type="text/javascript">
		jQuery(document).ready(function() {     
		  	Metronic.init(); // init metronic core components
			Layout.init(); // init current layout
		  	Login.init();
		  	Demo.init();
		});
	</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>