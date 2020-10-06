package writing;

import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {

	public static void main(String[] args) {
		try {
			FileWriter writer = new FileWriter("file2.txt");
			char ch[] = { 'H', 'E', 'L', 'L', 'O' };

			// writer.write("WELCOME", 3, 4);
			writer.write(ch, 1, 3);

			writer.flush();
			writer.close();
		
			

			System.out.println("Completed");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
