package writing;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteFile2 {

	public static void main(String[] args) {

		try {
			PrintWriter writer = new PrintWriter("file3.txt");
			writer.flush();
			writer.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
