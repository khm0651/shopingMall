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
			out.println("<script>alert('�߸��� �����Դϴ�.');location.href='./index.jsp';</script>");
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
				<input type="text" class = "write-input" name = "title" placeholder="��ǰ���� �Է��� �ּ���"/>
			</div>
			
			<div class="p-wrapper">
				<div class="p-label">����</div>
				<select name ="type">
					<option value = "outer">�ƿ���</option>
					<option value = "bottom">����</option>
					<option value = "shirts">���� / ���콺</option>
				</select>
			</div>
			
			<div class="p-wrapper">
				<div class="p-label">�ǸŰ�</div>
				<input type="text" class = "write-input" name = "price" placeholder="������ �Է��� �ּ���"/>
			</div>
			
			<div class="p-wrapper">
				<div class="p-label">���</div>
				<input type="text" class = "write-input" name = "stock" placeholder="��� ������ �Է��� �ּ���"/>
			</div>
			
			<div class="p-wrapper">
				<div class="p-label">����</div>
				<input type="text" class = "write-input" name = "color" placeholder="  , ����ؼ� ������ �Է����ּ���  ex)����,��� "/>
			</div>
			
			<div class="p-wrapper">
				<div class="p-label">������</div>
				<input type="text" class = "write-input" name = "size" placeholder="  , ����ؼ� ����� �Է����ּ��� ex)S,M,L"/>
			</div>
			
			<div class="write-button-wrapper">
				<input type="submit" class= "write-fav-btn" value="�ۼ��Ϸ�">
			</div>
			
			
			
			
		</div>
	</form>
<script src="./js/write.js"></script>
</body>
</html>