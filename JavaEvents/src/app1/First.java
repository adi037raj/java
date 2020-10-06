package app1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class First extends JFrame implements ActionListener {
	JButton btn1, btn2;

	public First() {
		setSize(400, 400);
		setLayout(new FlowLayout());
		btn1 = new JButton("Btn1");
		btn2 = new JButton("Button2");
		add(btn1);
		add(btn2);

		btn1.addActionListener(this);
		btn2.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		JButton b = (JButton) obj;
		String text=b.getText();
		b.setBackground(Color.red);
		
		
		if (obj == btn1) {			
			System.out.println(text+" clicked");
		} else if (obj == btn2) {
			System.out.println(text+" clicked");

		}
	}

	public static void main(String[] args) {
		new First();
	}

}
