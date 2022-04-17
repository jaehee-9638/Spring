<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style type="text/css">
	.inputArea{
		padding-top:20px;
	}
	.select_img img{
		margin:20px 0;
	}
</style>
</head>
<body>
<!-- div 태그로 수정해보자 수정전에는 잘 작동함 -->
<form action="boardInsertRes.do" method="post" enctype="multipart/form-data">
	
		
		<div class="inputArea">
			<label>아이디</label>
			<input type="text" name="board_id">
		</div>
		<div class="inputArea">
			<label>제목</label>
			<input type="text" name="board_title">
		</div>
		<div class="inputArea">
			<label>내용</label>
			<textarea rows="10" cols="20" name="board_content"></textarea>
		
		</div>
		<div class="inputArea">
			<label>비밀번호</label>
			<input type="text" name="board_pw">
		</div>
		<div class="inputArea">
			<label>상품소개</label>
			<textarea rows="5" cols="50" id="gdsDes" name="gdsDes"></textarea>
		</div>		
		<div class="inputArea">
			 <label for="gdsImg">이미지 첨부</label>
		 	 <input type="file" id="gdsImg" name="file" />
		 	 <div class="select_img"><img src="" /></div> 
			 <script>	
				  $("#gdsImg").change(function(){	
				   if(this.files && this.files[0]) {
				    var reader = new FileReader;
				    reader.onload = function(data) {
				     $(".select_img img").attr("src", 
				    		 data.target.result).width(500);        
				    }
				    reader.readAsDataURL(this.files[0]);
				   }
				  });
			 </script>
		</div>
		
		<div class="inputArea"><!-- 이거나중에 인풋에서 버튼으로 바꿔야하나 .. -->
				<input type ="submit" id="register_Btn" value="등록">
		</div>
		
	
</form>
</body>
</html>