<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/base.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404 | NOT FOUND</title>
<link rel="stylesheet"
	href="<c:url value="/assets/css/exception/404.css" />" />
</head>
<body>
	<div class="container">
		<img src="<c:url value="/assets/img/404.png " />" alt="img">
		<div class="content">
			<h1>404!</h1>
			<h3>Page not found.</h3>

			<a href="<c:url value="/home" />">Về trang chủ</a>
		</div>
	</div>
</body>
</html>