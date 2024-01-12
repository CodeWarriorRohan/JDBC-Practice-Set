import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider
{
    public static void main(String[] args) {
        getConnnection();
    }
    private static Connection conn;

    public static Connection getConnnection()
    {
        try
        {
//            String driver = "com.mysql.cj.jdbc.Driver";
//            String url = "jdbc:mysql://localhost:3306/testjdbc";
//            String url = "jdbc:mysql://localhost:3306/Photos";
//            String username = "root";
//            String password = "rna@2004";
            if(conn == null)
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
//                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","rna@2004");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management_app","root","rna@2004");
//                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Photos","root","rna@2004");

            }
            System.out.println("Database Connected..!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
}

