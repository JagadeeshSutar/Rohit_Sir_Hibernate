package meta_data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData; 

public class ResultSetMetaDataDemo {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/JDBC_Coaching";
        String user = "postgres";
        String pass = "tiger";

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url, user, pass); 
        
        String sql = "select * from teacher";
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        ResultSetMetaData dmd = rs.getMetaData(); 
        
        int colCount = dmd.getColumnCount();
        System.out.println("Column count is: " + colCount);
        
        String colName = dmd.getColumnName(3);
        System.out.println("Third column name is: " + colName);
        
        String type = dmd.getColumnTypeName(4);
        System.out.println("Type is: " + type);
        
        con.close();
    }
}
