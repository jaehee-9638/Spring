<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="registres.do" method="post">
		<table>
			<tr>
				<th>아이디 </th>
				<td><input type="text" name="member_id" ></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="member_pw" ></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="member_name" ></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="text" name="member_addr" ></td>
			</tr>
			<tr>
				<th>연락처</th>
				<td><input type="text" name="member_phone" ></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="member_email" ></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value ="회원가입 ">
					
				</td>
			</tr>
		</table>
	</form>
</body>
</html>