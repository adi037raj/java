package others;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class DesktopClassDemo {

	public static void main(String[] args) {
		Desktop desktop = Desktop.getDesktop();

		try {
			// URI uri = new URI("http://www.google.com");
			// desktop.browse(uri);

			// File file=new File("C:\\Users\\Mulayam\\Desktop\\tmp\\new.jpg");
			// desktop.open(file);

			File file = new File("C:\\Users\\Mulayam\\Desktop\\tmp\\c.txt");
			desktop.print(file);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
