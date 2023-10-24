<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script defer type="text/javascript" src="${path}/resources/javascript/listForm.js"></script>
<link rel="stylesheet" href="${path}/resources/css/listForm.css"/>
<meta charset="UTF-8">
<title>게시판 목록보기</title>
</head>
<body>
	<h1>게시판 글목록</h1>

    <table class="table_style" cellpadding="0" cellspacing="0">
        <tr> 
            <th>번호</th>
            <th>이름</th>
            <th>제목</th>
            <th>날짜</th>
            <th>조회수</th>
        </tr>
        <c:forEach var="dto" items="${list}">
        	<tr>
	            <td>${dto.board_idx }</td>
	            <td>${dto.board_name }</td>
	            <!-- 글 제목을 눌렀을때 어떤 제목의 몇번 글인지 알아야함 때문에
	            board_idx를 GET 방식으로 보내줘야함-->
	            <td><a href="contentForm?board_idx=${dto.board_idx}">
	            	${dto.board_title }
	            	</a>
	            </td>
	            <td>
	            	<c:set var="dateVar" value="${dto.board_date }"/>
	            	<fmt:formatDate value="${dateVar}" pattern="yyyy-MM-dd"/>
	            </td>
	            <td>${dto.board_hit }</td>
       		 </tr>
        </c:forEach>
        
        
        <tr>
            <td colspan="5"><a href="writeForm">글작성</a></td>
        </tr>
    </table>
</body>
</html>