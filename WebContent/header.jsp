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
                        ��
                    </div>

                </div>
                
                <div class="best-item-more">

                    <div class="m-search-group">

                        <ol class="m-search-list">
                            <li>�Ķ��Ķ��� ����</li>
                            <li>������ ��������</li>
                            <li>����� ������ ���콺</li>
                            <li>����� ������ ���콺</li>
                            <li>����� ������ ���콺</li>
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
						if(session.getAttribute("LOGIN_ID") != null){
							out.println("<a href='./my-page.jsp' class='username'>"+session.getAttribute("LOGIN_ID")+"</a>");
							out.println("<div class='welcome-label'>�� ȯ���մϴ�.</div>");
						}else{
							out.println("<a href='./sign-up.jsp'>ȸ������</a>");
						}
					%>
                </div>

                <div>
                	<%
						if(session.getAttribute("LOGIN_ID") != null){
							out.println("<a href='./logout'>�α׾ƿ�</a>");
						}else{
							out.println("<a href='./login.jsp'>�α���</a>");
						}
					%>
                </div>

            </div>
            
            <%
            
				if(session.getAttribute("IS_ADMIN") != null && session.getAttribute("IS_ADMIN").equals(true)){
					out.println("<a class='write' href='./write.jsp'>�۾���</a>");
				}
		
            %>
	           

        </div>

    </header>

    <nav class=menu-wrap>
        <div class="menu">
            <a href="./p-view?type=outer">
                �ƿ���
            </a>
            <a href="./p-view?type=bottom">
                ����
            </a>
            <a href="./p-view?type=shirts">
                ���� / ���콺
            </a>
        </div>
    </nav>
    
</body>
</html>