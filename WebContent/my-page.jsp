<%@page import="com.sun.org.apache.bcel.internal.generic.INSTANCEOF"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="./styles.css" />
</head>
<body>
	<%@include file="./header.jsp" %>
	
	<div class="mypage-wrapper">
	
		<div class="order">
			<div class="order-text">
				MY ORDER
			</div>
			<div class="order-info">
				<div class= order-item>
					<div class="order-item-title">
						입금전
					</div>
					<div class="order-item-sub">
						0
					</div>
				</div>
				<div class= order-item>
					<div class="order-item-title">
						배송준비중
					</div>
					<div class="order-item-sub">
						0
					</div>
				</div>
				<div class= order-item>
					<div class="order-item-title">
						배송중
					</div>
					<div class="order-item-sub">
						0
					</div>
				</div>
				<div class= order-item>
					<div class="order-item-title">
						배송완료
					</div>
					<div class="order-item-sub">
						0
					</div>
				</div>
			</div>
		</div>
		
		<div class="coupon">
			<div class="coupon-text">
				MY POINT / COUPON
			</div>
			<div class="coupon-info">
				<div class= "coupon-item">
					<div class="coupon-item-title">
						가용적립금
					</div>
					<div class="coupon-item-sub">
						0
					</div>
				</div>
				<div class= coupon-item>
					<div class="coupon-item-title">
						총적립금
					</div>
					<div class="coupon-item-sub">
						0
					</div>
				</div>
				<div class= coupon-item>
					<div class="coupon-item-title">
						사용적립금
					</div>
					<div class="coupon-item-sub">
						0
					</div>
				</div>
				
			</div>
		</div>
		
		<div class="card-wrapper">
		
			<a href = "./mypage-View?type=buy" class="card">
			
				<div class="card-img-wrapper">
					<img class = "card-img" src = "./img/order.png"/>
				</div>
				
				
				<div class="card-title">
					Order
				</div>
				
				<div class="card-sub">
					주문하신 상품의 주문내역을 확인할 수 있습니다.
				</div>
			</a>
			
			<a href = "./mypage-View?type=fav" class="card">
			
				<div class="card-img-wrapper">
					<img class = "card-img" src="./img/smart-cart.png"/>
				</div>
				
				
				<div class="card-title">
					Whishlist
				</div>
				
				<div class="card-sub">
					관심상품으로 등록하신 상품의 목록을 보여드립니다.
				</div>
			</a>
			
		</div>
		
		
		
	</div>
	

	
</body>
</html>