<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${path}/resources/css/contentForm.css">
<meta charset="UTF-8">
<title>글내용</title>
</head>
<body>
	<h2>글내용</h2>
<form action="updateAction" method="post">
		<table class="table_style" cellpadding="0" cellspacing="0">
		<!-- 글 수정시에 글 번호와 조회수도 데이터 두개를 같이 들고 가야한다. -->
		<!-- input hidden을 통해 사용자 눈에 보이진 않지만 서버에 데이터를 보내는 방법이다. -->
		<input type="hidden" name="board_idx" value="${dto.board_idx }"/>
		<input type="hidden" name="board_hit" value="${dto.board_hit }"/>
			<tr>
				<td class="position">번호</td>
				<td>${dto.board_idx }</td>
			</tr>
			<tr>
				<td class="position">조회수</td>
				<td>${dto.board_hit }</td>
			</tr>
			<tr>
                <td>이름</td>
                <td><input type="text" name="board_name" value="${dto.board_name }" size="50" readonly></td>
            </tr>
            <tr>
                <td>제목</td>
                <td><input type="text" name="board_title" value="${dto.board_title}" size="50" readonly></td>
            </tr>
            <tr>
                <td>내용</td>
                <td>
                    <textarea id="content" name="board_content" cols="50" rows="10" readonly>${dto.board_content }</textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="buttons">
                    <input type="submit" value="글수정">
                    <a href="listForm"><input type="button" value="목록보기"></a>
                    <a href="deleteAction?board_idx=${dto.board_idx }"><input type="button" value="삭제하기"></a>
                </td>
                
            </tr>
		</table>	
	</form>
</body>
</html>