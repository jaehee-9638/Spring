<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>update</h1>
	
	<form action="updateres.do" method="post">
		<input type="hidden" name="myno" value="${dto.myno }"/>
		
		<table border="1">
			<tr>
				<th>�ۼ���</th>
				<td>${dto.myname }</td>
			</tr>
			<tr>
				<th>����</th>
				<td><input type="text" name="mytitle" value="${dto.myname }"/></td>
			</tr>
			<tr>
				<th></th>
				<td><textarea rows="10" cols="60" name="mycontent">${dto.myname }</textarea></td>
			</tr>
			<tr>
				
				<td colspan="2" align="right" >
					<input type="submit" value="�ۼ���"/>
					<input type="button" value="���" onclick=""/>
				</td>
			</tr>
			
		</table>
	</form>

</body>
</html>