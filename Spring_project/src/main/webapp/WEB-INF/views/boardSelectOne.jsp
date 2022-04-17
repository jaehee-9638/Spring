<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">
	.mainbox{
		height:700px;
		background-color: #FDF5E6;
	}
	.inputArea {
		padding-top:10px;
		padding-left:20px;
	}
	.imageArea {
		padding-top:10px;
		
	}
	.oriImg{
		width:500px;
		height:500px;
		object-fit: contain;
		
	}
	.thumbImg{
	
	}
</style>

</head>
<body>
	<div  class= "col-md-6 col-md-offset-3" >
		<div class="mainbox">
			<div class="inputArea col-md-4" >
				<%-- <label>글번호</label>
				${dto.board_seq } --%>
				
				<label>작성자</label>
				${dto.board_id }
			</div>
			<div class="inputArea col-md-5">
				<label>작성일</label>
				${dto.board_regdate }
			</div>
			<div class="inputArea col-md-3">
				<label>조회수</label>
				${dto.board_read }
			</div>
			<div class="inputArea" style="padding-bottom:10px; padding-top:40px;">
				<label>제목</label>
				${dto.board_title }
			</div>
			<!-- 이미지 슬라이더 추가하자 이건 이미지 추가하는곳에서 인풋 여러개 추가하면 될듯  -->
			<!-- 이 디브태그 감싸서 이미지 ${dto.board_gdsimg} not empty면 글보이게 ?-->
			
			<c:if test="${dto.board_gdsimg !=null }">
				<div class="imageArea">
			 		<img src="${dto.board_gdsimg}"  class="oriImg center-block"   />
				</div>
			</c:if>	
			
			
			
			<div class="inputArea">
				<label>내용</label>
				${dto.board_content }
			</div>
			
			
			<%-- <div class="inputArea">
				<label>비밀번호</label>
				${dto.board_pw}
			</div> --%>
			
			<div style="float:right; padding-right:20px;">
				<input type ="button" value ="글수정" onclick="location.href='boardUpdateform.do?board_seq=${dto.board_seq }'" class="btn btn-warning">
				<input type ="button" value ="글삭제" onclick="location.href='boardDeleteRes.do?board_seq=${dto.board_seq }'" class="btn btn-warning">
			</div>
		</div>		
	</div>		
	

</body>
</html>