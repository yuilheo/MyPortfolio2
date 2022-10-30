<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>hello</title>
</head>
<body>
<c:if test="${not empty msg}">
	<script>
		alert("${msg}");
	</script>
</c:if>
<div id="list">
	<u1>
		<li><a href="<c:url value='/'/>">home</a></li>
		<li><a href="<c:url value='/signup'/>">Signup</a></li>
	</u1>
</div>
<div>
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
</div>
<div>
	<button type="button" id="writeBtn" onclick="location.href='<c:url value="/write"/>'">글쑤기</button>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="board" items="${list}">
		<tr>
			<td>${board.bno}</td>
			<td><a href="<c:url value='/read?bno=${board.bno}&page=${page}&pageSize=${pageSize}'/>"> ${board.title}</a></td>
			<td>${board.writer}</td>
			<td>${board.reg_date}</td>
			<td>${board.v_cnt}</td>
		</tr>
		</c:forEach>
	</table>
</div>
<div>
	<c:if test="${ph.showPrev}">
		<a href="<c:url value='/?page=${ph.b_page-1}&pageSize=${ph.p_size}'/>">&lt;</a>
	</c:if>
	<c:forEach var="i" begin="${ph.b_page}" end="${ph.e_page}">
		<a href="<c:url value='/?page=${i}&pageSize=${ph.p_size}'/>">${i}</a>
	</c:forEach>
	<c:if test="${ph.showNext}">
		<a href="<c:url value='/?page=${ph.e_page+1}&pageSize=${ph.p_size}'/>">&gt;</a>
	</c:if>
</div>
</body>
</html>
