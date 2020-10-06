package layout_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class BorderLayoutDemo extends JFrame {

	Panel pn, ps, pe, pw, pc;
	JButton b1, b2, b3, b4, b5;

	JMenuBar menuBar;
	JMenu file;
	JMenuItem newItem;
	
	public BorderLayoutDemo() {

		menuBar = new JMenuBar();
		file = new JMenu("File");
		newItem = new JMenuItem("New");
		file.add(newItem);
		menuBar.add(file);
		setJMenuBar(menuBar);

		pn = new Panel();
		ps = new Panel();
		pe = new Panel();
		pw = new Panel();
		pc = new Panel();

		b1 = new JButton("NORTH");
		b2 = new JButton("SOUTH");
		b3 = new JButton("EAST");
		b4 = new JButton("WEST");
		b5 = new JButton("CENTER");

		pn.setBackground(Color.red);
		pn.add(b1);

		ps.setBackground(Color.BLACK);
		ps.add(b2);

		pe.setBackground(Color.cyan);
		pe.add(b3);

		pc.setBackground(Color.YELLOW);
		// pc.add(b5);
		pc.setLayout(new BorderLayout());

		JTextArea ta = new JTextArea();

		pc.add(b5, BorderLayout.NORTH);
		pc.add(ta, BorderLayout.CENTER);

		pw.setBackground(Color.MAGENTA);
		pw.add(b4);

		add(pn, BorderLayout.NORTH);
		add(ps, BorderLayout.SOUTH);
		add(pe, BorderLayout.EAST);
		add(pw, BorderLayout.WEST);
		add(pc, BorderLayout.CENTER);

		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {

		new BorderLayoutDemo();
	}
}
