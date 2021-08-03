<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾</title>
</head>
<style>
#find{
	margin:auto;
	width:480px;
	text-align:center;
}
</style>
<body>
<table id="find">
	<tr>
		<td> 회원님의 아이디는 ${id}입니다.</td>
	</tr>
</table>
<a href="/memberLogin.mem">로그인</a>&nbsp;&nbsp;
<a href="./findPwForm.mem">비밀번호 찾기</a>
</body>
</html>