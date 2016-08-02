<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Target Account</title>

<link rel="stylesheet" href="<c:url value='/css/bootstrap.css'/>">
<link rel="stylesheet" href="<c:url value='/css/bootstrap-theme.css'/>">
<link rel="stylesheet" href="<c:url value='/css/myStyle.css'/>">
<link rel="stylesheet" href="<c:url value='/css/logo-nav.css'/>">
<link rel="stylesheet" href="<c:url value='/css/components.css'/>">
<link rel="stylesheet" href="<c:url value='/css/plugins.css'/>">
<link rel="stylesheet" href="<c:url value='/css/screen.css'/>">
<link rel="stylesheet" href="<c:url value='/css/dataTables.bootstrap.css'/>">
<link rel="stylesheet" href="<c:url value='/css/font-awesome.css'/>">

<script type="text/javascript" src="<c:url value='/js/jquery-1.11.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/jquery.dataTables.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/bootstrap.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/dataTables.bootstrap.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/myScript.js'/>"></script>

<!-- Validate -->
<link rel="stylesheet" href="http://jqueryvalidation.org/files/demo/site-demos.css">
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		 var targetAccountTable = $('#mytable').dataTable({
		    });
		 $('.click_modify').click(function (){
				var id = $(this).parent().parent().parent().attr('id');
				var targetAccount = $(this).parent().parent().parent().children('#accountTarget').html();
				var name = $(this).parent().parent().parent().children('#name').html();
				
				$("#md_Id").val(id);
				$("#md_accountId").val(targetAccount);
				$("#md_name").val(name);
				
				$("#modifyTargetAccount").modal('show');
				
			});
		 
		 $('.click_delete').click(function (){
				var id = $(this).parent().parent().parent().attr('id');
				
				$("#md_Id").val(id);
				
				$("#deleteTargetAccount").modal('show');
				
			});
    });
	
</script>
</head>
<body style="padding-top: 100px !important">
	<%@ include file="../models/navbarCustomer.jsp"%>
		
	<div class="page-content">
		<div class="container">
			<div class="portlet light">
				<!-- Button add targetAccount -->
				<a href="#" class="btn btn-primary" data-toggle="modal" data-target="#addTargetAccount" style="margin-bottom: 10px;">
					<span class="glyphicon glyphicon-plus"></span> Add
				</a>
				<table id="mytable" class="table table-striped table-bordered" cellspacing="0" width="100%"
						data-click-to-select="true" data-single-select="true" data-pagination="true" data-search="true">
					<thead>
			            <tr>
			                <th >#</th>
			                <th >Name</th>
			                <th >Account number</th>
			                <th >Edit</th>
			                <th >Delete</th>
			            </tr>
			        </thead>
			        <tbody>
						<c:forEach var="target" items="${targetAccounts}" varStatus="count">
							<tr id = "${target.idTarget }">
								<td>${count.count}</td>
								<td id="name">${target.name }</td>
								<td id="accountTarget">${target.accountTarget.id }</td>												
								<td>
									<p data-placement="top" data-toggle="tooltip" title="Edit">
										<button class="btn btn-primary btn-xs click_modify" data-title="Edit" data-toggle="modal" data-target="#edit" >
											<span class="glyphicon glyphicon-pencil">
											</span>
										</button>
									</p>
								</td>												
								<td>
									<p data-placement="top" data-toggle="tooltip" title="Delete">
										<button class="btn btn-danger btn-xs click_delete" data-title="Delete" data-toggle="modal" data-target="#delete" >
											<span class="glyphicon glyphicon-trash">
											</span>
										</button>	
									</p>
								</td>												
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<!-- Modal add targetAccount-->
	<div class="modal fade" id="addTargetAccount" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Add new targetAccount</h4>
	      </div>
	      <form id="frm-Addtarget">
		      <div class="modal-body">
		      	<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="form-group">
							<label class="control-label">AccountID</label>
							<input type="text" name="accountId"
								id="accountId" class="form-control" maxlength="12"/>
						</div>
					</div>
				</div>
		      	<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="form-group">
							<label class="control-label">Name</label>
							<input type="text" name="name"
								id="name" class="form-control" />
						</div>
					</div>
				</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary" onclick="addTargetAccount();">Add</button>
		      </div>
	      </form>
	    </div>
	  </div>
  </div>
  
  <!-- Modal Modify-->
	<div class="modal fade" id="modifyTargetAccount" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Modify targetAccount</h4>
	      </div>
	      <form id="frm-modify">
		      <div class="modal-body">
		      	<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="form-group">
							<label class="control-label">ID</label>
							<input type="text" name="md_Id"
								id="md_Id" class="form-control" disabled="disabled"/>
						</div>
					</div>
				</div>
		      	<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="form-group">
							<label class="control-label">AccountID</label>
							<input type="text" name="md_accountId"
								id="md_accountId" class="form-control" maxlength="12"/>
						</div>
					</div>
				</div>
		      	<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="form-group">
							<label class="control-label">Name</label>
							<input type="text" name="md_name"
								id="md_name" class="form-control" />
						</div>
					</div>
				</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary" onclick="modifyTargetAccount();">Save</button>
		      </div>
	      </form>
	    </div>
	  </div>
  </div>
  
  <!-- Modal delete-->
	<div class="modal fade" id="deleteTargetAccount" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">Delete targetAccount</h4>
	      </div>
	      <form id="frmAddtarget">
		      <div class="modal-body">
		      	<div class="alert alert-warning" role="alert">
		      		<strong>Warning!</strong> Delete Account?
				</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		        <button type="button" class="btn btn-primary" onclick="deleteTargetAccount();">Delete</button>
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
			$("#frm-Addtarget").validate({
				rules : {
					accountId : {
						required : true,
						number : true,
					},
					name : {
						required : true
					}
				}
			});
			$("#frm-modify").validate({
				rules : {
					md_Id : {
						required : true,
						number : true
					},
					md_name : {
						required : true
					}
				}
			});
		});
	</script>
</body>
</html>