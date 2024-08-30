package com.neotech.lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import org.junit.Test;

public class MetaData {
	public static String dbURL = "jdbc:mysql://147.182.216.34:3306/classicmodels";
	public static String dbUserName = "user1";
	public static String dbPassword = "Neotech@123";

	public static void main(String[] args) {

	}

	@Test
	public void dbMetaData() throws SQLException {
		Connection conn = DriverManager.getConnection(dbURL, dbUserName, dbPassword);
		DatabaseMetaData dbMetaData = conn.getMetaData();
		String driverName=dbMetaData.getDriverName();
		System.out.println(driverName);
		String dbVersion =dbMetaData.getDatabaseProductVersion();
		System.out.println(dbVersion);
		conn.close();
		
	}
	
	@Test
	public  void rsMetaData() throws SQLException {
		Connection conn=DriverManager.getConnection(dbURL,dbUserName,dbPassword);
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("SELECT * FROM customers;");
		ResultSetMetaData rsMetaData=rs.getMetaData();
		String CatalogName=rsMetaData.getCatalogName(1);
		int columnNum=rsMetaData.getColumnCount();
		String tableName=rsMetaData.getTableName(1);
		String columnName=rsMetaData.getColumnName(2);
		
		
 		System.out.println(CatalogName);
		System.out.println(columnNum);
		System.out.println(tableName);
		System.out.println(columnName);
		System.out.println("ALL COLUMN NAMES");
		for(int i=1; i<rsMetaData.getColumnCount();i++) {
			System.out.println("COLUMN NAME:"+rsMetaData.getColumnName(i));
			System.out.println("COLUMN TYPE NAME:"+rsMetaData.getColumnTypeName(i));
		}
		
		
	}

}
