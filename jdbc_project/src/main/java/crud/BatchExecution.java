package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchExecution {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:postgresql://localhost:5432/JDBC_Coaching";
		String username = "postgres";
		String password = "root";
		
		Class.forName("org.postgresql.Driver");
		Connection c = DriverManager.getConnection(url,username,password);
		
		String q1 = "insert into student values(6,'Tarun',69)";
		String q2 = "insert into student values(7,'Sanjay',99)";
		String q3 = "insert into student values(8,'Maindeep',6699)";
		
		Statement st = c.createStatement();
		st.addBatch(q1);
		st.addBatch(q2);
		st.addBatch(q3);
		
		st.executeBatch();
		c.close();
		
		
	}
}
