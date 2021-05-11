package com.ojas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.dao.PersonDao;
import com.ojas.model.Person;

/**
 * Servlet implementation class Updateservlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UpdateServlet() {
        super();
        
    }
    PersonDao persondao;
    @Override
    public void init() throws ServletException {
        persondao = new PersonDao();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        int num = Integer.parseInt(request.getParameter("no"));
        String ename = request.getParameter("ename");
        String contactno = request.getParameter("contactno");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");

 

        pw.println("<html><head><style type=text/css>");
        pw.println("table{width:50%;border-collapse:collapse;");
        pw.println("background-color:wheat;border-spacing:10px;}");
        pw.println("table,tr,td{border:1px solid blue;}");
        pw.println("th,td{padding:20x;}");
        pw.println("</style></head><body>");
        pw.println("<form action =UpdateServlet method=POST>");
        pw.println("<h1 style = background-color:maroon;color:white;padding:20px;");
        pw.println("text-align:center;>Welcome to Registration page</h1>");
        pw.println("<table align = center;><tr>");
        pw.println("<input type=hidden name= pid value="+num+">");
        pw.println("<td>Enter Name:</td><td><input type=text name=ename value="+ename+"></td>");
        pw.println("</tr><tr><td>Enter Contact no:</td>");
        pw.println("<td><input type=text name=contactno value="+contactno+"></td>");
        pw.println("</tr><tr><td>Enter Email Id:</td><td><input type=text name=email value="+email+"></td>");
        pw.println("</tr><tr><td>Gender</td><td>");
        if(gender.equals("Male")) {
            pw.println("<input type=radio name=gender value=male>Male");
            pw.println("<input type=radio name=gender value=female>Female");
        }
        else {     
        pw.println("<input type=radio name=gender value=female>Female</td>");
        pw.println("<input type=radio name=gender value=male>Male</td>");
        }
        pw.println("</tr><tr><td>Enter Address:</td><td><textarea name=address rows=5 cols=20>");
        pw.println("</textarea></td></tr><tr><td colspan=2 align=center><input type=submit value=click></td></tr>");
        pw.println("</table></form></body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		 response.setContentType("text/html");
	        PrintWriter pw = response.getWriter();
	        int num = Integer.parseInt(request.getParameter("pid"));
	        String ename = request.getParameter("ename");
	        String contactno = request.getParameter("contactno");
	        String email = request.getParameter("email");
	        String gender = request.getParameter("gender");
	        String address = request.getParameter("address");

	 

	        Person p = new Person();
	        p.setPid(num);
	        p.setEname(ename);
	        p.setContactno(contactno);
	        p.setEmail(email);
	        p.setGender(gender);
	        p.setAddress(address);
	        
	        if(persondao.updatePerson(p)) {
	            pw.println("update sucessfully");
	        }
	        else {
	            pw.println("Try Again");
	        }
	       
	}

}
