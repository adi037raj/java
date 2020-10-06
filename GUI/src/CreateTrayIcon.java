import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class CreateTrayIcon extends JFrame implements ActionListener {

	PopupMenu popupMenu;
	MenuItem iExit;

	public CreateTrayIcon() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("Home.gif");

		TrayIcon trayIcon = new TrayIcon(img);
		trayIcon.setImageAutoSize(true);
		
		trayIcon.setToolTip("This is My TrayIcon Demo");

		popupMenu = new PopupMenu();
		iExit = new MenuItem("Exit");
		popupMenu.add(iExit);
		iExit.addActionListener(this);

		trayIcon.setPopupMenu(popupMenu);

		SystemTray systemTray = SystemTray.getSystemTray();
		try {
			systemTray.add(trayIcon);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

	public static void main(String[] args) {
		new CreateTrayIcon();
	}
}
