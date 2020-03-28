package org.MODELS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {
	private static String url = "jdbc:sqlserver://localhost:1433;user=sa;password=sa";

	private void DBConnection() {

	}

	public static final Connection Connect() {
		try {
			Connection conn;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static final ResultSet Query(String strQuery) {
		Statement stmt;
		try {
			stmt = Connect().createStatement();
			ResultSet rs = stmt.executeQuery(strQuery);
			return rs;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
