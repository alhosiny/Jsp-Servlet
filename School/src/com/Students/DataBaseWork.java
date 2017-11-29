package com.Students;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseWork {
	private Connection c;
	private Statement s;
	public DataBaseWork() throws InstantiationException, IllegalAccessException, SQLException {
	     try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     String hostName = "localhost:3306";
		 String dbName = "test1";
		 String mySqlUrl =  "jdbc:mysql://"+hostName+"/"+dbName;
		 String user = "root";
		 String password = ""; 
	     c = DriverManager.getConnection(mySqlUrl, user, password);
	     s = c.createStatement();    
	}
	ResultSet select(String query) throws SQLException {
		return s.executeQuery(query);
	}
	void excuteDml(String query) throws SQLException {
		s.executeUpdate(query);
	}

}
