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
	
	<!-- �����ͺ��̽��ȿ� ����Ǿ��ִ� ��ǰ�鿡 ���� ���� ǥ�� -->
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
					${info.price[i] } ��
				</div>
				<div class="item-likeNcommit">
					<div >
						���ƿ� ${info.favorite[i] }
					</div>
					<div>
						|
					</div>
					<div >
						����  ${info.comment[i] }
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