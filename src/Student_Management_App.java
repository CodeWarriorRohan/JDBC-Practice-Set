import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Student_Management_App
{
    public static void main(String[] args) throws IOException
    {

        try
        {
            Connection conn = ConnectionProvider.getConnnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            /*
            String q1 = "create table Students(Roll_no int(10) primary key auto_increment, Name varchar(100), Email_Address varchar(50), DOB date, Contact_no varchar(20), Address text, Gender enum(\"M\",\"F\",\"O\"))";

            Statement stmt = conn.createStatement();
            stmt.executeUpdate(q1);

            System.out.println("Table is created..!");
            conn.close();
             */

            while (true)
            {
                System.out.println("Enter 1 for add student");
                System.out.println("Enter 2 for remove student");
                System.out.println("Enter 3 for update student");
                System.out.println("Enter 4 for display student");
                System.out.println("Enter 5 for exit student");

                int c = Integer.parseInt(br.readLine());
                if (c == 1)
                {
                    // Add student
                    String q = "insert into students(Roll_no, Name, Email_Address, DOB, Contact_no, Address, Gender) values (?,?,?,?,?,?,?)";
                    PreparedStatement pstmt = conn.prepareStatement(q);

                    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter Roll number :");
                    String roll_no = br1.readLine();

                    System.out.println("Enter Name :");
                    String name = br1.readLine();

                    System.out.println("Enter Email Address :");
                    String eadd = br1.readLine();

                    System.out.println("Enter Date of birth :");
                    String dob = br1.readLine();

                    System.out.println("Enter Contact number :");
                    String cn = br1.readLine();

                    System.out.println("Enter Address :");
                    String add = br1.readLine();

                    System.out.println("Enter Gender :");
                    String gn = br1.readLine();

                    pstmt.setString(1,roll_no);
                    pstmt.setString(2,name);
                    pstmt.setString(3,eadd);
                    pstmt.setString(4,dob);
                    pstmt.setString(5,cn);
                    pstmt.setString(6,add);
                    pstmt.setString(7,gn);

                    pstmt.executeUpdate();
                    System.out.println("Student is added successfully...!");
                }
                else if (c == 2)
                {
                    // Remove student
                    String q = "delete from students WHERE Id = ?";

                    PreparedStatement pstmt = conn.prepareStatement(q);

                    Scanner sc = new Scanner(System.in);

                    System.out.println("Enter Student Roll no. to delete");
                    int sr = sc.nextInt();

                    pstmt.setInt(1,sr);

                    int numberOfRows = pstmt.executeUpdate();
                    if (numberOfRows > 0)
                    {
                        System.out.println("Student with Roll no. "+sr+" is deleted successfully..");
                    }
                    else
                    {
                        System.out.println("Student with Roll no. "+sr+" is not found in the database..");
                    }

                }
                else if (c == 3)
                {
                    // Update student
                    String q = "update students set Name = ?, Email_Address = ?, DOB = ?, Contact_no = ?, Address = ?, Gender = ? WHERE Roll_no = ?";

                    BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

                    System.out.println("Enter new Name : ");
                    String name = br2.readLine();

                    System.out.println("Enter new Email_Address : ");
                    String eadd = br2.readLine();

                    System.out.println("Enter DOB :");
                    String dob = br2.readLine();

                    System.out.println("Enter new Contact number : ");
                    String cn = br2.readLine();

                    System.out.println("Enter new Address : ");
                    String add = br2.readLine();

                    System.out.println("Enter new Gender : ");
                    String gender = br2.readLine();

                    System.out.println("Enter Roll_no :");
                    int rn = Integer.parseInt(br.readLine());

                    PreparedStatement pstmt = conn.prepareStatement(q);

                    pstmt.setString(1, name);
                    pstmt.setString(2, eadd);
                    pstmt.setString(3, dob);
                    pstmt.setString(4, cn);
                    pstmt.setString(5, add);
                    pstmt.setString(6, gender);
                    pstmt.setInt(7, rn);

                    pstmt.executeUpdate();
                    System.out.println("Student is updated successfully...!");
                    conn.close();
                }
                else if (c == 4)
                {
                    // Display student
                    String q = "select * from students";

                    Statement stmt = conn.createStatement();
                    ResultSet set = stmt.executeQuery(q);
                    System.out.println("Data of all Students :");

                    while (set.next())
                    {
                        int rn = set.getInt(1);
                        String name = set.getString(2);
                        String eadd = set.getString(3);
                        String dob = set.getString(4);
                        String cn = set.getString(5);
                        String add = set.getString(6);
                        String gender = set.getString(7);

                        System.out.println(rn+" : "+name+" : "+eadd+" : "+dob+" : "+cn+" : "+add+" : "+gender);
                    }
                    System.out.println("\n");
                    conn.close();
                }
                else if (c == 5)
                {
                    // Exit
                    System.out.println("We have exited from app");
                    break;
                }
            }

            System.out.println("Thank you for using my application...");
            System.out.println("See you soon...");
            System.out.println("Bye bye...");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
