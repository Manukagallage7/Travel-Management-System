import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class db {
    static final String URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASS = "";
    static final String DB_NAME = "university_management_system";

    public static void main(String args[]) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = conn.createStatement()) {

            String sql = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
            stmt.executeUpdate(sql);
            System.out.println("Database '" + DB_NAME + "' created successfully...");

        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
