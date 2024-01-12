import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC_pr7_Updating_Data_of_Table
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
            System.out.println("Database Connected..!");

            String q = "update doctors set D_Name = ?, D_Address = ? WHERE D_ID = ?";

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter new D_Name : ");
            String name = br.readLine();

            System.out.println("Enter new D_Address : ");
            String add = br.readLine();

            System.out.println("Enter D_ID :");
            int id = Integer.parseInt(br.readLine());

            PreparedStatement pstmt = conn.prepareStatement(q);

            pstmt.setString(1, name);
            pstmt.setString(2, add);

            pstmt.setInt(3, id);

            pstmt.executeUpdate();

            System.out.println("Updation is completed..!");
            conn.close();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }


    }
}
