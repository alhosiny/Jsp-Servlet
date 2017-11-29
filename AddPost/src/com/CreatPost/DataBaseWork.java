package com.CreatPost;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DataBaseWork {
	private java.sql.Connection c;
	private java.sql.Statement s; 
	DataBaseWork() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hostName = "localhost:3306";
		String dbName = "test1";
		String mySqlUrl =  "jdbc:mysql://"+hostName+"/"+dbName;
		String user = "root";
		String password = "";
		
		 c = (java.sql.Connection)DriverManager.getConnection(mySqlUrl, user, password);
		 s = (java.sql.Statement)c.createStatement();
	}
	ResultSet select(String query) throws SQLException{
		return s.executeQuery(query);
	}
	void excuteDml(String query) throws SQLException {
		s.executeUpdate(query);
	}
	
}
