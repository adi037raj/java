import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class First extends JFrame {
	public First() {

		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		
		g.setColor(Color.red);
		
//		
//		
//		g.drawLine(20, 100, 200, 100);
//		g.drawString("Enter Name:", 20,120);
//		
//		g.setColor(Color.GREEN);
//		g.drawRect(100, 120, 200, 200);
//		g.drawOval(100, 120, 200, 200);
//
//		int arrX[]={200,300,400};
//		int arrY[]={200,100,500};
//		
////		g.drawPolyline(arrX, arrY, 4);
//		g.drawPolygon(arrX, arrY, 3);
//		
//		g.setColor(Color.red);
//		g.drawArc(300, 200, 200, 200, 180, 180);

		
		g.fillRect(20, 100, 200, 100);
		
		g.fillOval(100, 120, 200, 200);
		g.setColor(Color.GREEN);
		
		g.fillArc(300, 200, 200, 200, 90, 270);
	}

	public static void main(String[] args) {
		new First();
	}
}
