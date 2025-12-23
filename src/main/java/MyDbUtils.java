import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDbUtils {


    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("SQL Server JDBC Driver not found.", e);
        }
    }


    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=buyuser;encrypt=false;trustServerCertificate=true";
    private static final String USER = "sa";
    private static final String PASSWORD = "123";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}