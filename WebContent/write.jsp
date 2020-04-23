<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="./styles.css" />
</head>
<body>
	<%@ include file = "./header.jsp" %>
	<%
		if(session.getAttribute("IS_ADMIN") == null ){
			out.println("<script>alert('잘못된 접근입니다.');location.href='./index.jsp';</script>");
		}
	%>
	<form class="view-wrapper" action = "./write" method="POST" enctype="multipart/form-data" accept-charset="UTF-8">
		<div class="write-img-wrapper">
			<div class = "write-img">
				
			</div>
			<input type="file" name = "img" class="input-img"/>
		</div>
		
		<div class="product-info-wrapper">
		
			<div class="p-title">
				<input type="text" class = "write-input" name = "title" placeholder="상품명을 입력해 주세요"/>
			</div>
			
			<div class="p-wrapper">
				<div class="p-label">종류</div>
				<select name ="type">
					<option value = "outer">아우터</option>
					<option value = "bottom">하의</option>
					<option value = "shirts">셔츠 / 블라우스</option>
				</select>
			</div>
			
			<div class="p-wrapper">
				<div class="p-label">판매가</div>
				<input type="text" class = "write-input" name = "price" placeholder="가격을 입력해 주세요"/>
			</div>
			
			<div class="p-wrapper">
				<div class="p-label">재고</div>
				<input type="text" class = "write-input" name = "stock" placeholder="재고 수량을 입력해 주세요"/>
			</div>
			
			<div class="p-wrapper">
				<div class="p-label">색상</div>
				<input type="text" class = "write-input" name = "color" placeholder="  , 사용해서 색상을 입력해주세요  ex)빨강,노랑 "/>
			</div>
			
			<div class="p-wrapper">
				<div class="p-label">사이즈</div>
				<input type="text" class = "write-input" name = "size" placeholder="  , 사용해서 사이즈를 입력해주세요 ex)S,M,L"/>
			</div>
			
			<div class="write-button-wrapper">
				<input type="submit" class= "write-fav-btn" value="작성완료">

			</div>
			
			
			
			
		</div>
	</form>
<script src="./js/write.js"></script>
</body>
</html>