package mypack;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Notepad2 extends JFrame implements ActionListener
{
	JMenuBar mBar;
	JMenu mEdit;
	JMenuItem eCut,eCopy,ePaste,eDelete,eSelectAll,eGoto,eReplace;
	JTextArea ta;
	JScrollPane sp;
	Font f;
	public Notepad2()
	{
		ta=new JTextArea();
		sp=new JScrollPane(ta);
		
		mBar=new JMenuBar();
		mEdit=new JMenu("Edit");
		eCopy=new JMenuItem("Copy");
		eCut=new JMenuItem("Cut");
		ePaste=new JMenuItem("Paste");
		eDelete=new JMenuItem("Delete");
		eSelectAll=new JMenuItem("SelectAll");
		eGoto=new JMenuItem("GoTo");
		eReplace=new JMenuItem("Replace");
		
		mEdit.add(eCopy);
		mEdit.add(eCut);
		mEdit.add(eDelete);
		mEdit.add(ePaste);
		mEdit.add(eSelectAll);
		mEdit.addSeparator();
		mEdit.add(eGoto);
		mEdit.add(eReplace);
		
		mBar.add(mEdit);
		setJMenuBar(mBar);
		
		eCopy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
					ta.copy();	
			}
		});
		eCut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
					ta.cut();
			}
		});
		ePaste.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
					ta.paste();	
			}
		});
		eSelectAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
					ta.selectAll();	
			}
		});
		eDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
					ta.replaceSelection("");	
			}
		});
		
		eGoto.addActionListener(this);
		eReplace.addActionListener(this);
		
		KeyStroke ks_goto=KeyStroke.getKeyStroke(KeyEvent.VK_G,InputEvent.CTRL_MASK);
		eGoto.setAccelerator(ks_goto);
		
		KeyStroke ks_replace=KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK);
		eReplace.setAccelerator(ks_replace);
		
		f=new Font("Arial", Font.BOLD, 25);
		ta.setFont(f);
		ta.setSelectedTextColor(Color.WHITE);
		ta.setSelectionColor(Color.red);
		add(sp);
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new Notepad2();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Object obj=arg0.getSource();
		if(obj==eGoto)
		{
			new GotoDialog();
		}
		else if(obj==eReplace)
		{
			new ReplaceDialog();
		}
	}
	
	class GotoDialog extends JDialog implements ActionListener
	{
		JLabel lLine;
		JTextField txtLine;
		JButton bGoto,bCancel;
		public GotoDialog()
		{
			lLine=new JLabel("Line number");
			txtLine=new JTextField(10);
			bGoto=new JButton("Go");
			bCancel=new JButton("Cancel");
			
			setLayout(new FlowLayout());
			add(lLine);
			add(txtLine);add(bGoto);add(bCancel);
			
			bCancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					GotoDialog.this.dispose();
				}
			});
			
			txtLine.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyReleased(KeyEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyPressed(KeyEvent arg0)
				{
					if(arg0.getKeyCode()==KeyEvent.VK_ESCAPE)
						GotoDialog.this.dispose();
				}
			});
			
			bGoto.addActionListener(this);
			
			setSize(220, 100);
			setModal(true);
			setLocationRelativeTo(Notepad2.this);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setTitle("Goto Line");
			setResizable(false);
			setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			int goto_line=Integer.parseInt(txtLine.getText());
			int line=1;
			String str=ta.getText();
			for(int i=0;i<str.length();i++)
			{
				if(line==goto_line)
				{
					ta.setCaretPosition(i);
					this.dispose();
					return;
				}
				char ch=str.charAt(i);
				if(ch=='\n')
					line++;
			}
			if(line<goto_line)
			{
				JOptionPane.showMessageDialog(this, "Line Number out of range");
				txtLine.setText(String.valueOf(line));
				txtLine.selectAll();
				txtLine.requestFocus();
			}
			
		}
	}
	class ReplaceDialog extends JDialog implements ActionListener
	{
		JLabel lReplace,lFind;
		JTextField tFind,tReplace;
		JButton bFind,bReplace,bReplaceAll,bCancel;
		JCheckBox cbMatchCase;
		int i=0;
		boolean is_selected=false;
		boolean match_case=false;
		public ReplaceDialog()
		{
			lReplace=new JLabel("Replace With");
			lFind=new JLabel("Find What");
			tFind=new JTextField(10);
			tReplace=new JTextField(10);
			bFind=new JButton("Find Next");
			bReplace=new JButton("Replace");
			bReplaceAll=new JButton("Replace All");
			bCancel=new JButton("Cancel");
			cbMatchCase=new JCheckBox("Match Case");
			
			bCancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					Notepad2.this.dispose();
				}
			});
			
			add(lFind);add(tFind);
			add(lReplace);add(tReplace);
			add(bFind);add(bReplace);add(bReplaceAll);add(bCancel);
			add(cbMatchCase);
			
			cbMatchCase.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0)
				{
						if(cbMatchCase.isSelected())
							match_case=true;
						else
							match_case=false;
				}
			});
			
			bFind.addActionListener(this);
			bReplace.addActionListener(this);
			bReplaceAll.addActionListener(this);
			
			setLayout(new FlowLayout());
			setSize(250, 200);
			setModal(true);
			setLocationRelativeTo(Notepad2.this);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setTitle("Replace");
			setResizable(false);
			setVisible(true);
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			Object obj=arg0.getSource();
			if(obj==bFind)
			{
				String find_what,find_in;
				find_what=tFind.getText();
				find_in=ta.getText();
				if(!match_case)
				{
					find_in=find_in.toLowerCase();
					find_what=find_what.toLowerCase();
				}
				int index=find_in.indexOf(find_what, i);
				if(index<0)
				{
					JOptionPane.showMessageDialog(this, "Not Found");
					i=0;
					return;
				}
				ta.setSelectionStart(index);
				ta.setSelectionEnd(index+find_what.length());
				is_selected=true;
				i=index+1;
			}
			else if(obj==bReplace)
			{
				if(is_selected)
				{
					ta.replaceSelection(tReplace.getText());
					is_selected=false;
				}
			}
			else if(obj==bReplaceAll)
			{
				String find_what=tFind.getText();
				int j=0;
				while(true)
				{
					String find_in=ta.getText();
					if(!match_case)
					{
						find_in=find_in.toLowerCase();
						find_what=find_what.toLowerCase();
					}
					int index=find_in.indexOf(find_what, j);
					if(index<0)
						return;
					ta.setSelectionStart(index);
					ta.setSelectionEnd(index+find_what.length());
					ta.replaceSelection(tReplace.getText());
					j=index+1;
				}
			}
		}
	}
}