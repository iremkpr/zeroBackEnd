package com.neotech.lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.ConfigReader;
import utils.Constants;

public class exaamplesDBTest {

	public static void main(String[] args) throws SQLException {
 
		ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		Connection conn=DriverManager.getConnection(
				ConfigReader.getProperty("dbUrl"),
				ConfigReader.getProperty("dbUserName"),
				ConfigReader.getProperty("dbPassword"));
		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery("select * from customers where customerNumber<124;");
		ResultSetMetaData rsMetaData=rs.getMetaData();
		int columnCount=rsMetaData.getColumnCount();
		List<Map<String, String>> listOfMap=new ArrayList<>();
		Map<String, String> map;
		while(rs.next()) {
			map=new HashMap<>();
			for(int i=1; i<=columnCount;i++) {
				map.put(rsMetaData.getColumnName(i), rs.getString(i));
			}
			listOfMap.add(map);
			
		}
		for(Map<String,String> m:listOfMap) {
			System.out.println(m);
		}
	}

}
