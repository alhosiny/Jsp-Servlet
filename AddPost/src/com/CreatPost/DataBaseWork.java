package com.CreatPost;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DataBaseWork {
	java.sql.Connection c;
	java.sql.Statement s; 
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
	ResultSet select() throws SQLException{
		String query = "SELECT * FROM comment  ORDER BY `comment`.`id_comment` DESC"; 		
		return s.executeQuery(query);
	}
	void instert(String comment) throws SQLException {
		String query = "INSERT INTO `test1`.`comment` ( `id_comment` , `content` ) VALUES ( NULL , '"+comment+"' );";
		s.executeUpdate(query);
	}
	void remove(String id) throws SQLException {
		String query = "DELETE FROM `test1`.`comment` WHERE `comment`.`id_comment` = " + id+";" ;
		s.executeUpdate(query);
	}
	void update(String id, String content) throws SQLException {
		String query = "UPDATE  `test1`.`comment` SET  `content` =  ' "+content+"' WHERE  `comment`.`id_comment` ="+id+";";
		s.executeUpdate(query);
		
	}

}
