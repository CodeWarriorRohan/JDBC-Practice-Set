import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC_pr3_Insert_Query
{
    public static void main(String[] args) {

        try
        {
            String driver = "com.mysql.cj.jdbc.Driver";
            String databaseurl = "jdbc:mysql://localhost:3306/testjdbc";
            String username = "root";
            String password = "rna@2004";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(databaseurl, username, password);
            System.out.println("Database connected");

            // create a query

            String q = "insert into Doctors(D_Name, D_Address) values (?,?)";

            // get the PreparedStatement object

            PreparedStatement psmt = conn.prepareStatement(q);

            // set the values to query

            psmt.setString(1,"Ram");
//            psmt.setString(1,"Shyam");
//            psmt.setString(1,"Deepak");
//            psmt.setString(1,"Shubham");
            psmt.setString(2,"Ayodhya");
//            psmt.setString(2,"Gokul");
//            psmt.setString(2,"Delhi");
//            psmt.setString(2,"Shamli");

            psmt.executeUpdate();

            System.out.println("Inserted..!");

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
