package crud;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StoredProcedure {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/JDBC_Coaching";
		String user = "postgres";
		String password = "root";
		try {
			Class.forName("org.postgresql.Driver");
			Connection c = DriverManager.getConnection(url,user,password);
			CallableStatement cs = c.prepareCall("call create_teacher_records(?,?,?,?,?,?,?)");
			cs.setInt(1, 190);
			cs.setString(2, "Chandana");
			cs.setString(3, "Female");
			cs.setInt(4, 21);
			cs.setString(5, "chandu@mail.com");
			cs.setString(6, "9921004051");
			cs.setString(7, "AB -ve");
			
			cs.execute();
			cs.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
//
//CREATE OR REPLACE PROCEDURE create_teacher_records(
//	    p_id INT,
//	    p_name VARCHAR,
//	    p_gender VARCHAR,
//	    p_age INT,
//	    p_email VARCHAR,
//	    p_phone VARCHAR,
//	    p_bloodgroup VARCHAR
//	)
//	LANGUAGE plpgsql
//	AS $$
//	BEGIN
//	    INSERT INTO teacher (id, name, gender, age, email, phone, bloodgroup)
//	    VALUES (p_id, p_name, p_gender, p_age, p_email, p_phone, p_bloodgroup);
//	    
//	    RAISE NOTICE 'Teacher record inserted successfully: %', p_name;
//	END;
//	$$;


