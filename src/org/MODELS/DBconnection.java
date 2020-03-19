package org.MODELS;

import java.sql.*;

public class DBconnection {
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=EMPLOYEE_PAYMENT_MANAGEMENT;" + "integratedSecurity=true";
	private static String USER_NAME = "sa";
	private static String PW = "sa";
	
	public static void main(String args[])
	{
		try {
			Connection conn = getConnection(DB_URL,USER_NAME,PW);
			Statement stmt = conn.createStatement();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Connection getConnection(String dB_URL2, String uSER_NAME2, String pW2) {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(dB_URL2,uSER_NAME2,pW2);
			System.out.println("Connect successfully");
		} catch (Exception e) {
			System.out.println("Connect Failure");
			e.printStackTrace();
		}
		return conn;
	}
}
