package layout_demo;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NullLayoutDemo extends JFrame {

	JLabel lblUser, lblPassword;
	JTextField txtUser;
	JPasswordField txtPass;
	JButton btnLogin, btnCancel;

	public NullLayoutDemo() {

		setLayout(null);

		lblPassword = new JLabel("Password");
		lblUser = new JLabel("User");

		txtPass = new JPasswordField();
		txtUser = new JTextField();

		btnCancel = new JButton("Cancel");
		btnLogin = new JButton("Login");

		lblUser.setBounds(50, 50, 80, 20);
		lblPassword.setBounds(50, 70, 80, 20);

		txtUser.setBounds(140, 50, 200, 20);
		txtPass.setBounds(140, 70, 200, 20);

		btnLogin.setBounds(160, 90, 80, 20);
		btnCancel.setBounds(250, 90, 80, 20);

		add(lblUser);
		add(txtUser);

		add(lblPassword);
		add(txtPass);
		add(btnLogin);
		add(btnCancel);

		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		new NullLayoutDemo();
	}
}
