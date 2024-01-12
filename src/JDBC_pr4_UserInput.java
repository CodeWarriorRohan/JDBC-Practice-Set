import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC_pr4_UserInput
{
    public static void main(String[] args)
    {
        try
        {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/testjdbc";
            String username = "root";
            String password = "rna@2004";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected");

            // create a query

            String q = "insert into Doctors(D_Name, D_Address) values (?,?)";

            PreparedStatement psmt = conn.prepareStatement(q);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter D_Name :");
            String name = br.readLine();

            System.out.println("Enter D_Address :");
            String add = br.readLine();


            psmt.setString(1,name);
            psmt.setString(2,add);

            psmt.executeUpdate();
            System.out.println("Inserted...!");

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
