<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>update</h1>
	
	<form action="updateres.do" method="post">
		<input type="hidden" name="orderSeq" value="${dto.orderSeq }"/>
		
		<table border="1">
		
		<tr>
			<th>상품가격</th>
			<td>${dto.productPrice }</td>
		</tr>
		<tr>
			<th>택배비</th>
			<td>${dto.delivery }</td>
		</tr>
		<tr>
			<th>총가격</th>
			<td>${dto.amount }</td>
		</tr>
		<tr>
			<th>받는사람주소</th>
			<td><input type="text" name="useraddress" value="${dto.receiveAddress }"/></td>
		</tr>
		<tr>
			<th>받는사람이름</th>
			<td><input type="text" name="username" value="${dto.receiveName }"/></td>
		</tr>
		<tr>
			<th>수량</th>
			<td>${dto.quantity }</td>
		</tr>
		<tr>
			<th>운영자판매상품명</th>
			<td>${dto.productName }</td>
		</tr>
		<tr>
			<th>주문날짜</th>
			<td>${dto.orderDate }</td>
		</tr>
		<tr>
			<th>상품시퀀스</th>
			<td>${dto.productSeq }</td>
		</tr>
		<tr>
			<th>유저아이디</th>
			<td>${dto.userId }</td>
		</tr>
		
			<tr>
				
				<td colspan="2" align="right" >
					<input type="submit" value="글수정"/>
					<input type="button" value="취소" onclick=""/>
				</td>
			</tr>
			
		</table>
	</form>

</body>
</html>