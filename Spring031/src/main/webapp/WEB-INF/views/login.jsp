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
		$("#alrr").hide();
	});
	
	function login(){
		var memberid=$("#memberid").val().trim();
		var memberpw=$("#memberpw").val().trim();
		var loginVal={
				"memberid":memberid,
				"memberpw":memberpw
		}

		if(memberid==null||memberid==""||memberpw==null||memberpw==""){
			alert("id및 pw를 다시 확인해주세요  ");
		}else {
			$.ajax({
				type:"post",
				url:"logincontrol.do",	//컨트롤러로 
				data:JSON.stringify(loginVal),	//JSON.stringify메소드 사용해서 json객체를 STring 으로 변환 하고
				contentType:"application/json",	//@RequesBody로 보내야하니까 형태지정 (json으로)
				dataType:"json",
				success : function(msg) { //성공시 
		             if	(msg.check==true){	//만약 check가 true면 list.do로
		            	 location.href="list.do"; 
		             }else{//아니면 제일아래 틀잡아준곳보여주면서 "ID혹은 PW가 잘못되었습니다 "라는 문구 cnfffur하고
		            	 $("#alrr").show();
		             	 $("#alrr").html(" ID혹은 PW가 잘못되었습니다 ");
		             }
		             
					},	
				error : function() {	
			          alert('통신실패');		//에러시 - 통신실패 라는문구 경고창으로
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
			<td><input type ="text" id="memberpw"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="로그인" onclick="login();">
			</td>
		</tr>
		<tr>
			<td colspan="2" id="alrr">
				
			</td>
		</tr>
		
	</table>

</body>
</html>