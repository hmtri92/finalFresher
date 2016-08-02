<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="<c:url value='/css/dataTables.bootstrap.css'/>">

<style type="text/css">
	[ac-chart] {
				float:left;
				width: 48%;
				height: 400px;
				margin: 0 1%;
			}
</style>
</head>
<body style="padding-top: 100px !important" ng-app="example">
	<%@ include file="../models/navbarAdmin.jsp"%>
	
	
	<div class="page-content">
		<div class="container">
			<div class="portlet light">
				<div ng_controller="MainController">
					<select ng-model="chartType">
						<option value="pie">pie</option>
						<option value="bar">bar</option>
						<option value="line">line</option>
						<option value="point">point</option>
						<option value="area">area</option>
					</select>
					
					<span ng-show="chartType==='pie'">
						<label for="innerRadius">Radius:</label>
						<input ng-model="config1.innerRadius" type="number" id="innerRadius" />
					</span>
					
					</br>
					
					<div class="row">
				        <div class="col-xs-12 col-md-12">
				        	<div class="charts">
								<div id="chart1" ac-chart="chartType" ac-data="data1" ac-config="config1" class='chart'></div>
				        	</div>
				        </div>
			        </div>
			        <div class="row">
				        <div class="col-xs-12 col-md-12">
				        	<div class="charts">
								<div id="chart2" ac-chart="chartType" ac-data="data2" ac-config="config2" class='chart'></div>
				        	</div>
				        </div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<%@ include file="../models/footer.jsp"%>
	<!-- start footer -->
	
	<script type="text/javascript" src="<c:url value='/js/angularjs/angular.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/angularjs/d3.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/angularjs/angular-charts.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/angularjs/app.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/jquery-1.11.1.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/bootstrap.js'/>"></script>
	
	<script type="text/javascript" src="<c:url value='/js/myScript.js'/>"></script>

	<style>
        .ac-tooltip {
            color: black;
            border: 2px solid rgba(200,200,0,0.8);
            background-color: rgba(200,200,0,0.5);
        }

        #chart1 .ac-legend-box {
            border-radius: 10px;
        }

    </style>

</body>
</html>