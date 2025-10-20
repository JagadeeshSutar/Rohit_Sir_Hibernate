//package jdbc_project;
//
//import java.beans.Statement;
//import java.io.File;
//import java.io.FileInputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.util.Properties;
//
//public class Fetch_Data {
//	public static void main(String[] args) {
//		Class.forName("org.postgresql.Driver");
//		
//		//Ways of creating a connection object
//		//1.getConnection(String url,String user,String password);
//		String url = "jdbc:postgresql://localhost:5432/JDBC_Coaching";
//		String username = "user";
//		String password = "user";
//	//
//		Connection con = DriverManager.getConnection(url, username, password);
//		
//		//2.getConnection(String url)
//		//String url="jdbc:postgresl:///localhost:5432/JDBC_Coaching?user=postgres&&password=system";
//		//Connection con = DrvierManager.getConnection(url);
//		
//		//3.getConnection(String url,Properties file)
////		String url =  "jdbc:postgresql://localhost:5432/JDBC_Coaching";
////		File file = new File("C:\\Users\\HP\\OneDrive\\Desktop\\Rohit_Sir_Spring_Notes\\jdbc_project\\src\\main\\java\\jdbc_project\\credentials.properties");
////		FileInputStream fis = new FileInputStream(file);
////		Properties properties = new Properties();
////		properties.load(fis)
//		
//		// String query = "select * from student";
//		String query = "select id,age from student";
//
//		Statement st = con.createStatementL();
//
//		// It will return the boolean values if query executed true else it will return
//		// false
//		//	ResultSet rs = st.execute(query);
//		
//		//
//		ResultSet rs = st.executeQuery(query);
//
//		while(rs.next())
//		{
//			System.out.println(rs.getInt(0));
//		}
//
//		con.close();
//
//	}
//}




package jdbc_project;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement; // Correct import for Statement
import java.util.Properties;

public class Fetch_Data {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // 1. Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // 2. Define connection details
            String url = "jdbc:postgresql://localhost:5432/JDBC_Coaching";
            String username = "user";
            String password = "user";

            // 3. Create a connection to the database
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful!");

            // 4. Create a Statement object to execute SQL queries
            st = con.createStatement();

            // 5. Define the SQL query to fetch data
            String query = "SELECT id, age FROM student";

            // 6. Execute the query and store the result in ResultSet
            rs = st.executeQuery(query);

            // 7. Loop through the ResultSet to get each row's data
            while (rs.next()) {
                // Note: ResultSet columns start at 1, not 0
                int id = rs.getInt("id");     // Can also use rs.getInt(1);
                int age = rs.getInt("age");   // Can also use rs.getInt(2);
                System.out.println("ID: " + id + ", Age: " + age);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 8. Close resources in the reverse order of their opening
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

