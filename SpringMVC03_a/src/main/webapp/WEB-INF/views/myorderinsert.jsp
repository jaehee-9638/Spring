<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>insert</h1>
	<form action="writeres.do" method="post">
		<table border="1">
			
			<tr>
				<th>상품가격</th>
				<td><input type="text" name="productPrice"/></td>
			</tr>
			<tr>
				<th>택배비</th>
				<td><input type="text" name="delivery"/></td>
			</tr>
			<tr>
				<th>총가격</th>
				<td><input type="text" name="amount"/></td>
			</tr>
			<tr>
				<th>받는사람주소</th>
				<td><input type="text" name="receiveAddress"/></td>
			</tr>
			<tr>
				<th>받는사람이름</th>
				<td><input type="text" name="receiveName"/></td>
			</tr>
			<tr>
				<th>수량</th>
				<td><input type="text" name="quantity"/></td>
			</tr>
			<tr>
				<th>운영자판매상품명</th>
				<td><input type="text" name="productName"/></td>
			</tr>
			<tr>
				<th>상품시퀀스</th>
				<td><input type="text" name="productSeq"/></td>
			</tr>
			<tr>
				<th>유저아이디</th>
				<td><input type="text" name="userId"/></td>
			</tr>
				
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="글작성"/>
						<input type="button" value="취소" onclick=""/>
					</td>
				</tr>
			
			
		</table>
		
	</form>




</body>
</html>