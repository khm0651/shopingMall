package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Comment
 */
@WebServlet("/Comment")
public class Comment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Comment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String title = request.getParameter("write-comment-title");
		String content = request.getParameter("write-comment");
		String pid = request.getParameter("pid");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		if(session.getAttribute("LOGIN_ID")==null) {
			out.println("<script>alert('로그인 후 이용해주시기 바랍니다.');history.go(-1);</script>");
			
		}else {
			String id = (String) session.getAttribute("LOGIN_ID");
			Connection conn = null;
			Statement stmt = null;
			Date date =new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			String query = "insert into comment values ('"+pid+"','"+id+"','"+title+"','"+content+"','"+format.format(date)+"')";
			try {
				String dburl = "jdbc:apache:commons:dbcp:wdbpool";
				conn = DriverManager.getConnection(dburl);
				stmt = conn.createStatement();
				int rs = stmt.executeUpdate(query);
				if(rs == 0 ) {
					out.println("<script>alert('댓글 작성 실패'); history.go(-1);</script>");
				}else {
					System.out.println("hi");
					out.println("<script>alert('댓글 작성 성공'); history.go(-1);</script>");
				}
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(conn!=null)conn.close();
					if(stmt != null)stmt.close();
				}catch(SQLException e) {
					System.out.println(e.getMessage());
				}
				
			}
		}
		
	}

}
