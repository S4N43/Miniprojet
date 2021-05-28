package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.Bibmanager;

/**
 * Servlet implementation class Adduser
 */
@WebServlet("/Adduser")
public class Adduser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Bibmanager um;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adduser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		um=new Bibmanager();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String lg=request.getParameter("log");
		String ps=request.getParameter("pass");
		String role=request.getParameter("role");
		
		int nb=um.addUser(lg, ps, role);
		
		response.sendRedirect("index.jsp");
		
		
	}

}
