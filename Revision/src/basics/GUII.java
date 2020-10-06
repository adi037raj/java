package basics;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUII extends JFrame{
	
	JTextArea ta;
	public GUII()
	{
		ta=new JTextArea();
		add(ta);
		Toolkit t=Toolkit.getDefaultToolkit();
		setSize(t.getScreenSize());
		setVisible(true);
	}
	
public static void main(String[] args) {
	new GUII();
}
}
