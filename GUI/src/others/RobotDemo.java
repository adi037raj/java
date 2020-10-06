package others;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class RobotDemo extends javax.swing.JFrame {

	public RobotDemo() {

		setSize(500, 500);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
			Robot robot = new Robot();
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Dimension dimension = toolkit.getScreenSize();
			Rectangle rectangle = new Rectangle(dimension);

			// Rectangle rectangle=new Rectangle(100,100,200,200);
			// Image is parent of BufferedImage class
			BufferedImage image = robot.createScreenCapture(rectangle);

			FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Mulayam\\Desktop\\file.jpg");
			ImageIO.write(image, "jpg", outputStream);
			System.out.println("Captured");

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new RobotDemo();
	}
}
