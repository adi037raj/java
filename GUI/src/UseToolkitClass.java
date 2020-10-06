import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.event.KeyEvent;

public class UseToolkitClass {

	public static void main(String[] args) {

		Toolkit toolkit = Toolkit.getDefaultToolkit();

		Dimension dimension = toolkit.getScreenSize();
		System.out.println(dimension);
		
		System.out.println(toolkit.getLockingKeyState(KeyEvent.VK_CAPS_LOCK));
		System.out.println(toolkit.getLockingKeyState(KeyEvent.VK_NUM_LOCK));
		System.out.println(toolkit.getLockingKeyState(KeyEvent.VK_SCROLL_LOCK));
	}
}
