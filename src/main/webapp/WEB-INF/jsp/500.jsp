<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error 500</title>

<link rel="stylesheet" href="<c:url value='/css/bootstrap.css'/>">
<link rel="stylesheet" href="<c:url value='/css/bootstrap-theme.css'/>">
<link rel="stylesheet" href="<c:url value='/css/myStyle.css'/>">
<link rel="stylesheet" href="<c:url value='/css/error.css'/>">

<script type="text/javascript" src="<c:url value='/js/jquery-1.11.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/login/jquery-migrate.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/bootstrap.js'/>"></script>

</head>
<body class="page-500-full-page">
	<div class="row">
		<div class="col-md-12 page-500" style="margin-top: 0px;">
			<img alt="" src="<c:url value='/images/kidmondo_face_sad.gif' />">
		</div>
	</div>
	<div class="row">
		<div class="col-md-12 page-500" style="margin-top: 0px;">
			<div class=" number">
				500
			</div>
			<div class=" details">
			<h3>Oops! Something went wrong.</h3>
			<p>
				 We are fixing it!<br/>
				Please come back in a while.<br/><br/>
			</p>
		</div>
		</div>
	</div>
</body>
</html>