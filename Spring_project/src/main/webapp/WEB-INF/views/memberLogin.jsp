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
		
		var member_id=$("#member_id").val().trim();
		var member_pw=$("#member_pw").val().trim();
		var loginVal={
				"member_id":member_id,
				"member_pw":member_pw
				//자바 스크립트의 오브젝트는 k:v,k:v형태로 있었는데 
		}
		
		if(member_id==null||member_id==""||member_pw==null||member_pw==""){
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
							
							location.href="loginRes.do";
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
<!-- loginRes.do" method="post" -->
	
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" id="member_id" ></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="member_pw" ></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value ="로그인 " onclick="login();">

					<input type="button" value ="회원가입" onclick="location.href='registForm.do'">
					
				</td>
			</tr>
			<tr>
			
			<td colspan="2" align="center" id="loginChk"></td>
		</tr>
		</table>

</body>
</html>