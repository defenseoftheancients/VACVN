<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/base.jspf" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/meta.jsp"%>
<title><decorator:title /></title>
<link rel="stylesheet" href="<c:url value="/assets/css/admin/dashboard.css" />" />
<decorator:head />
</head>
<body>
	<div class="container">
		<%@ include file="sidebar.jsp" %>
		<div class="main">
			<%@ include file="navbar.jsp" %>
			<decorator:body />
		</div>
	</div>
	
	<script type="module" src="<c:url value="/assets/js/admin/dashboard.js" />"> </script>
	
	
</body>
</html>