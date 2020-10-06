package mypack;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.omg.CORBA.Environment;

public class UseFontDialog extends JFrame
{
	JTextArea ta;
	JMenuBar mbar;
	JMenu mFormat;
	JMenuItem fFont;
	public UseFontDialog()
	{
		ta=new JTextArea();
		mbar=new JMenuBar();
		mFormat=new JMenu("Format");
		fFont=new JMenuItem("Font");
		
		mbar.add(mFormat);
		mFormat.add(fFont);
		setJMenuBar(mbar);
		add(ta);
		
		fFont.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				new FontDialog();
			}
		});
		
		ta.setFont(new Font("Arial Black", Font.BOLD, 24));
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new UseFontDialog();
	}
	
	class FontDialog extends JDialog implements ListSelectionListener
	{
		JList<String> listFamily,listStyle;
		JList<Byte> listSize;
		JScrollPane spFamily,spStyle,spSize;
		JLabel lblSample;
		JButton bOK,bCancel;
		public FontDialog()
		{
			String styles[]={"Regular","Bold","Italic","BoldItalic"};
			Byte size[]={8,9,10,11,12,14,16,18,20,22,24,26,28,36,48,72};
			GraphicsEnvironment environment=GraphicsEnvironment.getLocalGraphicsEnvironment();
			String families[]= environment.getAvailableFontFamilyNames();
			
			listFamily=new JList<>(families);
			listStyle=new JList<>(styles);
			listSize=new JList<>(size);
			lblSample=new JLabel("Sample");
			bOK=new JButton("OK");
			bCancel=new JButton("Cancel");
			
			spFamily=new JScrollPane(listFamily);
			spStyle=new JScrollPane(listStyle);
			spSize=new JScrollPane(listSize);
			
			add(spFamily);
			add(spStyle);
			add(spSize);
			add(lblSample);
			add(bOK);
			add(bCancel);
			
			Font f= ta.getFont();
			lblSample.setFont(f);
			String font_family=f.getFamily();
			byte font_size=(byte) f.getSize();
			int font_style=f.getStyle();
			
			listFamily.setSelectedValue(font_family, true);
			listSize.setSelectedValue(font_size, true);
			if(font_style==Font.PLAIN)
				listStyle.setSelectedIndex(0);
			else if(font_style==Font.BOLD)
				listStyle.setSelectedIndex(1);
			else if(font_style==Font.ITALIC)
				listStyle.setSelectedIndex(2);
			else
				listStyle.setSelectedIndex(3);
			
			listFamily.addListSelectionListener(this);
			listSize.addListSelectionListener(this);
			listStyle.addListSelectionListener(this);
			
			bCancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					dispose();	
				}
			});
			
			bOK.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					ta.setFont(lblSample.getFont());
					dispose();
				}
			});
			
			setLayout(new FlowLayout());
			setSize(350,400);
			setTitle("Font Dialog");
			setModal(true);
			setLocationRelativeTo(FontDialog.this);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setVisible(true);
		}
		
		@Override
		public void valueChanged(ListSelectionEvent arg0)
		{
			String family=listFamily.getSelectedValue();
			String style=listStyle.getSelectedValue();
			byte size=listSize.getSelectedValue();
			
			Font f;
			if(style.compareToIgnoreCase("regular")==0)
				f=new Font(family, Font.PLAIN, size);
			else if(style.compareToIgnoreCase("bold")==0)
				f=new Font(family, Font.BOLD, size);
			else if(style.compareToIgnoreCase("italic")==0)
				f=new Font(family, Font.ITALIC, size);
			else
				f=new Font(family, Font.ITALIC+Font.BOLD, size);
			lblSample.setFont(f);
		}
	}
}
