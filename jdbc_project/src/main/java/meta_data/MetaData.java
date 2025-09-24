package meta_data;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MetaData {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/JDBC_Coaching";
		String user = "postgres";
		String pass = "tiger";

		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection(url, user, pass);
			
			DatabaseMetaData dmd = c.getMetaData();
			
			String username=dmd.getUserName();
			System.out.println(username);
			
			String driverName=dmd.getDriverName();
			System.out.println(driverName);
			
			boolean result = dmd.supportsOuterJoins();
			System.out.println(result);
			
			c.close();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
