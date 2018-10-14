
import javax.swing.*;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.io.*;

import javafx.scene.paint.Color;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.io.*;
public class StudentmainPage extends WindowAdapter{
	
	String no;
	boolean stat;
	//public void hod()
	//{
		//L/ogin l1 = new Login();
		//l1.logindf();
	//}
	public void Studentmain() {
		
		 JFrame f=new JFrame("Student Registration");    
	     final JLabel label = new JLabel();
	     label.setBounds(20,350, 400,50);  
	     //name
	     final JLabel name = new JLabel("Name"); 
	     name.setBounds(60, 30, 100, 60);
	     final JTextField name1 = new JTextField();  
	        name1.setBounds(120,45, 100,30);
	        name1.setVisible(false);
	        //roll
	        JLabel rollno=new JLabel("RollNo:");    
	        rollno.setBounds(60, 80, 100, 60); 
	        final JTextField rollno1 = new JTextField();  
	        rollno1.setBounds(120,97, 100,30); 
	        //branch
	     final JLabel branch = new JLabel("Branch");
	     branch.setBounds(60, 130, 100, 60);
	     final JTextField branch1 = new JTextField();  
	        branch1.setBounds(120,150, 100,30);
	        branch1.setVisible(false);
	        //section
	     final JLabel section = new JLabel("Section");
	     section.setBounds(60, 180, 100, 60);
	     final JTextField section1 = new JTextField();  
	        section1.setBounds(120,195, 100,30);
	        section1.setVisible(false);
	        //year
	        final JLabel year= new JLabel("Year");
		     year.setBounds(60, 230, 100, 60);
		     final JTextField year1 = new JTextField();  
		        year1.setBounds(120,250, 100,30);
		        year1.setVisible(false);
	     
	     //submit 
	        JButton b = new JButton("Submit");  
	        b.setBounds(115,350, 80,30); 
	        b.setVisible(false);
	        JButton b1 = new JButton("Retrive");  
	        b1.setBounds(115,300, 80,30);
	        b1.setVisible(true);
	        //exit yes or no window
	       // f.addWindowListener(this);  
	        f.addWindowListener(this);
	        //database variablles
	           String d_name =" ";
        	    String d_rol =" ";
        	     String d_branch =" ";
        	    String d_year =" ";
        	    String d_section =" ";
	       
	      //frame add 
	        f.add(rollno); f.add(label); 
	        f.add(name);f.add(branch);
	        //f.add(l2); 
	        f.add(b); f.add(rollno1);
	        f.add(section1);
	        f.add(branch1);
	        f.add(name1);
	        f.add(b1);
	        f.add(section);
	        f.add(year);
	        f.add(year1);
	        //f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
	                f.setSize(400, 500);    
	                f.setLayout(null);    
	                f.setVisible(true);     
	             
	            
	                b1.addActionListener(new ActionListener() {  
	                public void actionPerformed(ActionEvent e) {       
	         
	             
	                	no = rollno1.getText();
	                	Database d1 = new Database(no);
	                	d1.data();
	                	 String r1=d1.rol;
	                   rollno1.setText(r1);
	                   rollno1.setEditable(false);
	                   //String names ="shiva";
	                   String n1 = d1.name;
	                   name1.setText(n1);
	                   name1.setVisible(true);
	                   name1.setEditable(false);
	                   //String branches = "cse";
	                   String b1=d1.branch;
	                   branch1.setText(b1);
	                   branch1.setVisible(true);
	                    branch1.setEditable(false);
	                   //String years = "1";
	                    String y1=d1.year;
	                   year1.setText(y1);
	                   year1.setVisible(true);
	                   year1.setEditable(false);
	                   //String sections = "c1";
	                   String s1=d1.section;
	                   section1.setText(s1);
	                   section1.setVisible(true);
	                   section1.setEditable(false);
	                   
	                   	b.setVisible(true);
	                   		

	                   //	b1.setVisible(false);
	                }
	                
	             });
	             
	                //b.addActionListener(new ActionListener() {  
		              //  public void actionPerformed(ActionEvent e) {
	                b.addActionListener(new ActionListener()
	            	{
	            		public void actionPerformed (ActionEvent e)
	            		{
	            			//StudentmainPage Student1 = new StudentmainPage();
	            			//Student1.Studentmain();
	            		//	Student2 = Student1;
	            			stat=true;
	            			Database d2 = new Database(no,stat);
	            			d2.statusfrom_studentmainPage();
	            			//stat=false;
	            			 JFrame f1=new JFrame();  
	            			    JOptionPane.showMessageDialog(f1,"Details Submited"); 
	            			    StudentmainPage Student1 = new StudentmainPage();
	            				Student1.Studentmain();
	            		}
	            	});
	                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		                
		                
		                
		                
		                
	}
		                
		                }	                
	  
	
	

