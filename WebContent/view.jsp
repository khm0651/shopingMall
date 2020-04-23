<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.sun.org.apache.bcel.internal.generic.INSTANCEOF"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="./styles.css" />
</head>
<body>
	<%@include file="./header.jsp" %>
	
	<div class="view-wrapper">
		<div class = "img-wrapper">
			<image src="./img/${vInfo.img }" class="product-img">
		</div>
		<div class="product-info-wrapper">
		
			<div class="p-title">
				${vInfo.name }
			</div>
			
			<div class="p-wrapper">
				<div class="p-label">ǰ�� �ڵ�</div>
				<div class="id">${vInfo.pid }</div>
			</div>
			
			<div class="p-wrapper">
				<div class="p-label">�ǸŰ�</div>
				<div class="price" >${vInfo.price } ��</div>
			</div>
			
			<div class="p-wrapper">
				<div class="p-label">���</div>
				<div class="stock">�ǽð� ��� �ȳ�  <span> ${vInfo.stock }</span> �� </div>
			</div>
			
			<div class="p-wrapper">
				<div class="p-label">����</div>
				<select class="color">
					<c:forEach var="i" begin = "0" end = "${vInfo.colorCount -1}">
						<option value="${vInfo.color[i] }">${vInfo.color[i] }</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="p-wrapper">
				<div class="p-label">������</div>
				<select class="size">
					<c:forEach var="i" begin = "0" end = "${vInfo.sizeCount -1}">
						<option value="${vInfo.size[i] }">${vInfo.size[i] }</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="p-count-wrapper">
				<div class="left">
					<div class="select-color">
						
					</div>
					<div>
						/
					</div>
					<div class="select-size">
						
					</div>
				</div>
				
				<div class="center">
					<div class="count-box">
						1
					</div>
					<div class="count-btn-wrapper">
						<button class="count-btn-up">��</button>
						<button class="count-btn-down">��</button>
					</div>
					
				</div>
				
				<div class="right">
					<div class="p-count-price">
						${vInfo.price } ��
					</div>
				</div>	
				
			</div>
			
			<div class="p-total-wrapper">
				<div class="p-label">�� �����ݾ�</div>
				<div class="total">${vInfo.price } ��</div>
			</div>
			
			<div class="button-wrapper">
				<form action="./favbuy" method="POST" class="fav-btn" accept-charset="UTF-8">
					��ٱ���
					<input type="hidden" name="fav" value="${vInfo.pid }"/>
				</form>
				<form action="./favbuy" method="POST" class="buy-btn" accept-charset="UTF-8">
					�����ϱ�
					<input type="hidden" name="buy" value="${vInfo.pid }"/>
					<input type="hidden" name = "name" value="${vInfo.name }"/>
					<input type="hidden" name="price" value="${vInfo.price }"/>
					<input type="hidden" name="color"/>
					<input type="hidden" name="size" />
					<input type="hidden" name="count" />
				</form>
			</div>
		</div>

	</div>
	
	<div class="comment-wrapper">
		<div class ="comment">
			<div class="comment-info">
				<div>
					�г���
				</div>
				<div>
					�ۼ���¥
				</div>
			</div>
			<div class="comment-title">
				����
			</div>
			<div class="comment-sub">
				��ۿ����Դϴ� ��� �����Դϴ�.
			</div>
		</div>
		
		<div class ="comment">
			<div class="comment-info">
				<div>
					�г���
				</div>
				<div>
					�ۼ���¥
				</div>
			</div>
			<div class="comment-title">
				����
			</div>
			<div class="comment-sub">
				��ۿ����Դϴ� ��� �����Դϴ�.
			</div>
		</div>
		
		<div class ="comment">
			<div class="comment-info">
				<div>
					�г���
				</div>
				<div>
					�ۼ���¥
				</div>
			</div>
			<div class="comment-title">
				����
			</div>
			<div class="comment-sub">
				��ۿ����Դϴ� ��� �����Դϴ�.
			</div>
		</div>
		
		<div class ="comment">
			<div class="comment-info">
				<div>
					�г���
				</div>
				<div>
					�ۼ���¥
				</div>
			</div>
			<div class="comment-title">
				����
			</div>
			<div class="comment-sub">
				��ۿ����Դϴ� ��� �����Դϴ�.
			</div>
		</div>
		
		<div class ="comment">
			<div class="comment-info">
				<div>
					�г���
				</div>
				<div>
					�ۼ���¥
				</div>
			</div>
			<div class="comment-title">
				����
			</div>
			<div class="comment-sub">
				��ۿ����Դϴ� ��� �����Դϴ�.
			</div>
		</div>
		
		<div class ="comment">
			<div class="comment-info">
				<div>
					�г���
				</div>
				<div>
					�ۼ���¥
				</div>
			</div>
			<div class="comment-title">
				����
			</div>
			<div class="comment-sub">
				��ۿ����Դϴ� ��� �����Դϴ�.
			</div>
		</div>
	</div>
	
	
	
	<img class="comment-button" src="./img/write.png"/>

	<script src="./js/view.js" charset="UTF-8"></script>
	<script src="./js/header.js"></script>
</body>
</html>