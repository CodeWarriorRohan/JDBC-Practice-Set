import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_pr1_CreateConnection
{
    public static void main(String[] args)
    {
        getConnection();
    }

    public static Connection getConnection()
    {
        try
        {
            String driver = "com.mysql.cj.jdbc.Driver";
            String databaseurl = "jdbc:mysql://localhost:3306/testjdbc";
            String username = "root";
            String password = "rna@2004";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(databaseurl, username, password);
            System.out.println("Database connected");
            return conn;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }
}
