import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBC_pr10_Delete_Query
{
    private static Connection conn;

    public static Connection getConnection()
    {
        try
        {
            if (conn == null)
            {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","rna@2004");
                System.out.println("Database connected..!");

                String q = "delete from employee WHERE Id = ?";

                PreparedStatement pstmt = conn.prepareStatement(q);

                Scanner sc = new Scanner(System.in);

                System.out.println("Enter employee Id to delete");
                int emId = sc.nextInt();

                pstmt.setInt(1,emId);

                int numberOfRows = pstmt.executeUpdate();
                if (numberOfRows > 0)
                {
                    System.out.println("Employee with Id "+emId+" is deleted successfully..");
                }
                else
                {
                    System.out.println("Employee with Id "+emId+" is not found in the database..");
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
    public static void main(String[] args)
    {
        getConnection();
    }
}
