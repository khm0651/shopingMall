<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="./styles.css">
</head>
<body>

	<%@include file = "./header.jsp" %>
	<div class="login-form-wrap">
        <form action="login" method="POST" class="login-form" accept-charset="UTF-8">
            <div class="login-list">
               
                <input type="text" placeholder="���̵�" class="login-info" name = "id">
            </div>
    
           <div class="login-list">
               
                <input type="password" placeholder="��й�ȣ" class="login-info" name = "pw">
            </div>
    
            <input type="submit" value="�α���" class="sign-up-submit">
        </form>
    </div>
    

    <script src="./main.js"></script>

</body>
</html>