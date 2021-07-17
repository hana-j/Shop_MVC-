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
.banner{padding:15px;}
.banner li{float:left; padding:10px;}
.banner img{max-width:100%;}
.banner p{margin-top:10px; line-height:150%;}
.banners::after{
	content:"";
	clear:both;
	display:block;
	}
.items{
	padding:15px;
	padding-bottom:40px;
	background-color:gray;
	}
.items img{
	max-width:100%;
	display:block;
	}
.items ul{
	background-color:white;
	margin-bottom:20px;
	}
.items li:nth-child(2){padding:15px 10px;}
.items li:last-child{padding:0px 10px 10px 10px;}
.items::after{
	content:"";
	clear:both;
	display:block;
}
footer{
	color:white;
	background-color:black;
	padding-bottom:80px;
}
footer .box div{padding: 60px 0 0 20px;}
footer .box div:first-child h1{margin-top:20px;}
footer .box div:nth-child(2) li{
	display: inline-block;
	margin-right: 5px;
}
footer .box div:nth-child(2) p{
	margin-top:20px;
	line-height: 150%;
}
footer .box div:last-child{
	text-align:right;
	padding-right:20px;
}
footer::after{
	content:"";
	clear:both;
	display: block;
}

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
		<h1 class="logo"><a href="index.html"><span>The</span>&nbsp;굿즈 #</a></h1>
		<nav>
		<div class="gnb">
		<ul>
			<li><a href="${pageContext.request.contextPath}/goodsList.shop">굿즈</a>
				<ul>
					<li><a href="${pageContext.request.contextPath}/goodsList.shop">굿즈 홈</a></li>
					<li><a
						href="${pageContext.request.contextPath}/newGoodsList.shop">신상 굿즈</a></li>
					<li><a
						href="${pageContext.request.contextPath}/cartList.shop">장바구니</a></li>
				</ul></li>
			<li><a href="#">회원관리</a>
				<ul>
					<li><a href="${pageContext.request.contextPath}/memberJoin.me">회원가입</a></li>
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
						<a href="${pageContext.request.contextPath}/memberLogin.me">로그인</a>
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
	<section class="banners">
		<div class="box">
			<div class="banner col_m_4 col_4">
			<ul>
			<li class="col_s_2"><img  src="./images/icon1.jpg"  ></li>
			<li class="col_s_2">
				<h3>예약 안내</h3>
				<p>스튜디오 대여는 사전에 인터넷 예약을 하셔야 합니다. 예약은 1일 이전까지 가능 합니다.</p>
			</li>
			</ul>
		</div>
		<div class="banner col_m_4 col_4">
			<ul>
			<li class="col_s_2"><img  src="./images/icon2.jpg"  ></li>
			<li class="col_s_2">
				<h3>포토갤러리</h3>
				<p>취업 사진, 가족 사진, 프로필 사진, 우정 사진등 개인 또는 단체가 이용 할 수 있습니다.</p>
			</li>
			</ul>
		</div>
		</div>
</section>
<section class="items"> 
		<div class="box">
			<div class="item col_m_4 col_2">
			<ul>
			<li><img src="./images/main2.jpg" > </li>
				<li><h3>촬영 스튜디오</h3></li>
				<li>카메라, 촬영 소품, 조명 완벽 구비</li>
			</ul>
			</div>
			<div class="item col_m_4 col_2">
			<ul>
			<li><img src="./images/main2.jpg" > </li>
				<li><h3>촬영 스튜디오</h3></li>
				<li>카메라, 촬영 소품, 조명 완벽 구비</li>
			</ul>
			</div>
			<div class="item col_m_4 col_2">
			<ul>
			<li><img src="./images/main2.jpg" > </li>
				<li><h3>촬영 스튜디오</h3></li>
				<li>카메라, 촬영 소품, 조명 완벽 구비</li>
			</ul>
			</div>
			<div class="item col_m_4 col_2">
			<ul>
			<li><img src="./images/main2.jpg" > </li>
				<li><h3>촬영 스튜디오</h3></li>
				<li>카메라, 촬영 소품, 조명 완벽 구비</li>
			</ul>
			</div>
		</div>
</section>

<footer>
		<div class="box">
			<div class="col_m_3 col_3">
				<h3>고객센터</h3>
				<h1>Tel : 1588-1588</h1>
			</div>
			<div class="col_m_4 col_4">
				<ul>
					<li>회사소개</li>
					<li>|</li>
					<li>개인정보처리방침</li>
					<li>|</li>
					<li>이용약관</li>
					<li>|</li>
					<li>제휴안내</li>
				</ul>
				<p>주소 : 경기도 용인시 수지구 정평로<br>
				   email : photo@korea.com<br>
				   COTYRIGHT © 2021 The 스튜디오 . ALL RIGHTS RESERVED.
				</p>
			</div>
			
		</div>
</footer>
</div>
</body>
</html>
