package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.management.openmbean.OpenDataException;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class CreateMDI extends JFrame implements ActionListener
{
	JDesktopPane desktop;
	JMenuBar mBar;
	JMenu mOption;
	JMenuItem insert,search;
	public CreateMDI()
	{
		desktop=new JDesktopPane();
		mBar=new JMenuBar();
		mOption=new JMenu("Option");
		insert=new JMenuItem("Insert");
		search=new JMenuItem("Search");
		
		mOption.add(insert);
		mOption.add(search);
		mBar.add(mOption);
		
		setJMenuBar(mBar);
		
		insert.addActionListener(this);
		search.addActionListener(this);
		
		add(desktop);
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new CreateMDI();
	}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Object obj=arg0.getSource();
		if(obj==insert)
		{
			InsertForm obj_insert=new InsertForm(this);
			try {
				obj_insert.setSelected(true);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(obj==search)
		{
			SearchForm	obj_search=SearchForm.createSearch(this);
			try {
				obj_search.setSelected(true);
				obj_search.setLocation(0, 0);
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void addChild(JInternalFrame obj)
	{
		desktop.add(obj);
	}
	class InsertForm extends JInternalFrame
	{
		public InsertForm(CreateMDI parent)
		{
			setTitle("Insert Details");
			setSize(300, 300);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setClosable(true);
			setIconifiable(true);
			parent.addChild(this);
			setVisible(true);
		}
	}
}
class SearchForm extends JInternalFrame
{
	private static SearchForm obj=null;
	private SearchForm(CreateMDI parent)
	{
		setTitle("Search Details");
		setSize(300, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setClosable(true);
		setIconifiable(true);
		parent.addChild(this);
		setVisible(true);
		
		addInternalFrameListener(new InternalFrameAdapter()
		{
			@Override
			public void internalFrameClosed(InternalFrameEvent arg0)
			{
				obj=null;
			}
		});
	}
	public static SearchForm createSearch(CreateMDI parent)
	{
		if(obj==null)
			obj=new SearchForm(parent);
		return obj;
	}
}