package com.neotech.lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
 import org.junit.Test;

public class hw1 {
	public static String dbUrl="jdbc:mysql://147.182.216.34:3306/classicmodels";
	public static String dbUserName="user1";
	public static String dbPassword="Neotech@123";

	/*
        Connect to classicmodels database
        Execute a query to get all information of customer with id 124
        Get the resultset metadata
        Print the number of columns
        Get all the column names and store them in an arraylist
        Print the Arraylist
        */
	 
	@Test 
	public void getResult() throws SQLException {
		Connection conn=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from customers where customerNumber<'124';");
		ResultSetMetaData rsMetaData=rs.getMetaData();
		int columns=rsMetaData.getColumnCount();
		System.out.println(columns);
		List<String> arr=new ArrayList<>();
		for(int i=1; i<=columns; i++) {
			arr.add(rsMetaData.getColumnName(i));
		}
		System.out.println(arr);
	
  		while(rs.next()) {
 			String customerName=rs.getString("customerName");
 			String phone=rs.getString("phone").toString();
 			System.out.println(customerName+ ":"+phone);
  		}
	  rs.close();
	  st.close();
	  conn.close();
	}

 
}















/*
	public static String dbUrl="jdbc:mysql://147.182.216.34:3306/classicmodels";
	public static String dbUserName="user1";
	public static String dbPassword="Neotech@123";
	@Test
	public void testHW() throws SQLException {
		Connection conn=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		Statement st=conn.createStatement();
		ResultSet rsResultSet=st.executeQuery("select * from customers where customerNumber='124';");
		ResultSetMetaData rsMetaData=rsResultSet.getMetaData();
		int columnSize=rsMetaData.getColumnCount();
		System.out.println("Number of columns:"+columnSize);
		ArrayList<String> list=new ArrayList<String>();
		for(int i=1;i<=columnSize;i++) {
			list.add(rsMetaData.getColumnName(i));
		}
 		for(String str:list) {
			System.out.println(str);
		}
		
	}*/