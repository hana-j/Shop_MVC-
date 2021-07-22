<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.MemberBean, java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 회원관리 페이지 (회원목록리스트)</title>
<style type="text/css">
#memberListArea{
	width:400px;
	border:1px solid gray;
	margin:auto;
}
table{
	width:380px;
	margin:auto;
	text-align:center;
}

</style>
</head>
<body>
<section id="memberListArea">
	<table>
		<tr>
			<td colspan="2"><h1>회원목록</h1></td>
		</tr>
		<c:forEach var="member" items="${memberList}">
		<tr>
			<td>
				<a href="memberViewAction.mem?id=${member.id}">${member.id}</a>
			</td>
			<td>
				<a href="memberModAction.mem?id=${member.id}">수정</a>
			</td>
			<td>
				<a href="memberDeleteAction.mem?id=${member.id}">삭제</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</section>
</body>
</html>