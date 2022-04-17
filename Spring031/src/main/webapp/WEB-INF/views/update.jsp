<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateres.do">
	<input type="hidden" name="myno" value="${dto.myno }">
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
				<td><input type="text" name="mytitle" value="${dto.mytitle }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" name="mycontent" value="${dto.mycontent }"></td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${dto.mydate }</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>