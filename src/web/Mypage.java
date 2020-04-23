package web;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Mypage
 */
@WebServlet("/Mypage")
public class Mypage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mypage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String dburl ="jdbc:apache:commons:dbcp:wdbpool";
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		try {
			Connection conn = DriverManager.getConnection(dburl);
			Statement stmt = conn.createStatement();
			Mybuy mybuy = new Mybuy();
			Myfav myfav = new Myfav();
			HttpSession session = request.getSession();
			int c;
			String type = request.getParameter("type");
			
			RequestDispatcher dispatcher;
			
			if(type.equals("buy")) {
				ResultSet rs = stmt.executeQuery("select buy.pid,name,price,color,size,count,img,buydate from buy join pimg on buy.pid = pimg.pid where id = '"+session.getAttribute("LOGIN_ID")+"'");
				rs.last();
				c = rs.getRow();
				rs.first();
				for(int i =0; i<c; i++) {
					mybuy.setPid(i, rs.getString("pid"));
					mybuy.setName(i, rs.getString("name"));
					mybuy.setPrice(i, rs.getString("price"));
					mybuy.setSize(i, rs.getString("size"));
					mybuy.setImg(i, rs.getString("img"));
					mybuy.setColor(i, rs.getString("color"));
					mybuy.setC(i, rs.getString("count"));
					mybuy.setBuydate(i, rs.getString("buydate").substring(0,10));
					mybuy.setDate(i,rs.getString("buydate"));
					if(!rs.next()) {
						break;
					}
				}
				request.setAttribute("Mybuy", mybuy);
				if (conn != null) conn.close();
				if (stmt != null) stmt.close();
				dispatcher = request.getRequestDispatcher("./mypage-view.jsp");
				dispatcher.forward(request, response);
				
			}else if(type.equals("fav")) {
				ResultSet rs = stmt.executeQuery("select f.id,f.pid,name,price,img,favdate from favorite as f join product as p on f.pid = p.pid join pimg on f.pid = pimg.pid where id = '"+session.getAttribute("LOGIN_ID")+"'");
				rs.last();
				c = rs.getRow();
				rs.first();
				for(int i =0; i<c; i++) {
					myfav.setPid(i, rs.getString("pid"));
					myfav.setName(i, rs.getString("name"));
					myfav.setPrice(i, rs.getString("price"));
					myfav.setImg(i, rs.getString("img"));
					myfav.setDate(i, rs.getString("favdate"));
					if(!rs.next()) {
						break;
					}
				}
				request.setAttribute("MyFav", myfav);
				if (conn != null) conn.close();
				if (stmt != null) stmt.close();
				dispatcher = request.getRequestDispatcher("./myWish-view.jsp");
				dispatcher.forward(request, response);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
