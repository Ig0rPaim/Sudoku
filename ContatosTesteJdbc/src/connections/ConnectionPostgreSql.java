package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPostgreSql {
	private static String uri = "jdbc:postgresql://localhost:5432/";
	private static String user = "postgres";
	private static String pass = "admin123";
	
	public static Connection getConn() throws SQLException {
		Connection conn = DriverManager.getConnection(uri, user, pass);
		return conn;
	}
	
	public void closeConn(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException er){
				er.printStackTrace();
			}
		}
	}
}
	