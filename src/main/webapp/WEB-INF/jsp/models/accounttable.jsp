<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-12">
	<div class="Metronic-alerts alert fade in alert-success" id="message" onclick="$('#message')."><i class="fa fa-cogs"></i>${RESULT}</div>
</div>	


<div class="col-md-12">
	<table id="mytable">
		<thead>
			<tr>
				<th><center>Account Number</center></th>
				<th><center>Owner Name</center></th>										
				<th><center>Money Amount</center></th>							
				<th><center>State</center></th>								
				<th><center>Actions</center></th>								
			</tr>
		</thead>
		<tbody>
			<c:forEach var="account" items="${listAccount}">
				<tr>
					<td><center>${account.id}</center></td>
					<td><center>${account.firstName} ${account.midName} ${account.lastName}</center></td>
					<td><center>${account.availableAmount}</center></td>	
					<td><center>${account.state.name}</center></td>
					<td></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>