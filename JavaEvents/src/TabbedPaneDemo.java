import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TabbedPaneDemo extends JFrame implements ChangeListener {

	JTabbedPane tab;
	JPanel p1, p2, p3;

	public TabbedPaneDemo() {
		// default layout of JPanel is FlowLayout
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();

		JButton b1 = new JButton("Personal Information");
		p1.add(b1);

		p1.setBackground(Color.CYAN);
		p2.setBackground(Color.DARK_GRAY);
		p3.setBackground(Color.yellow);

		// tab = new JTabbedPane();

		// tab=new JTabbedPane(JTabbedPane.LEFT);
		// tab=new JTabbedPane(JTabbedPane.RIGHT);
//		tab = new JTabbedPane(JTabbedPane.BOTTOM);
//		tab = new JTabbedPane(JTabbedPane.TOP);
		
		tab=new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		
		
		
		
		
		tab.addTab("Personal Info", p1);
		tab.addTab("Contact", p2);
		tab.addTab("Address", p3);

		add(tab);
		tab.setBackgroundAt(0, Color.BLUE);
		tab.addChangeListener(this);
		// tab.setEnabled(false);
		// tab.setEnabledAt(2, false);

		setSize(500, 600);
		setResizable(false);
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new TabbedPaneDemo();
	}

	@Override
	public void stateChanged(ChangeEvent e) {

		int index = tab.getSelectedIndex();
		String title = tab.getTitleAt(index);

		setTitle(title);

	}
}
