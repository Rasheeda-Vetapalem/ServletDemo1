package com.ojas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextExample1
 */
public class ContextExample1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextExample1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    ServletContext context=null;
	public void init(ServletConfig config) throws ServletException {
		context=config.getServletContext();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		context.setAttribute("goldrate","45000.00");
		pw.println("<h3 style=color:green;>gold Rate"+context.getAttribute("goldrate"));
		pw.println("servlet Version="+context.getMajorVersion()+"."+context.getEffectiveMajorVersion()+"</h3>");
		
		
		
		
	
	
	}

}
