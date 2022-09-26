<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>hello</title>
</head>
<body>
<c:if test="${not empty param.msg}">
	<script>
		alert("${param.msg}");
	</script>
</c:if>
<div id="list">
	<u1>
		<li><a href="<c:url value='/'/>">home</a></li>
		<li><a href="<c:url value='/signup'/>">Signup</a></li>
		<li><a href="<c:url value='/write'/>">write</a></li>
	</u1>
</div>
<c:if test="${sessionScope.id==null}">
	<form action="<c:url value ='/login'/>" method="post">
		<input type="text" name="id"value="${cookie.id.value}" placeholder="id 입력">
		<input type="password" name="pwd" placeholder="패스워드 입력">
		<button>로그인</button>
		<label><input type="checkbox" name="rememberId" ${empty cookie.id.value?"":"checked"}>아이디 기억</label>
	</form>
<form action="<c:url value ='/find'/>" method="get">
	<button>아이디 비밀번호 찾기</button>
</form>
</c:if>
<c:if test="${sessionScope.id!=null}">
	<form action="<c:url value ='/logout'/>" method="get">
		<button>로그아웃</button>
	</form>
</c:if>
</body>
</html>
