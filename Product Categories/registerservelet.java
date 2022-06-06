package com.servelet.register;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

@WebServlet("/register")
public class registerservelet extends HttpServlet {
	 
	private static final String INSERT_QUERY="INSERT INTO REGISTERPAGE1(FNAME,LNAME,EMAIL,PHONENUMBER,PASSWORD,CONPASSWORD) VALUES(?,?,?,?,?,?)";
	
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("firstname");
		String lastname=req.getParameter("lastname");
		String email=req.getParameter("email");
		String phonenumber=req.getParameter("phonenumber");
		String password=req.getParameter("password");
		String conpassword=req.getParameter("conpassword");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(java.sql.Connection con = ( DriverManager.getConnection("jdbc:mysql:///registerpage","root","Gurunath123@"));
				PreparedStatement ps = con.prepareStatement(INSERT_QUERY);){
			ps.setString(1, name);
			ps.setString(2, lastname);
			ps.setString(3, email);
			ps.setString(4, phonenumber);
			ps.setString(5, password);
			ps.setString(6, conpassword);
			
			int count=ps.executeUpdate();
			if (count==0) {
				pw.println("record not stored into database");
			}else {
				pw.println("record  stored into database");
			}
		}
		catch(SQLException se) {
			pw.println(se.getMessage());
			se.printStackTrace();
		}catch(Exception e) {
			pw.println(e.getMessage());
			e.printStackTrace();
		}
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
	doGet(req,res);
	
	}
	

}
