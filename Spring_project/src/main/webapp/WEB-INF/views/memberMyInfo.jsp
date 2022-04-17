<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>회원번호</th>
			<td>${dto.member_no }</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${dto.member_id }</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${dto.member_pw }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${dto.member_name }</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${dto.member_addr }</td>
		</tr>
		<tr>
			<th>연락처</th>
			<td>${dto.member_phone }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${dto.member_email}</td>
		</tr>
		<tr>
			<th>등급</th>
			<td>${dto.member_role}</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="myInfoUpdate.do?member_no=${dto.member_no }">내정보 수정 </a>
				<a href="dropId.do?member_no=${dto.member_no }&member_role=${dto.member_role}">탈퇴</a>
			</td>
		</tr>
	</table>
</body>
</html>