import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBarDemo extends JFrame {

	JMenuBar menuBar;
	JMenu file;
	JMenuItem newItem;
	JToolBar toolBar;
	JButton button1, button2, button3;

	public ToolBarDemo() {

		menuBar = new JMenuBar(); 
		file = new JMenu("File");
		newItem = new JMenuItem("New");
		file.add(newItem);
		menuBar.add(file);
		setJMenuBar(menuBar);

		Icon i1 = new ImageIcon("Home.gif");
		// button1 = new JButton("Button1");
		button1 = new JButton("Button1", i1);
		// button1.setIcon(i1);

		button1.setToolTipText("This is Home Button");
		button1.setHorizontalTextPosition(SwingConstants.CENTER);
		button1.setVerticalTextPosition(SwingConstants.BOTTOM);

		button2 = new JButton("Button2", i1);
		button3 = new JButton("Button3", i1);

		toolBar = new JToolBar();
		toolBar.add(button1);
		toolBar.add(button2);
		toolBar.addSeparator();
		toolBar.add(button3);

		toolBar.setFloatable(false);
		// toolBar.setOrientation(JToolBar.VERTICAL);

		add(toolBar, BorderLayout.NORTH);

		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ToolBarDemo();
	}
}
