package mypack;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CircularShape extends JFrame
{
	JButton b1;
	JPanel pan;
	public CircularShape()
	{
		pan=new JPanel();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		setOpacity(0.8f);
		Ellipse2D.Float ellipse=new Ellipse2D.Float(0, 0, 400, 400);
		setShape(ellipse);
		setVisible(true);
		
		add(pan);
		pan.setBackground(Color.blue);
		pan.setLayout(null);
		b1=new JButton("Cancel");
		b1.setBounds(180, 180, 80, 30);
		pan.add(b1);
		validate();
		
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				dispose();
			}
		});
	}
	public static void main(String[] args)
	{
		new CircularShape();
	}
}