
import java.sql.Connection;
import java.sql.DriverManager;

    public class DbConnection {
        private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
        private static final String USER = "root"; // Change to your MySQL username
        private static final String PASSWORD = "jeysql"; // Change to your MySQL password

        public static Connection getConnection() {
            Connection con = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (Exception e) {
                System.out.println("Database connection failed: " + e.getMessage());
            }
            return con;
        }
    }


