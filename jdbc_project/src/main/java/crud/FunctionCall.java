package crud;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FunctionCall {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/JDBC_Coaching";
		String user = "postgres";
		String password = "root";

		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection(url, user, password);

			// Call the function using SELECT
			CallableStatement st = c.prepareCall("SELECT count_by_gender(?)");

			st.setString(1, "Female");

			ResultSet rs = st.executeQuery();
			rs.next();
			int result = rs.getInt(1);
			System.out.println("The Result is " + result);

			rs.close();
			st.close();
			c.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}


//CREATE FUNCTION count_by_gender(gender_input VARCHAR)
//RETURNS INTEGER AS $$
//DECLARE
//    total_count INTEGER;
//BEGIN
//    SELECT COUNT(*) INTO total_count
//    FROM student   -- 👈 change this to your table name
//    WHERE gender = gender_input;
//
//    RETURN total_count;
//END;
//$$ LANGUAGE plpgsql;
