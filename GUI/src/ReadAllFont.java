import java.awt.GraphicsEnvironment;

public class ReadAllFont {
	public static void main(String[] args) {
		GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String fontName[] = graphicsEnvironment.getAvailableFontFamilyNames();
		for (String string : fontName) {
			System.out.println(string);
		}
	}
}
