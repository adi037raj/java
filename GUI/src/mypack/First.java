package mypack;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.TextField;

public class First {

	public static void main(String[] args) {

		Frame frame = new Frame();
		frame.setTitle("My Frame");
		frame.setSize(400, 400);

		LayoutManager layout = new FlowLayout();
		frame.setLayout(layout);

		Button btn = new Button("Button");
		frame.add(btn);

		Button btn2 = new Button("Button2");
		frame.add(btn2);

		
		Label lbl=new Label("User Name:");
		frame.add(lbl);
		
		TextField textField=new TextField(20);
		frame.add(textField);
		
	
		
		Label lblPass=new Label("Password");
		frame.add(lblPass);
		
		TextField textPass=new TextField(20);
		textPass.setEchoChar('#');
		
		Color clr=Color.red;
		textPass.setForeground(clr);
		textPass.setBackground(Color.cyan);
		
		
		frame.setBackground(Color.YELLOW);
		frame.add(textPass);
		
		
		
		
		
		// frame.setLocation(100, 100);
		// if argument is null then frame will be displayed in center or screen
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);

	}

}
