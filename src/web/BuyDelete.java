package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BuyDelete
 */
@WebServlet("/BuyDelete")
public class BuyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		String pid = request.getParameter("pid");
		String date = request.getParameter("date");
		String query1 = "delete from buy where id='"+session.getAttribute("LOGIN_ID")+"' and pid='"+pid+"' and buydate = '"+date+"'";
		String query2 = "update product set stock = stock + 1 where pid = '"+pid+"'";
		PrintWriter out = response.getWriter();
		Connection conn = null;
		Statement stmt = null;
		try {
			String dburl = "jdbc:apache:commons:dbcp:wdbpool";
			conn = DriverManager.getConnection(dburl);
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(query1);
			if(result == 0) {
				System.out.println("삭제 실패");
			}
			result = stmt.executeUpdate(query2);
			if(result == 0) {
				System.out.println("stock 증가 실패");
			}
				
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(stmt!= null) stmt.close();
				if(conn!= null) conn.close();
				out.println("<script>alert('삭제 성공');location.href = document.referrer;</script>");
				
			}catch(SQLException e) {}
		}
	}

}
