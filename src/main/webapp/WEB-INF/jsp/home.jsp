<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CSC Banking System</title>

<link rel="stylesheet" href="<c:url value='/css/bootstrap.css'/>">
<link rel="stylesheet" href="<c:url value='/css/bootstrap-theme.css'/>">
<link rel="stylesheet" href="<c:url value='/css/myStyle.css'/>">
<link rel="stylesheet" href="<c:url value='/css/logo-nav.css'/>">
<link rel="stylesheet" href="<c:url value='/css/components.css'/>">
<link rel="stylesheet" href="<c:url value='/css/plugins.css'/>">
<link rel="stylesheet" href="<c:url value='/css/screen.css'/>">

<script type="text/javascript" src="<c:url value='/js/jquery-1.11.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/bootstrap.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/myScript.js'/>"></script>

</head>
<body style="padding-top: 100px !important" >

	<div class="page-content" style="min-height:100%;position:relative;">
		
		<c:choose>
			<c:when test="${role == 'admin'}">
				<%@ include file="models/navbarAdmin.jsp"%>
			</c:when>
			<c:when test="${role == 'account_support'}">
				<%@ include file="models/navbar.jsp"%>
			</c:when>
			<c:when test="${role == 'customer'}">
				<%@ include file="models/navbarCustomer.jsp"%>
			</c:when>
		</c:choose>
			
		<div class="container">
			<div class="portlet light">
				<div class="row">
					<div class="col-md-6">
						<div class="panel panel-info">
							<div class="panel-heading">
								User profile
							</div>
							<div class="panel-body">
								<dl class="dl-horizontal">
									<dt>User Name</dt>
									<dd>${user.loginID}</dd>
									<dt>ID Card Number</dt>
									<dd>${user.idCardNumber}</dd>
									<c:if test="${role == 'customer'}">
										<dt>Balance amount</dt>
										<dd>${user.availableAmount}</dd>
									</c:if>
									<dt>Full name</dt>
									<dd>${user.firstName} ${user.midName} ${user.lastName}</dd>
									<dt>Address 1</dt>
									<dd>${user.address1}</dd>
									<dt>Address 2</dt>
									<dd>${user.address2}</dd>
									<dt>Phone Number 1</dt>
									<dd>${user.phoneNum1}</dd>
									<dt>Email 1</dt>
									<dd>${user.phoneNum2}</dd>
									<dt>Phone Number 2</dt>
									<dd>${user.email1}</dd>
									<dt>Email 2</dt>
									<dd>${user.email2}</dd>
								</dl>
							</div>
						</div>
					</div>
					<c:choose>
						<c:when test="${role == 'admin'}">
							<%@ include file="models/bodyHomeAdmin.jsp"%>
						</c:when>
						<c:when test="${role == 'account_support'}">
							<%@ include file="models/bodyHomeSupport.jsp"%>
						</c:when>
						<c:when test="${role == 'customer'}">
							<%@ include file="models/bodyHomeUser.jsp"%>
						</c:when>
					</c:choose>
				</div>
			</div>
		</div>
		<%@ include file="models/footer.jsp"%>
	</div>
</body>
</html>