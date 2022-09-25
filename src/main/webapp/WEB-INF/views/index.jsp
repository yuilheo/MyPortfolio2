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
		<li><a href="<c:url value='/'/>">home</a></li>
		<li><a href="<c:url value='/signup'/>">Signup</a></li>
		<li><a href="<c:url value='/list'/>">list</a></li>
	</u1>
</div>
	<form action="<c:url value ='/login'/>" method="post">
		<input type="text" name="id" placeholder="id 입력">
		<input type="password" name="pwd" placeholder="패스워드 입력">
		<button>로그인</button>
	</form>
<form action="<c:url value ='/find'/>" method="get">
	<button>아이디 비밀번호 찾기</button>
</form>
</body>
</html>
