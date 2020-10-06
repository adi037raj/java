package mypack;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertStudent extends JPanel
{
	JLabel lName,lReg,lBranch,lMarks;
	JTextField tReg,tName,tMarks;
	JComboBox<String> cmbBranch;
	JButton bSubmit;
	public InsertStudent()
	{
		lName=new JLabel("Name");
		lMarks=new JLabel("Marks");
		lReg=new JLabel("RegNo");
		lBranch=new JLabel("Branch");
		
		tName=new JTextField(15);
		tReg=new JTextField(6);
		tMarks=new JTextField(4);
		bSubmit=new JButton("Submit");
		String branch[]={"CSE","ECE","IT","ME","CE","EE"};
		cmbBranch=new JComboBox<>(branch);
		
		add(lReg);add(tReg);
		add(lName);add(tName);
		add(lBranch);add(cmbBranch);
		add(lMarks);add(tMarks);
		add(bSubmit);
		
		bSubmit.addActionListener(new SubmitStudent(this));
	}
}
