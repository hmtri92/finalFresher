	<!-- Support -->
	
<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top narbar-img"
	role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value='/userhome'/>" > <img src="<c:url value='/images/logo.png'/>"
				width="229" height="74" alt="">
			</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul style="font-size: 18px" class="nav navbar-nav">
				<li><a href="<c:url value='/support/createAccount'/>">Creare Account</a></li>
				<li><a href="<c:url value='/support/modifyAccount'/>">Modify Account</a></li>
				<li><a href="<c:url value='/support/searchaccount'/>">Search Account</a></li>
				<li class="dropdown">
		          <a style="font-size: 18px;" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
		          	State <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li style="padding-bottom: 10px">
		            	<a href="<c:url value='/support/change_State_Dis-Active'/>">
		            		<i class="glyphicon glyphicon-credit-card"></i>  Disable -> Active
	            		</a>
            		</li>
            		<li style="padding-bottom: 10px">
		            	<a  href="<c:url value='/support/change_State_Active-Dis'/>" >
		            		<i class="glyphicon glyphicon-credit-card"></i>  Active -> Disable
	            		</a>
            		</li>
            		<li style="padding-bottom: 10px">
		            	<a  href="<c:url value='/support/change_State_removeable-Removed'/>">
		            		<i class="glyphicon glyphicon-credit-card"></i>  Removeable -> Removed
	            		</a>
            		</li>            		
		          </ul>
		        </li>
				<li class="dropdown">
		          <a style="font-size: 18px;" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
		          	Funds <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li style="padding-bottom: 10px">
		            	<a href="<c:url value='/support/viewAddFunds'/>">
		            		<i class="glyphicon glyphicon-credit-card"></i>  Add funds
	            		</a>
            		</li>
            		<li style="padding-bottom: 10px">
		            	<a  href="<c:url value='/support/viewTransferBySupport'/>" >
		            		<i class="glyphicon glyphicon-credit-card"></i>  Transfer
	            		</a>
            		</li>
            		<li style="padding-bottom: 10px">
		            	<a  href="<c:url value='/support/viewWithdraw'/>">
		            		<i class="glyphicon glyphicon-credit-card"></i>  Withdraw
	            		</a>
            		</li>            		
		          </ul>
		        </li>
				
			</ul>
			<!-- Dropdow menu -->
			<ul class="nav navbar-nav navbar-right">
		        <li class="dropdown">
		          <a style="font-size: 18px;" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
		          	  ${username} <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li style="padding-bottom: 10px"><a href="<c:url value='/viewprofile'/>"><i class="glyphicon glyphicon-user"></i>  Edit profile</a></li>
		            <li><a href="<c:url value="/j_spring_security_logout" />"><i class="glyphicon glyphicon-off"></i>  Sign out</a></li>
		          </ul>
		        </li>
	      	</ul>
		</div>
	</div>
</nav>