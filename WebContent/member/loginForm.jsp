<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style>
	#loginformArea{
		margin:auto;
		width:600px;
		border:1px solid gray;
	}
	table{
		width:380px;
		margin:auto;
		text-align:center;
	}
</style>
</head>
<body>
<section id="loginformArea">
<form name="loginform" action="./memberLoginAction.mem" method="post">
	<table>
		<tr>
			<td colspan="2">
				<h1>로그인 페이지</h1>
			</td>
		</tr>
		<tr><td><label for="member_id">아이디 : </label></td>
		<td><input type="text" name="id" id="id"/></td></tr>
		<tr><td><label for="pass">비밀번호 : </label></td>
		<td><input type="password" name="pass" id="pass"/></td></tr>
		<tr>
			<td colspan="2">
				<a href="javascript:loginform.submit()">로그인</a>&nbsp;&nbsp;
				<a href="./memberJoin.mem">회원가입</a>&nbsp;&nbsp;
				<a href="./idFind.mem">아이디 찾기</a>
			</td>
		</tr>
	</table>
</form></section>
</body>
</html>
