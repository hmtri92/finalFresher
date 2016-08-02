<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<link rel="stylesheet" href="<c:url value='/css/dataTables.bootstrap.css'/>">

<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/myScript.js"></script>
<link rel="stylesheet" href="css/validationEngine.jquery.css"
	type="text/css" media="screen" title="no title" charset="utf-8" />
<link rel="stylesheet" href="css/template.css" type="text/css"
	media="screen" title="no title" charset="utf-8" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"
	type="text/javascript"></script>
<script src="js/jquery.validationEngine-en.js" type="text/javascript"></script>
<script src="js/jquery.validationEngine.js" type="text/javascript"></script>
<script>
	jQuery(document).ready(function() {
		// binds form submission and fields to the validation engine
		jQuery("#update").validationEngine();
	});
</script>

</head>
<body style="padding-top: 100px !important">
	<%@ include file="../models/navbar.jsp"%>

	<div class="page-content">
		<div class="container">
			<div class="Metronic-alerts alert alert-danger fade in" id="message">

			</div>
			<!-- <div class="portlet light"> -->
			<div class="tab-pane" id="tab_1">
				<div class="portlet box blue">
					<div class="portlet-title">
						<div class="caption">
							<i class="fa fa-gift"></i>Verify-State
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

	<!-- start footer -->
	<%@ include file="../models/footer.jsp"%>
</body>
</html>
