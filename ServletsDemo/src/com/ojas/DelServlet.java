package com.ojas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.dao.PersonDao;

/**
 * Servlet implementation class DelServlet
 */
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int value = Integer.parseInt(request.getParameter("no"));
		PersonDao persondao = new PersonDao();
		if(persondao.delPerson(value)) {
			response.sendRedirect("./ListPerson");
			
		}else {
			pw.println("<h2 style=color:red> deleted sucessfully </h2>");
		}
	}


	
}
