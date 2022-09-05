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
<form action="<c:url value =''/>" method="post" onsubmit="return Check(this);">
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
			} else if(a.id.value.length>13){
				alert('id는 12을 초과했습니다');
				return false;
			}
			if(a.pwd.value.length==0){
				alert('pwd를 입력해주세여');
				return false;
			} else if(a.pwd.value.length>16){
				alert('pwd는 16을 초과했습니다');
				return false;
			}

			return true;
		}
	</script>
</form>
</body>
</html>
