package com.ojas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfigDemo
 */
public class ConfigDemo extends HttpServlet {

	 

    String cname = null;

 

    public ConfigDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

 

    public void init(ServletConfig config) throws ServletException {
        cname= config.getInitParameter("cname");
    }

 

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<html><body bgcolor=wheat text = blue><form action=ConfigDemo method=POST>");
        pw.println("<h1 style= color:maroon>Online courses</h1><hr/>");
        pw.println("<p> Select course name : </p>");
        pw.println("<p><select name=cname>");
        String cn[] = cname.split(",");
        for (String x : cn) {
            pw.println("<option>" + x + "</option>");
        }
        pw.println("</select></p><p><input type=submit value=Register></p></form></body></html>");

 

    }

 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        String cs[] = {"JAVA",".NET","ORACLE"};
        double prices[] = {25000.00, 20000.00,15000.00,18000.00};
        String cnames = request.getParameter("cname");
        int ind=0;
        for(int i = 0; i<cs.length;i++){
            if(cname.equalsIgnoreCase(cs[i])){
                ind = i;
            }
        }
        pw.println("<h1 style= color:green>Your selected couesrname is :"+cnames+"<br>");
        
        pw.println("You have to pay"+prices[ind]+"Rs only</h1>");
        pw.println("<h4 style:color:green>Thank you</h4>");
        
    }

 

}
 