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
			<th>글번호</th>
			<td>${dto.myno }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${dto.myname }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.mytitle }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${dto.mycontent }</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${dto.mydate }</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="글수정" onclick="location.href='updateform.do?myno=${dto.myno }'">
				<input type="button" value="글삭제" onclick="location.href='deleteres.do?myno=${dto.myno }'">
			</td>
		</tr>
	</table>
</body>
</html>