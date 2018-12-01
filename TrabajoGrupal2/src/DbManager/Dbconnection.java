package DbManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {

	// String url = "jdbc:mysql://10.1.104.32:3306/facturacion?useSSL=false";
	private String url = "jdbc:mysql://190.140.93.250:3306/facturacion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	// private String url = "jdbc:mysql://127.0.0.1:3306/facturacion?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	
	private String user = "Guest";
	private String password = "123456789";
	private Connection conn = null;

	public Dbconnection() {
	
	}
	

	public void CloseConnection() {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("no problem");
			return conn;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(" problem");
			e.printStackTrace();
			
		}
		return null;
		
	}

	public void setCon(Connection conn) {
		this.conn = conn;
	}
}
