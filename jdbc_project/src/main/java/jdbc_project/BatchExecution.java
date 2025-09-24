package jdbc_project;

import java.sql.Connection;

public class BatchExecution {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/JDBC_Coaching";
		String username = "postgres";
		String password = "system";
		
		Class.forName("org.postgresql.Driver");
		
		Connection con = DriverManager.getConnection(url,username,password);
		
		String q1 = "insert into student values(10,'Shreyasi',23)";
		String q2 = "insert into student values(11,'Shu"
	}
}
