import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBC_pr2_CreateTable
{
    public static void main(String[] args) {
        getConnection();
    }

    public static void getConnection()
    {
        try
        {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/testjdbc";
            String username = "root";
            String password = "rna@2004";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,password);

            if(conn.isClosed())
            {
                System.out.println("Connection is closed!");
            }
            else
            {
                System.out.println("Connection is created!");
            }

            // create a query

            String q = "create table Doctors(D_ID int(20) primary key auto_increment, D_Name varchar(100) not null, D_Address varchar(300))";
            // create a statement

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(q);

            System.out.println("Table is created in database!");
            conn.close();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
