package com.ojas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.dao.PersonDao;
import com.ojas.model.Person;

/**
 * Servlet implementation class ListPerson
 */
public class ListPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    PersonDao personDao;
    public ListPerson() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		personDao = new PersonDao();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		List<Person> list = personDao.listPerson();

		pw.println("<html><head><style type=text/css>");
		pw.println("table{width:50%;border-collapse:collapse;");
		pw.println("background-color:wheat;border-spacing:10px;}");
		pw.println("table,tr,td{border:1px solid blue;}");
		pw.println("th,td{padding:20x;}");
		pw.println("</style></head><body>");
		pw.println("<form action =#>");
		pw.println("<h1 style = background-color:maroon;color:white;padding:20px;");
		pw.println("text-align:center;>list Persons</h1>");
		pw.println("<table align = center;>");
		pw.println("<tr>");

		for (Person p : list) {
			int num = p.getPid();
			String ename=p.getEname();
			String contactno=p.getContactno();
			String email=p.getEmail();
			String gender=p.getGender();
			String address=p.getAddress();
			pw.println("<td>" + num + "</td>");
			pw.println("<td> " + p.getPid() + "</td>");
			pw.println("<td> " + ename+ "</td>");
			pw.println("<td> " + contactno + "</td>");
			pw.println("<td> " + email + "</td>");
			pw.println("<td> " + gender + "</td>");
			pw.println("<td> " + address + "</td>");
			pw.println("<td><a href=DelServlet?no="+num+">delete</a></td>");
			pw.println("<td><a href=UpdateServlet?no="+num+"&ename="+ename+"&contactno="+contactno+"&email="+email+"&gender="+gender+"&address="+address+">update</a></td>");
		
			pw.println("</tr>");
		}
		pw.println("</table></form></body></html>");

	}
}
