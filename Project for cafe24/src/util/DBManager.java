package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DBManager {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String jdbcDriver = "jdbc:mariadb://localhost:3306/dlgnlwo3";
			String dbUser = "dlgnlwo3";
			String dbPass = "whffkaos1";
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}