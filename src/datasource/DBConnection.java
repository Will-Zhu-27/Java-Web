package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import domain.Subject;

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
	
//	 /**
//	 * Connect to the PostgreSQL database
//	 * @return a Connection object
//	 */
//	 public static Connection connect() {
//		 Connection conn = null;
//		 try {
//			 Class.forName("org.postgresql.Driver");
//			 conn = DriverManager.getConnection(url, user, password);
//			 if (conn != null) {
//				 System.out.println("Connected to the local PostgreSQL server successfully.");
//			 } else {
//				 System.out.println("Try to connect to Cloud PostgreSQL server");
//				 DriverManager.registerDriver(new org.postgresql.Driver());
//				 String dbUrl = System.getenv("JDBC_DATABASE_URL");
//				 conn = DriverManager.getConnection(dbUrl);
//				 System.out.println("Connected to the Cloud PostgreSQL server successfully.");
//			 }
//		 } catch (SQLException e) {
//			 System.out.println(e.getMessage());
//		 } catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			 System.out.println("forName Problem");
//			e.printStackTrace();
//		}
//		 return conn;
//	 }
	public static Connection connect() {
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
			String dbUrl = System.getenv("JDBC_DATABASE_URL");
			Connection dbConnection = DriverManager.getConnection(dbUrl);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Connection problem");
		return null;
	}
	
	 public static void main(String[] args) {
		 DBConnection app = new DBConnection();
		 app.connect();
		 // test connection
		 List<Subject> sub= Subject.getAllSubjects();
   		 for (Subject subject : Subject.getAllSubjects()) {
   			 System.out.println(subject.getSubjectCode());
  		  }
	 }
}