package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Pview
 */
@WebServlet("/Pview")
public class Pview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type = request.getParameter("type");
		String query="select product.pid, name, price, favorite, comment, img from product join pImg on product.pid = pImg.pid where type = '"+type+"'";
		Pinfo info = readDB(query);
		request.setAttribute("info", info);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./p-view.jsp");
		dispatcher.forward(request, response);

	}
	
	private Pinfo readDB(String query) {
		// TODO Auto-generated method stub
		Pinfo pinfo = new Pinfo();
		Connection conn = null;
		Statement stmt = null;
		try {
			String dburl = "jdbc:apache:commons:dbcp:wdbpool";
			conn = DriverManager.getConnection(dburl);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			rs.last();
			int c = rs.getRow();
			rs.first();
			
			for (int i = 0 ; i<c; i++) {
				pinfo.setPid(i,rs.getString("pid"));
				pinfo.setName(i,rs.getString("name"));
				pinfo.setPrice(i,rs.getString("price"));
				pinfo.setImg(i,rs.getString("img"));
				pinfo.setFavorite(i,rs.getInt("favorite"));
				pinfo.setComment(i,rs.getInt("comment"));
				if(!rs.next()) {
					break;
				}
			}
				

			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		return pinfo;
	}

}
