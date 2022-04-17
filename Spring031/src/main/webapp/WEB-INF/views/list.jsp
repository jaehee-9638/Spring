<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	리스트 입니다 
	<table>
		<tr>
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		
		<c:forEach var="dto" items="${list }">
			<tr>
				<td>${dto.myno }</td>
				<td>${dto.myname }</td>
				<td><a href="detail.do?myno=${dto.myno }">${dto.mytitle }</a></td>
				<td>${dto.mydate }</td>	
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4">
				<input type="button" value="글작성" onclick="location.href='insertform.do'">
			</td>
		</tr>
		
		
	</table>
</body>
</html>