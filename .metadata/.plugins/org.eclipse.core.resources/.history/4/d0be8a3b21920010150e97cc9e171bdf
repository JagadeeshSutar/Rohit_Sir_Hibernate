package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String url = "jdbc:postgresql://localhost:5431/JDBC_Coaching";
		String url = "jdbc:postgresql://localhost:5432/JDBC_Coaching";
		String username = "postgres";
		String password = "root";
		
		Connection connection;
		try {
			//connection
			connection = DriverManager.getConnection(url,username,password);
			//create statement
			Statement statement = connection.createStatement();
			String query = "update student set age=21 where id=5";
//			String query = "insert into student values(1,'Ram',26)";	
			//execute query
			statement.execute(query);
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
