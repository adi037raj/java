package mypack;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class StudentForm extends JFrame
{
	JTabbedPane tab_pan;
	InsertStudent insert_form;
	ShowStudent show_form;
	public StudentForm()
	{
		tab_pan=new JTabbedPane();
		insert_form=new InsertStudent();
		show_form=new ShowStudent();
		
		tab_pan.addTab("Insert", insert_form);
		tab_pan.addTab("Show", show_form);
		
		add(tab_pan);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	public static void main(String[] args)
	{
		new StudentForm();
	}
}
