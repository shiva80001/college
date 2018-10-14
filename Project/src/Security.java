import javax.swing.*;

import java.util.Calendar;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Security {
	String time;
	String no;
	void security(){
JFrame sec = new JFrame("Security");
//JPanel sec1 = new JPanel();
//roll
JLabel roll = new JLabel("RoLL No");
roll.setBounds(60, 80, 100, 60);
//roll text
JTextField roll1 = new JTextField();
roll1.setBounds(120,97, 100,30);
sec.add(roll);
sec.add(roll1);
//no=roll1.getText();

//Status
JButton status = new JButton ("Status"); 
status.setBounds(125, 150, 100, 40);
//Time Stamp

   
JButton Time = new JButton ("TimeStamp"); 
Time.setBounds(125, 250, 100, 40);
Time.setVisible(false);

//label
JLabel status1 = new JLabel();
status1.setBounds(125, 300, 100, 40);
status1.setVisible(false);
JLabel time1 = new JLabel();
time1.setBounds(125, 300, 100, 40);
//add
sec.setSize(400, 500);  
sec.add(Time);
sec.add(status);
sec.add(status1);
//action
status.addActionListener(new ActionListener()
{
	public void actionPerformed (ActionEvent e)
	{
		no=roll1.getText();
	Database d3 = new Database(no);
	d3.statusfrom_security();
	//d3.TimeStamp();
	status1.setVisible(true);
	//status1.setEditable(false);
	boolean data= d3.stat;
	//String data1= data;
		//String data = "yes";
		
		//status1.
		String data1=Boolean.toString(data);
		status1.setText(data1);
		Time.setVisible(true);
		
	}
});

Time.addActionListener(new ActionListener()
{
	public void actionPerformed (ActionEvent e)
	{
		
	Database d4 = new Database(no);
	d4.TimeStamp();
		
	}
});
sec.setLayout(null);    
sec.setVisible(true); 
sec.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	}

