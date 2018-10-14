import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.*;
public class MainPage {
	//StudentmainPage Student2;
	public void page()
	{
		
	JFrame f = new JFrame("Main Page");
	JButton b1 = new JButton ("Student");
	//final JTextField tf1 = new JTextField();
	//tf1.setBounds(50, 50, 150, 20);
	JButton b2 = new JButton ("HOD");
	//final JTextField tf2 = new JTextField("Welcome HOD");
	//tf2.setBounds(50, 100, 150, 20);
	JButton b3 = new JButton ("Security");
	//final JTextField tf3 = new JTextField("Welcome Security");
	//tf3.setBounds(50, 50, 150, 20);
	b1.setBounds(130, 100, 100, 40);
	b1.addActionListener(new ActionListener()
	{
		public void actionPerformed (ActionEvent e)
		{
			StudentmainPage Student1 = new StudentmainPage();
			Student1.Studentmain();
			//Student2 = Student1;
		}
	});
	b2.addActionListener(new ActionListener()
	{
		public void actionPerformed (ActionEvent e)
		{
			
			//StudentmainPage Student1 = new StudentmainPage();
			//Student1.hod();
			//Login l1 = new Login();
			//l1.logindf();
			//Student2 = Student1;
			HOD h1= new HOD();
			h1.logindf();
		}
	});
	b3.addActionListener(new ActionListener()
	{
		public void actionPerformed (ActionEvent e)
		{
			Security security1 = new Security();
			security1.security();
		}
	});
	f.add(b1);
	//f.add(tf1);
	b2.setBounds(130, 150, 100, 40);
	f.add(b2);
	b3.setBounds(130, 200, 100, 40);
	f.add(b3);
	f.setSize(400, 500);
	f.setLayout(null);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//System.out.println("hai");
	
}
	
}