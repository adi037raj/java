import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JFrame;

public class ChangeFormIcon extends JFrame {

	public ChangeFormIcon() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("Home.gif");
		setIconImage(img);
//		System.out.println(new File("Home.gi").exists());
		
		setSize(400, 400);
		setTitle("MyForm");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ChangeFormIcon();
	}
}
