<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<body>

	<header class="header-wrap">

        <div class="header">

            <div class="best-item-search">

                <div class="search-group">

                    <ol class="search-list">
                        
                    </ol>

                    <div class="search-more">
                        ▼
                    </div>

                </div>
                
                <div class="best-item-more">

                    <div class="m-search-group">

                        <ol class="m-search-list">
                            <li>파랑파랑한 자켓</li>
                            <li>멋쟁이 조거팬츠</li>
                            <li>산뜻한 느낌의 브라우스</li>
                            <li>산뜻한 느낌의 브라우스</li>
                            <li>산뜻한 느낌의 브라우스</li>
                        </ol>
    
                        <div class="m-search-more">
                            
                        </div>
    
                    </div>

                </div>
                
                
            </div>

            <div class="home-title">
                <a href="./index.jsp">BigGates</a>
            </div>

            <div class="login-wrap">
				
                <div>
                	<%
                		//로그인을 한경우 "사용자아이디" 님 환영합니다 표시 그렇지않은경우 회원가입 표시
						if(session.getAttribute("LOGIN_ID") != null){
							out.println("<a href='./my-page.jsp' class='username'>"+session.getAttribute("LOGIN_ID")+"</a>");
							out.println("<div class='welcome-label'>님 환영합니다.</div>");
						}else{
							out.println("<a href='./sign-up.jsp'>회원가입</a>");
						}
					%>
                </div>

                <div>
                	<%
                		//로그인을 한 경우 로그아웃 표시 그렇지 않은경우  로그인 표시
						if(session.getAttribute("LOGIN_ID") != null){
							out.println("<a href='./logout'>로그아웃</a>");
						}else{
							out.println("<a href='./login.jsp'>로그인</a>");
						}
					%>
                </div>

            </div>
            
            <%
            	//어드민 계정일 경우 글쓰기 버튼 생성
				if(session.getAttribute("IS_ADMIN") != null && session.getAttribute("IS_ADMIN").equals(true)){
					out.println("<a class='write' href='./write.jsp'><image src='./img/write.png'/ class='forAdmin'>글쓰기</a>");
				}
		
            %>
	           

        </div>

    </header>

    <nav class=menu-wrap>
        <div class="menu">
            <a href="./p-view?type=outer">
                아우터
            </a>
            <a href="./p-view?type=bottom">
                하의
            </a>
            <a href="./p-view?type=shirts">
                셔츠 / 블라우스
            </a>
        </div>
    </nav>
    
</body>
</html>