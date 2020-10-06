package mypack;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CopyBLOB extends JFrame implements ActionListener
{
	JLabel lSource,lDest;
	JTextField tSource,tDest;
	JButton bSource,bDest,bCopy;
	String file_name;
	final static int SIZE=10*1024*1024;
	public CopyBLOB()
	{
		lSource=new JLabel("Select File");
		lDest=new JLabel("Select Folder");
		tSource=new JTextField(15);
		tDest=new JTextField(15);
		bSource=new JButton("Browse");
		bDest=new JButton("Browsse");
		bCopy=new JButton("Copy");
		
		tSource.setEditable(false);
		tDest.setEditable(false);
		
		bSource.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				//JFileChooser chooser=new JFileChooser();
				JFileChooser chooser=new JFileChooser("e:/song");
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int option=chooser.showOpenDialog(CopyBLOB.this);
				if(option==JFileChooser.CANCEL_OPTION)
					return;
				String str=chooser.getSelectedFile().getAbsolutePath();
				file_name=chooser.getSelectedFile().getName();
				tSource.setText(str);
				tSource.setToolTipText(str);
			}
		});
		
		bDest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				JFileChooser chooser=new JFileChooser("c:/temp");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int option=chooser.showOpenDialog(CopyBLOB.this);
				if(option==JFileChooser.CANCEL_OPTION)
					return;
				String str=chooser.getSelectedFile().getAbsolutePath();
				tDest.setText(str);
				tDest.setToolTipText(str);
			}
		});
		
		bCopy.addActionListener(this);
		setLayout(new FlowLayout());
		add(lSource);add(tSource);add(bSource);
		add(lDest);add(tDest);add(bDest);
		add(bCopy);
		
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new CopyBLOB();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		CopyThread th=new CopyThread();
		th.start();
	}
	class CopyThread extends Thread
	{
		@Override
		public void run() 
		{
			String source,dest;
			source=tSource.getText();
			if(source.length()==0)
			{
				JOptionPane.showMessageDialog(CopyBLOB.this, "Select Source File");
				return;
			}
			dest=tDest.getText();
			if(dest.length()==0)
			{
				JOptionPane.showMessageDialog(CopyBLOB.this, "Select Destination Folder");
				return;
			}
			
			try {
				File f_dest=new File(dest+"/"+file_name);
				if(f_dest.exists())
				{
					int option= JOptionPane.showConfirmDialog(CopyBLOB.this, "File already exists.\nDo you want to overrite it?","Question", JOptionPane.YES_NO_OPTION);
					if(option==JOptionPane.NO_OPTION)
						return;
				}
				RandomAccessFile rFile_read=new RandomAccessFile(source, "r");
				RandomAccessFile rFile_write=new RandomAccessFile(f_dest, "rw");
				
				byte data[]=new byte[SIZE];
				while(true)
				{
					int actual_read= rFile_read.read(data, 0, SIZE);
					rFile_write.write(data, 0, actual_read);
					if(actual_read!=SIZE)
					{
						break;
					}
				}
				
				rFile_read.close();
				rFile_write.close();
				JOptionPane.showMessageDialog(CopyBLOB.this, "File Copied");
				tSource.setText("");
				tDest.setText("");
				
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