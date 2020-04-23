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
	<div class="sign-up-form-wrap">
        <form action="signUp" method="POST" class="sign-up-form" accept-charset="UTF-8">
            <div class="sign-up-list">
                <div class="sign-up-label">
                    이름
                </div>
                <input type="text" class="sign-up-info" name = "name">
            </div>
    
            <div class="sign-up-list">
                <div class="sign-up-label">
                    아이디
                </div>
                <input type="text" class="sign-up-info" name = "id">
            </div>
    
            <div class="sign-up-list">
                <div class="sign-up-label">
                    비밀번호
                </div>
                <input type="text" class="sign-up-info" name = "pw">
            </div>
    
            <div class="sign-up-list">
                <div class="sign-up-label">
                    전화번호
                </div>
                <input type="text" class="sign-up-info" name = "tel">
            </div>
    
            <div class="sign-up-list">
                <div class="sign-up-label">
                    주소
                </div>
                <input type="text" class="sign-up-info" name = "addr">
            </div>
    
            <input type="submit" value="가입 하기" class="sign-up-submit">
        </form>
    </div>
    

    <script src="./main.js"></script>

</body>
</html>