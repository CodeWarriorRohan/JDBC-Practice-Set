import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBC_pr6_Inserting_big_images_Dynamically
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
            System.out.println("Database Connected..!");

            // create a table
//            String q = "create table Images2(P_ID int(10) primary key auto_increment, P_pic longblob)";

            // create statement

//            Statement stmt = conn.createStatement();
//            stmt.executeUpdate(q);

//            System.out.println("Table is created..!");

            String q = "insert into Images2(P_pic) values(?)";

            PreparedStatement pstmt = conn.prepareStatement(q);

            JFileChooser jfc = new JFileChooser();
            jfc.showOpenDialog(null);

            File file = jfc.getSelectedFile();

            FileInputStream fis = new FileInputStream(file);
            pstmt.setBinaryStream(1,fis,fis.available());

            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "success..");

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
