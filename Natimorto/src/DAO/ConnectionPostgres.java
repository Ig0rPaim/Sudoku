package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostgres {
	private static String url = "jdbc:postgresql://localhost:5432/";
	private String user = "postgres";
	private String password = "adimin123";
	
	public Connection getConn() throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}
	
	public void closeConnectio(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException er) {
				er.printStackTrace();
			}
		}
	}
}
