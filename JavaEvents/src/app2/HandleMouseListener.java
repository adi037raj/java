package app2;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HandleMouseListener extends JFrame implements MouseListener {

	JButton btn;
	public HandleMouseListener() {
		setSize(400, 400);
		setLayout(new FlowLayout());

		btn = new JButton("Button");
		btn.addMouseListener(this);

		add(btn);
		addMouseListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("clicked");

		int count = e.getClickCount();

		System.out.println("Num Of Button :" + e.getButton());

		if (count == 2) {
			System.out.println("Clicked");
			System.out.println("X=" + e.getX());
			System.out.println("Y=" + e.getY());
			System.out.println("X On Screen=" + e.getXOnScreen());
			System.out.println("Y On Screen=" + e.getYOnScreen());
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method s
		// System.out.println("entered");
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("exited");

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("pressed");

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("released");
	}

	public static void main(String[] args) {
		new HandleMouseListener();
	}
}
