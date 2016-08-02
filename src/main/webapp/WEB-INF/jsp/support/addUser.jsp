<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/myStyle.css">
<link rel="stylesheet" href="css/logo-nav.css">
<link rel="stylesheet" href="css/components.css">
<link rel="stylesheet" href="css/plugins.css">
<link rel="stylesheet" href="css/screen.css">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/myScript.js"></script>

</head>
<body style="padding-top: 100px !important">
	<%@ include file="../models/navbar.jsp"%>

	<div class="page-content">
		<div class="container">

			<div class="alert alert-warning" role="alert" id="message">
				<a href="#" class="close" data-dismiss="alert">&times;</a>
			</div>
			<!-- <div class="portlet light"> -->
			<div class="tab-pane" id="tab_1">
				<div class="portlet box blue">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-gift"></i>createAccount
						</div>
					</div>
					<div class="portlet-body form">
						<!-- BEGIN FORM-->

						<form id="createUser" class="horizontal-form"
							action="createUser" method="POST">
							<div class="form-body">

								<h3 class="form-section">Account Info</h3>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">Account Number</label> <input
												type="text" name="accountNumber" id="accountNumber"
												class="form-control" />
										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">id</label> <input type="text"
												name="id" id="id" class="form-control" />
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">idCardNumber</label> <input
												type="text" name="idCardNumber" id="idCardNumber"
												class="form-control" />
										</div>
									</div>
									<!--/span-->
									<div class="col-md-4">
										<div class="form-group">
											<label class="control-label">availableAmount</label> <input
												type="text" name="availableAmount" id="availableAmount"
												class="form-control" />
										</div>
									</div>
									<!--/span-->
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">typeAccount</label> <input
												type="text" name="typeAccount" id="typeAccount"
												class="form-control" />
										</div>
									</div>

								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">role</label> <input type="text"
												name="role" id="role" class="form-control" />
										</div>
									</div>

								</div>


								<h3 class="form-section">Account Info</h3>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label">firstName</label> <input
												type="text" name="firstName" id="firstName"
												class="form-control" />
										</div>
									</div>

								</div>
							</div>
							<!--/span-->
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">lastName </label> <input
										type="text" name="lastName" id="lastName" class="form-control" />
								</div>
							</div>
							<!--/span-->
							<!--/span-->
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">midName </label> <input
										type="text" name="midName" id="midName" class="form-control" />
								</div>
							</div>
							<!--/span-->
							<!--/span-->
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">phoneNum1 </label> <input
										type="text" name="phoneNum1" id="phoneNum1"
										class="form-control" />
								</div>
							</div>
							<!--/span-->
							<!--/span-->
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">phoneNum2 </label> <input
										type="text" name="phoneNum2" id="phoneNum2"
										class="form-control" />
								</div>
							</div>
							<!--/span-->
							<!--/span-->
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">address1 </label> <input
										type="text" name="address1" id="address1" class="form-control" />
								</div>
							</div>
							<!--/span-->
							<!--/span-->
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">address2 </label> <input
										type="text" name="address2" id="address2" class="form-control" />
								</div>
							</div>
							<!--/span-->
							<!--/span-->
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">email1 </label> <input type="text"
										name="email1" id="email1" class="form-control" />
								</div>
							</div>
							<!--/span-->
							<!--/span-->
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">email2 </label> <input type="text"
										name="email2" id="email2" class="form-control" />
								</div>
							</div>
							<!--/span-->
							<!--/span-->
							<div class="col-md-6">
								<div class="form-group">
									<label class="control-label">state </label> <input type="text"
										name="state" id="state" class="form-control" />
								</div>
							</div>
							<!--/span-->
							<div class="form-actions right">

								<button id="submit" type="submit" class="btn blue"
									value="Add Account">
									<i class="fa fa-check"></i> Add
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

	<!-- start footer -->
	<%@ include file="../models/footer.jsp"%>
</body>
</html>