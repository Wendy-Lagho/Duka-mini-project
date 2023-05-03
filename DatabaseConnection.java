import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseConnection {

    private Connection conn;

    public DatabaseConnection() {
        try {
            // register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // open a connection to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "password");
            System.out.println("Database connection successful!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void close() {
        try {
            conn.close();
            System.out.println("Database connection closed.");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    DatabaseConnection connection = new DatabaseConnection();
}
