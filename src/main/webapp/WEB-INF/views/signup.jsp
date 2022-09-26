<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--회원가입--%>
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
<form action="<c:url value ='/signup'/>" method="post" onsubmit="return Check(this);">
	<input type="text" name="email" placeholder="email 입력">
	<input type="text" name="id" placeholder="id 입력">
	<input type="text" name="nick_name" placeholder="닉네임 입력">
	<input type="text" name="adress" placeholder="주소 입력">
	<input type="password" name="pwd" placeholder="비밀번호">
	<button>회원가입</button>
	<script>
		function Check(a){
			if(a.id.value.length==0){
				alert('id를 입력해주세요');
				return false;
			} else if(a.id.value.length>13||a.id.value.length<5){
				alert('id는 5~12글자입니다');
				return false;
			}
			if(a.pwd.value.length==0){
				alert('pwd를 입력해주세여');
				return false;
			} else if(a.pwd.value.length>16||a.pwd.value.length<6){
				alert('pwd는 6~15글자입니다');
				return false;
			}

			return true;
		}
	</script>
</form>
</body>
</html>
