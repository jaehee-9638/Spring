<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h1>detail</h1>
	
	<table border="1">
		<tr>
			<th>�ۼ���</th>
			<td>${dto.myname }</td>
		</tr>
		<tr>
			<th>����</th>
			<td>${dto.mytitle }</td>
		</tr>
		<tr>
			<th>����</th>
			<td><textarea rows="10" cols="60" readonly="readonly">${dto.mycontent }</textarea></td>
		</tr>
		<tr>
			
			<td colspan="2" align="right">
				<input type="button" value="����" onclick="location.href='updateform.do?myno=${dto.myno}'"/>
				<input type="button" value="����" onclick="location.href='delete.do?myno=${dto.myno}'"/>
				<input type="button" value="���" onclick="location.href='list.do'"/>
			</td>
		</tr>
		
	
	</table>

</body>
</html>