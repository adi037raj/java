package mypack;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Notepad1 extends JFrame implements ActionListener
{
	JTextArea ta;
	JScrollPane sp;
	String file_name="";
	JMenuBar mBar;
	JMenu mFile;
	JMenuItem fSave,fSaveAs;
	Font f;
	public Notepad1()
	{
		ta=new JTextArea();
		sp=new JScrollPane(ta);
		mBar=new JMenuBar();
		mFile=new JMenu("File");
		fSave=new JMenuItem("Save");
		fSaveAs=new JMenuItem("SaveAs");
		f=new Font("Arial", Font.BOLD, 25);
		ta.setFont(f);
		ta.setSelectionColor(Color.BLUE);
		ta.setSelectedTextColor(Color.white);
		
		mBar.add(mFile);
		mFile.add(fSave);
		mFile.add(fSaveAs);
		
		mFile.setMnemonic('f');
		
		fSave.addActionListener(this);
		fSaveAs.addActionListener(this);
		
		setJMenuBar(mBar);
		
		add(sp);
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Untitled - Notepad");
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new Notepad1();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Object obj=arg0.getSource();
		if(obj==fSave)
		{
			if(file_name.length()==0)
				showSaveAsDialog();
			else
				saveFile(file_name);
		}
		else if(obj==fSaveAs)
		{
			showSaveAsDialog();
		}
	}
	
	void showSaveAsDialog()
	{
		JFileChooser chooser=new JFileChooser();
		int option=chooser.showSaveDialog(this);
		if(option==JFileChooser.CANCEL_OPTION)
			return;
		String str=chooser.getSelectedFile().getAbsolutePath()+".txt";
		
		File f_dest=new File(str);
		if(f_dest.exists())
		{
			option= JOptionPane.showConfirmDialog(Notepad1.this, "File already exists.\nDo you want to overrite it?","Question", JOptionPane.YES_NO_OPTION);
			if(option==JOptionPane.NO_OPTION)
				return;
		}
		saveFile(str);
	}
	void saveFile(String name)
	{
		String data=ta.getText();
		try {
			PrintStream pw=new PrintStream(name);
			Scanner sc=new Scanner(data);
			while(sc.hasNext())
			{
				String s=sc.nextLine();
				pw.println(s);
			}
			file_name=name;
			setTitle(file_name);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
