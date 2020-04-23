package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		if(session.getAttribute("LOGIN_ID")!=null) {
			session.removeAttribute("LOGIN_ID");
			if(session.getAttribute("IS_ADMIN")!=null) {
				session.removeAttribute("IS_ADMIN");
			}
			response.sendRedirect("./");
		}else {
			out.println("<script>alert('�߸��� �����Դϴ�.');history.back();</script>");
		}
	}

}
