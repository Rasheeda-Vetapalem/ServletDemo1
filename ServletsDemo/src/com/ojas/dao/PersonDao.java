package com.ojas.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.ojas.model.Person;



public class PersonDao {
    static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java200","root","root");
            System.out.println("Connected");
        }
        catch (Exception e) {
           
            System.out.println(e);
        }
        return con;
       
    }
   
    public boolean addPerson(Person person) {
        boolean b=false;
        try{
            Connection con=getConnection();
            PreparedStatement pst=con.prepareStatement("insert into person(ename,contactno,email,gender,address)values(?,?,?,?,?)");
            pst.setString(1, person.getEname());
            pst.setString(2, person.getContactno());
            pst.setString(3, person.getEmail());
            pst.setString(4,person.getGender());
            pst.setString(5,person.getAddress());
            int res=pst.executeUpdate();
           
            if(res>0){
                b=true;
              
            }
          
        }
        catch(Exception e){
            System.out.println(e);
        }
        return b;
           
    }
    public boolean validate(String uname,String pword) {
    	boolean b=false;
    	try{
    		Connection con=getConnection();
    		PreparedStatement pst=con.prepareStatement("select * from person where ename=? and contactno=?");
    		pst.setString(1, uname);
    		pst.setString(2, pword);
    		ResultSet res=pst.executeQuery();
    		if(res.next()){
    			b=true;
    		}
    	}
    		catch(Exception e){
    			System.out.println(e);
    		}
    		return b;
    	}
    
    
    public List<Person> listPerson() {
  	  List<Person> list=new ArrayList<Person>();
       try {
           Connection con = getConnection();
           Statement st=con.createStatement();
           ResultSet rs = st.executeQuery("Select * from person");
           while (rs.next()) {
        	   Person p=new Person(rs.getInt(1) , rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
               list.add(p);
              
              
             
           }
       } catch (Exception e) {
           System.out.println(e);
       }
	return list;
    }
        
public boolean delPerson(int num) {
	boolean b=false;
	try{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("delete from person where pid=?");
		pst.setInt(1, num);
		int res=pst.executeUpdate();
		if(res>0){
			b=true;
		}
	}
		catch(Exception e){
			System.out.println(e);
		}
		return b;
	}
public static boolean updatePerson(Person person) {
    boolean b = false;
    try {
        Connection con = getConnection();
        PreparedStatement pst = con
                .prepareStatement("update person set ename=?,contactno=?,email=?,gender=?,address=? where pid=?");
        pst.setString(1, person.getEname());
        pst.setString(2, person.getContactno());
        pst.setString(3, person.getEmail());
        pst.setString(4, person.getGender());
        pst.setString(5, person.getAddress());
        pst.setInt(6, person.getPid());
        int res = pst.executeUpdate();
        if (res > 0) {
            b = true;
        }
    } catch (Exception e) {
        System.out.println(e);
    }
    return b;
}

}