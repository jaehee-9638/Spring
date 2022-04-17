<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	유저 메인
	${login.member_id }님 반갑습니다.
	
	
	<br><a href="boardList.do">게시판</a><br>
	
	<br><a href="boardListPage.do?num=1">게시판</a><br>
	
	<a href="logout.do">로그아웃</a><br>
	
	<a href="myInfo.do?member_no=${login.member_no}">내정보 조회</a><br>
	
</body>
</html>