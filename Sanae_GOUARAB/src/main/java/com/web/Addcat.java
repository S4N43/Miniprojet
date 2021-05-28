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
 * Servlet implementation class Addcat
 */
@WebServlet("/Addcat")
public class Addcat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Bibmanager um;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addcat() {
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
		String nomcat=request.getParameter("nom_cat");

		
		int nb=um.addcat(nomcat);
		
		response.sendRedirect("CatAff.jsp");
		
		
	}

}
