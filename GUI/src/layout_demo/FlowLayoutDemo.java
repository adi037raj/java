package layout_demo;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutDemo extends JFrame {

	JButton b1,b2,b3,b4,b5;
	
	
	public FlowLayoutDemo() {

		b1=new JButton("Button1");
		b2=new JButton("Button2");
		b3=new JButton("Button3");
		b4=new JButton("Button4");
		b5=new JButton("Button5");
		
//		FlowLayout layout=new FlowLayout();
//		FlowLayout layout=new FlowLayout(FlowLayout.LEFT);
		FlowLayout layout=new FlowLayout(FlowLayout.LEFT,20,20);
		
		//		layout.setHgap(20);
		
		setLayout(layout);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		
		
		
		
		
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		new FlowLayoutDemo();
	}
}
