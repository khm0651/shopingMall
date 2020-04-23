<%@page import="com.sun.org.apache.bcel.internal.generic.INSTANCEOF"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./styles.css">
</head>
<body>
    
    <%@include file = "./header.jsp" %>
	
	

    <div class="img-slide-wrap">

        <div class="img-slide">
            <img src="./img/banner3.jpg" class="slide img-one">

            
            <img src="./img/banner2.jpg" class="slide img-two">

           
            <img src="./img/banner1.jpg" class="slide img-three">

            
            <img src="./img/banner3.jpg" class="slide img-one">

            
        </div>

    </div>
    
    <div class="section-one">

        <div class="title">
            Best Product
        </div>

        <div class="best-item-wrap">
        	<c:if test="${BestPinfo.listSize>0 }">
				<c:forEach var="i" begin = "0" end = "${BestPinfo.listSize -1}">
		            <form action = "./view" method="POST" accept-charset="UTF-8" class="best-item">
		                
		                <div class="item-index">
		                    ${i+1 }
		                </div>
		                
		                <div class="item-img-wrap" >
		                    <img src="./img/${ BestPinfo.img[i]}" class="item-img">
		                </div>
		                
		                <div class="item-info">
		                    <div class="item-title">
		                        ${BestPinfo.name[i] }
		                    </div>
		                    <div class="item-price" >
		                        ${BestPinfo.price[i] } 원
		                    </div>
		                    <div class="item-likeNcommit">
		                        <div >
		                            좋아요 ${BestPinfo.favorite[i] }
		                        </div>
		                        <div>
		                            |
		                        </div>
		                        <div >
		                            리뷰  ${BestPinfo.comment[i] }
		                        </div>
		                    </div>
		                </div>
		                
		                
		                <input type="hidden" name= "name" value ="${ BestPinfo.name[i] }" />
	
		            </form>
				</c:forEach>
            </c:if>

        </div>

    </div>

    <div class="section-two">

        <div class="title">
            New Product
        </div>

        <div class="new-item-wrap">
        	<c:if test="${NewPinfo.listSize>0 }">
				<c:forEach var="i" begin = "0" end = "${NewPinfo.listSize -1}">
				<form action = "./view" method="POST" accept-charset="UTF-8" class="new-item">
	                <div class="item-index">
	                    ${i+1 }
	                </div>
	                <div class="item-img-wrap">
	                    <img src="./img/${NewPinfo.img[i] }" class="item-img">
	                </div>
	                <div class="item-info">
	                    <div class="item-title">
	                        ${NewPinfo.name[i] }
	                    </div>
	                    <div class="item-price">
	                        ${NewPinfo.price[i] } 원
	                    </div>
	                    <div class="item-likeNcommit">
	                        <div>
	                            좋아요 ${NewPinfo.favorite[i] }
	                        </div>
	                        <div>
	                            |
	                        </div>
	                        <div>
	                            리뷰 ${NewPinfo.comment[i] }
	                        </div>
	                    </div>
	                </div>
	    			
	    			<input type="hidden" name= "name" value ="${ NewPinfo.name[i] }" />
	    			
	            </form>
	    		</c:forEach>
            </c:if>
    
           
    
            

        </div>
        

        
    </div>

    <footer class="footer">
        <div>

        </div>
        <div>

        </div>
        <div>

        </div>
    </footer>
    <script src="./js/main.js"></script>
    <script src="./js/header.js"></script>
</body>
</html>