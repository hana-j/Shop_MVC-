<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Template Test</title>
<style type="text/css">
	.t{
		margin:auto;
		width:960px;
		color:gray;
	}
</style>
</head>
<body>
<table border=0 class="t">
	<tr>
		<td align="center"><br>
		<jsp:include page="menu_top.jsp"></jsp:include>
		</td>
	</tr>
	<tr>
		<td align="center">
			<jsp:include page='${pagefile}'></jsp:include>
		</td>
	</tr>
	<tr>
		<td align="center"><br>
		<jsp:include page="sub_main.jsp"></jsp:include>
		</td>
	</tr>
</table>
</body>
</html>