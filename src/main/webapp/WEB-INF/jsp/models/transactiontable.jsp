
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-12">
	<div class="Metronic-alerts alert fade in alert-success" id="message"><i class="fa fa-cogs"></i>${RESULT}</div>
</div>
<div class = "col-md-12">
	<table id="mytable">
		<thead>
			<tr>
				<th><center>Id</center></th>
				<th><center>Type</center></th>
				<th><center>Source Account</center></th>
				<th><center>Target Account</center></th>										
				<th><center>Money Amount</center></th>	
				<th><center>Transfered Date</center></th>								
			</tr>
		</thead>
		<tbody>
			<c:forEach var="transaction" items="${listTransaction}">
				<tr>
					<td><center>${transaction.idTransaction}</center></td>
					<td><center>													
							<c:choose>
								<c:when test="${transaction.typeTransaction == '1'}">
									Adding
								</c:when>
								<c:when test="${transaction.typeTransaction == '2'}">
									Withdrawing
								</c:when>
								<c:when test="${transaction.typeTransaction == '3'}">
									Transferring
								</c:when>
							</c:choose>											
					</center></td>
					<td><center>${transaction.sendAccount.id}</center></td>
					<td><center>${transaction.receiveAccount.id}</center></td>										
					<td><center>${transaction.amount}</center></td>
					<td><center>${transaction.date}</center></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>