package web;

import java.sql.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private String pid = null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		HttpSession session = request.getSession();
		
		String query = "select * from product join pImg on product.pid = pImg.pid where name = '"+name+"'";
		
		View view = readProductDB(query);
		String query2 = "select * from comment where pid='"+pid+"'";
		String id = (String) session.getAttribute("LOGIN_ID");
		CommentDao comment = readCommentDB(query2);
		request.setAttribute("comment", comment);
		request.setAttribute("vInfo", view);
		request.setAttribute("id", id);
		request.setAttribute("pid",pid);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./view.jsp");
		dispatcher.forward(request, response);
		
	}

	private CommentDao readCommentDB(String query2) {
		CommentDao comment = new CommentDao();
		Connection conn = null;
		Statement stmt = null;
		try {
			String dburl = "jdbc:apache:commons:dbcp:wdbpool";
			conn = DriverManager.getConnection(dburl);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query2);
			int i =0;
			while(rs.next()) {
				comment.setContent(i, rs.getString("content"));
				comment.setId(i, rs.getString("id"));
				comment.setTitle(i, rs.getString("title"));
				comment.setDate(i, rs.getString("date"));
				i++;
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(conn!=null)conn.close();
				if(stmt!=null)stmt.close();
			}catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return comment;
	}

	private View readProductDB(String query) {
		// TODO Auto-generated method stub
		View vinfo = new View();
		Connection conn = null;
		Statement stmt = null;
		try {
			String dburl = "jdbc:apache:commons:dbcp:wdbpool";
			conn = DriverManager.getConnection(dburl);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			String[] size = null;
			String[] color = null;
			
			if(rs.next()) {
				size = rs.getString("size").split(",");
				color = rs.getString("color").split(",");
				vinfo.setPid(rs.getString("pid"));
				pid = rs.getString("pid");
				vinfo.setName(rs.getString("name"));
				vinfo.setPrice(rs.getString("price"));
				vinfo.setStock(rs.getInt("stock"));
				for(int i = 0 ; i<size.length; i++) {
					vinfo.setSize(i,size[i]);
				}
				for(int i = 0 ; i<color.length; i++) {
					vinfo.setColor(i,color[i]);
				}
				vinfo.setType(rs.getString("type"));
				vinfo.setImg(rs.getString("img"));
				vinfo.setFavorite(rs.getInt("favorite"));
				vinfo.setComment(rs.getInt("comment"));
				
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		return vinfo;
	}

}
