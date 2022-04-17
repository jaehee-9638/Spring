<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insertres.do">
		<table>	
			<tr>
				<th>작성자</th>
				<td><input type="text" name="myname"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input type="text" name="mytitle"></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td><input type="text" name="mycontent"></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" value="글작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>