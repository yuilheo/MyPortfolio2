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
	<form action="<c:url value="/"/>"  method="get">
		<select  name="option">
			<option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
			<option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>
			<option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>
		</select>

		<input type="text" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}" placeholder="검색어를 입력해주세요">
		<input type="submit"  value="검색">
	</form>
	<button type="button" id="writeBtn" onclick="location.href='<c:url value="/write"/>'">글쑤기</button>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="boardDto" items="${list}">
		<tr>
			<td>${boardDto.bno}</td>
			<td><a href="<c:url value='/read${ph.sc.queryString}&bno=${boardDto.bno}'/>">${boardDto.title}</a></td>
			<td>${boardDto.writer}</td>
			<td>${boardDto.reg_date}</td>
			<td>${boardDto.v_cnt}</td>
		</tr>
		</c:forEach>
	</table>
</div>
<div>
	<c:if test="${t_cnt==null || t_cnt==0}">
		게시물이 없습니다
	</c:if>
<c:if test="${t_cnt!=null || t_cnt!=0}">
	<c:if test="${ph.showPrev}">
		<a href="<c:url value='/${ph.sc.getQueryString(ph.b_page-1)}'/>">&lt</a>
	</c:if>
	<c:forEach var="i" begin="${ph.b_page}" end="${ph.e_page}">
		<a href="<c:url value='/${ph.sc.getQueryString(i)}'/>">${i}</a>
	</c:forEach>
	<c:if test="${ph.showNext}">
		<a href="<c:url value='/${ph.sc.getQueryString(ph.e_page+1)}'/>">&gt</a>
	</c:if>
</c:if>
</div>
</body>
</html>
