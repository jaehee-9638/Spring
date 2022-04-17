<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="boardUpdateRes.do" method="post">
<input type ="hidden" name="board_seq" value="${dto.board_seq }">
	<table>
		
		<tr>
			<th>아이디</th>
			<td>${dto.board_id }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type ="text" name="board_title" value="${dto.board_title }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><input type ="text" name="board_content" value="${dto.board_content }"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type ="text" name="board_pw" name="board_" value="${dto.board_pw }"></td>
			<!-- 이거 name속성 지워도 값 갈수있나 ? -->
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정완료" >
			</td>
		</tr>
	</table>
</form>	
</body>
</html>