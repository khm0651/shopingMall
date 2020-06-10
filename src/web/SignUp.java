package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SignUp
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SignUp" })
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String addr = request.getParameter("addr");
		
		PrintWriter out = response.getWriter();
		if(checkInfo(name,id,pw,tel,addr)) {
			out.println("<script>"
					+ "alert('ȸ������ �Ϸ�');"
					+ "location.href='./';"
					+ "</script>");
		
			
		}else {
			out.println("<script>"
					+ "alert('ȸ������ ����');"
					+ "history.back();"
					+ "</script>");
			
		}
		
	}

	private boolean checkInfo(String name, String id, String pw, String tel, String addr) throws ServletException {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		try {

			String jdbcUrl = "jdbc:apache:commons:dbcp:wdbpool";
			conn = DriverManager.getConnection(jdbcUrl);
			stmt = conn.createStatement();
			if(name == "" || id == "" || pw == "" || tel == "" || addr == "") {
				return false;
			}
			int rs = stmt.executeUpdate("insert into member values ('"+name+"','"+id+"','"+pw+"','"+tel+"','"+addr+"')");
			if(rs==0) {
				return false;
			}else {
				return true;
			}
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {

			//Ŀ�ؼ��� Ǯ�� ��ȯ��
			try { 
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				
			} catch(SQLException ex) {}

		}
		return false;
		


		
	}

	
}
