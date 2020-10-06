package mypack;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ShowStudent extends JPanel implements ActionListener
{
	JPanel top_pan,data_pan;
	JButton bShow,bDelete,bUpdate,bExcel;
	JRadioButton rbName,rbMarks;
	ButtonGroup grp;
	JTable table;
	ArrayList<Student> list_std=null;
	public ShowStudent()
	{
		top_pan=new JPanel();
		data_pan=new JPanel();
		bShow=new JButton("Show");
		rbName=new JRadioButton("Name");
		rbMarks=new JRadioButton("Marks");
		grp=new ButtonGroup();
		bDelete=new JButton("Delete");
		bUpdate=new JButton("Update");
		bExcel=new JButton("Export in Excel");
		
		grp.add(rbMarks);
		grp.add(rbName);
		
		top_pan.add(bShow);
		top_pan.add(rbName);
		top_pan.add(rbMarks);
		top_pan.add(bDelete);
		top_pan.add(bUpdate);
		top_pan.add(bExcel);
		bDelete.setEnabled(false);
		bUpdate.setEnabled(false);
		bExcel.setEnabled(false);
		
		bShow.addActionListener(this);
		rbMarks.addActionListener(this);
		rbName.addActionListener(this);
		bDelete.addActionListener(this);
		bUpdate.addActionListener(this);
		bExcel.addActionListener(new ExportInExcel());
		
		rbName.setEnabled(false);
		rbMarks.setEnabled(false);
		
		setLayout(new BorderLayout());
		add("North",top_pan);
		add(data_pan);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Object obj=arg0.getSource();
		if(obj==bShow)
		{
			list_std= DBManager.getAllStudents();
			if(list_std==null)
			{
				JOptionPane.showMessageDialog(this, "Problem in connection");
				return;
			}
		
			table=new JTable(list_std.size(), 4);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			rbName.setEnabled(true);
			rbMarks.setEnabled(true);
			bDelete.setEnabled(true);
			bUpdate.setEnabled(true);
			bExcel.setEnabled(true);
			
			grp.clearSelection();
		}
		else if(obj==rbName)
		{
			Collections.sort(list_std, new Comparator<Student>() {

				@Override
				public int compare(Student arg0, Student arg1)
				{
					int res;
					res=arg0.getName().compareToIgnoreCase(arg1.getName());
					return res;
				}
			});
		}
		else if(obj==rbMarks)
		{
			Collections.sort(list_std, new Comparator<Student>() {

				@Override
				public int compare(Student arg0, Student arg1)
				{
					return arg0.getMarks()-arg1.getMarks();
				}
			});
		}
		else if(obj==bDelete)
		{
			int row=table.getSelectedRow();
			if(row<0)
			{
				JOptionPane.showMessageDialog(this, "Please select a row");
				return;
			}
			int option=JOptionPane.showConfirmDialog(this, "Are you sure to delete?\n", "Question", JOptionPane.YES_NO_OPTION);
			if(option==JOptionPane.NO_OPTION)
				return;
			Student std=list_std.get(row);
			int i= DBManager.deleteStudent(std);
			if(i>0)
			{
				JOptionPane.showMessageDialog(this, "Student Deleted");
				list_std.remove(row);
				table=new JTable(list_std.size(), 4);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			}
			else if(i==-1)
			{
				JOptionPane.showMessageDialog(this, "Problem in connection");
				return;
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Some Problem Occured");
				return;
			}
		}
		else if(obj==bUpdate)
		{
			int row=table.getSelectedRow();
			if(row<0)
			{
				JOptionPane.showMessageDialog(this, "Please select a row");
				return;
			}
			int option=JOptionPane.showConfirmDialog(this, "Are you sure to update?\n", "Question", JOptionPane.YES_NO_OPTION);
			if(option==JOptionPane.NO_OPTION)
				return;
			Student std=list_std.get(row);
			new UpdateDialog(std);
			
			int i= DBManager.updateStudent(std);
			if(i>0)
			{
				JOptionPane.showMessageDialog(this, "Student Details Updated");
				list_std.set(row, std);
			}
			else if(i==-1)
			{
				JOptionPane.showMessageDialog(this, "Problem in connection");
				return;
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Some Problem Occured");
				return;
			}
		}
		
		for(int i=0;i<list_std.size();i++)
		{
			Student std=list_std.get(i);
			table.setValueAt(std.getReg(), i, 0);
			table.setValueAt(std.getName(), i, 1);
			table.setValueAt(std.getBranch(), i, 2);
			table.setValueAt(std.getMarks(), i, 3);
		}
		JScrollPane sp=new JScrollPane(table);
		data_pan.removeAll();
		data_pan.repaint();
		data_pan.add(sp);
		data_pan.validate();
	}
	
	class ExportInExcel implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			Calendar cal=Calendar.getInstance();
			int dt,mon,year;
			dt=cal.get(Calendar.DATE);
			mon=cal.get(Calendar.MONTH)+1;
			year=cal.get(Calendar.YEAR);
			String filename=dt+"-"+mon+"-"+year+".xls";
			
			try {
				RandomAccessFile rFile=new RandomAccessFile(filename, "rw");
				String reg,name,branch;
				int marks;
				Iterator<Student> iterator=list_std.iterator();
				while(iterator.hasNext())
				{
					Student std=iterator.next();
					reg=std.getReg();
					name=std.getName();
					branch=std.getBranch();
					marks=std.getMarks();
					
					rFile.writeChars(reg+"\t"+name+"\t"+branch+"\t"+marks+"\n");
				}
				rFile.close();
				JOptionPane.showMessageDialog(ShowStudent.this, "Data Exported in excel");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}