package transaction_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class TransactionManagement {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/JDBC_Coaching";
        String user = "postgres";
        String pass = "tiger";

        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(url, user, pass);
            c.setAutoCommit(false);  // Start transaction

            Statement st = c.createStatement();

            String sqlBooking_info = "insert into booking_info values(10,'AIR INDIA','BLR','Spain')";
            String sqlPassenger_info1 = "insert into passenger_info values(1,'NIKHIL',21,'MALE')";
            String sqlPassenger_info2 = "insert into passenger_info values(2,'KARAN',20,'MALE')";
            String sqlPassenger_info3 = "insert into passenger_info values(3,'SIVA',21,'MALE')";
            String sqlPay_info = "insert into payment_info values(101,1,29000,9000,'recieved')";

            // Insert booking info
            st.execute(sqlBooking_info);

            // Create savepoint after booking info
            Savepoint sp = c.setSavepoint("AfterBooking");

            try {
                // Insert passenger info
                st.execute(sqlPassenger_info1);
                st.execute(sqlPassenger_info2);
                st.execute(sqlPassenger_info3);

                if (DemoPaymentGateWay.isSuccess()) {
                    // Insert payment info and commit everything
                    st.execute(sqlPay_info);
                    c.commit();
                    System.out.println("Payment is Successful");
                } else {
                    // Rollback only to savepoint (undo passenger info but keep booking info)
                    c.rollback(sp);
                    c.commit();
                    System.out.println("Payment Failed & Passenger Data Reverted");
                }
            } catch (SQLException e) {
                // Rollback entire transaction in case of unexpected error
                c.rollback();
                System.out.println("Error occurred, transaction rolled back");
                e.printStackTrace();
            }

            c.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
