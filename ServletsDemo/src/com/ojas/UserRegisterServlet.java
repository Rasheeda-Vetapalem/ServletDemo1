package com.ojas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.dao.PersonDao;
import com.ojas.model.Person;

public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	PersonDao personDao;
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    public void init(ServletConfig config) throws ServletException {
        personDao = new PersonDao();
    }

 

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String ename = request.getParameter("ename");
        String contactno = request.getParameter("contactno");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        Person p = new Person();
        p.setEname(ename);
        p.setContactno(contactno);
        p.setEmail(email);
        p.setGender(gender);
        p.setAddress(address);
        
        if(personDao.addPerson(p)){
            pw.println(
                    "<h1 stlye=background-color:maroon>Registration done</h1>");
        }else
        {
            pw.println("<h1 stlye=background-color:maroon>Try again</h1>");
        }
    }
    }

 