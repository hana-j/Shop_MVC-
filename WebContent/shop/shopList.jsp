<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap, vo.Shop, java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>The 굿즈 #</title>
<style type="text/css">
	#listForm{
		width:700px;
		height:500px;
		margin:auto;
	}
	h2{
		text-align:center;
	}
	table{
		margin:auto;
		width:550px;
	}
	.div_empty{
		background-color:#3399ff;
		width:100%;
		heigth:100%;
		text-align:center;
	}
	#todayImageList{
		text-align:center;
		}
	#productImage{
		width:150px;
		heigth:150px;
		border: none;
	}
	
</style>
</head>
<body>
<section id="listForm">
<c:choose>
<c:when test="${shopList!=null}">
<h2>굿즈 목록</h2>
<table>
	<tr>
		<c:forEach var="list" items="${shopList}" varStatus="status">
		<td>
			<a href="goodsView.shop?id=${list.id}">
			<img src="images/${list.image}" id="goodsImage" width="300px" height="200px"/>
			</a>
			상품명 : ${list.kind}<br>
			가격: ${list.price}<br>
		</td>
		</c:forEach>
		<c:if test="${((status.index+1) mod 3)==0 }"></c:if>
	</tr>
	
</table>
</c:when>
<c:otherwise>
	<div class="div_empty">
	현재 판매중인 물건이 없습니다.
	</div>
</c:otherwise>
</c:choose>
</section>
</body>
</html>