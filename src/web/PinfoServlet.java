package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PinfoServlet
 */
@WebServlet("/PinfoServlet")
public class PinfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PinfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String query="select * from product join pImg on product.pid = pImg.pid order by favorite desc limit 3";
		Pinfo bestpinfo = readDB(query);
		query="select * from product join pImg on product.pid = pImg.pid order by writedate desc limit 3";
		Pinfo newpinfo = readDB(query);
		
		request.setAttribute("BestPinfo", bestpinfo);
		request.setAttribute("NewPinfo", newpinfo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("./main.jsp");
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
				pinfo.setStock(i,rs.getInt("stock"));
				pinfo.setColor(i,rs.getString("color"));
				pinfo.setSize(i,rs.getString("size"));
				pinfo.setType(i,rs.getString("type"));
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

