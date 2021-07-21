<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset = "UTF-8" name="viewport" content="width=device-width, initial-scale=1">
<title> The 굿즈 # </title>
<style>
*{margin:0;padding:0; box-sizing:border-box;}

a:link, a:visited, a:hover, a:active{
			text-decoration:none;
}
li{list-style-type:none;}
header{
	position:relative;
	height:70px;
	background: #3399ff;
	}
header .logo{
	position: absolute;
	top:23px;
	left:20px;
	font-size:1.3em;
}
header .logo span{
	color : #ff9900;
	font-weight:bold;
	}
header .logo a{
	color: white;
}
.gnb {
	height: 36px;
	margin: auto;
	
}
/*메인메뉴 영역*/
.gnb>ul {
	text-align: center; height : 50px;
	background: #3399ff;
	padding: 0;
	height: 36px;
	padding-top: 24px;
}


.gnb>ul>li {
	display: inline-block;
	width: 102px;
	height: 36px;
	margin-top: 0;
	position: relative;
}


.gnb>ul>li>a {
	display: block;
	width: 100%;
	height: 100%;
	font: bold 13px/30px "맑은 고딕", arial;
	text-align: center;
	color: #fff;
	background: #3399ff;
}


.gnb ul li a:hover {
	color: black;
	background: #3399ff;
}
/*서브메뉴 영역*/
.gnb ul ul {
	display: none;
}

.gnb ul li:hover ul {
	display: block;
}

.gnb li li {
	width: 100px;
	height: 36px;
	background-color: #47a9f4;
	text-align: center;
	float: left;
}

.gnb li li a {
	color:white;
	display: block;
	width: 100%;
	height: 100%;
	font: bold 12px/25px "맑은 고딕", arial;
	margin-top: 5px;
}

.gnb li li a:hover {
	color: black;
	background: none;
}
.main_image img{max-width:100%;}

[class*="col_"]
	{float:left;}
	.col_s_1{width: 15%;}
	.col_s_2{width: 25%;}
	.col_s_3{width: 50%;}
	.col_s_4{width: 50%;}
	.col_s_5{width: 75%;}

@media only screen and(min-width: 768px){
	/*테블릿 */
	.col_m_1{width:15%;}
	.col_m_2{width:25%;}
	.col_m_3{width:50%;}
	.col_m_4{width:50%;}
	.col_m_5{width:75%;}

	.box{
		max-width: 1170px;
		margin:0 auto;
		position:relative;
	}
	.banners {margin:50px 0;}
	.items{padding-top: 60px;}
	.item{padding-right: 15px;}
}
@media only screen and(min-width:1200px){
	/*데스크탑*/
	.col_1{width:15%;}
	.col_2{width:25%;}
	.col_3{width:50%;}
	.col_4{width:50%;}
	.col_5{width:75%;}

	header .menu_btn {display: none;}
	header .menu{display: block;}
	header .menu li{
		display: inline-block;
		margin:5px 0 0 50px;
	}
	.box{
		max-width: 1170px;
		margin:0 auto;
		position:relative;
		float:left;
	}
	.banner{padding-right: 30px;}
	.itmes{padding-top:60px;}
	.item{padding-right: 15px;}
}


</style>
</head>
<body>
<div id="container">
<header>
	<div id="box">
		<h1 class="logo"><a href="${pageContext.request.contextPath}/goodsList.shop"><span>The</span>&nbsp;굿즈 #</a></h1>
		<nav>
		<div class="gnb">
		<ul>
			<li><a href="#">굿즈</a>
				<ul>
					<li><a href="${pageContext.request.contextPath}/goodsList.shop">굿즈 홈</a></li>
					<li><a
						href="${pageContext.request.contextPath}/newGoodsList.shop">신상 굿즈</a></li>
					<li><a
						href="${pageContext.request.contextPath}/goodsCartList.shop">장바구니</a></li>
				</ul></li>
			<li><a href="#">회원관리</a>
				<ul>
					<li><a href="${pageContext.request.contextPath}/memberJoin.mem">회원가입</a></li>
					<li><a
						href="${pageContext.request.contextPath}/memberListAction.me">굿즈 셀러 등록</a></li>
				</ul></li>
			<li><a href="#">커뮤니티</a>
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/boardWriteForm.bo">글 쓰기</a></li>
					<li><a href="${pageContext.request.contextPath}/boardList.bo">굿즈 커뮤니티</a></li>
				</ul></li>
			<li><a href="#">검색</a></li>
			<li><c:choose>
					<c:when test="${id eq null }">
						<a href="${pageContext.request.contextPath}/memberLogin.mem">로그인</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/memberLogout.me">로그아웃</a>
					</c:otherwise>
				</c:choose>
		</ul>
</div>
			
		</nav>
	</div>
</header>
<section class="main_image">
<img src="./images/main.jpg" >
</section>

</div>
</body>
</html>
