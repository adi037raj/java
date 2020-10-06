package app2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CreateFocustListener extends JFrame implements FocusListener {

	JTextField t1, t2;
	final Color DEFAULT_BACKGROUND = Color.RED;
	JButton btn;

	public CreateFocustListener() {
		setSize(400, 400);
		setLayout(new FlowLayout());

		t1 = new JTextField(20);
		t2 = new JTextField(20);

		btn = new JButton("Button");
		btn.setBackground(DEFAULT_BACKGROUND);

		t1.setBackground(DEFAULT_BACKGROUND);
		t2.setBackground(DEFAULT_BACKGROUND);

		add(t1);
		add(t2);
		add(btn);

		t1.addFocusListener(this);
		t2.addFocusListener(this);

		btn.addFocusListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void focusGained(FocusEvent e) {
		Object obj = e.getSource();

		JComponent component=(JComponent)obj;
		component.setBackground(Color.cyan);
	}

	@Override
	public void focusLost(FocusEvent e) {
		Object obj = e.getSource();

//		JTextField textField = (JTextField) obj;
//		textField.getBackground();
//		textField.setBackground(DEFAULT_BACKGROUND);
//		textField.setForeground(Color.BLACK);
	
	
		JComponent component=(JComponent)obj;
		component.setBackground(DEFAULT_BACKGROUND);
	
	}

	public static void main(String[] args) {
		new CreateFocustListener();
	}
}
