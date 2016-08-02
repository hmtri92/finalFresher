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
							<i class="fa fa-gift"></i>Verify New->Active
						</div>
					</div>
					<div class="portlet-body form">
						<!-- BEGIN FORM-->

						<div >
					<table id="mytable" class="table table-striped table-bordered" cellspacing="0" width="100%"
						data-click-to-select="true" data-single-select="true" data-pagination="true" data-search="true">
						<thead>
				            <tr>
				                <th >ID</th>
				                <th >State</th>
				                <th >Verify</th>
				            </tr>
				        </thead>
				        <tbody>
							<c:forEach var="listAccount" items="${listAccount}">
								<tr id = "${listAccount.id}">
									<td>${listAccount.id}</td>
									<td>${listAccount.state.name}</td>
									<td>
										
									<form id="update" class="horizontal-form" action="doupdateState"
						method="POST">
						<input
											type="text" name="accountNumber" id="accountNumber"
											 value="${listAccount.id}" />
											
											 
							<button id="submit" type="submit" class="submit">
								<i class="fa fa-check"></i> Verify
							</button>
					
						</form>
								</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

					<center>
						<font color="red">${message }</font>
					</center>
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
	<%-- <%@ include file="../models/footer.jsp"%>
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
	</script> --%>
</body>
</html>