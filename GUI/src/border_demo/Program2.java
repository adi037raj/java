package border_demo;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Program2 extends JFrame {

	JPanel panel;

	public Program2() {
		setLayout(null);
		panel = new JPanel();
		panel.setBounds(50, 50, 200, 200);
		add(panel);
		Border border = null;

		// Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED);
		// Border border = BorderFactory.createBevelBorder(BevelBorder.RAISED,
		// Color.red, Color.BLUE);

		border = BorderFactory.createEtchedBorder();
		border = BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.red, Color.BLACK);

		border = BorderFactory.createMatteBorder(10, 1, 1, 10, Color.red);

		border = BorderFactory.createTitledBorder("Login");

		Border etchBorder = BorderFactory.createEtchedBorder();

		border = BorderFactory.createTitledBorder("Login");
		border = BorderFactory.createTitledBorder(etchBorder, "Login");
		border = BorderFactory.createTitledBorder(etchBorder, "Login", TitledBorder.LEFT, TitledBorder.TOP);

		Font font = new Font("Forte", Font.BOLD, 16);
		// border=BorderFactory.createTitledBorder(etchBorder,
		// "Login",TitledBorder.LEFT,TitledBorder.TOP,font);
		border = BorderFactory.createTitledBorder(etchBorder, "Login", TitledBorder.LEFT, TitledBorder.TOP, font,
				Color.red);
		
		
		

		
		
		
		
		panel.setBorder(border);
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Program2();
	}
}
