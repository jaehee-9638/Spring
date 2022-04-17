<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>list</h1>

	<table border="1">
	<col width="100"/>
		<col width="150"/>
		<col width="100"/>
		
		<col width="250"/>
		<col width="100"/>
		<tr>
			<th>주문번호</th>
			<th>상품명</th>
			<th>총가격</th>
			<th>구매일자</th>
			<th>자세히 보기</th>
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>		
					<th colspan="5">----------작성된 글이 없습니다.--------</th>
				</tr>	
			</c:when>
			<c:otherwise>
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.orderSeq }</td>
						<td>${dto.productName }</td>
						<td>${dto.amount }</td>
						
						<td>${dto.orderDate }</td>
						
						<td><a href="detail.do?orderSeq=${dto.orderSeq }">버튼</a></td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
			<tr>
				<td colspan="5" align="right"><input type="button" value="글작성" onclick="location.href='writeform.do'"></td>
			</tr>
	</table>



</body>
</html>