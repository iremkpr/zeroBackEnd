package com.neotech.lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class Task1 {
	public static String dbURL="jdbc:mysql://147.182.216.34:3306/LibraryMgmt";
	public static String dbUserName="user1";
	public static String dbPassword="Neotech@123";
	
	public static void main(String[] args) throws SQLException {
 		
		Connection conn=DriverManager.getConnection(dbURL,dbUserName,dbPassword);
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("SELECT BookCategoryName FROM bookcategory;");
		ArrayList<String> arr=new ArrayList<String>();
 		while(rs.next()) {
			arr.add(rs.getObject("BookCategoryName").toString());
 		}
 		Iterator<String> iterator=arr.iterator();
 		while(iterator.hasNext()) {
 			
			System.out.println(iterator.next());

 		}
		 //OR
 		System.out.println("-------");
 		for(String str:arr) {
 			System.out.println(str);
 		}
		rs.close();
		st.close();
		conn.close();
	}

}
