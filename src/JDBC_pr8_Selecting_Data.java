import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_pr8_Selecting_Data
{
    public static void main(String[] args)
    {
        try
        {
            Connection conn = ConnectionProvider.getConnnection();

            String q = "select * from doctors";

            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(q);

            while (set.next())
            {
                int id = set.getInt(1);
                String name = set.getString(2);
                String add = set.getString(3);

                System.out.println("Data of table doctors are :");

                System.out.println(id+" : "+name+" : "+add);
            }
            conn.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
