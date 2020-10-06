package mypack;

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

public class ShowTrayIcon extends JFrame
{
	SystemTray tray;
	TrayIcon tray_icon;
	PopupMenu popup;
	MenuItem mExit;
	public ShowTrayIcon()
	{
		popup=new PopupMenu();
		mExit=new  MenuItem("Exit");
		popup.add(mExit);
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		mExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
		});
		
		tray=SystemTray.getSystemTray();
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Image img= toolkit.getImage("notepad.gif");
		tray_icon=new TrayIcon(img);
		tray_icon.setPopupMenu(popup);
		try {
			tray.add(tray_icon);
			tray_icon.displayMessage("SMS", "Software Started", TrayIcon.MessageType.INFO);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args)
	{
		new ShowTrayIcon();
	}
}
