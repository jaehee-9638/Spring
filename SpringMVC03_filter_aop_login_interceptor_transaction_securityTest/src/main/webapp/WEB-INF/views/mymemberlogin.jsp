<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
	$(function(){
		$("#loginChk").hide();
	});
	
	function login(){
		var memberid=$("#memberid").val().trim();
		var memberpw=$("#memberpw").val().trim();
		var loginVal={
				"memberid":memberid,
				"memberpw":memberpw
				//자바 스크립트의 오브젝트는 k:v,k:v형태로 있었는데 
		}
		
		if(memberid==null||memberid==""||memberpw==null||memberpw==""){
			alert("ID 밒 PW 를 다시 확인해 주세요");
		}else{
			$.ajax({
				type:"post",
				url:"ajaxlogin.do",
				data:JSON.stringify(loginVal),
				//위에 오브젝트를 컨트롤러로(제이슨 형태로) 보냈음  
				
				contentType:"application/json",
				//만약 얘안쓰면 통신실패: 415에러 (언 서포티드 미디어 타입 : 리퀘스트객체에 담겨오는 값이 잘못되었다는 ..)
				dataType:"json",
				success:function(msg){
					if(msg.check==true){
						location.href="list.do";
					}else{
						$("#loginChk").show();
						$("#loginChk").html("ID혹은 PW가 잘못되었습니다 ");
					}
				},
				error:function(){
					alert("통신실패");
				}
			
			});
			
		}
	}
</script>
</head>
<body>

	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" id="memberid"></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="text" id="memberpw"></td>
		</tr>
		<tr>
			
			<td colspan="2">
			<input type="button" value="login" onclick="login();"/>
			<input type="button" value="regist" onclick="location.href='registform.do'"/>
												<!--  onclick="location.href='writeform.do'" -->
			</td>
		</tr>
		<tr>
			
			<td colspan="2" align="center" id="loginChk"></td>
		</tr>
	</table>

</body>
</html>