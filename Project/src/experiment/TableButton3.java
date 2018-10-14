package experiment;
      //package waste;

      import java.awt.*;
      import java.awt.event.*;
      import java.util.*;
      import javax.swing.*;
      import javax.swing.table.*;

      public class TableButton3 extends JFrame
      {
          public TableButton3()
          {
          	//previous values
              String[] columnNames = {" stu_name","stu_rollno","stu_branch","stu_year "," stu_sec "," stu_status ","stu_date ","Response1","Response2"};
              Object[][] data =
              {
                  {"shiva","123456", "cse", '2', "c1",'0',22-1-32,"Granted","Not Granted"},
                  {"shiva","123456", "cse", '2', "c1",'0',22-1-32,"Granted","Not Granted"},
                  {"shiva","123456", "cse", '2', "c1",'0',22-1-32,"Granted","Not Granted"},
                  {"shiva","123456", "cse", '2', "c1",'0',22-1-32,"Granted","Not Granted"}
              };

              DefaultTableModel model = new DefaultTableModel(data, columnNames);
              JTable table = new JTable( model )
              
              {
                  //  Returning the Class of each column will allow different
                  //  renderers to be used based on Class
              	
                  public Class getColumnClass(int column)
                  {  
                      return getValueAt(0, column).getClass();
                  }
                  //public boolean isCellEditable(int row, int column) {
                      //all cells false
                    //  return false;
                   //}
               
              };
              

              JScrollPane scrollPane = new JScrollPane( table );
              getContentPane().add( scrollPane );

              //  Create button column
              ButtonColumn buttonColumn = new ButtonColumn(table, 7,8);
          }

          public static void main(String[] args)
          {
              TableButton3 frame = new TableButton3();
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

              public ButtonColumn(JTable table, int column,int column1)
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
                  columnModel.getColumn(column1).setCellRenderer( this );
                  columnModel.getColumn(column1).setCellEditor( this );
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
                  //table.isCellEditable(row, column);
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

