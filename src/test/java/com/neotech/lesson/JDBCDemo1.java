package com.neotech.lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo1 {

	//DB URL/Address and port number
	public static String dbUserName = "user1";
	public static String dbPassword = "Neotech@123";
	
	//db url format
	//jdbc:jdbctype://ipaddress:portnumber/db_name
	public static String dbUrl = "jdbc:mysql://147.182.216.34:3306/LibraryMgmt";

  	public static void main(String[] args) throws SQLException {
		 
		//create a connection 
		Connection conn=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		System.out.println("DB CONNECTION IS SUCCESFULL");
		//create a statement 
		Statement st=conn.createStatement();
		ResultSet rs= st.executeQuery("SELECT * from book");
		
		//GET ALL VALUES FROM RESULT SET
		rs.next();
		//getting value with using column name
		String bookName1=rs.getString("BookName");
		System.out.println(bookName1);
		
		
		//getting value with using int column index
		rs.next();
		String bookName2=rs.getString(2);
		System.out.println(bookName2);
		
		rs.next();
		String bookName3=rs.getObject("BookName").toString();
		System.out.println(bookName3);

		while(rs.next()) {
			String bookName=rs.getObject("BookName").toString();
			System.out.println(bookName);
		}
		rs.close();
		st.close();
		conn.close();
  	}

}
