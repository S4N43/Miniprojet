package exemple;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.Bibmanager;
import com.util.User;
import com.util.UserManager;
import com.util.cate;

/**
 * Servlet implementation class test
 */
@WebServlet(description = "test de servlet", urlPatterns = { "/test" })
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	Bibmanager um;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		um = new Bibmanager();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		
		
		String lg=request.getParameter("log");
		String ps=request.getParameter("pass");
		User u=um.authentification(lg, ps);
		if(u!=null)
		{
			HttpSession ses =request.getSession(true);
			ses.setAttribute("user", u);
			response.sendRedirect("index.jsp");
		}else
		{
			
			response.sendRedirect("auth.jsp?res=err");
		}
		
	
	}
	

}
