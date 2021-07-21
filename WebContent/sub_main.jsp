<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
*{margin:0;padding:0; box-sizing:border-box;}

a:link, a:visited, a:hover, a:active{
			text-decoration:none;
}
li{list-style-type:none;}
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
	background-color:#3399ff;
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
	padding-left:5px;
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

@media only screen and (min-width: 768px){
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
@media only screen and (min-width:1200px){
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
<section class="banners">
		<div class="box">
			<div class="banner col_m_4 col_4">
			<ul>
			<li class="col_s_2"><img  src="./images/icon1.jpg"  ></li>
			<li class="col_s_2">
				<h3>셀러 모집</h3>
				<p>혼자만 즐기던 취향 공유하고 돈도 벌자 </p>
			</li>
			</ul>
		</div>
		<div class="banner col_m_4 col_4">
			<ul>
			<li class="col_s_2"><img  src="./images/icon2.jpg"  ></li>
			<li class="col_s_2">
				<h3>나만의 굿즈 제작</h3>
				<p>똑같은 물건을 싫다! 나는 딱 봐도 내거다 싶은 물건을 원한다</p>
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
				<li><h3>굿즈 #</h3></li>
				<li>나만의 다양한 굿즈를 제작해보세요</li>
			</ul>
			</div>
			<div class="item col_m_4 col_2">
			<ul>
			<li><img src="./images/main2.jpg" > </li>
				<li><h3>취향 모집</h3></li>
				<li>나와 비슷한 사람과 함께 공동 제작 가능</li>
			</ul>
			</div>
			<div class="item col_m_4 col_2">
			<ul>
			<li><img src="./images/main2.jpg" > </li>
				<li><h3>셀러 모집</h3></li>
				<li>SNS공간이 아닌 나만의 판매공간이 필요한 셀러모집</li>
			</ul>
			</div>
			<div class="item col_m_4 col_2">
			<ul>
			<li><img src="./images/main2.jpg" > </li>
				<li><h3></h3></li>
				<li></li>
			</ul>
			</div>
		</div>
</section>

<footer>
		<div class="box">
			<div class="col_m_3 col_3">
				<h4>고객센터</h4>
				<h4>Tel : 1588-1588</h4>
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
				   email : Goods#@korea.com<br>
				   COTYRIGHT © 2021 The 굿즈 # . ALL RIGHTS RESERVED.
				</p>
			</div>
			
		</div>
</footer>
</body>
</html>