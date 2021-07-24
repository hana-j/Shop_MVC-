<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 관리자모드(회원정보 변경)</title>
<style>
 #memberInfoArea{
 	width:400px; margin:auto; border:1px solid gray;
 }
 table{
 	width:380px; margin:auto; text-align:center;
 }
</style>
<script type="text/javascript">
	function changePW(chk){
		if(chk.checked){
			document.getElementById("PWChange").style.display="block";
		}else{
			document.getElementById("PWChange").style.displty="none";
		}
	}
	function modifyFormSubmit(f){
		if(f.pw_change.checked){
		if(f.password.value!=f.pass_chk.value){
			alert("비밀번호가 일치하지 않습니다.");
			f.password.value="";
			f.pass_chk="";
			f.pass.focus();
			return false;
			}
		}
		f.submit();
	}
</script>
<style type="text/css">
	
</style>
</head>
<body>
	<section id = "memberInfoArea">
		<form action = "memberModifyAction.mem" method="post" name="modifyform">
			<input type="hidden" name="id" id="id" value="${member.id}">
			<table>
				<tr>
					<td>아이디 : </td>
					<td>${member.id}</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="checkbox" name="pw_change" id="pw_change" onclick="changePW(this)"/>비밀번호 변경
					</td>
				</tr>
				<tr>
					<td colspan ="2" align="left">
						<div id="PWChange" style="display:none">
							<table>
							 	<tr>
							 	<!-- 여기서 사용하는 name 값이 view 페이지에 파라미터로 넘어가니까 값이 같아야함  -->
							 	<td>비밀번호 : </td>
							 	<td><input type="password" name="password" id="password" value="${member.password}"/></td>
							 	</tr>
							 	<tr>
							 	<td>비밀번호 확인 : </td>
							 	<td><input type="password" name="pass_chk" id="pass_chk"/></td>
							 	</tr>
						 	</table>
						 </div>
					</td>
				</tr>
				<tr>
					<td>이름 : </td>
					<td><input type="text" name ="name" id="name" value="${member.name}"/></td>
				</tr>
				<tr>
					<td>나이 : </td>
					<td><input type="text" name ="age" id="age" value="${member.age}"/></td>
				</tr>
				<tr>
					<td>성별 : </td>
					<td>
					<c:if test="${member.gender eq '남' }">
						<input type="radio" name = "gender" id="gender" value="남" checked id="gender"/>남자
						<input type="radio" name="gender" id="gender" value="여"/>여자
					</c:if>
					<c:if test="${member.gender eq '여' }">
						<input type="radio" name = "gender" id="gender" value="남" />남자
						<input type="radio" name="gender" id="gender" value="여" checked/>여자
					</c:if>
					</td>
				</tr>
				<tr>
					<td>이메일 주소 : </td>
					<td><input type="text" name="email" id="email" value="${member.email }"/></td>
				</tr>
				<tr>
					<td colspan="2">
					<a href="javascript:modifyFormSubmit(modifyform)">정보수정</a>&nbsp;&nbsp;
					<a href="javascript:modifyform.reset();changePW(pw_change)">다시작성</a>&nbsp;&nbsp;
					<a href="memberListAction.mem">리스트로 돌아가기</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>