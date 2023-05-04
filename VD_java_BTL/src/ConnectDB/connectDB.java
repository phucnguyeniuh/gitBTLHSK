package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {
	public static Connection con = null;
	public static connectDB instance = new connectDB();

	public static connectDB getinstance() {
		return instance;
	}

	public void connect() {
		String url="jdbc:sqlserver://localhost:1433;databasename=QuanLyBanXeMay";
		String user="sa";
		String password="sapassword";
		try {
			con= DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (con != null) {
	        System.out.println("Connected");
	    }
	}
	
	public static void disconnect() {
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static Connection getConnection() {
		return con;
	}
}
