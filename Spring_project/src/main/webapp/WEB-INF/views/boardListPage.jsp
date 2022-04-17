<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>selectlistpage</h1>
	
	<table border="1">
		<col width="50"/>
		<col width="100"/>
		<col width="500"/>
		<col width="100"/>
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
			<th>조회수</th>
			
		</tr>
		<c:choose>
			<c:when test="${empty list }">
				<tr>		
					<th colspan="4">----------작성된 글이 없습니다.--------</th>
				</tr>	
			</c:when>
			<c:otherwise>
			
			
					<!-- varStatus : rownum출력용 -->
					<c:forEach varStatus="status" var="dto" items="${list }">
						<tr>
							<td>
								<!--${count }:총 게시물 수, ${select }:현재페이지, ${page_cnt }:페이지 게시물 수  -->
								<!-- (총게시글-반복상태의변수의index)-((현재페이지-1)*페이지 게시물수 ) -->
								<!-- 반복상태 변수의 index는 페이지 마다 새로 시작 0~9를 반복한다.  -->
								${(count - status.index) - ( (select - 1)  *  page_cnt ) }
							</td>
							<td>${dto.board_id }</td>
							<td><a href="boardSelectOne.do?board_seq=${dto.board_seq }">${dto.board_title }</a></td>
							<td>${dto.board_content }</td>
							<td>${dto.board_read }</td>
						</tr>
					</c:forEach>
				
			</c:otherwise>
		</c:choose>
	</table>
		<div>
		<p>페이징</p>
		
		<!--이전,다음: ctag if문에 model에담긴 값 조회: false면 출력X ,true면 출력O  -->
		<c:if test="${prev}">
			<span>[ <a href="boardListPage.do?num=${first_page - 10}">이전</a> ]</span>
		</c:if>
		<c:forEach begin="${first_page}" end="${end_page}" var="num">
			<span>
				<!-- 현재페이지가 아닌 다른 페이지 클릭 시 페이지 이동 -->
				<c:if test="${select != num}">
					<a href="boardListPage.do?num=${num}">${num}</a>
				</c:if>    
				<c:if test="${select == num}">
					<b>${num}</b>
				</c:if>
			</span>
		</c:forEach>
		<c:if test="${next}">
			 <span>[ <a href="boardListPage.do?num=${end_page + 1}">다음</a> ]</span>
		</c:if>
			
		</div>
		
	<table>
			<tr>
				<td colspan="4" align="right">
					<input type="button" value="글작성" onclick="location.href='boardInsert.do'">
				</td>
			</tr>
	</table>

</body>
</html>