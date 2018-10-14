//import java.util.Date; 
import java.time.LocalDateTime;



import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

//import com.sun.corba.se.spi.orbutil.fsm.Action;

import experiment.moj;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.io.*;
public class Database {
	String emp;
	String pass;
	Database(String no1)
	{
		this.value=no1;
	}
	Database(String no1,boolean stat)
	{
		this.value=no1;
		this.stat=stat;
	}
	Database(String emp,String pass)
	{
		this.emp=emp;
		this.pass=pass;
	}
    public Database() {
		// TODO Auto-generated constructor stub
	}
	String name =" ";
	   String rol =" ";
	   String branch =" ";
	   String year =" ";
	   String section =" ";
	   MainPage m1 = new MainPage();
	   //StudentmainPage val = new StudentmainPage();
	  // String value = m1.Student2.no;
	   String value=" ";
	   boolean stat;
	   //String stamp;
	   //String status;
	   String name1_d=" ";
	   String rol1_d=" ";
	   String branch1_d="";
	   String year1_d="";
	   String section1_d="";
	   String status_d="";
	   String date_d="";
	   
	public void data()
	{
	
		   try{  
        	   Class.forName("com.mysql.jdbc.Driver");  
        	   Connection con=DriverManager.getConnection(  
        	   "jdbc:mysql://127.0.0.1:3306/student","root","shiva");  
        	   Statement stmt=con.createStatement(); 
        	   PreparedStatement st = con.prepareStatement("select * from stu_tbl where stu_rollno= ?");
        	   st.setString(1, value);
        	   ResultSet rs = st.executeQuery();
        	   if (rs.next() == false)
        	   { 
        		   JFrame f1=new JFrame();  
   			   JOptionPane.showMessageDialog(f1,"Invalid RollNO"); 
        		   //System.out.println("ResultSet in empty in Java");
   			StudentmainPage Student2 = new StudentmainPage();
			Student2.Studentmain();
        		  } 
        	   else
        	   {
        	   do {
        	     name = rs.getString("stu_name");
        	    rol = rs.getString("stu_rollno");
        	    branch = rs.getString("stu_branch");
        	    year = rs.getString("stu_year");
        	    section = rs.getString("stu_sec");
        	    //System.out.println(name+" "+rol+" "+branch+" "+year+" "+section+" ");
        	    }while(rs.next());
        	   }
        	   con.close();
           }
        	   catch(Exception e)
           { System.out.println(e);}

	}
	public void statusfrom_studentmainPage()
	{
		try{  
     	   Class.forName("com.mysql.jdbc.Driver");  
     	   Connection con=DriverManager.getConnection(  
     	   "jdbc:mysql://127.0.0.1:3306/student","root","shiva");  
     	   Statement stmt=con.createStatement(); 
     	   PreparedStatement st = con.prepareStatement("UPDATE stu_tbl set stu_status=? where stu_rollno=?");
     	   st.setBoolean(1, stat);
     	   st.setString(2, value);
     	   st.execute();
     	  
     	   con.close();
        }
     	   catch(Exception e)
        { System.out.println(e);}

		
	}
	public void statusfrom_security()
	{
		
		try{  
     	   Class.forName("com.mysql.jdbc.Driver");  
     	   Connection con=DriverManager.getConnection(  
     	   "jdbc:mysql://127.0.0.1:3306/student","root","shiva");  
     	   Statement stmt=con.createStatement();
     	 //  System.out.println(value+" ");
     	   PreparedStatement st = con.prepareStatement("select * from stu_tbl where stu_rollno= ?");
     	   st.setString(1,value);
     	   ResultSet rs = st.executeQuery();
     	   while(rs.next()) {
     	     name = rs.getString("stu_name");
     	    rol = rs.getString("stu_rollno");
     	    branch = rs.getString("stu_branch");
     	    year = rs.getString("stu_year");
     	    section = rs.getString("stu_sec");
     	    stat = rs.getBoolean("stu_status");
     	   System.out.println(name+" "+rol+" "+branch+" "+year+" "+section+" "+stat+" ");
     	    }
     	   con.close();
        }
     	   catch(Exception e)
        { System.out.println(e);}

	}
	public void TimeStamp()
	{
		try{ 
     	   Class.forName("com.mysql.jdbc.Driver");  
     	   Connection con=DriverManager.getConnection(  
     	   "jdbc:mysql://127.0.0.1:3306/student","root","shiva");  
     	   Statement stmt=con.createStatement(); 
     	   PreparedStatement st = con.prepareStatement("UPDATE stu_tbl set stu_date= now() where stu_rollno=?;");
      	//st.setTimestamp(1, date);
     	   st.setString(1,value);
     	   st.execute();
     	   con.close();
        }
     	   catch(Exception e)
        { System.out.println(e);}

		
	}

