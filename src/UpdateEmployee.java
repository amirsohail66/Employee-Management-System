import javax.swing.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class UpdateEmployee extends JFrame implements ActionListener {
    Random ran = new Random();
    int number = ran.nextInt(999999);

    JTextField tfeducation,tfdesignation,tffname,tfaddress,tfphone,tfaadhar,tfemail,tfsalary;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel lblempid;
    JButton add,back;

    String empId;
    UpdateEmployee(String empId){
        this.empId = empId;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD, 25));
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif", Font.PLAIN,20));
        add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(200,150,150,30);
        add(lblname);

        JLabel labeflname = new JLabel("Father's Name");
        labeflname.setBounds(400,150,150,30);
        labeflname.setFont(new Font("serif", Font.PLAIN,20));
        add(labeflname);

        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);

        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif", Font.PLAIN,20));
        add(labeldob);

        JLabel lbldob = new JLabel();
        lbldob.setBounds(200,200,150,30);
        add(lbldob);

        JLabel labesalery = new JLabel("Salary");
        labesalery.setBounds(400,200,150,30);
        labesalery.setFont(new Font("serif", Font.PLAIN,20));
        add(labesalery);

        tfsalary = new JTextField();
        tfsalary.setBounds(600,200,150,30);
        add(tfsalary);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif", Font.PLAIN,20));
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel labephone = new JLabel("Phone Number");
        labephone.setBounds(400,250,150,30);
        labephone.setFont(new Font("serif", Font.PLAIN,20));
        add(labephone);

        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

        JLabel labelemail = new JLabel("Email id");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif", Font.PLAIN,20));
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel labeleducation = new JLabel("Highest Education");
        labeleducation.setBounds(400,300,150,30);
        labeleducation.setFont(new Font("serif", Font.PLAIN,20));
        add(labeleducation);


        tfeducation = new JTextField();
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);

        JLabel labeldesignation = new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("serif", Font.PLAIN,20));
        add(labeldesignation);

        tfdesignation = new JTextField();
        tfdesignation.setBounds(200,350,150,30);
        add(tfdesignation);

        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400,350,150,30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN,20));
        add(labelaadhar);

        JLabel lblaadhar= new JLabel();
        lblaadhar.setBounds(600,350,150,30);
        add(lblaadhar);

        JLabel labelemployeeid = new JLabel("Employee Id");
        labelemployeeid.setBounds(50,400,150,30);
        labelemployeeid.setFont(new Font("serif", Font.PLAIN,20));
        add(labelemployeeid);

        lblempid = new JLabel();
        lblempid.setBounds(200,400,400,30);
        lblempid.setFont(new Font("serif", Font.PLAIN,20));
        add(lblempid);

        try {
            conn c = new conn();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfemail.setText(rs.getString("email"));
                tfphone.setText(rs.getString("phone"));
                tfeducation.setText(rs.getString("education"));
                tfsalary.setText(rs.getString("salary"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblempid.setText(rs.getString("empId"));
                tfdesignation.setText(rs.getString("designation"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        add = new JButton("Update Details");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add(add);

        back = new JButton("Back");
        back.setBounds(450,550,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        add(back);

        setSize(900,700);
        setLocation(230,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String fname = tffname.getText();
            String salary = tfsalary.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String emails = tfemail.getText();
            String education =tfeducation.getText() ;
            String designation = tfdesignation.getText();

            try {
                conn conn = new conn();
                String query = "update employee set fname = '"+fname+"',salary = '"+salary+"',address = '"+address+"',phone = '"+phone+"',email = '"+emails+"',education = '"+education+"',designation = '"+designation+"' where empId = '"+empId+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details updated successfully");
                new Home();
            }catch (Exception e){
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
