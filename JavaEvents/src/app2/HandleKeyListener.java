package app2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HandleKeyListener extends JFrame implements KeyListener {
	JTextField textField;

	public HandleKeyListener() {

		JLabel label = new JLabel("Mobile Number");
		add(label);

		textField = new JTextField(20);
		add(textField);

		textField.addKeyListener(this);

		setLayout(new FlowLayout());
		Dimension dimension = new Dimension(500, 300);
		setSize(dimension);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		textField.setBackground(Color.RED);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (textField.getText().length() == 10)
			e.setKeyChar('\0');
		char ch = e.getKeyChar();
		if (ch < '0' || ch > '9') {
			e.setKeyChar('\0');
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// System.out.println(textField.getText().length());
		textField.setBackground(Color.white);
	}

	public static void main(String[] args) {
		new HandleKeyListener();
	}
}
