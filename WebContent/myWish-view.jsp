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
					���� ��¥
				</div>
				
				<div class="myorder-img-wish">
					�̹���
				</div>
				
				<div class="myorder-infomation">
					��ǰ ����
				</div>
							
				<div class="myorder-condition">
					��ǰ���űݾ�
				</div>
					
				
			</div>
			
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
								${MyFav.price[i] }��
								<button class="condition-cancle" name ="${MyFav.pid[i]}">
									��� ���
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