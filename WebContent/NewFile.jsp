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
        <h1>����ϴ� �츮����</h1>
    </header>
    <section>
        ���� �����ϴ� ������ �ؾ� �ϴ� ������<br>
        ������ ���α׷����̴�.(��� �ʼ� �ڽ�)<br>
        ���� ��¥�� <%=today%> �Դϴ�.<br>
        ������ �ϰڽ��ϴ�.<br>
    </section>
    <footer>
        <h5>(��) �鼮���б� ICT �к�</h5>
    </footer>
</body>
</html>