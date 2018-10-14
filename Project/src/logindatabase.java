
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class logindatabase {
	String emp;
	String pass;
	String  id;
	logindatabase(String emp,String pass)
	{ 
		this.emp=emp;
	    this.pass=pass;	
	}


	public void hod()
	{
		System.out.println("in login database");

		   try{  
	    	   Class.forName("com.mysql.jdbc.Driver");  
	    	   Connection con=DriverManager.getConnection(  
	    	   "jdbc:mysql://127.0.0.1:3306/employees","root","shiva");  
	    	   Statement stmt=con.createStatement(); 
	    	   String query="select * from  emp_tbl where emp_id=? and emp_pass=?";
	    	 // PreparedStatement st = con.prepareStatement("select * from  emp_tbl where emp_id=? and emp_pass=?");
	    	   PreparedStatement st = con.prepareStatement(query);
	    	   st.setString(1,emp);
	    	   st.setString(2,pass);
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
	    	   if(rs.next())
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
}