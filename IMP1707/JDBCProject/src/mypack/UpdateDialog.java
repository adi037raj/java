package mypack;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UpdateDialog extends JDialog implements ActionListener
{
	JLabel lReg,lName,lBranch,lMarks;
	JTextField tReg,tName,tMarks;
	JComboBox<String> cmbBranch;
	JButton bUpdate;
	Student std;
	public UpdateDialog(Student std)
	{
		this.std=std;
		
		lName=new JLabel("Name");
		lMarks=new JLabel("Marks");
		lReg=new JLabel("RegNo");
		lBranch=new JLabel("Branch");
		
		tName=new JTextField(std.getName(), 15);
		tReg=new JTextField(std.getReg(),6);
		tMarks=new JTextField(String.valueOf(std.getMarks()),4);
		bUpdate=new JButton("Submit");
		String branch[]={"CSE","ECE","IT","ME","CE","EE"};
		cmbBranch=new JComboBox<>(branch);
		
		tReg.setEditable(false);
		add(lReg);add(tReg);
		add(lName);add(tName);
		add(lBranch);add(cmbBranch);
		add(lMarks);add(tMarks);
		add(bUpdate);
		
		cmbBranch.setSelectedItem(std.getBranch());
		bUpdate.addActionListener(this);
		
		setLayout(new FlowLayout());
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		String name,branch;
		int marks;
		name=tName.getText().trim();
		branch=cmbBranch.getSelectedItem().toString();
		marks=Integer.parseInt(tMarks.getText().trim());
		
		std.setBranch(branch);
		std.setName(name);
		std.setMarks(marks);
		this.dispose();
	}
}
