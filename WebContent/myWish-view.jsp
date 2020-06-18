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
					담은 날짜
				</div>
				
				<div class="myorder-img-wish">
					이미지
				</div>
				
				<div class="myorder-infomation">
					상품 정보
				</div>
							
				<div class="myorder-condition">
					상품구매금액
				</div>
					
				
			</div>
			<!-- 데이터베이스 안에 사용자가 장바구니에 담은 정보들 표시 -->
			<div class="myorder-list-wrapper">
				<c:if test ="${MyFav.count > 0}">
					<c:forEach var="i" begin="0" end="${MyFav.count -1 }">
						<div class="myorder-list">
							<div class= "myorder-list-date">
								${MyFav.date[i] }
							</div>
							
							<img class = "myorder-list-img-wish" src="./img/${MyFav.img[i]}" />
							
							<div class= "myorder-list-info">
								${MyFav.name[i] }
							</div>
							<div class= "myorder-list-price">
								${MyFav.price[i] }원
								<button class="condition-cancle" name ="${MyFav.pid[i]}">
									담기 취소
								</button>
							</div>
							
						</div>
					</c:forEach>
				</c:if>
			</div>
			
			
		</div>
		<script src="./js/myWish-view.js"></script>
</body>
</html>