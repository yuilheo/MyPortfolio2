<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--메인--%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>hello</title>
</head>
<body>
<div id="list">
	<u1>
		<li>home</li>
		<li><a href="<c:url value='/'/>">home</a></li>
		<li><a href="<c:url value='/signup.jsp'/>">Signup</a></li>
		<li><a href="<c:url value='/list'/>">list</a></li>
	</u1>
</div>
</body>
</html>
