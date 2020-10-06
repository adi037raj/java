import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

class MoveCircle extends Frame implements ActionListener, WindowListener {
	final int D = 40, WX = 100, WY = 100, w = 400;
	int x = 200, y = 100;
	byte incrx, incry;
	boolean dirx = true, diry = true;
	Timer t;

	MoveCircle() {
		setSize(600, 600);
		setVisible(true);
		// setDefaultCloseOperation(3);

		addWindowListener(this);
		incrx = generateNum();
		incry = generateNum();

		t = new Timer(20, this);
		;
		t.start();
	}

	public void paint(Graphics gr) {
		gr.clearRect(WX, WY, w, w);
		gr.drawRect(WX, WY, w, w);
		gr.drawOval(x, y, D, D);
	}

	public void actionPerformed(ActionEvent ae) {
		if (diry == true)
			y += incry;
		else
			y -= incry;

		if (dirx == true)
			x += incrx;
		else
			x -= incrx;
		if (y + D >= w + WY) {
			diry = false;
			incry = generateNum();
		}
		if (y <= WY) {
			diry = true;
			incry = generateNum();
		}
		if (x + D >= w + WX) {
			dirx = false;
			incrx = generateNum();
		}
		if (x <= WX) {
			dirx = true;
			incrx = generateNum();
		}
		repaint();
	}

	byte generateNum() {
		Random r = new Random();
		byte num;
		do {
			num = (byte) (r.nextInt(9));
		} while (num <= 1);
		return num;
	}

	public static void main(String ar[]) {
		MoveCircle obj = new MoveCircle();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		t.stop();

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		t.start();

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		t.start();

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		t.stop();
	}
}