package com.neotech.lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
 import utils.ConfigReader;
import utils.Constants;

public class StoringData {

	public static void main(String[] args) throws SQLException {
		getAndStoreData("SELECT employeeNumber, lastName, firstName,email,jobTitle  FROM employees LIMIT 5;");
	}
 
	public static void getAndStoreData(String query) throws SQLException {
		ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		String dbUrl=ConfigReader.getProperty("dbUrl");
		String dbUserName=ConfigReader.getProperty("dbUserName");
		String dbPassword=ConfigReader.getProperty("dbPassword");
		
		Connection conn=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(query);
		ResultSetMetaData rsMetaData=rs.getMetaData();
		ArrayList<String> results=new ArrayList<>();
		for(int i=1; i<=rsMetaData.getColumnCount();i++) {
			results.add(rsMetaData.getColumnName(i));
		}
 
		List<Map<String, String>> listOfMap=new ArrayList<>();
		Map<String, String> map;
		int columnCount=rsMetaData.getColumnCount();
		while(rs.next()) {
			map=new LinkedHashMap<>();
			for(int i=1; i<=columnCount;i++) {
 				map.put(rsMetaData.getColumnName(i),rs.getString(i));
				
 			}
			listOfMap.add(map);
		}

		for(Map<String, String> m:listOfMap) {
			System.out.println(m);
		}
		
		rs.close();
		st.close();
		conn.close();
 	}
 
}
