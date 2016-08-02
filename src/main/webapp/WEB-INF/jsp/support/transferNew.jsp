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

<link rel="stylesheet" href="http://jqueryvalidation.org/files/demo/site-demos.css">

<script type="text/javascript" src="<c:url value='/js/jquery-1.11.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/bootstrap.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/myScript.js'/>"></script>

<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>

</head>
<body style="padding-top: 100px !important">
	<%@ include file="../models/navbar.jsp"%>
	
	<div class="page-content">
		<div class="container">
			<div class="row">
				<!-- form -->
				<div class="col-md-4">
					<div class="tab-pane" id="tab_1">
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-gift"></i>Transfer
								</div>
							</div>
							<div class="portlet-body">
								<div class="row">
									<form id="frm-Account">
										<div class="col-lg-12">
											<div class="form-group">
												<label class="control-label">Send Number</label>
												<div class="row">
													<div class="col-md-10" style="padding-right: 0;">
											      		<input type="text" name="accountNumber" maxlength="12"
																id="accountNumber" class="form-control" placeholder="Id Account">
													</div>
													<div class="col-md-2" style="padding-left: 0">
												        <button style="padding-top: 9px; padding-bottom: 8px;" onclick="checkAccount();"
													         class="btn btn-primary" type="button">
												        	<span class="glyphicon glyphicon-refresh"></span>
												        </button>
													</div>
												</div>
											</div>
									  	</div>
									</form>
								</div>
								<div class="row">
									<form id="frm-targetAccount">
										<div class="col-md-12">
											<div class="form-group">
												<label class="control-label">Target Number</label>
												<div class="row">
													<div class="col-md-10" style="padding-right: 0;">
														<input type="text" name="targetaccountNumber" maxlength="12"
															id="targetaccountNumber" class="form-control" />
													</div>
													<div class="col-md-2" style="padding-left: 0">
														<button style="padding-top: 9px; padding-bottom: 8px;" style="margin-top: 10px" 
															onclick="checkTargetAccount();" 
															class="btn btn-primary" type="button">
															<span class="glyphicon glyphicon-refresh"></span>
														</button>
													</div>
												</div>
											</div>
										</div>
									</form>
								</div>
								<div class="row">
									<form id="frm-amount">
										<div class="col-md-12">
											<div class="form-group">
												<div class="form-group">
												<label class="control-label">Amount</label>
												<input type="text" name="amount"
													id="amount" class="form-control" value = "0" />
											</div>
											</div>
										</div>
									</form>
								</div>
								<div class="row">
									<div class="col-md-6" style="float: right;">
										<button type="button" class="btn default" onclick="goHome();">Cancel</button>
										<button id="submit" type="button" class="btn blue" onclick="tranferBySupport();">
											<i class="fa fa-check"></i> Send
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<!-- Send account infomation -->
				<div class="col-md-4">
					<div class="tab-pane" id="tab_1">
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-gift"></i>Send Account
								</div>
							</div>
							<div class="portlet-body">
								<div class="row">
									<div class="col-md-3">
										<label class="control-label">Firstname:</label>
									</div>
									<div class="col-md-9">
										<input type="text" name="firstname" id="firstname"
											class="form-control" disabled="disabled"/>
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<label class="control-label">Midname:</label>
									</div>
									<div class="col-md-9">
										<input type="text" name="midname" id="midname"
											class="form-control" disabled="disabled" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<label class="control-label">Lastname:</label>
									</div>
									<div class="col-md-9">
										<input type="text" name="lastname" id="lastname"
											class="form-control" disabled="disabled" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<label class="control-label">Phone Number 1</label>
									</div>
									<div class="col-md-9">
										<input type="text" name="phoneNum1" id="phoneNum1"
												class="form-control" disabled="disabled" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<label class="control-label">Phone Number 2</label>
									</div>
									<div class="col-md-9">
										<input type="text" name="phoneNum2" id="phoneNum2"
												class="form-control" disabled="disabled" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label class="control-label">Address 1</label>
											<textarea rows="2" name="address1" id="address1"
												class="form-control" disabled="disabled" >
											</textarea>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label class="control-label">Address 2</label>
											<textarea rows="2" name="address2" id="address2"
												class="form-control" disabled="disabled" >
											</textarea>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<!-- Target account infomation -->
				<div class="col-md-4">
					<div class="tab-pane" id="tab_1">
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-gift"></i>Target Account
								</div>
							</div>
							<div class="portlet-body">
								<div class="row">
									<div class="col-md-3">
										<label class="control-label">Firstname:</label>
									</div>
									<div class="col-md-9">
										<input type="text" name="targetfirstname" id="targetfirstname"
											class="form-control" disabled="disabled"/>
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<label class="control-label">Midname:</label>
									</div>
									<div class="col-md-9">
										<input type="text" name="targetmidname" id="targetmidname"
											class="form-control" disabled="disabled" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<label class="control-label">Lastname:</label>
									</div>
									<div class="col-md-9">
										<input type="text" name="targetlastname" id="targetlastname"
											class="form-control" disabled="disabled" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<label class="control-label">Phone Number 1</label>
									</div>
									<div class="col-md-9">
										<input type="text" name="targetphoneNum1" id="targetphoneNum1"
												class="form-control" disabled="disabled" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-3">
										<label class="control-label">Phone Number 2</label>
									</div>
									<div class="col-md-9">
										<input type="text" name="targetphoneNum2" id="targetphoneNum2"
												class="form-control" disabled="disabled" />
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label class="control-label">Address 1</label>
											<textarea rows="2" name="targetaddress1" id="targetaddress1"
												class="form-control" disabled="disabled" >
											</textarea>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label class="control-label">Address 2</label>
											<textarea rows="2" name="targetaddress2" id="targetaddress2"
												class="form-control" disabled="disabled" >
											</textarea>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- Message -->
	<%@ include file="../models/message.jsp"%>

	<!-- start footer -->
	<%@ include file="../models/footer.jsp"%>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$("#frm-targetAccount").validate({
				rules : {
					targetaccountNumber : {
						required : true,
						number : true,
						maxlength: 12,
				      	minlength: 12
					}
				}
			});
			$("#frm-Account").validate({
				rules : {
					accountNumber : {
						required : true,
						number : true,
						maxlength: 12,
				      	minlength: 12
					}
				}
			});
			$("#frm-amount").validate({
				rules : {
					amount : {
						required: true,
						number : true,
						min : 1
					}
				}
			});
		});
	</script>
</body>
</html>