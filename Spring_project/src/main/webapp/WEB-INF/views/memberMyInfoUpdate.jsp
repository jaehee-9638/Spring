<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	내정보 수정 
	<form action="myInfoUpdateRes.do" method="post">
	<input type ="hidden" name="member_no" value ="${dto.member_no }">
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
			<td><input type="text" name ="member_pw" value="${dto.member_pw }"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${dto.member_name }</td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name ="member_addr" value="${dto.member_addr }"></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" name ="member_phone" value="${dto.member_phone }"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name ="member_email" value="${dto.member_email}"></td>
		</tr>
		<tr>
			<th>등급</th>
			<td>${dto.member_role}</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type ="submit" value="정보 수정" >
				
			</td>
		</tr>
	</table>
	</form>
</body>
</html>