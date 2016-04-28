package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
	private String url="jdbc:mysql://localhost:3308/db_studentmanager";
	private String dbUserName="root";
	private String dbUserPsd="aini1314";
	private String jdbcName="com.mysql.jdbc.Driver";
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection conn=DriverManager.getConnection(url, dbUserName, dbUserPsd);
		return conn;
		
	}
	static public void closeConn(Connection conn){
		
			try {
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				System.err.println("¡¨Ω” ß∞‹");
				e.printStackTrace();
			}
		
	}
	
}
	

