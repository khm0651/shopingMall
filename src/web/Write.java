package web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class Write
 */
@WebServlet("/Write")
public class Write extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Write() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		ServletContext context = getServletContext();
		String uploadPath = context.getRealPath("img");
		int maxsize = 30*1024*1024;
		String encoding = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request,uploadPath,maxsize,encoding);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmss");
		Date time = new Date();
		PrintWriter out = response.getWriter();
		
		Enumeration files = multi.getFileNames();
		String fname = (String) files.nextElement();
		String fileName = multi.getFilesystemName(fname);
		String type = fileName.substring(fileName.indexOf("."),fileName.length());
		String newName = multi.getParameter("type") + format1.format(time) + type;
		String pid = newName.substring(0,newName.indexOf("."));
		
		if(fileName != null) {
			File upfile1 = new File(uploadPath+"/"+fileName);
			File upfile2 = new File(uploadPath+"/"+newName);
			if(upfile1.renameTo(upfile2)) {
				System.out.println("업로드및 이름변경 성공");
			}else {
				System.out.println("업로드및 이름변경 실패");
			}
		}
		String query1 = "insert into product values('"+pid+"','"+multi.getParameter("title")+"','"+multi.getParameter("price")+"','"+multi.getParameter("stock")+"','"+multi.getParameter("color")+"','"+multi.getParameter("size")+"','"+multi.getParameter("type")+"',0,0,'"+format1.format(time)+"')";
		String query2 = "insert into pimg values('"+pid+"','"+newName+"')";
		Connection conn = null;
		Statement stmt = null;
		try {
			String dburl = "jdbc:apache:commons:dbcp:wdbpool";
			conn = DriverManager.getConnection(dburl);
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(query1);
			if(result == 0) {
				System.out.println("업로드 실패");
			}
			stmt.close();
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query2);
			if(result == 0) {
				System.out.println("업로드 실패");
			}
				
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(stmt!= null) stmt.close();
				if(conn!= null) conn.close();
				out.println("<script>alert('게시글 작성 완료'); location.href='./index.jsp';</script>");
				
			}catch(SQLException e) {}
		}
		
	}

}
