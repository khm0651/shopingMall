<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.sun.org.apache.bcel.internal.generic.INSTANCEOF"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel = "stylesheet" href="./styles.css">
</head>
<body>
	<%@ include file = "./header.jsp" %>
	
	<!-- 데이터베이스안에 저장되어있는 상품들에 대한 정보 표시 -->
	<div class="p-view-wrapper">
		<c:forEach var="i" begin="0" end = "${info.listSize - 1}">
		<form action = "./view" method="POST" accept-charset="UTF-8" class="p-view-item">
	                
			<div class="item-img-wrap" >
				<img src="./img/${info.img[i] }" class="item-img">
			</div>
	                
			<div class="item-info">
				<div class="item-title">
					${info.name[i] }
				</div>
				<div class="item-price" >
					${info.price[i] } 원
				</div>
				<div class="item-likeNcommit">
					<div >
						좋아요 ${info.favorite[i] }
					</div>
					<div>
						|
					</div>
					<div >
						리뷰  ${info.comment[i] }
					</div>
				</div>
			</div>
	                
	                
			<input type="hidden" name= "name" value ="${ info.name[i] }" />

		</form>
		</c:forEach>
		

	</div>
	
	<script type="text/javascript" src="./js/pview.js"></script>
</body>
</html>