import javax.swing.*;
import java.awt.*;
import java.sql.Connection;

public class JDBC_pr9_Selecting_Image
{
    public static void main(String[] args)
    {
        JFrame jf = new JFrame("Display Image");
        jf.setSize(600,600);
        jf.setLayout(null);
        jf.setVisible(true);

        JTextField tf1 = new JTextField();
        tf1.setBounds(120,50,350,350);
//        tf1.setBackground(Color.BLACK);

        JTextField tf = new JTextField();
        tf.setBounds(150,500,120,40);
        tf.setFont(new Font("arial",Font.BOLD,15));

        JButton b = new JButton("Show Image");
        b.setBounds(300,500,120,40);

        jf.add(b);
        jf.add(tf);
        jf.add(tf1);

        try
        {
            Connection conn = ConnectionProvider.getConnnection();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