	public void login()
	{
		System.out.println("in login database");

		   try{  
			   
	    	   Class.forName("com.mysql.jdbc.Driver");  
	    	   Connection con=DriverManager.getConnection(  
	    	   "jdbc:mysql://127.0.0.1:3306/employees","root","shiva");  
	    	   Statement stmt=con.createStatement(); 
	    	   String query="select * from  emp_tbl where emp_id=? and emp_pass=?";
	    	 // PreparedStatement st = con.prepareStatement("select * from  emp_tbl where emp_id= ? and emp_pass= ?");
	    	   PreparedStatement st = con.prepareStatement(query);
	    	   st.setString(1,emp);
	    	   st.setString(2,pass);
	    	   //System.out.println("hai shiva in login");
	    	   ResultSet rs = st.executeQuery();
	    	/*   if (rs.next()==false)
	    	   { 
	    		   emp=rs.getString("emp_id");
	    		   JFrame f1=new JFrame();  
				   JOptionPane.showMessageDialog(f1,"Invalid Employee ID and Password"); 
	    		   System.out.println("ResultSet in empty in Java");
	    		   System.out.println(emp+" ");
				//StudentmainPage Student2 = new StudentmainPage();
			//Student2.Studentmain();
	    		  } 
	    	   else
	    	   {
	    	   do {
	    	     //name = rs.getString("stu_name");
	    	    //rol = rs.getString("stu_rollno");
	    	    //branch = rs.getString("stu_branch");
	    	    //year = rs.getString("stu_year");
	    	   // section = rs.getString("stu_sec");
	    	    emp=rs.getString("emp_id");
	    	    pass=rs.getString("emp_pass");
	    	    System.out.println(emp+" "+pass+" ");
	    	    }while(rs.next());
	    	   }*/
	    	  // System.out.println(emp+" ");
	    	  // System.out.println(pass+" ");
	    	   boolean record =rs.next();
	    	   System.out.println(record);
	    	   if(record)
	    	   {
	    		   JFrame f1=new JFrame();
	    		   JOptionPane.showMessageDialog(f1,"log in successful");
	    	   }
	    	   else
	    	   {
	    		   JFrame f1=new JFrame();
	    		   JOptionPane.showMessageDialog(f1,"invalid details");
	    	   }
	    	  /* String sql = "SELECT emp_id, emp_pass FROM emp_tbl where emp_id='"+emp+"' and emp_pass='"+pass+"'";
	           ResultSet rs = stmt.executeQuery(sql);
	   while(rs.next())
	    {
	   emp=rs.getString("emp_id");
	   System.out.println( emp+" ");
	String   userpass=rs.getString("emp_pass");   
	   }

	   if(id!=null)
	   System.out.println("Login Success");
	   else
	   System.out.println("Login Failed");*/
	    	   con.close();
	       }
	    	   catch(Exception e)
	       { System.out.println(e);}

	}
/*	public void data_from_database_hod()
	{
		/*
	
		   try{  
        	   Class.forName("com.mysql.jdbc.Driver");  
        	   Connection con=DriverManager.getConnection(  
        	   "jdbc:mysql://127.0.0.1:3306/student","root","shiva");  
        	   Statement stmt=con.createStatement(); 
        	   PreparedStatement st = con.prepareStatement("select * from stu_tbl where stu_status=1 ");
        	  // st.setString(1, value);
        	   ResultSet rs = st.executeQuery();
        	   //int columnsNumber = rs.
        	   //if (rs.next() == false)
        	   //{ 
        		 //  JFrame f1=new JFrame();  
   			   //JOptionPane.showMessageDialog(f1,"Invalid RollNO"); 
        		   //System.out.println("ResultSet in empty in Java");
   			///StudentmainPage Student2 = new StudentmainPage();
			///Student2.Studentmain();
        		 // } 
        	   //else
        	   //{
        	 /*  while(rs.next()); {
        	     name1_d = rs.getString("stu_name");
        	    rol1_d = rs.getString("stu_rollno");
        	    branch1_d = rs.getString("stu_branch");
        	    year1_d = rs.getString("stu_year");
        	    section1_d = rs.getString("stu_sec");
        	     //status_d=rs.getString("stu_status");
        		    date_d=rs.getString(" stu_date");
        		   
        	    
        	    System.out.println(name1_d+" "+rol1_d+" "+branch1_d+" "+year1_d+" "+section1_d+" ");
        	    }*/
        	  // System.out.println("in in database data_hod_database");
        	 //  TableExample be = TableExample();
        	 /* JFrame b = new JFrame();
        	  String name1_d1=" ";
        		String rol1_d1=" ";
        		String branch1_d1=" ";
        		String year1_d1=" ";
        		String section1_d1=" ";
        		String status_d1=" ";
        		String date_d1=" ";
        		boolean sta=false;
        		JFrame f;
        		int val =rs.getRow();
        		  //JTable jt;
        		//status_d1=Boolean.toString(sta);
        		JTable jt=new JTable();
        		
        		
        		
        		javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel();
        		model.setColumnIdentifiers(new String [] {
        				" stu_name","stu_rollno","stu_branch","stu_year "," stu_sec "," stu_status ","stu_date "});
        		jt.setModel(model);
        		while (rs.next()) {
         		    name1_d1=rs.getString("stu_name");
            		 rol1_d1=rs.getString("stu_rollno");
            		 branch1_d1=rs.getString("stu_branch");
            		 year1_d1=rs.getString("stu_year");
            		 section1_d1=rs.getString("stu_sec");
            		 System.out.println("hai i ");
            		 status_d1=rs.getString("stu_status");
            		 date_d1=rs.getString("stu_date");
            		 model.addRow(new Object [] {name1_d1,rol1_d1,branch1_d1,year1_d1,section1_d1,status_d1,date_d1});
          	 
  //           		String column[]={" stu_name","stu_rollno","stu_branch","stu_year "," stu_sec "," stu_status ","stu_date "};         
             	      
            		// Action delete = new AbstractAction();
            	/*	 ListSelectionModel select= jt.getSelectionModel();  
                     select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
                     select.addListSelectionListener(new ListSelectionListener() {  
                       public void valueChanged(ListSelectionEvent e) {  
                         String Data = null;  
                         String id = null;
                         int[] row = jt.getSelectedRows();  
                         int[] columns = jt.getSelectedColumns();  
                         for (int i = 0; i < row.length; i++) {  
                           for (int j = 0; j < columns.length; j++) {  
                             Data = (String) jt.getValueAt(row[i], columns[j]);  
                         id=(String) jt.getValueAt(jt.getSelectedRow(),1).toString();
                            // System.out.println(jt.getValueAt(jt.getSelectedRow(), 0).toString());
                           } }  
                         System.out.println("Table element selected is: " + Data);    
                         System.out.println("Table id is :"+id);
                       }       
                     });  
                     
             		//System.out.println(name1_d1+" "+rol1_d1+" "+branch1_d1+" "+year1_d1+" "+section1_d1+" "+sta+" "+date_d1+" ");
             		
        		 
             		JScrollPane sp=new JScrollPane(jt);    
               	    b.add(sp);
               	   // x.setBounds(50, 100, 30, 10);
               	   // b.add(x);
            		 }
        		 		jt.setModel(model);
        		 		//jt.getColumn(" response").setCellRenderer(new ButtonRenderer());
        		 		
        		 		
        	  /*  
        	   while (rs.next()) {
        		    name1_d1=rs.getString("stu_name");
           		 rol1_d1=rs.getString("stu_rollno");
           		 branch1_d1=rs.getString("stu_branch");
           		 year1_d1=rs.getString("stu_year");
           		 section1_d1=rs.getString("stu_sec");
           		 System.out.println("hai i ");
           		 status_d1=rs.getString("stu_status");
           		 date_d1=rs.getString("stu_date");
           		 System.out.println(name1_d1+" "+rol1_d1+" "+branch1_d1+" "+year1_d1+" "+section1_d1+" "+sta+" "+date_d1+" ");
        	   }*/
        	   //System.out.println(val+"  ");
        		 //Print one row          
        		 /*for(int i = 1 ; i <= columnsNumber; i++){
        			 System.out.println("in in database data_hod_database1");
        		       System.out.print(rs.getString(i) + " "); //Print one element of a row

        		 }

        		   System.out.println();//Move to the next line to print the next row.           

        		     }
        	   
        	   //jt.setBounds(30,40,200,300);          
       	              
       	    b.setSize(300,400);    
       	    b.setVisible(true);
        	   //}
        	   con.close();
        	  // TableExample tr = new TableExample();
        	 
           }
        	   catch(Exception e)
           { System.out.println(e);}*/
        		 	
     /*   		 		moj frame = new moj();
        		        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        		        frame.pack();
        		        frame.setVisible(true);
}*/

public void data_from_database_hod()
{
	 moj frame = new moj();
     //frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
     frame.pack();
     frame.setVisible(true);
	
	}
	
	private TableExample TableExample() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
