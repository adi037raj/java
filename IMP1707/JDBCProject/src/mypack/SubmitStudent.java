package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class SubmitStudent implements ActionListener
{
	InsertStudent insert;
	
	public SubmitStudent(InsertStudent insert)
	{
		this.insert = insert;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		String reg,name,branch;
		int marks;
		reg= insert.tReg.getText().trim();
		if(reg.length()==0)
		{
			JOptionPane.showMessageDialog(insert, "RegNo can't be left blank");
			insert.tReg.setText("");
			insert.tReg.requestFocus();
			return;
		}
		name=insert.tName.getText().trim();
		branch=insert.cmbBranch.getSelectedItem().toString();
		marks=Integer.parseInt(insert.tMarks.getText());
		
		Student std=new Student(reg, name, branch, marks);
		int r=DBManager.insertStudent(std);
		if(r>0)
		{
			JOptionPane.showMessageDialog(insert, "Data Stored");
			insert.tReg.setText("");
			insert.tMarks.setText("");
			insert.tName.setText("");
			insert.cmbBranch.setSelectedIndex(0);
		}
		else if(r==-1)
			JOptionPane.showMessageDialog(insert, "Problem in SQL Connection");
		else if(r==-2)
			JOptionPane.showMessageDialog(insert, "RegNo already stored");
		else
			JOptionPane.showMessageDialog(insert, "Problem in Server");
			
	}
}
