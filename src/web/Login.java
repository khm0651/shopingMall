package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		PrintWriter out = response.getWriter();
		if(checkInfo(id,pw)) {
			HttpSession session = request.getSession();
			session.setAttribute("LOGIN_ID", id);
			if(id.equals("khm0920")) session.setAttribute("IS_ADMIN", true);
			response.sendRedirect("./");
		}else {
			out.println("<script>"
					+ "alert('아이디 또는 비밀번호가 틀렸습니다.');"
					+ "history.back();"
					+ "</script>");
			
		}
	}

	private boolean checkInfo(String id, String pw) throws ServletException {
		// TODO Auto-generated method stub
		Connection conn =null;
		Statement stmt = null;
		try {
			String dburl = "jdbc:apache:commons:dbcp:wdbpool";
			conn = DriverManager.getConnection(dburl);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from member where id = '"+id+"';");
			if(rs == null) {
				return false;
			}else {
				if(rs.next()) {
					if(rs.getString("pw").equals(pw)) {
						return true;
					}else {
						return false;
					}
				}else {
					return false;
				}
				
			}
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			e.getStackTrace();
		}
		finally {
			try {
				if(stmt != null ) stmt.close();
				if(conn != null) conn.close();
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			
		}
		return false;
	}

}
