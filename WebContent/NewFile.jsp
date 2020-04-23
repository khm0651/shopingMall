<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
   	header{color:blue;}
    section{color:gray;}
	footer{color:black;}
</style>
</head>
<body>

	<% 
        Date today= new Date();

    %>
    <header>
        <h1>사랑하는 우리가족</h1>
    </header>
    <section>
        내가 좋아하는 열심히 해야 하는 과목은<br>
        웹서버 프로그래밍이다.(취업 필수 코스)<br>
        현재 날짜는 <%=today%> 입니다.<br>
        열심히 하겠습니다.<br>
    </section>
    <footer>
        <h5>(주) 백석대학교 ICT 학부</h5>
    </footer>
</body>
</html>