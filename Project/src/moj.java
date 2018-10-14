

//package waste;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class moj extends JFrame
{
    public moj()
    {
    	String name1_d1=" ";
		String rol1_d1=" ";
		String branch1_d1=" ";
		String year1_d1=" ";
		String section1_d1=" ";
		String status_d1=" ";
		String date_d1=" ";
		boolean sta=false;
		//JTable table;
    	try{ 
  	   Class.forName("com.mysql.jdbc.Driver");  
  	   Connection con=DriverManager.getConnection(  
  	   "jdbc:mysql://127.0.0.1:3306/student","root","shiva");  
  	   Statement stmt=con.createStatement(); 
  	   PreparedStatement st = con.prepareStatement("select * from stu_tbl where stu_status=1 ");
   	
  	 ResultSet rs = st.executeQuery();
  	DefaultTableModel model = new javax.swing.table.DefaultTableModel();
	model.setColumnIdentifiers(new String [] {
			" stu_name","stu_rollno","stu_branch","stu_year "," stu_sec "," stu_status ","stu_date ","granted"});
  //	String[] columnNames = {" stu_name","stu_rollno","stu_branch","stu_year "," stu_sec "," stu_status ","stu_date ","Response1","Response2"};
  	
        	while (rs.next()) {
     		    name1_d1=rs.getString("stu_name");
        		 rol1_d1=rs.getString("stu_rollno");
        		 branch1_d1=rs.getString("stu_branch");
        		 year1_d1=rs.getString("stu_year");
        		 section1_d1=rs.getString("stu_sec");
        		// System.out.println("hai i ");
        		 status_d1=rs.getString("stu_status");
        		 date_d1=rs.getString("stu_date");
        		 String granr="Granted";
        //		 String grane="Not Granted";
        		 model.addRow(new Object [] {name1_d1,rol1_d1,branch1_d1,year1_d1,section1_d1,status_d1,date_d1,granr});
        	}
        	con.close();
            JTable table = new JTable( model )
            
            {
                //  Returning the Class of each column will allow different
                //  renderers to be used based on Class
            	
                public Class getColumnClass(int column)
                {  
                    return getValueAt(0, column).getClass();
                }
              //  public boolean isCellEditable(int row, int column) {
                    //all cells false
                //    return false;
                 //}
             
            };
            ButtonColumn buttonColumn = new ButtonColumn(table, 7);
            JScrollPane scrollPane = new JScrollPane( table );
            getContentPane().add( scrollPane );

            //  Create button column 
    	}
    	
  	   catch(Exception e)
     { System.out.println(e);}
    }
    	//previous values
        
        

       // DefaultTableModel model = new DefaultTableModel(data, columnNames);
        /*JTable table = new JTable( model )
        
        {
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
        	
            public Class getColumnClass(int column)
            {  
                return getValueAt(0, column).getClass();
            }
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
             }
         
        };*/
        

        //JScrollPane scrollPane = new JScrollPane( table );
        //getContentPane().add( scrollPane );

        //  Create button column
        //ButtonColumn buttonColumn = new ButtonColumn(table, 7,8);
   // }

    public static void main(String[] args)
    {
        moj frame = new moj();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);
    }

    class ButtonColumn extends AbstractCellEditor
        implements TableCellRenderer, TableCellEditor, ActionListener
    {
        JTable table;
        JButton renderButton;
        JButton editButton;
        String text;

        public ButtonColumn(JTable table, int column)
        {
            super();
            this.table = table;
            renderButton = new JButton();

            editButton = new JButton();
            editButton.setFocusPainted( false );
            editButton.addActionListener( this );

            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(column).setCellRenderer( this );
            columnModel.getColumn(column).setCellEditor( this );
        }

        public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            if (hasFocus)
            {
                renderButton.setForeground(table.getForeground());
                renderButton.setBackground(UIManager.getColor("Button.background"));
            }
            else if (isSelected)
            {
                renderButton.setForeground(table.getSelectionForeground());
                 renderButton.setBackground(table.getSelectionBackground());
            }
            else
            {
                renderButton.setForeground(table.getForeground());
                renderButton.setBackground(UIManager.getColor("Button.background"));
            }

            renderButton.setText( (value == null) ? "" : value.toString() );
            return renderButton;
        }

        public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column)
        {
            text = (value == null) ? "" : value.toString();
            editButton.setText( text );
            return editButton;
        }

        public Object getCellEditorValue()
        {
            return text;
        }

        public void actionPerformed(ActionEvent e)
        {
            fireEditingStopped();
            System.out.println( e.getActionCommand() + " : " + table.getSelectedRow());
        }
    }
}