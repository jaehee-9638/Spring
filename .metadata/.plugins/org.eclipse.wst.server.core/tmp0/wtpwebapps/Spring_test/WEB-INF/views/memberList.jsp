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

<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.member_no }</td>
						<td>${dto.member_id }</td>
						<td>${dto.member_pw }</td>
						<td>${dto.member_name }</td>
						
					</tr>
				</c:forEach>

</body>
</html>