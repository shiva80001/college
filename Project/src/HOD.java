
import javax.swing.*;
 
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.io.*;   
import java.awt.event.*;  
public class HOD {  
	String emp;
	String pass;
	
public void logindf()
{
    //public static void main(String[] args) {    
    JFrame f=new JFrame("Password Field Example");    
     final JLabel label = new JLabel();            
     label.setBounds(20,150, 400,50);  
     final JPasswordField value = new JPasswordField();   
     value.setBounds(100,75,100,30);   
     JLabel l1=new JLabel("Employee ID");    
        l1.setBounds(20,20, 80,30);    
        JLabel l2=new JLabel("Password:");    
        l2.setBounds(20,75, 80,30);    
        JButton b = new JButton("Login");  
        b.setBounds(100,120, 80,30);    
        final JTextField text = new JTextField();  
        text.setBounds(100,20, 100,30);    
                f.add(value); f.add(l1); f.add(label); f.add(l2); f.add(b); f.add(text);  
                f.setSize(400,500);    
                f.setLayout(null);    
                f.setVisible(true);
                
                 
                
                //get text from id and pass
               // l1.
                
              // String pass=value.getPassword();
              
                b.addActionListener(new ActionListener() {  
                public void actionPerformed(ActionEvent e) {       
                 
                	//logindatabase l2 = new logindatabase(emp,pass);
                	//l2.hod();
                	Database d4 = new Database();
                	d4.data_from_database_hod();
                	//b1.data_from_database_hod();
                	 emp=text.getText();
                	 pass = new String(value.getPassword());
                	Database b1 = new Database(emp,pass);
                	b1.login();
                	System.out.println(emp+" "+pass+" in hod class");
                	
                	
                	
                	
                }  
             });   
//}  
	}
} 