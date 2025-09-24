package jdbc_project;

import java.beans.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class Fetch_Data {
	Class.forName("org.postgresql.Driver");
	
	//Ways of creating a connection object
	//1.getConnection(String url,String user,String password);
	//String url = "jdbc:postgresql://localhost:5432/JDBC_Coaching";
//	String username = "user";
//	String password = "user";
//
//	Connection con = DriverManager.getConnection(url, username, password);
	
	//2.getConnection(String url)
	//String url="jdbc:postgresl:///localhost:5432/JDBC_Coaching?user=postgres&&password=system";
	//Connection con = DrvierManager.getConnection(url);
	
	//3.getConnection(String url,Properties file)
	String url =  "jdbc:postgresql://localhost:5432/JDBC_Coaching";
	File file = new File("C:\\Users\\HP\\OneDrive\\Desktop\\Rohit_Sir_Spring_Notes\\jdbc_project\\src\\main\\java\\jdbc_project\\credentials.properties");
	FileInputStream fis = new FileInputStream(file);
	Properties properties = new Properties();
	properties.load(fis)
	
	// String query = "select * from student";
	String query = "select id,age from student";

	Statement st = con.createStatementL();

	// It will return the boolean values if query executed true else it will return
	// false
	//	ResultSet rs = st.execute(query);
	
	//
	ResultSet rs = st.executeQuery(query);

	while(rs.next())
	{
		System.out.println(rs.getInt(0));
	}

	con.close();

}
