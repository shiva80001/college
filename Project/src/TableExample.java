import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;    
public class TableExample {    
    JFrame f;    
    TableExample(){    
    f=new JFrame(); 
    
    
    String name1_d1=" ";
	   String rol1_d1=" ";
	   String branch1_d1="";
	   String year1_d1="";
	   String section1_d1="";
	   String status_d1="";
	   String date_d1="";
	  
	   //StudentmainPage val = new StudentmainPage();
	  // String value = m1.Student2.no;
	   String value=" ";
	   boolean stat;
	   //String stamp;
	   //String status;
	/*   
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
     	   do {
     	     name = rs.getString("stu_name");
     	    rol = rs.getString("stu_rollno");
     	    branch = rs.getString("stu_branch");
     	    year = rs.getString("stu_year");
     	    section = rs.getString("stu_sec");
     	    
     	    //System.out.println(name+" "+rol+" "+branch+" "+year+" "+section+" ");
     	    }while(rs.next());
     	   
     	   con.close();
        }
     	   catch(Exception e)
        { System.out.println(e);}

	}
      */
   /* String data[][]={ {"101","Amit","670000","4654","48+8","7987","yuygu"},    
                          {"102","Jai","780000","4654","48+8","7987","yuygu"},    
                          {"101","Sachin","700000","4654","48+8","7987","yuygu"}};*/
	   
    
	   String name1= "shiva";
	   String rollno1="123";
	   String branch1 = "cse";
	   String year1="1";
	   String sec1="c";
	   String status1="true";
	   String date1="10-10-2018";
			   
	   
	   
	   String data[][]= {{name1,rollno1,branch1,year1,sec1,status1,date1}};
	   
	   
	String column[]={" stu_name","stu_rollno","stu_branch","stu_year "," stu_sec "," stu_status ","stu_date "};         
    JTable jt=new JTable(data,column);    
    jt.setBounds(30,40,200,300);          
    JScrollPane sp=new JScrollPane(jt);    
    f.add(sp);          
    f.setSize(300,400);    
    f.setVisible(true);    
}     
public static void main(String[] args) {    
    new TableExample(); 
    Database b6= new Database();
}    
} 