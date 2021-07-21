<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="vo.Shop" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세페이지</title>
<style type="text/css">
	#listForm{
		width:640px;
		border:1px solid blue;
		margin:auto;
	}
	h2{
		text-align:center;
	}
	img{
		width:280px;
		height:280px;
		border:none;
	}
	#content_main{
		heigth:300px;
		
	}
	#content_left{
		width:300px;
		float:left;
	}
	#commandList{
		text-align:center;
	}
	#desc{
		height:170px;
	}
</style>
</head>
<body>
<section id="listForm">
<!-- goods 속성을 El태그 사용해서 값을 받아옴  -->
<h2>${goods.kind}의 상세 정보</h2>

		<div id="content_left">
			<img src="images/${goods.image}"/>
		</div>
		
		<section id="content_right">
			<b>종류 : </b> ${goods.kind}<br>
			<b>가격 : </b> ${goods.price}<br>
			<p id="desc">
			<b>내용 : </b> ${goods.content}<br></p>
		</section>
		
		<div style="clear:both"></div>
		<nav id="commandList">
			<a href="goodsList.shop">상품 더 둘러보기</a>
			<a href="goodsCartList.shop?id=${goods.id}">장바구니 담기</a><br>
		</nav>
		

</section>
</body>
</html>