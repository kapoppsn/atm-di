package atmwithdatabase;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class JdbcSQLiteConnection {
    public static void main(String[] args) {
        Map<Integer, Customer> customers = new HashMap<Integer, Customer>();
        try {
// setup
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:customers.db";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database....");
                System.out.println("----- Data in customers table -----");
                String query = "Select * from customers";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    int password = resultSet.getInt(2);
                    int amount = resultSet.getInt(3);

                   System.out.println("id:"+id+" name:"+password+" price: "+amount);
                }
// close connection
                conn.close();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
