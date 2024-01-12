import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Swing_Student_Management_App extends JFrame
{
    public static void main(String[] args) throws IOException
    {
        JFrame f = new JFrame("Students Information Form");
        JTextField tf1; JTextField tf2; JTextField tf3;
        JComboBox cb1; JComboBox cb2; JComboBox cb3;
        JTextField tf4; JTextArea ta5; JTextField tf6;
        JRadioButton jb1, jb2;  JLabel jl8; JLabel jl9;

        JButton b1 = new JButton("Add");
        JButton b2 = new JButton("Remove");
        JButton b3 = new JButton("Update");
        JButton b4 = new JButton("Display");
        JButton b5 = new JButton("Exit");

        JLabel l0 = new JLabel("Students Information Form");
        l0.setBounds(280,10,300,50);
        l0.setFont(new Font("arial",Font.BOLD,20));

        JLabel l1 = new JLabel("Roll number");
        l1.setBounds(20,120,200,30);
        tf1 = new JTextField();
        tf1.setBounds(200,120,200,30);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(20,170,200,30);
        tf2 = new JTextField();
        tf2.setBounds(200,170,200,30);

        JLabel l3 = new JLabel("Email address");
        l3.setBounds(20,220,200,30);
        tf3 = new JTextField();
        tf3.setBounds(200,220,200,30);

        JLabel l4 = new JLabel("Date Of Birth");
        l4.setBounds(20,270,200,30);

        String[] day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        cb1 = new JComboBox<>(day);
        cb1.setBounds(200,270,60,30);

        String[] month = {"Jan","Fab","March","April","May","June","July","Aug","Sept","Octo","Nov","Dec"};
        cb2 = new JComboBox<>(month);
        cb2.setBounds(270,270,60,30);

        String[] year = {"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
        cb3 = new JComboBox<>(year);
        cb3.setBounds(340,270,60,30);

        JLabel l5 = new JLabel("Contact number");
        l5.setBounds(20,320,200,30);
        tf4 = new JTextField();
        tf4.setBounds(200,320,200,30);

        JLabel l6 = new JLabel("Address");
        l6.setBounds(20,430,200,50);
        ta5 = new JTextArea();
        ta5.setBounds(200,430,200,50);

        JLabel l7 = new JLabel("Gender");
        l7.setBounds(20,370,200,30);
        jb1 = new JRadioButton("Male");
        jb1.setBounds(200,370,100,30);
        jb2 = new JRadioButton("Female");
        jb2.setBounds(300,370,100,30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(jb1);
        bg.add(jb2);

        tf6 = new JTextField();
        tf6.setBounds(550,120,180,200);

        jl8 = new JLabel("Student Photo");
        jl8.setBounds(600,330,120,30);

        jl9 = new JLabel("");
        jl9.setBounds(200,600,150,50);

        b1.setBounds(300,500,90,40);
        b2.setBounds(300,550,90,40);
        b3.setBounds(420,500,90,40);
        b4.setBounds(420,550,90,40);
        b5.setBounds(665,630,90,40);

        f.add(tf1); f.add(tf2); f.add(tf3); f.add(cb1);
        f.add(cb2); f.add(cb3); f.add(tf4); f.add(ta5);
        f.add(jb1); f.add(jb2); f.add(tf6); f.add(jl8);

        f.add(l0); f.add(l1); f.add(l2); f.add(l3);
        f.add(l4); f.add(l5); f.add(l6); f.add(l7);

        f.add(b1); f.add(b2); f.add(b3);
        f.add(b4); f.add(b5); f.add(jl9);

        f.setSize(800,730);
        f.setLayout(null);
        f.setVisible(true);

    }
}

