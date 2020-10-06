import java.awt.PopupMenu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class CreatePopupMenu extends JFrame implements MouseListener {
	JPopupMenu popupMenu;
	JMenuItem m1, m2, m3;

	public CreatePopupMenu() {
		popupMenu = new JPopupMenu();
		m1 = new JMenuItem("First Menu");
		m2 = new JMenuItem("Second Menu");
		m3 = new JMenuItem("Third Menu");

		popupMenu.add(m1);
		popupMenu.add(m2);
		popupMenu.add(m3);

		addMouseListener(this);

		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CreatePopupMenu();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 3) {
			popupMenu.show(this, e.getX(), e.getY());
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
