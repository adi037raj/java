package border_demo;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class FirstProgram extends JFrame {
	JPanel panel;

	public FirstProgram() {

		setLayout(null);
		panel = new JPanel();
		panel.setBounds(50, 50, 200, 200);
		add(panel);
		// panel.setBackground(Color.RED);

		LineBorder border = new LineBorder(Color.red, 2, true);

		panel.setBorder(border);

		JTextField text = new JTextField();
		text.setBounds(270, 50, 200, 30);
		add(text);
		text.setBorder(border);

		JButton btn = new JButton("<html><h1>Button</h1></html>");
		btn.setBounds(270, 200, 100, 50);
		add(btn);
		btn.setBorder(border);

		
		
		
		
		
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new FirstProgram();
	}
}
