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
	<%
		request.setCharacterEncoding("UTF-8"); 
	  	response.setCharacterEncoding("UTF-8");
	%>
	<%@include file="./header.jsp" %>
	
	<div class="myorder">
			<div class="myorder-header">
			
				<div class="myorder-date">
					주문일자
				</div>
				
				<div class="myorder-img">
					이미지
				</div>
				
				<div class="myorder-infomation">
					상품 정보
				</div>
				
				<div class="myorder-count">
					주문수량
				</div>
				
				<div class="myorder-price">
					상품구매금액
				</div>
				
				<div class="myorder-condition">
					주문처리상태
				</div>
				
				
			</div>
			
			<div class="myorder-list-wrapper">
				<c:if test ="${Mybuy.count > 0}">
					<c:forEach var="i" begin="0" end="${Mybuy.count - 1}">
						<div class="myorder-list">
							<div class= "myorder-list-date">
								${Mybuy.buydate[i] }
							</div>
							
							<img class = "myorder-list-img" src="./img/${Mybuy.img[i]}" />
							
							<div class= "myorder-list-info">
								사이즈 ${Mybuy.size[i] } / 색깔 ${Mybuy.color[i] }
							</div>
							<div class= "myorder-list-count">
								${Mybuy.c[i] }
							</div>
							<div class= "myorder-list-price">
								${Mybuy.price[i] }원
							</div>
							<div class="myorder-list-condition">
								<div class="condition-title">
									신청
								</div>
								<button class="condition-cancle" name ="${Mybuy.pid[i] }/${Mybuy.date[i] }">
									신청 취소
								</button>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
			
			
		</div>
		<script src="./js/mypage-view.js"></script>
</body>
</html>