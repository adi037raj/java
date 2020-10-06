package myswing;

import java.awt.Button;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

//JFrame extends Frame(c) and WindowConstraints(I(DISPOSE_ON_CLOSE, DO_NOTHING_ON_CLOSE, HIDE_ON_CLOSE))
public class First extends JFrame {
	public First() {

		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Button b1 = new Button("AWT Button");
		JButton btn = new JButton("Swing Button");

		add(b1);
		add(btn);

		JTextField textField = new JTextField(20);
		add(textField);
		
		JPasswordField passwordField=new JPasswordField(20);
		add(passwordField);
		
		JCheckBox checkBox=new JCheckBox("CheckBox1");
		JCheckBox checkBox2=new JCheckBox("CheckBox2");
		
		add(checkBox);
		add(checkBox2);
		
		ButtonGroup group=new ButtonGroup();
		
		JRadioButton radioButton=new JRadioButton("Male");
		JRadioButton radioButton2=new JRadioButton("Male");
		group.add(radioButton);
		group.add(radioButton2);
		
		add(radioButton);
		add(radioButton2);
		
		
		
		String names[]={"Dhanbad","Ranchi","Bokaro"};
		JComboBox<String> city=new JComboBox<>(names);
		city.addItem("Kolkata");

		
		add(city);
	

		setLayout(new FlowLayout());

		setAlwaysOnTop(true);
		setVisible(true);

	}

	public static void main(String[] args) {
		new First();
	}
}
