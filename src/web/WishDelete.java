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
 * Servlet implementation class WishDelete
 */
@WebServlet("/WishDelete")
public class WishDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishDelete() {
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
		PrintWriter out = response.getWriter();
		String query1 = "delete from favorite where id = '"+session.getAttribute("LOGIN_ID")+"' and pid = '"+pid+"'";
		String query2 = "update product set favorite = favorite - 1 where pid = '"+pid+"'";
		Connection conn = null;
		Statement stmt = null;
		try {
			String dburl = "jdbc:apache:commons:dbcp:wdbpool";
			conn = DriverManager.getConnection(dburl);
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(query1);
			if(result == 0) {
				System.out.println("���� ����");
			}
			result = stmt.executeUpdate(query2);
			if(result == 0) {
				System.out.println("favorite ���� ����");
			}
				
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(stmt!= null) stmt.close();
				if(conn!= null) conn.close();
				out.println("<script>alert('���� ����');location.href = document.referrer;</script>");
				
			}catch(SQLException e) {}
		}
	}

	

}
