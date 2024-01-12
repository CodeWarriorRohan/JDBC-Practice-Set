import java.io.FileInputStream;
import java.sql.*;

public class JDBC_pr5_Inserting_Images
{
    public static void main(String[] args)
    {
        try
        {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/Photos";
            String username = "root";
            String password = "rna@2004";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected");

//          create a query

//            String q = "create table Images(P_ID int(10) primary key auto_increment, P_pic blob)";

//          create a statement

//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(q);

//            System.out.println("Table is created in database!");

            String qu = "insert into Images(P_pic) values(?)";

            PreparedStatement pstmt = conn.prepareStatement(qu);

//          Note --> blob datatype can store only less than 65 kb data (image)

            FileInputStream fs = new FileInputStream("E:\\1658739965197.jpg");

            pstmt.setBinaryStream(1,fs,fs.available());

            pstmt.executeUpdate();

            System.out.println("Image Inserted..!");

            conn.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
