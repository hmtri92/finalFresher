<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="<c:url value='/css/bootstrap.css'/>">
<link rel="stylesheet" href="<c:url value='/css/bootstrap-theme.css'/>">
<link rel="stylesheet" href="<c:url value='/css/myStyle.css'/>">
<link rel="stylesheet" href="<c:url value='/css/logo-nav.css'/>">
<link rel="stylesheet" href="<c:url value='/css/components.css'/>">
<link rel="stylesheet" href="<c:url value='/css/plugins.css'/>">
<link rel="stylesheet" href="<c:url value='/css/screen.css'/>">
<link rel="stylesheet"
	href="http://jqueryvalidation.org/files/demo/site-demos.css">


<script type="text/javascript"
	src="<c:url value='/js/jquery-1.11.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/bootstrap.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/myScript.js'/>"></script>

</head>
<body style="padding-top: 100px !important">
	<%@ include file="../models/navbar.jsp"%>

	<div class="page-content">
		<div class="container">

			<!-- <div class="portlet light"> -->
			<div class="tab-pane" id="tab_1">
				<div class="portlet box blue">
					<div class="portlet-title">
						<div class="caption">
							<i class="glyphicon glyphicon-plus"></i>Create Account
						</div>
					</div>
					<div class="portlet-body form">
						<!-- BEGIN FORM-->

						<form class="horizontal-form" id="createAccount"
							action="docreateAccount" method="POST">
							<div class="form-body">

								<h3 class="form-section">Account Info</h3>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">Account Number</label> <input
												type="text" name="id" id="id" class="form-control" placeholder="12 number"/>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">ID-CardNumber</label> <input
												type="text" name="idCardNumber" id="idCardNumber"
												class="form-control" placeholder="9 number"/>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">ID-Login</label> <input
												type="text" name="loginId" id="loginId" class="form-control" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">Firstname</label> <input
												type="text" name="firstName" id="firstName"
												class="form-control" />
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">Midname</label> <input
												type="text" name="midName" id="midName" class="form-control" />
										</div>
									</div>
									<!--/span-->
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">Lastname</label> <input
												type="text" name="lastName" id="lastName"
												class="form-control" />
										</div>
									</div>
									<!--/span-->
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Address 1</label> <input
												type="text" name="address1" id="address1"
												class="form-control" />
										</div>
									</div>
									<!--/span-->
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Address 2</label> <input
												type="text" name="address2" id="address2"
												class="form-control" />
										</div>
									</div>
									<!--/span-->
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Email 1</label> <input
												type="text" name="email1" id="email1" class="form-control" />
										</div>
									</div>
									<!--/span-->
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Email 2</label> <input
												type="text" name="email2" id="email2" class="form-control" />
										</div>
									</div>
									<!--/span-->
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Phone Number 1</label> <input
												type="text" name="phoneNum1" id="phoneNum1"
												class="form-control" />
										</div>
									</div>
									<!--/span-->
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Phone Number 2</label> <input
												type="text" name="phoneNum2" id="phoneNum2"
												class="form-control" />
										</div>
									</div>
									<!--/span-->
								</div>


								<h3 class="form-section">Bank-Info</h3>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">TypeAccount :</label> <select
												name="typeAccount" id="typeAccount" id="typeAccount" class="form-control">
												<option value="">Choose Type Account</option>
												<option value="1">DEPOSIT</option>
												<option value="2">SAVING</option>
												<option value="3">OTHER</option>

											</select>
										</div>
									</div>
									<!--/span-->
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Role :</label> <select
												name="role" id="role" class="form-control" id="role">
												<option value="">Choose role</option>
												<option value="1">Customer</option>
												<option value="2">Admin</option>
												<option value="3">Customer</option>
												
											</select>
										</div>
									</div>


									<!--/span-->
								</div>
							</div>
							<div class="form-actions right">
								<center>
									<font color="red">${message }</font> User: <font color="red">${User.loginID }</font>
									Password: <font color="red">${pass1 }</font>

								</center>
								<button type="button" class="btn default" onclick="goHome();">Cancel</button>
								<button id="submit" type="submit" class="btn blue">
									<i class="glyphicon glyphicon-plus"></i> Add Account
								</button>
							</div>
						</form>
						<!-- END FORM-->
					</div>
				</div>
			</div>
			<!-- </div> -->
		</div>
	</div>

	<!-- Message -->
	<%@ include file="../models/message.jsp"%>

	<!-- start footer -->
	<%@ include file="../models/footer.jsp"%>
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script
		src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
	<script
		src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#createAccount").validate({
				rules : {
					email1 : {
						required : true,
						email : true
					},
					email2 : {

						email : true
					},
					phoneNum1 : {
						required : true,
						number : true
					},
					phoneNum2 : {
						number : true
					},
					address1:"required",
					 id: {
					      required: true,
					      maxlength: 12,
					      minlength: 12
					    },
					    idCardNumber: {
						      required: true,
						      maxlength: 9,
						      minlength: 9
						    },
						    loginId: {
							      required: true,
							      maxlength: 12,
							      minlength: 6
							    },
							    firstName:"required",
							    lastName:"required",
							    midName:"required",
							    typeAccount:"required",
							    role:"required",
							    
						    
					
					
				}
			});
		});
	</script>
</body>
</html>