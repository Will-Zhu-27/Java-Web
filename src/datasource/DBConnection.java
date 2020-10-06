package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {
	 private static final String url = "jdbc:postgresql://localhost:5432/Sample";
	 private static final String user = "postgres";
	 private static final String password = "effort";
	 
	public static PreparedStatement prepare(String stm) throws SQLException {
		PreparedStatement preparedStatement = null;
		try {
			Connection dbConnection = connect();
			preparedStatement = dbConnection.prepareStatement(stm);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return preparedStatement;
	}
	
	 /**
	 * Connect to the PostgreSQL database
	 * @return a Connection object
	 */
	 public static Connection connect() {
		 Connection conn = null;
		 try {
			 conn = DriverManager.getConnection(url, user, password);
			 if (conn != null) {
				 System.out.println("Connected to the PostgreSQL server successfully.");
			 } else {
				 System.out.println("Failed to make connection!");
			 }
		 } catch (SQLException e) {
			 System.out.println(e.getMessage());
		 }
		 return conn;
	 }
	 
	 public static void main(String[] args) {
		 DBConnection app = new DBConnection();
		 app.connect();
	 }
}