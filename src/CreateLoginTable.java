import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateLoginTable {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Load SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Connect to SQLite database (file-based)
            conn = DriverManager.getConnection("jdbc:sqlite:login.db");

            // Create table
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "username TEXT NOT NULL UNIQUE," +
                         "password TEXT NOT NULL)";
            stmt.executeUpdate(sql);

            System.out.println("Table created successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
