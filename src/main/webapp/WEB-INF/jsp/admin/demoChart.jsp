<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/css/bootstrap.css'/>">
<link rel="stylesheet" href="<c:url value='/css/bootstrap-theme.css'/>">
<link rel="stylesheet" href="<c:url value='/css/myStyle.css'/>">
<link rel="stylesheet" href="<c:url value='/css/logo-nav.css'/>">
<link rel="stylesheet" href="<c:url value='/css/components.css'/>">
<link rel="stylesheet" href="<c:url value='/css/plugins.css'/>">
<link rel="stylesheet" href="<c:url value='/css/screen.css'/>">

<%-- <script type="text/javascript" src="<c:url value='/js/angularjs/angular.min.js'/>"></script> --%>
<script type="text/javascript" src="<c:url value='/js/jquery-1.11.1.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/bootstrap.js'/>"></script>

<script type="text/javascript" src="<c:url value='/js/myScript.js'/>"></script>

<title>Ví dụ sử dụng Directive ng-Form</title>
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.2/angular.min.js"></script>
        <script>
            angular.module('myapp', [])
                    .controller('ExampleController', ['$scope', function($scope) {
                    // Khởi tạo giá trị ban đầu cho list = [];
                    $scope.list = [];
                     
                    // Khi submit form thì chạy hàm này
                    $scope.submit = function()
                    {
                        // nếu người dùng có nhập nội dung thì lưu nó vào list
                        if ($scope.text)
                        {
                            $scope.list.push(this.text);
                             
                            // đồng thời xóa dữ liệu trong thẻ input
                            $scope.text = '';
                        }
                    };
                }]);
        </script>

</head>
<body style="padding-top: 100px !important" ng-app="myapp">
	<%@ include file="../models/navbarAdmin.jsp"%>
	<div class="page-content">
		<form ng-submit="submit()" ng-controller="ExampleController">
            Nhập tên sinh viên
            <input type="text" ng-model="text" name="text" />
            <input type="submit" id="submit" value="Thêm" /> <br/>
            Danh sách sinh viên: <pre>list={{list}}</pre>
        </form>
	</div>
	
	<!-- start footer -->
	<%@ include file="../models/footer.jsp"%>
</body>
</html>