package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class FavBuy
 */
@WebServlet("/FavBuy")
public class FavBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavBuy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String fav = request.getParameter("fav");
		String buy = request.getParameter("buy");
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("LOGIN_ID"));
		PrintWriter out = response.getWriter();
		String id = null;
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		if(session.getAttribute("LOGIN_ID") != null) {
			id = session.getAttribute("LOGIN_ID").toString();
			Connection conn = null;
			Statement stmt = null;
			
			try {
				String dburl = "jdbc:apache:commons:dbcp:wdbpool";
				conn = DriverManager.getConnection(dburl);
				stmt = conn.createStatement();
				if(fav != null) {
					
					ResultSet rs = stmt.executeQuery("select * from favorite where id = '"+id+"' and pid ='"+fav+"'");
					if(rs.next()) {
						stmt.close();
						conn.close();
						out.println("<script>alert('이미 장바구니에 있습니다.'); history.back();</script>");
					}else {
						String favQuery="insert into favorite values('"+id+"','"+fav+"','"+format1.format(time).substring(0,10)+"')";
						int insert = stmt.executeUpdate(favQuery);
						if(insert != 1) {
							stmt.close();
							conn.close();
							out.println("<script>alert('장바구니 담기 실패'); history.back();</script>");
							

						}else {
							int update = stmt.executeUpdate("update product set favorite = favorite + 1 where pid = '"+fav+"'");
							if(update != 1) {
								stmt.close();
								conn.close();
								out.println("<script>alert('오류 발생'); history.back();</script>");
							}else {
								
								stmt.close();
								conn.close();
								out.println("<script>alert('장바구니 담기 성공'); history.back();</script>");
							}
							

						}
					}
				
					
					
				}else if (buy != null){
					
					String buyQuery="insert into buy values('"+id+"','"+request.getParameter("buy")+"','"+request.getParameter("name")+"',"+Integer.parseInt(request.getParameter("price"))+",'"+request.getParameter("color")+"','"+request.getParameter("size")+"',"+Integer.parseInt(request.getParameter("count"))+",'"+format1.format(time)+"')";
					int update = stmt.executeUpdate("update product set stock = stock - "+Integer.parseInt(request.getParameter("count"))+" where pid = '"+request.getParameter("buy")+"'");
					if(update != 1) {
						System.out.println("업데이트 실패");
					}else {
						System.out.println("업데이트 성공");
					}
					int rs = stmt.executeUpdate(buyQuery);
					if(rs != 1) {
						stmt.close();
						conn.close();
						out.println("<script>alert('구매하기 실패'); location.href=document.referrer;</script>");
						

					}else {
						stmt.close();
						conn.close();
						out.println("<script>alert('구매하기 성공'); history.back();</script>");

					}
					
				}
				
			}catch(Exception e){
				System.out.println(e.getMessage());
			}finally {
				try {
					stmt.close();
					conn.close();
				}catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
			}
		}else {
			out.println("<script>alert('로그인 후 이용해주시기 바랍니다.'); history.back()</script>");
		}
		
		
		
		
		
		
		
	}

}
