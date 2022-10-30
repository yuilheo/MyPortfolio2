<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>hello</title>
	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
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
	<form action="" id="form">
		<input type="hidden" name ="bno" value="${boardDto.bno}">
		<input type="text" name = "title" value="${boardDto.title}"${mode=="new"?'':'readonly="readonly"'}>
		<textarea name="content" id="" cols="30" rows="10" ${mode=="new"?'':'readonly="readonly"'}>${boardDto.content}</textarea>
		<button type="button" id="writebtn" class="btn">등록</button>
		<button type="button" id="modifybtn" class="btn">수정</button>
		<button type="button" id="removebtn" class="btn">삭제</button>
		<button type="button" id="listbtn" class="btn">목록</button>
	</form>
</div>
<script>
	$(document).ready(function (){
		$('#listbtn').on("click",function (){
			location.href = "<c:url value='/'/>?page=${page}&pageSize=${pageSize}";
		});
        $('#writebtn').on("click",function (){
            let form = $('#form');
            form.attr("action","<c:url value='/write'/>");
            form.attr("method","post");
            form.submit();
        });
        $('#modifybtn').on("click",function (){
            let form = $('#form');
            let isReadOnly = $("input[name=title]").attr("readonly");

            if(isReadOnly=='readonly'){
                $("input[name=title]").attr("readonly",false);
                $("textarea").attr("readonly",false);
                $("#modifybtn").html("등록");
				return;
            }
            form.attr("action","<c:url value='/modify'/>");
            form.attr("method","post");
            form.submit();
        });
		$('#removebtn').on("click",function (){
			if(!confirm("정말로 삭제하시겠습니가?")) return;
			let form = $('#form');
			form.attr("action","<c:url value='/remove?page=${page}&pageSize=${pageSize}'/>");
			form.attr("method","post");
			form.submit();
		});
	});
</script>
</body>
</html>