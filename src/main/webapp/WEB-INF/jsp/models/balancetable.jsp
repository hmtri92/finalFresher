<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-12">
	<div class="Metronic-alerts alert fade in alert-success" id="message"><i class="fa fa-cogs"></i>${RESULT}</div>
</div>							

<div class="col-md-12">
	<table id="mytable">
	<thead>
		<tr>
			<th><center>ID</center></th>
			<th><center>Period</center></th>
			<th><center>Balance</center></th>	
		</tr>
	</thead>
	<tbody>
		<c:forEach var="balanceInfo" items="${listBalance}">
			<tr>
				<td><center>${balanceInfo.idBalanceAmount}</center></td>
				<td><center>${balanceInfo.period}</center></td>
				<td><center>${balanceInfo.balance}</center></td>										
					</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>
</div>