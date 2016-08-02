<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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

<!-- Validate -->
<link rel="stylesheet" href="http://jqueryvalidation.org/files/demo/site-demos.css">
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>

</head>
<body style="padding-top: 100px !important">
	<%@ include file="../models/navbarCustomer.jsp"%>
	
	<div class="page-content">
		<div class="container">
			<div class="portlet light">
			<form id="frm-transfer">
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<h3 class="form-section" style="color: rgb(210, 105, 30);">Transfer money</h3>
						<div class="form-group">
							<label class="control-label">Account Number</label><br>
							<select id="targetAccount" name="targetAccount" class="form-control input-medium">
								<option value="">--Choose Target Account--</option>
								<c:forEach var="item" items="${targetAccounts}">
									<option value="${item.idTarget}">${item.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="form-group">
							<label class="control-label">Amount</label>
							<input type="text" name="amount"
								id="amount" class="form-control" value="0" />
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-3 col-md-offset-6">
						<div style="float: right">
							<button type="button" class="btn default" onclick="goHome();">Cancel</button>
							<button id="submit" type="button" class="btn blue" onclick="transferTargetID();">
								<i class="fa fa-check"></i> Send
							</button>
						</div>
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>
	
	<!-- Message -->
	<%@ include file="../models/message.jsp"%>
	
	<!-- start footer -->
	<%@ include file="../models/footer.jsp"%>
	
	<script type="text/javascript">
		$(document).ready(function() {
			$("#frm-transfer").validate({
				rules : {
					targetAccount : {
						required : true,
					},
					amount : {
						required : true,
						number : true,
						min : 1
					}
				}
			});
		});
	</script>
	
</body>
</html>