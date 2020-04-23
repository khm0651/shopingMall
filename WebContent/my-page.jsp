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
						�Ա���
					</div>
					<div class="order-item-sub">
						0
					</div>
				</div>
				<div class= order-item>
					<div class="order-item-title">
						����غ���
					</div>
					<div class="order-item-sub">
						0
					</div>
				</div>
				<div class= order-item>
					<div class="order-item-title">
						�����
					</div>
					<div class="order-item-sub">
						0
					</div>
				</div>
				<div class= order-item>
					<div class="order-item-title">
						��ۿϷ�
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
						����������
					</div>
					<div class="coupon-item-sub">
						0
					</div>
				</div>
				<div class= coupon-item>
					<div class="coupon-item-title">
						��������
					</div>
					<div class="coupon-item-sub">
						0
					</div>
				</div>
				<div class= coupon-item>
					<div class="coupon-item-title">
						���������
					</div>
					<div class="coupon-item-sub">
						0
					</div>
				</div>
				
			</div>
		</div>
		
		<div class="card-wrapper">
		
			<a href = "./Mypage-View?type=buy" class="card">
			
				<div class="card-img-wrapper">
					<img class = "card-img" src = "./img/order.png"/>
				</div>
				
				
				<div class="card-title">
					Order
				</div>
				
				<div class="card-sub">
					�ֹ��Ͻ� ��ǰ�� �ֹ������� Ȯ���� �� �ֽ��ϴ�.
				</div>
			</a>
			
			<a href = "./Mypage-View?type=fav" class="card">
			
				<div class="card-img-wrapper">
					<img class = "card-img" src="./img/smart-cart.png"/>
				</div>
				
				
				<div class="card-title">
					Whishlist
				</div>
				
				<div class="card-sub">
					���ɻ�ǰ���� ����Ͻ� ��ǰ�� ����� �����帳�ϴ�.
				</div>
			</a>
			
		</div>
		
		
		
	</div>
	

	
</body>
</html>